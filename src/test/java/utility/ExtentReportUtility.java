package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import baseTest.BaseTest;

public class ExtentReportUtility implements ITestListener
{
	/*ExtentSparkReporter: Handles the UI (User Interface) and look-and-feel of the report, including theme, title, and location.
	ExtentReports: Populates common information in the report, such as computer name, environment, tester name, and operating system.
	ExtentTest: Responsible for updating the status of individual test cases (pass, fail, skip) and attaching relevant information like error messages.
	 */
	// ExtentSparkReporter is used to define the HTML report file path and report settings (theme, title, etc.)
	public ExtentSparkReporter sparkReporter;
	
	// ExtentReports is the main class that creates and manages the report
	public ExtentReports extent;
	
	// ExtentTest is used to create individual test logs (like PASS, FAIL, INFO) in the report
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext testContext)
	//ITestContext is a special object in TestNG that gives info about the current test execution — like parameters, groups, 
	//test name, and timing.
	{
	//1. Timestamp and Report Name Generation

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	repName = "Test-Report-" + timeStamp + ".html";
	sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

	//2. Extent Report Configuration

	sparkReporter.config().setDocumentTitle("DemoBlaze Automation Report");
	sparkReporter.config().setReportName("DemoBlaze Functional Testing");
	sparkReporter.config().setTheme(Theme.DARK);

	extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("Application", "DemoBlaze");
	extent.setSystemInfo("Module", "Admin");
	extent.setSystemInfo("Sub Module", "Customers");
	extent.setSystemInfo("User Name", System.getProperty("user.name"));
	extent.setSystemInfo("Environment", "QA");

	String os = testContext.getCurrentXmlTest().getParameter("os");
	extent.setSystemInfo("Operating System", os);

	String browser = testContext.getCurrentXmlTest().getParameter("browser");
	extent.setSystemInfo("Browser", browser);

	List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
	if (!includedGroups.isEmpty()) {
	    extent.setSystemInfo("Groups", includedGroups.toString());
	}
	}
	//3. onTestSuccess()
	public void onTestSuccess(ITestResult result)
	{
	test = extent.createTest(result.getTestClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.PASS, result.getName() + " got successfully executed");
	}
	//4. onTestFailure() with Screenshot Capture
	public void onTestFailure(ITestResult result)
	{
	test = extent.createTest(result.getTestClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.FAIL, result.getName() + " got failed");
	test.log(Status.INFO, result.getThrowable().getMessage());

	try {
	    String imgPath = new BaseTest().captureScreenshot(result.getName());
	    test.addScreenCaptureFromPath(imgPath);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	}
	//5. onTestSkipped()
	public void onTestSkipped(ITestResult result)
	{
	test = extent.createTest(result.getTestClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.SKIP, result.getName() + " got skipped");
	test.log(Status.INFO, result.getThrowable().getMessage());
	}
	//6. onFinish() – Auto-open and Email the Report
	public void onFinish(ITestContext context)
	{
	extent.flush();
	String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
	File extentReport = new File(pathOfExtentReport);

	try {
	    Desktop.getDesktop().browse(extentReport.toURI());
	} catch (IOException e) {
	    e.printStackTrace();
	}

	/*try {
	    URL url = new URL("file:///" + System.getProperty("user.dir") + "/reports/" + repName);
	    ImageHtmlEmail email = new ImageHtmlEmail();
	    email.setDataSourceResolver(new DataSourceUrlResolver(url));
	    email.setHostName("smtp.googlemail.com");
	    email.setSmtpPort(465);
	    email.setAuthenticator(new DefaultAuthenticator("email", "pass"););
	    email.setSSLOnConnect(true);
	    email.setFrom("email");
	    email.setSubject("Test Results");
	    email.setMsg("Please find Attached Report....");
	    email.addTo("pavankumar.busyaq@gmail.com");
	    email.attach(url, "extent report", "please check report...");
	    email.send();
	} catch (Exception e) {
	    e.printStackTrace();
	}*/
	}


}

package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public static Object[][] readExcel(String sheetname) throws IOException
	{
		String filepath=System.getProperty("user.dir")+"\\testdata\\demoBlazeData.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				DataFormatter formatter=new DataFormatter();
				data[i-1][j]=formatter.formatCellValue(row.getCell(j));
			}
		}
		book.close();
		fis.close();
		return data;
		
	}

}

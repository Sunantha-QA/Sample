package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	static public String rel_path=System.getProperty("user.dir");
	static public String excelpath=rel_path+"/TestData/TestData.xlsx";
		
	public String ReadExcelData(int row, int col, String sheetname) throws Throwable 
	{
		File file = new File(excelpath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook W=new XSSFWorkbook(fis);
		XSSFSheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}
	public int excel_row_count(String sheetname) throws IOException
	{
		File file = new File(excelpath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook W=new XSSFWorkbook(fis);
		XSSFSheet S = W.getSheet(sheetname);
		int count=S.getLastRowNum();
		return count;
	}
}

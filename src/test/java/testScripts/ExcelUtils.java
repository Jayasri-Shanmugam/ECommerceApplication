package testScripts;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	static XSSFWorkbook workbook;
	
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath,String sheetName)
	{
		try
		
		{
			
		workbook=new XSSFWorkbook(excelPath);
		
		 sheet=workbook.getSheet(sheetName);
		 
		}
		
		catch(Exception exp)
		
		{
			
			exp.printStackTrace();
			
		}
	}
	
	public static void main(String args[])
	
	{
		
		getRowCount();
		
	}
	public static int  getRowCount()
	
	{
		int rowCount=0;
		
		try
		
		{
			
		rowCount=sheet.getPhysicalNumberOfRows();
		
		System.out.println("No of rows: "+rowCount);
		
		}
		
		catch(Exception exp)
		
		{
			
			exp.printStackTrace();
			
		}
		
		return rowCount;
		
	}
	
	public static String getCellData(int rowNum,int columnNum)
	
	{
		
		String cellData=null;
		
		try
		
		{
		
		cellData=sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
		
//		String cellData1=sheet.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(cellData);
		
//		System.out.println(cellData1);
		
		}
		
		catch(Exception exp)
		
		{
			
			exp.printStackTrace();
			
		}
		
		return cellData;
	}
	
	public static int  getColCount()
	{
		
		int rowCount=0;
		
		try
		
		{
			
		rowCount=sheet.getPhysicalNumberOfRows();
		
		System.out.println("No of coloumn: "+rowCount);
		
		}
		
		catch(Exception exp)
		
		{
			
			exp.printStackTrace();
			
		}
		
		return rowCount;
	}

}

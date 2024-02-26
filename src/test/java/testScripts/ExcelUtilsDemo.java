package testScripts;

public class ExcelUtilsDemo 
{

	public static void main(String[] args) 
	
	{
		
		String projectpath=System.getProperty("user.dir");
		
		ExcelUtils excel=new ExcelUtils(projectpath+"\\src\\test\\resources\\testData\\Data.xlsx", "Sheet1");
		
        excel.getCellData(1,0);
        
        excel.getCellData(1, 1);
		
	}

}

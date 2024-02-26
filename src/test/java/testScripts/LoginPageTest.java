package testScripts;

import java.util.Properties;

import java.io.*;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import testScripts.ExcelUtils;

public class LoginPageTest

{
	WebDriver driver;
	
	Properties tempProp;
	
	FileInputStream obtained;
	
	@BeforeTest
	
	public void setUp() throws IOException
	
	{
		
		tempProp=new Properties();
		
		String path=System.getProperty("user.dir")+"//src//test//resources//Properties//config.properties";
		
		obtained=new FileInputStream(path);
		
		tempProp.load(obtained);
		
		obtained.close();
		
		String browser=tempProp.getProperty("browser");
		
		String url=tempProp.getProperty("url");
		
		System.out.println("Browser name..."+browser);
		
		if(browser.equalsIgnoreCase("chrome")) 
			
		{
			
			driver=new ChromeDriver();
			
			driver.get(url);
			
	    }
		
		else if(browser.equalsIgnoreCase("edge")) 
			
		{
			
			driver=new EdgeDriver();
			
			driver.get(url);
			
		}
		
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider="test1data")
	
	public void test1(String username,String password) throws FileNotFoundException, IOException, ParseException
	
	
	{
		
        String path = System.getProperty("user.dir") + "//src//test//resources//JSON//locators.json"; 
	
	    JSONParser jsonparse = new JSONParser();
	
        JSONObject jsonobject = (JSONObject) jsonparse.parse(new FileReader(path));
   
        System.out.println("Username: " + username);
   
        System.out.println("Password: " + password);
   
        String email = (String) jsonobject.get("emailInput");
   
        String passwd = (String) jsonobject.get("passwordInput");
   
        String loginBtn = (String)jsonobject.get("submitButton");
   
        driver.findElement(By.xpath(email)).clear();
   
        driver.findElement(By.xpath(email)).sendKeys(username);
   
        driver.findElement(By.xpath(passwd)).clear();
   
        driver.findElement(By.xpath(passwd)).sendKeys(password);
   
        driver.findElement(By.xpath(loginBtn)).click();
		
	}
	
	@DataProvider(name="test1data")
	
    public Object[][] getData()
    
    {
		
		String projectpath=System.getProperty("user.dir");
		
    	String excelPath=projectpath+"\\src\\test\\resources\\testData\\Data.xlsx";
    	
    	Object data[][]=testData(excelPath,"Sheet1");
    	
    	return data;
    	
    }
    
    
	public static Object[][] testData(String excelPath,String sheetName)
	
	{
		
		ExcelUtils excel=new ExcelUtils(excelPath,sheetName);
		
		int rowCount=excel.getRowCount();
		
		int colCount=excel.getColCount();
		
		Object data[][]=new Object[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++)
			
		{
			
			for(int j=0;j<colCount;j++)
				
			{
				
				String cellData=excel.getCellData(i, j);
				
//				System.out.println(cellData+" | ");
				data[i-1][j]=cellData;
				
			}
			
//			System.out.println();
		}
		
		return data;
	}
}

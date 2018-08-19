package atrayee.SHIPTT;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

/**
 * setting the base class
 * code created by Atrayee Bhadra
 *
 */
public class BaseApp 

{   WebDriver driver; 
     XSSFWorkbook workbook;
     XSSFSheet sheets;
     XSSFCell cell;
     
     
    
     @BeforeTest
	public void login()
	{
        
	// setting driver properties
     
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Buna\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	    driver= new ChromeDriver();
		 
		//navigate the driver to www.shipt.com
		driver.get("https://www.shipt.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// loginbutton of the front home page
		WebElement logbutton= driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/header/nav/ul[2]/li[1]/a"));
		logbutton.click();
	}
    
     
     @ Test
     
     // creating a data driven framework for importing email and pass word
     // maven dependency of apache poi version embedded to read the excel file
    public void ReadData()throws IOException, Exception
    {
    	// Import Excel Sheet
    	File src = new File("C:\\Users\\Buna\\Desktop\\Ab-11.xlsx");
    	//Load the file
    	FileInputStream fis= new FileInputStream(src);
    	// Load the workbook.
		workbook = new XSSFWorkbook(fis);
		//Load the sheet in which data is stored.
		sheets= workbook.getSheet("Sheet1");
    	
    	
	for(int i=1; i<=sheets.getLastRowNum(); i++)
	
	{
		//for email import from excel sheet
	   cell = sheets.getRow(i).getCell(0);
	   cell.setCellType(Cell.CELL_TYPE_STRING);
	   driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[2]/form/div[1]/div/div/div/label/input")).clear();	
	   driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[2]/form/div[1]/div/div/div/label/input")).sendKeys(cell.getStringCellValue());
		
		
	  // for password import from excel sheet
	   cell = sheets.getRow(i).getCell(1);
	   cell.setCellType(Cell.CELL_TYPE_STRING);
	   driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[2]/form/div[2]/div/div/div/label/input")).clear();
	   driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[2]/form/div[2]/div/div/div/label/input")).sendKeys(cell.getStringCellValue());
	  
	  // if email password valid click on submit button
	   WebElement submits= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/form/button"));
	   submits.click();
	
	// if the email and password is valid result column will show passed.
       FileOutputStream fos=new FileOutputStream(src);
	//Message to be written in the excel sheet
       String message = "Passed";
    // Create cell where data needs to be written.
       sheets.getRow(i).createCell(2).setCellValue(message);
    // finally write content
       workbook.write(fos);	
 
    // clicking on the account button of the user page after loggin
       WebElement accbutton= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/header/a[2]/span"));
       accbutton.click();
	
	//logging out of the account
	   WebElement lgout = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/div[2]/button"));
	   lgout.click();
	   fos.close();	
	   workbook = new XSSFWorkbook(new FileInputStream(src));	
	
	// end of automation
		
	}
  
  }
  
}
	
	

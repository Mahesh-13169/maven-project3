package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider1 
{
     WebDriver driver;
     @BeforeSuite
     public void openbrowser()
     {
    	 System.out.println("open broswer");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\91909\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
     }
    @ BeforeTest
     public void geturl()
     {
    	 System.out.println("open url");
    	 driver.get("https://www.facebook.com/");
     }
    @BeforeClass
    public void windowmax() throws InterruptedException
    {
    	System.out.println("windowmax");
    	driver.manage().window().maximize();
    	Thread.sleep(3000);
    }
    @BeforeMethod
    public void getcookies()
    {
    	System.out.println("getcookies");
    	
    }
    @Test(dataProvider="data")
    public void test(String username,String pass) throws InterruptedException
    {
    	System.out.println("test");
    	driver.findElement(By.id("email")).clear();
    	driver.findElement(By.id("email")).sendKeys(username);
    	Thread.sleep(3000);
        driver.findElement(By.id("pass")).clear();
       driver.findElement(By.id("pass")).sendKeys(pass);
    
    	Thread.sleep(3000);
    	
    }
    @DataProvider(name="data")
    public Object[][] dp()
    {
    	return new Object[][]
    			{
    		     {"standard_user","secret_sauce"},
    		     {"locked_out_user","secret_sauce"},
    		     {"problem_user","secret_sauce"},
    		     {"performance_glitch_user","secret_sauce"}
    		     
    			};
    }
    @AfterMethod
    public void getscreenshot() throws IOException
    {
    	System.out.println("ss");
    	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFileToDirectory(src, new File("C:\\Users\\91909\\eclipse-workspace\\Maven-Project3\\Screenshot"));
    }
    @AfterClass
	public void deleteallcookies()
	{
		System.out.println("dlt cookies");
	}
	
	
	@AfterTest
	public void closedbconnection()
	{
		System.out.println("close db connection");
	}
	
	
	
	@AfterSuite
	public void closebrowser()
	{
		System.out.println("close browser");
		driver.close();
	}

    
    
    
     
     
     
}

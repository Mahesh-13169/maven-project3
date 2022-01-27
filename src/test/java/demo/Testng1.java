package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng1 
{
	WebDriver driver;
	@BeforeSuite
    public void OpenBrowser()
    {
    	System.out.println("open browser");
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\91909\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver=new ChromeDriver();
    }
	@BeforeTest
	public void geturl()
	{
		System.out.println("geturl");
		driver.get("https://www.google.co.in/");	
	}
	@BeforeClass
	public void maximizeurl()
	{
		System.out.println("maximizeurl");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("beforemethod");
		
	}
	@AfterMethod
	public void screenshot() throws IOException
	{
		System.out.println("take screenshot");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\Users\\91909\\eclipse-workspace\\Maven-Project3\\Screenshot"));
		
	}
	@Test(priority = 0)
	public void a() throws InterruptedException
	{
		System.out.println("i am in a");
		System.out.println("test");
	    driver.findElement(By.name("q")).sendKeys("india");
	    Thread.sleep(3000);
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(3000);
	}
	public void screenshot1() throws IOException
	{
		System.out.println("take screenshot1");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\Users\\91909\\eclipse-workspace\\Maven-Project3\\Screenshot"));
		
	}
	
	@Test(priority = 1)
	public void b() throws InterruptedException
	{
		System.out.println("i am in b");
		System.out.println("test1");
		JavascriptExecutor js=( JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)"," ");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//h3[@class=\"LC20lb MBeuO DKV0Md\"])[5]")).click();
		Thread.sleep(6000);
	}
	@AfterClass
	public void deleteallcookies()
	{
		System.out.println("deleteallcookies");
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

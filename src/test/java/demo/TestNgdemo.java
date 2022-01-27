package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

public class TestNgdemo
{
	WebDriver driver;
	@BeforeSuite
	public void openbrowser()
	{
		System.out.println("open broswer");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\91909\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	@BeforeTest
	public void getURL()
	{
		System.out.println("get URL");
		driver.get("https://www.amazon.in/");
	}
	
	@BeforeClass
	public void URLMaximizie()
	{
		System.out.println("maximize url");
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public void getcookies()
	{
		System.out.println("get cookies");
	}
	
	
	@Test
	public void Demo() throws InterruptedException
	{
	//	System.out.println("Demo");
	//	driver.findElement(By.id("flights")).click();
		Thread.sleep(3000);
		 driver.get("https://www.youtube.com/");
		 Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void getscreenshot() throws IOException
	{
		System.out.println("get ss");
		
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




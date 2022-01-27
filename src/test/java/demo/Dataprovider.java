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
import org.openqa.selenium.interactions.Actions;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Dataprovider 
{
   WebDriver driver;
   ExtentHtmlReporter htmlReporter;
   ExtentReports extent;
   ExtentTest test;
   @BeforeSuite
   public void openbrowser()
   {
	   System.out.println("open broswer");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\91909\\Downloads\\updated chrome driver\\chromedriver.exe");
		 driver=new ChromeDriver();
   }
   @BeforeTest
   public void geturl()
   {
	   htmlReporter =new ExtentHtmlReporter("extent.html");
	   extent =new ExtentReports();
	   extent.attachReporter(htmlReporter);
	   test =extent.createTest("login-data", "login ");
	   System.out.println("get url");
	   driver.get("https://www.mercurytravels.co.in/");
   }
   @BeforeClass
   public void windowmaximise()
   {
	   System.out.println("windowmaximise");
	   driver.manage().window().maximize();
   }
   @BeforeMethod
   public void getcookies()
   {
	   System.out.println("getcookies");
   }
   @Test(dataProvider="login-data")
   public void login(String email,String pass) throws InterruptedException
   {
	   System.out.println("login");
	   Thread.sleep(3000);
	   Actions ac=new Actions(driver); 
       WebElement log=driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"])[2]"));
       ac.moveToElement(log).build().perform();
       test.info("dropdown checked");
       Thread.sleep(3000);
       WebElement login=driver.findElement(By.xpath("(//a[@data-toggle=\"modal\"])[3]"));
       login.click();
       test.info("click on login button");
       Thread.sleep(3000);
       driver.findElement(By.id("sign_user_email")).sendKeys(email);
       test.info("entername username");
       Thread.sleep(3000);
       driver.findElement(By.id("sign_user_password")).sendKeys(pass);
       test.info("enter password");
       Thread.sleep(3000);
       driver.findElement(By.xpath("(//button[@class=\"btn btn-lg btn-primary modal-btn ajax-submit\"])[1]")).click();
       test.info("login successful");
       Thread.sleep(3000);
       WebElement welcome=driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"])[4]"));
       ac.moveToElement(welcome).build().perform();
       test.info("dropdown check");
       Thread.sleep(3000);
       driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[2]/ul/li[3]/a")).click();
       test.info("click on logout button");
       Thread.sleep(3000);
       System.out.println("logout successful");
       test.info("logout successful");
       test.pass("completed");
       
   }
   @DataProvider(name="login-data")
   public Object[][] dp()
   {
	  return new Object[][] 
			  {
		        
		         new Object[] {"tandalemahesh0144@gmail.com","Amu@4321"},
		         new Object[] {"maheshtandale76@gmail.com","Amu@54321"}
			  };
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
		extent.flush();
		System.out.println("close db connection");
	}
	
	
	
	@AfterSuite
	public void closebrowser()
	{
		System.out.println("close browser");
		driver.close();
	}

}

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
import org.testng.annotations.Test;

public class TestNG 
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
		driver.get("http://demo.guru99.com/test/drag_drop.html");
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
	@Test(priority = 0)
	public void testa() throws InterruptedException
	{
		System.out.println("i am in test a");
		WebElement drag=driver.findElement(By.xpath("(//a[@class=\"button button-orange\"])[5]"));//drag and drop
		Thread.sleep(3000);
	    WebElement drop=driver.findElement(By.xpath("(//li[@class=\"placeholder\"])[1]"));
	    WebElement drag1= driver.findElement(By.xpath("(//a[@class=\"button button-orange\"])[6]"));
	    WebElement drop1= driver.findElement(By.xpath("(//li[@class=\"placeholder\"])[3]"));
	    WebElement	drag2=driver.findElement(By.xpath("(//a[@class=\"button button-orange\"])[2]"));
	    WebElement drop2=driver.findElement(By.xpath("(//li[@class=\"placeholder\"])[2]"));
	    WebElement drag3=driver.findElement(By.xpath("(//a[@class=\"button button-orange\"])[4]"));
	    WebElement drop3=driver.findElement(By.xpath("(//li[@class=\"placeholder\"])[4]"));
	
	    Actions s=new Actions(driver);
	     s.dragAndDrop(drag, drop).perform();
	     Thread.sleep(3000);
	     s.dragAndDrop(drag1, drop1).perform();
	     Thread.sleep(3000);
	     s.dragAndDrop(drag2, drop2).perform();
	     Thread.sleep(3000);
	     s.dragAndDrop(drag3, drop3).perform();
	    Thread.sleep(3000);
}
	@Test(priority = 1)
	public void testb() throws InterruptedException
	{
		System.out.println("i am in test b");
		driver.get("https://www.mercurytravels.co.in/");
	    WebElement mouseover=	driver.findElement(By.xpath("(//a[@style=\"cursor: pointer;\"])[3]"));
	    Actions act=new Actions(driver);
	    act.moveToElement(mouseover).build().perform();//mouse hover
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title=\"Forex Products\"]")).click();
		Thread.sleep(3000);
		    
		}
	
	@Test(priority = 3)
	public void testc() throws InterruptedException
	{
		System.out.println("i am in test c");
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightclick=driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
		Actions s1=new Actions(driver);
		s1.contextClick(rightclick).build().perform();//right click
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class=\"context-menu-item context-menu-icon context-menu-icon-edit\"]")).click();
     	String s=	driver.switchTo().alert().getText();
     	 Thread.sleep(3000);
		System.out.println(s);
		driver.switchTo().alert().accept();
		  Thread.sleep(3000);
		
	}
	@Test(priority = 1)
	public void  testd() throws InterruptedException
	{
		System.out.println("i am in test d");
		driver.get("https://jqueryui.com/slider/");
		driver.switchTo().frame(0);
        WebElement slider=driver.findElement(By.xpath("//span[@tabindex=\"0\"]"));//slider
        Actions s2=new Actions(driver);
        s2.dragAndDropBy(slider, 400, 0).build().perform();
        Thread.sleep(3000);
        s2.dragAndDropBy(slider, -400, 0).build().perform();
        Thread.sleep(3000);
   }
	@Test(priority = 4)
	public void teste() throws InterruptedException
	{
		System.out.println("i am in test e");
		driver.get("https://jqueryui.com/resizable/");
		
	        driver.switchTo().frame(0);
	        WebElement resize=driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
	        Thread.sleep(3000);
	        Actions ac=new Actions(driver);
	       ac.dragAndDropBy(resize, 100, 120).build().perform();
	       Thread.sleep(3000);
	       driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	       WebElement doubleclick=driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"));
	       ac.doubleClick(doubleclick).build().perform();
	       Thread.sleep(3000);
	 String ss=      driver.switchTo().alert().getText();
	 System.out.println(ss);
	       driver.switchTo().alert().accept();
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


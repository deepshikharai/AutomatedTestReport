package mytests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;



public class FirstTest {
	WebDriver driver;
	String url="https://www.google.com/";
	String sparkUrl="https://www.spark.co.nz/shop/";
	Properties pro;
	WebDriverWait wait;
	
	
	@BeforeTest
	public void beforeTest() throws Exception {
		try{
			/*File src= new File("Property.properties");
			FileInputStream fis = new FileInputStream(src);*/
			pro=new Properties();
			pro.load(FirstTest.class.getResourceAsStream("/Property.properties"));
			//pro.load(fis);
		}catch(Exception e){
			System.out.println("Exception is=="+e.getMessage());
		}
		DesiredCapabilities dcp = new DesiredCapabilities();
		dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		dcp.setCapability("name", "SparkTest");
		dcp.setCapability("idleTimeout", 150);
		//driver = new RemoteWebDriver(new URL("http://35.193.7.170:4444/wd/hub"),dcp);
		//System.out.println(pro.getProperty("selenium.url"));
		driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
		//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32\\chromedriver.exe");
		/*System.setProperty("webdriver.chrome.driver",pro.getProperty("chrome.driver").toString());
		//Open browser instance
		driver = new ChromeDriver();*/
		wait = new WebDriverWait(driver,1000);
		driver.get(sparkUrl);
		//System.out.println("Opening Google");
		Thread.sleep(100);
	}
	
  @Test
  public void f() throws Exception {
	  System.out.println("Page Title:"+driver.getTitle());
		//driver.findElement(By.id("lst-ib")).sendKeys("Kubernetes");
		//driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(pro.getProperty("searchword"));//works
//		wait.until(ExpectedConditions.elementToBeClickable(By.id(pro.getProperty("searchbox")))).sendKeys(pro.getProperty("searchword"));
//		System.out.println("Data entered to search");
//		Thread.sleep(100);
//		//driver.findElement(By.name("btnK")).click();
//		//driver.findElement(By.id("lst-b")).sendKeys(Keys.ENTER);
//		//driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(Keys.ENTER);//works
//		wait.until(ExpectedConditions.elementToBeClickable(By.id(pro.getProperty("searchbox")))).sendKeys(Keys.ENTER);
//		System.out.println("search clicked");
//		Cookie cookie = new Cookie("zaleniumTestPassed", "true");
//	    driver.manage().addCookie(cookie);
		Thread.sleep(100);
	        System.out.println("allphones clicking");
		WebElement allphones=(new WebDriverWait(driver,1200)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='quicklinks']/div[3]/a")));
		allphones.click();
	        System.out.println("allphones clicked");
  }

  /*@Test
  public void f1() throws Exception {
	  System.out.println("Page Title:"+driver.getTitle());
		//driver.findElement(By.id("lst-ib")).sendKeys("Kubernetes");
		//driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(pro.getProperty("searchword"));//works
//		wait.until(ExpectedConditions.elementToBeClickable(By.id(pro.getProperty("searchbox")))).sendKeys(pro.getProperty("searchword"));
//		System.out.println("Data entered to search");
//		Thread.sleep(100);
//		//driver.findElement(By.name("btnK")).click();
//		//driver.findElement(By.id("lst-b")).sendKeys(Keys.ENTER);
//		//driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(Keys.ENTER);//works
//		wait.until(ExpectedConditions.elementToBeClickable(By.id(pro.getProperty("searchbox")))).sendKeys(Keys.ENTER);
//		System.out.println("search clicked");
//		Cookie cookie = new Cookie("zaleniumTestPassed", "true");
//	    driver.manage().addCookie(cookie);
		Thread.sleep(100);
	  
  }*/
  

  @AfterTest
  public void afterTest() throws Exception {
	  //System.out.println("Page Title:"+driver.getTitle());
		//driver.findElement(By.id("lst-ib")).sendKeys("Kubernetes");
		//driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(pro.getProperty("searchword"));//works
//		wait.until(ExpectedConditions.elementToBeClickable(By.id(pro.getProperty("searchbox")))).sendKeys(pro.getProperty("searchword"));
//		System.out.println("Data entered to search");
//		Thread.sleep(100);
//		//driver.findElement(By.name("btnK")).click();
//		//driver.findElement(By.id("lst-b")).sendKeys(Keys.ENTER);
//		//driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(Keys.ENTER);//works
//		wait.until(ExpectedConditions.elementToBeClickable(By.id(pro.getProperty("searchbox")))).sendKeys(Keys.ENTER);
//		System.out.println("search clicked");
//		Cookie cookie = new Cookie("zaleniumTestPassed", "true");
//	    driver.manage().addCookie(cookie);
		//Thread.sleep(100);
	  driver.quit();
  }

}

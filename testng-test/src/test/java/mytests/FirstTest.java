package mytests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.Properties;
import java.io.IOException;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;





public class FirstTest {
	public WebDriver driver;
	 public int finalSeed;
	@BeforeClass
	@Parameters("browser")
	public void browsers(String browser) throws IOException
	{
		/*Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
		Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
		Runtime.getRuntime().exec("taskkill /im cmd.exe /f");	*///Not needed
		 	long timeSeed = System.nanoTime(); // to get the current date time value
	        double randSeed = Math.random() * 1000; // random number generation
	        long midSeed = (long) (timeSeed * randSeed); 
	        String s = midSeed + "";
	        String subStr = s.substring(0, 9);
	        finalSeed = Integer.parseInt(subStr);    // integer value
	        System.out.println(finalSeed);	        
		if(browser.equalsIgnoreCase("firefox"))
		{
			/*DesiredCapabilities cap = DesiredCapabilities.firefox();
			File profileDirectory = new File(
					System.getProperty("user.dir") + "\\lib\\Firefox\\Profile\\hcgql5go.default");
			FirefoxProfile profile = new FirefoxProfile(profileDirectory);
			cap.setCapability(FirefoxDriver.PROFILE, profile);
			cap.setJavascriptEnabled(true);
			cap.setPlatform(Platform.WINDOWS);
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\lib\\geckodriver\\geckodriver.exe");
			//this.driver = new FirefoxDriver(cap);
			driver=(new FirefoxDriver(cap));*/
			
			/*System.setProperty("webdriver.chrome.driver", "D://driver//chromedriver_win32//chromedriver.exe");
			//this.driver = new ChromeDriver();
			driver=(new ChromeDriver());*/
			
			DesiredCapabilities dcp = new DesiredCapabilities();
			dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
			dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
			dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
			dcp.setCapability("name", "mercury tours");
			dcp.setCapability("idleTimeout", 150);
			//driver = new RemoteWebDriver(new URL("http://35.187.87.222:4444/wd/hub"),dcp);
			//driver = new RemoteWebDriver(new URL("http://104.199.94.18:4444/wd/hub"),dcp);
			//driver = new RemoteWebDriver(new URL("http://104.197.155.22:4444/wd/hub"),dcp);
			//driver = new RemoteWebDriver(new URL("http://35.231.161.229:4444/wd/hub"),dcp);
			//driver = new RemoteWebDriver(new URL("http://35.231.203.123:4444/wd/hub"),dcp);
			driver = new RemoteWebDriver(new URL("http://35.196.187.54:5555/wd/hub"),dcp);
			//http://35.196.187.54:5555
			//driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			/*System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\lib\\geckodriver\\chromedriver.exe");*/
			
			/*System.setProperty("webdriver.chrome.driver", "D://driver//chromedriver_win32//chromedriver.exe");
			//this.driver = new ChromeDriver();
			driver=(new ChromeDriver());*/
			
			DesiredCapabilities dcp = new DesiredCapabilities();
			dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
			dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
			dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
			dcp.setCapability("name", "mercury tours");
			dcp.setCapability("idleTimeout", 150);
			//driver = new RemoteWebDriver(new URL("http://104.197.155.22:4444/wd/hub"),dcp);
			//driver = new RemoteWebDriver(new URL("http://35.231.161.229:4444/wd/hub"),dcp);
			driver = new RemoteWebDriver(new URL("http://35.231.203.123:4444/wd/hub"),dcp);
			//driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
		}
		
		//driver.get("https://www.spark.co.nz/shop/");
	}
	
   @Test(priority=1)
	  public void user_should_logintotours(){
		        String url="http://newtours.demoaut.com/";
		        driver.get(url);		 
			driver.findElement(By.name("userName")).sendKeys("drai");
			driver.findElement(By.name("password")).sendKeys("infosys16");
			System.out.println("entered in search box");
			driver.findElement(By.name("login")).click();
			} 
	@Test(priority=2)
    public void user_click_on_newstab(){
		String singnoff =driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]")).getText();
		System.out.println(singnoff+" "+"on flight booking page");
		
	}
	@Test(priority=3)
    public void flight_booking(){
		driver.findElement(By.name("tripType")).sendKeys("roundtrip");
		driver.findElement(By.name("passCount")).sendKeys("1");
		driver.findElement(By.name("fromPort")).sendKeys("Frankfurt");
		driver.findElement(By.name("fromMonth")).sendKeys("2");
		driver.findElement(By.name("fromDay")).sendKeys("2");
		driver.findElement(By.name("toPort")).sendKeys("London");
		driver.findElement(By.name("toMonth")).sendKeys("3");
		driver.findElement(By.name("toDay")).sendKeys("4");
		driver.findElement(By.name("servClass")).sendKeys("Business");
		driver.findElement(By.name("airline")).sendKeys("No Preference");
		driver.findElement(By.name("findFlights")).click();
		driver.findElement(By.name("outFlight")).sendKeys("Blue Skies Airlines$361$271$7:10");
		driver.findElement(By.name("inFlight")).sendKeys("Blue Skies Airlines$631$273$14:30");
		driver.findElement(By.name("reserveFlights")).click();
		
		
	}
	@Test(priority=4)
    public void flight_bookingconfirm(){
		driver.findElement(By.name("passFirst0")).sendKeys("deepshikha");
		driver.findElement(By.name("passLast0")).sendKeys("rai");
		driver.findElement(By.name("buyFlights")).click();
		String Successmessage=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")).getText();
		System.out.println(Successmessage);
	}
		
	
	@AfterClass
	public void close_chrome(){
		driver.quit();
		
	}
}

package mytests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SparkMultiBrowserTest {
	
	public String browser="chrome";
	public WebDriver driver;
	 public int finalSeed;
	@BeforeTest
	public void browsers() throws IOException
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
			dcp.setCapability("name", "PHP");
			dcp.setCapability("idleTimeout", 150);
			//driver = new RemoteWebDriver(new URL("http://35.225.119.127:4444/wd/hub"),dcp);
			driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
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
			dcp.setCapability("name", "Spark");
			dcp.setCapability("idleTimeout", 150);
			//driver = new RemoteWebDriver(new URL("http://35.225.119.127:4444/wd/hub"),dcp);
			driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
		}
		
		driver.get("https://www.spark.co.nz/shop/");
	}
	
	@Test
	public void login() throws InterruptedException
	{
		//driver.manage().window().maximize();
		/*WebElement shop=(new WebDriverWait(driver,120)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='header-tracking']/div/nav/ul/li[1]/a")));
		shop.click();*/
		
		System.out.println("allphones clicking");
		WebElement allphones=(new WebDriverWait(driver,1200)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='quicklinks']/div[3]/a")));
		allphones.click();
		
		System.out.println("allphones clicked");
		
		System.out.println("phone clicking");
		By SelectDevice = By.xpath(".//*[@id='entry']/div[2]/div[2]/div/a");
		WebElement phone=(new WebDriverWait(driver,120)).until(ExpectedConditions.presenceOfElementLocated(SelectDevice));
		phone.click();
		System.out.println("phone clicked");
		
		System.out.println("existingCustomer Clicking");
		By existingCustomer=By.xpath(".//*[@id='page']/div/div/div/div[2]/div[5]/div[3]/div/div/div[2]/div[1]/div[2]/div/span[2]/label/div");
		WebElement existingcustomers=(new WebDriverWait(driver,120)).until(ExpectedConditions.presenceOfElementLocated(existingCustomer));
		existingcustomers.click();
		System.out.println("existingCustomer Clicked");
		
		
		System.out.println("continuebutton Clicking");
		By continuebutton=By.xpath(".//*[@id='page']/div/div/div/div[2]/div[5]/button");
		WebElement continues=(new WebDriverWait(driver,120)).until(ExpectedConditions.presenceOfElementLocated(continuebutton));
		continues.click();
		System.out.println("continuebutton Clicked");
		
		
		System.out.println("nextbuttons clicking");
		By nextbutton=By.xpath(".//*[@id='new-customer-login']");
		WebElement nextbuttons=(new WebDriverWait(driver,120)).until(ExpectedConditions.presenceOfElementLocated(nextbutton));
		nextbuttons.click();
		System.out.println("nextbuttons Clicked");
		
		System.out.println("emailid Clicking");
		By emailid=By.xpath(".//*[@id='new-email-id']");
		WebElement emailidss=(new WebDriverWait(driver,120)).until(ExpectedConditions.presenceOfElementLocated(emailid));
		emailidss.click();
		emailidss.sendKeys("testinfo"+finalSeed+"@gmail.com");
		System.out.println("emailid Clicked");
		
		
		System.out.println("firstname Clicking");
		By firstname=By.xpath(".//*[@id='first-name']");
		WebElement names=(new WebDriverWait(driver,120)).until(ExpectedConditions.presenceOfElementLocated(firstname));
		names.click();
		names.sendKeys("TEST");
		System.out.println("firstname Clicked");
		
		
		
		System.out.println("Next Clicking");
		By nextafteremail=By.xpath(".//*[@id='customer_identity']/div/div/div[1]/div/section/div/div/div[4]/div[2]/div/button");
		WebElement nextafteremailss=(new WebDriverWait(driver,120)).until(ExpectedConditions.visibilityOfElementLocated((nextafteremail)));
		nextafteremailss.click();
		System.out.println("Next Clicked");
		
		
		System.out.println("new number Clicking");
		By newnumber=By.xpath(".//*[@id='numberOptionPanel']/div/div/div/div[1]/label/span");
		WebElement newnumbers=(new WebDriverWait(driver,120)).until(ExpectedConditions.visibilityOfElementLocated((newnumber)));
		newnumbers.click();
		System.out.println("new number clicked");
		
		
		System.out.println("add to cart clicking");
		By addtocart=By.xpath(".//*[@id='configurator_form']/div[2]/div/div/div/div[2]/div[11]/button");
		WebElement addtocarts=(new WebDriverWait(driver,120)).until(ExpectedConditions.visibilityOfElementLocated((addtocart)));
		addtocarts.click();
		System.out.println("add to cart clicked");
		
		
		System.out.println("remove clicking");
		By remove=By.xpath(".//*[@id='cart']/div[1]/div/div/fieldset[2]/div/div/fieldset[1]/a");
		WebElement emoves=(new WebDriverWait(driver,120)).until(ExpectedConditions.visibilityOfElementLocated((remove)));
		emoves.click();
		System.out.println("remove clicked");
		
		System.out.println("accept clicking");
		By accept=By.xpath(".//*[@id='accept_delete1']");
		WebElement accepted=(new WebDriverWait(driver,120)).until(ExpectedConditions.visibilityOfElementLocated((accept)));
		accepted.click();
		System.out.println("accept clicked");
	}
	
	
	
	@AfterTest
	public void afterlogin() throws IOException
	{
		driver.quit();	
	}

}

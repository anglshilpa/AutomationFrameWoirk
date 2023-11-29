package vt.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vt.ObjectRepository.HomePage;
import vt.ObjectRepository.LoginPage;

public class BaseClass {
	
	public  PropertyFileUtility putil=new PropertyFileUtility();
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public DataBaseUtility dutil=new DataBaseUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public static WebDriver sdriver;
	
	public WebDriver driver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsCnfig()
	{
		System.out.println("---------Database Connection successful------");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcCnfig() throws Throwable
	{
		String BROWSER=putil.getBrowser();
		System.out.println(BROWSER);
		if(BROWSER.equalsIgnoreCase(putil.getBrowser()))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase(putil.getBrowser()))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else
		{
			System.out.println("invalid browser");
		}
		
		//driver=sdriver;//nly for listners
		driver.get(putil.getBaseUrl());
		wutil.getMaximizeWindow(driver);
		wutil.getWaitforPage(driver);
	}
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmCnfig() throws Throwable
	{
	    LoginPage lp=new LoginPage(driver);
	    lp.getLoginToApp(putil.getUserName(), putil.getPassward());
	    System.out.println("-----LoggedIn successfully-------");
	}
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void asCnfig()
	{

		HomePage hp=new HomePage(driver);
		hp.getSignOutOfApp(driver);
		System.out.println("---Loggedout successfully");
		
	}
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acCnfig()
	{
		driver.quit();
		System.out.println("----Browser closed successfully----");
	}
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void amCnfig()
	{
		System.out.println("---------Database Connection successful------");
	}

}

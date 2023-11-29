package vt.OrganisationTests;




import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vt.GenericUtilities.ExcelFileUtility;
import vt.GenericUtilities.*;
import vt.GenericUtilities.JavaUtility;
import vt.GenericUtilities.PropertyFileUtility;
import vt.GenericUtilities.WebDriverUtility;
import vt.ObjectRepository.CreateNewOrganizationPage;
import vt.ObjectRepository.HomePage;
import vt.ObjectRepository.LoginPage;
import vt.ObjectRepository.OrganizationInfoPage;
import vt.ObjectRepository.OrganizationPage;
@Listeners(vt.GenericUtilities.ListnerImplimentation.class)
public class CreateOrganisationTest extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void CreateOrganisationTest() throws Throwable {
		 
		
		  // step 1: read data from excel sheet
		  
		 String OrgName=eutil.readDataFromExcel("Organization", 1, 1)+jutil.getRandom();
		
		
		 // step 4 : Navigate to organization link
		    HomePage hp=new HomePage(driver);
		    hp.getClickOrganizationlink();
		    Reporter.log("Navigate to organization link successfully", true);
		    
		//step 5 : click on create origination look up icon 
		   OrganizationPage op=new OrganizationPage(driver);
		   op.getClickOrganizationLookUpIcon();
		   Reporter.log("click on create origination look up icon successfully", true);
		    
		    
	    // step 6 : create origination with mandatory field
		    CreateNewOrganizationPage cncp=new CreateNewOrganizationPage(driver);
		    cncp.getCreateOrganization(OrgName);
		    Reporter.log("create origination with mandatory field", true);
		    
		// step  7 : validate verify
		    OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		   String Organisationheader =oip.getOrgHeader();
		   Assert.assertTrue(Organisationheader.contains(OrgName));
	}

}

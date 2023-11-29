package vt.ContactsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vt.GenericUtilities.BaseClass;
import vt.GenericUtilities.ExcelFileUtility;
import vt.GenericUtilities.IPathConstant;
import vt.GenericUtilities.JavaUtility;
import vt.GenericUtilities.PropertyFileUtility;
import vt.GenericUtilities.WebDriverUtility;
import vt.ObjectRepository.ContactInfoPage;
import vt.ObjectRepository.ContactsPage;
import vt.ObjectRepository.CreateNewContactsPage;
import vt.ObjectRepository.CreateNewOrganizationPage;
import vt.ObjectRepository.HomePage;
import vt.ObjectRepository.LoginPage;
import vt.ObjectRepository.OrganizationInfoPage;
import vt.ObjectRepository.OrganizationPage;


@Listeners(vt.GenericUtilities.ListnerImplimentation.class)
public class CreateContactWithOrganizationTest extends BaseClass {
	
	 @Test
	 public void CreateContactwithOrganizationTest()throws Throwable {
		
	        //Step 2 : read Data from excel file
		    String OrgName = eutil.readDataFromExcel("Contacts", 4,2)+jutil.getRandom();
		    String LastName=eutil.readDataFromExcel("Contacts", 4,3)+jutil.getRandom();
		 
		    //Step 6 : click on organization- set as prerequsit for the script
		    HomePage hpage=new HomePage(driver);
		     hpage.getClickOrganizationlink();
		     Reporter.log("click on organization- set as prerequsit for the script", true);
		     
		     
		     //step 7 : click on create orglook up icon
		     OrganizationPage op=new OrganizationPage(driver);
		     op.getClickOrganizationLookUpIcon();
		     Reporter.log("click on create orglook up icon", true);
		     
		     
		     //create org with manditory deatils
		     CreateNewOrganizationPage copage=new CreateNewOrganizationPage(driver);
		     copage.getCreateOrganization(OrgName);
		     Reporter.log("create org with manditory deatils", true);
		     
		     //Validation for organization been created
		     OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		    String OrgTitle = oip.getOrgHeader();
		    Assert.assertTrue(OrgTitle.contains(OrgName));
		   
		     //Step 8 Navigate to contacts link
		     hpage.getClickContactsLink();
		     Reporter.log("Navigate to contacts link successfully", true);
		     
		     //Step 9 : click on createcontactlookup icon 
		     ContactsPage cp=new ContactsPage(driver);
		     cp.getClickOnCreateContactsIcon();
		     Reporter.log("click on createcontactlookup icon successfully", true);
		     
		     //Step 9 Enter the orgName , LastName n Click on save button
		     CreateNewContactsPage cncpage=new CreateNewContactsPage(driver);
		     cncpage.getCraeteNewContact(driver, LastName, OrgName);
		     Reporter.log("Enter the orgName , LastName n Click on save button successfully", true);
		     
		     
		     //step 13 : reacj to contact Info Page
		     ContactInfoPage cfp=new ContactInfoPage(driver);
		     String headerName = cfp.getTextFromContactInfoPage();
		     Assert.assertTrue(headerName.contains(LastName));
		     
		     
		    
		    
		   
		  
		  
	}

}

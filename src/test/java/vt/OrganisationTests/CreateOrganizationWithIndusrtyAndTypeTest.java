package vt.OrganisationTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vt.GenericUtilities.BaseClass;
import vt.ObjectRepository.CreateNewOrganizationPage;
import vt.ObjectRepository.HomePage;
import vt.ObjectRepository.OrganizationInfoPage;
import vt.ObjectRepository.OrganizationPage;


@Listeners(vt.GenericUtilities.ListnerImplimentation.class)
public class CreateOrganizationWithIndusrtyAndTypeTest extends BaseClass{
	
	@Test
	public void craeteOrganizationWithIndustryAndType() throws Throwable
	{
		//ReadData from excel sheet
		
		 String OrgName=eutil.readDataFromExcel("Organization", 7,2);
		 String Industry=eutil.readDataFromExcel("Organization", 7, 3);
		 String Type=eutil.readDataFromExcel("Organization", 7, 4);
				 
		//Step 1 : click on craeteOrganizationLink 

		
		  HomePage hp=new HomePage(driver);
		  hp.getClickOrganizationlink();
		  Reporter.log("click on craeteOrganizationLink ", true);
		  
		  //Clilk on CreateOrganization look up icon
		  
		  OrganizationPage op=new OrganizationPage(driver);
		  op.getClickOrganizationLookUpIcon();
		  Reporter.log("/Clilk on CreateOrganization look up icon successfully",true );
		  
		  //Enter orgName , industry n type , click on save button
		  
		  CreateNewOrganizationPage cncp=new CreateNewOrganizationPage(driver);
		  cncp.getOrgnameWithTypeDropdown(OrgName, Industry, Type);
		  Reporter.log("Enter orgName , industry n type , click on save button", true);
		  
		  //Validate its been created with specified details or not
		  
		  OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		  String OrgHeader = oip.getOrgHeader();
		  Assert.assertTrue(OrgHeader.contains(OrgName));
		  System.out.println("Organization created successfully");
		  
		
		
		
		
		
	}

}

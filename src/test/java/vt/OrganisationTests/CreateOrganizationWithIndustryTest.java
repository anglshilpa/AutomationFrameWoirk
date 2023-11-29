package vt.OrganisationTests;

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
public class CreateOrganizationWithIndustryTest  extends BaseClass {
	
	 @Test
	 public void craeteOrganizationWithIndustr() throws Throwable
	 {
		 
		 String OrgName=eutil.readDataFromExcel("Organization",4 ,2)+jutil.getRandom();
		 String Industry=eutil.readDataFromExcel("Organization", 4, 3);
		 
		 //Click on organization link
		 HomePage hp=new HomePage(driver);
		 hp.getClickOrganizationlink();
		 Reporter.log("Click on organization link successfully", true);
		 
		 //click on createOrganizationIcon
		 OrganizationPage cp=new OrganizationPage(driver);
		 cp.getClickOrganizationLookUpIcon();
		 Reporter.log("click on createOrganizationIcon successfully", true);
		 
		 // specify orgName n take select industryType and click on save
		 CreateNewOrganizationPage cncp=new CreateNewOrganizationPage(driver);
		 cncp.getOrgNameWithIndustryType(OrgName, Industry);
		 Reporter.log("specify orgName n take select industryType and click on save", true);
		 
		 //Validate
		 
		 OrganizationInfoPage op=new OrganizationInfoPage(driver);
		 String OrgHeader=op.getOrgHeader();
		 Assert.assertTrue(OrgHeader.contains(OrgName));
		 
		 
	 }

}

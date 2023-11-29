package vt.OrganisationTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vt.ContactsTests.CraeteContactWithLeadSourceTest;
import vt.GenericUtilities.BaseClass;
import vt.ObjectRepository.CreateNewOrganizationPage;
import vt.ObjectRepository.HomePage;
import vt.ObjectRepository.OrganizationInfoPage;
import vt.ObjectRepository.OrganizationPage;

@Listeners(vt.GenericUtilities.ListnerImplimentation.class)
public class CreateMultipleOrganizationTest extends BaseClass{
	
	
	   
	  @Test(dataProvider ="readMultipleData")
	  public void createMultipleOrganizationTest(String OrgName, String Industry)
	  {
		  String   OrgN=OrgName+jutil.getRandom();
		  HomePage hp=new HomePage(driver);
		  hp.getClickOrganizationlink();
		  
		  //Click on craeteorganization look up icon
		  
		  OrganizationPage op=new OrganizationPage(driver);
		  op.getClickOrganizationLookUpIcon();
		  
		  CreateNewOrganizationPage cncp=new CreateNewOrganizationPage(driver);
		  cncp.getOrgNameWithIndustryType(OrgN, Industry);
		  
		  OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		  String orgHeader = oip.getOrgHeader();
		  Assert.assertTrue(orgHeader.contains(OrgN));
		  System.out.println("its done");
		}
	  
	  @DataProvider
	  public Object[][] readMultipleData() throws Throwable
	  {
		   Object[][] data = eutil.readMultipleData("Multiple");
		   return data;
		  
	  }

}

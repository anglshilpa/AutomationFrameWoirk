package vt.ContactsTests;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vt.GenericUtilities.BaseClass;
import vt.ObjectRepository.ContactInfoPage;
import vt.ObjectRepository.ContactsPage;
import vt.ObjectRepository.CreateNewContactsPage;
import vt.ObjectRepository.HomePage;

@Listeners(vt.GenericUtilities.ListnerImplimentation.class)
public class CraeteContactWithLeadSourceTest extends BaseClass{
	
	
	@Test
	public void createContactWithLeadsource() throws Throwable{
		
		
		    
		  
		    String LatsName=eutil.readDataFromExcel("Contacts",7,2)+jutil.getRandom();
		    String LeadSrcDD = eutil.readDataFromExcel("Contacts",7,3);
		    
		    //Step 1 : Click on to conntactsLink successfully
		    HomePage hp=new HomePage(driver);
		    hp.getClickContactsLink();
		    Reporter.log("Click on to conntactsLink successfully", true);
		    
		    // step 2 : click on createContact icon successfully
		    ContactsPage cp=new ContactsPage(driver);
		    cp.getClickOnCreateContactsIcon();
		    Reporter.log("click on createContact icon successfully");
		     
		  //Step 3 : Enter lastName LeadSrc and click on save button
		    
		    CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		    cncp.getCreateContactwithLeads(LatsName, LeadSrcDD);
		    Reporter.log("Enter lastName LeadSrc and click on save button", true);
		    
		    ContactInfoPage cip=new ContactInfoPage(driver);
		    String contactHeader=cip.getTextFromContactInfoPage();
		    Assert.assertTrue(contactHeader.contains(LatsName));
		    
		    
		   // step 4 : logged out successfull from application
		   hp.getSignOutOfApp(driver);
		   System.out.println("LoggedOut successfully");
		   Reporter.log("logged out successfull from application");
		   
		    
		    
		    
		    
		  
		     
	}
}

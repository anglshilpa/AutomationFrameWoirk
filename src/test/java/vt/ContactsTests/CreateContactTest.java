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
public class CreateContactTest extends vt.GenericUtilities.BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void craeteContactWithTest() throws Throwable {
		
		  /*Read the data from excel sheet*/
		String LastName = eutil.readDataFromExcel("contacts", 1, 2)+jutil.getRandom();
			
			 
			//step 3 :navigate to contacts link
			 HomePage hp=new HomePage(driver);
			 hp.getClickContactsLink();
			 Reporter.log("navigate to contacts link successfully", true);
			
			//step 4:click on create contact lool up icon
			 ContactsPage cp=new ContactsPage(driver);
			 cp.getClickOnCreateContactsIcon();
			 Reporter.log("clicked on create contact lool up icon successfully", true);
			 
			 //step 5 : create contact with maditory fields
			 CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
			 cncp.getCraeteContact(LastName);
			 Reporter.log("create contact with maditory fields successfully",true);
			 
			//step 6:valicodation
			ContactInfoPage cip=new ContactInfoPage(driver);
			String contactheader=cip.getTextFromContactInfoPage();
			Assert.assertTrue(contactheader.contains(LastName));
			
			 
						
		}
		
	}



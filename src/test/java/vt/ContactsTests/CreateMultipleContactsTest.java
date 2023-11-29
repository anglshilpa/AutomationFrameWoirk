package vt.ContactsTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vt.GenericUtilities.BaseClass;
import vt.ObjectRepository.ContactInfoPage;
import vt.ObjectRepository.ContactsPage;
import vt.ObjectRepository.CreateNewContactsPage;
import vt.ObjectRepository.HomePage;

@Listeners(vt.GenericUtilities.ListnerImplimentation.class)
public class CreateMultipleContactsTest extends BaseClass {

	@Test(dataProvider = "readMultipleDataForLastName")
	public void createMultiplecontactTest(String lastName)
	{
		String lName=lastName+jutil.getRandom();
		HomePage hp=new HomePage(driver);
		hp.getClickContactsLink();
		
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getClickOnCreateContactsIcon();
		
		
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.getCraeteContact(lName);
		
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String cheder=cip.getTextFromContactInfoPage();
		Assert.assertTrue(cheder.contains(lName));
		System.out.println("did successfully");
		
		
	}
	
	@DataProvider
	public Object[][] readMultipleDataForLastName() throws Throwable
	{
		Object[][] data = eutil.readDataToCreateMultipleData("MultipleContact");
		return data;
	}

}

package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactsLookUpIcon;
	
	public ContactsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	/**
	 * @return the contactsLookUpIcon
	 */
	public WebElement getContactsLookUpIcon() {
		return contactsLookUpIcon;
	}
	/**
	 * this method will perform click operation on contactlokup img
	 */
	public void getClickOnCreateContactsIcon()
	{
		contactsLookUpIcon.click();
	}
	
	
	
	

}

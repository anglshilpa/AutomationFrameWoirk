package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vt.GenericUtilities.WebDriverUtility;


public class HomePage extends WebDriverUtility {
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgnizationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	public HomePage(WebDriver driver){
		 PageFactory.initElements(driver,this);
		 
		
	}

	/**
	 * @return the orgnizationLink
	 */
	public WebElement getOrgnizationLink() {
		return orgnizationLink;
	}

	/**
	 * @return the contactsLink
	 */
	public WebElement getContactsLink() {
		return contactsLink;
	}

	/**
	 * @return the signOutImg
	 */
	public WebElement getSignOutImg() {
		return signOutImg;
	}

	/**
	 * @return the signOut
	 */
	public WebElement getSignOut() {
		return signOut;
	}
	
	

	/**
	 * this method will click on organizations link in Homepage
	 */
	public void getClickOrganizationlink()
	{
		orgnizationLink.click();
	}
	/**
	 * this mehod will click in contactsLinks in HomePage
	 */
	public void getClickContactsLink()
	{
		contactsLink.click();
	}
	/**
	 * @return the leadsLink
	 */
	public WebElement getLeadsLink() {
		return leadsLink;
	}

	/**
	 * this method will perform mouseHover to the adminstration n click on sign out
	 * @param driver
	 */
	 public void getSignOutOfApp(WebDriver driver)
	 {
		getMouseHover(driver,signOutImg );
		signOut.click();
	 }
	 /**
	  * this methos will click on leadsLink
	  */
	 public void getClicKLeadsLink()
	 {
		 leadsLink.click();
	 }
	

}

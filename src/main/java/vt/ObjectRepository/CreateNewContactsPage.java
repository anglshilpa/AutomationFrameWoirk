package vt.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vt.GenericUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility  {
	
	  @FindBy(name="lastname")
	  private WebElement contactLastName;
	  
	  
	  @FindBy(xpath="//input[@title='Save [Alt+S]']")
	  private WebElement contactSaveButton;
	  
	  @FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	  private WebElement createContactLookUpicon;
	  
	  
	  @FindBy(id="search_txt")
	  private WebElement searchTextfied;
	  
	  
	  @FindBy(name="search")
	  private WebElement searchNowButton;
	  
	  @FindBy(name="leadsource")
	  private WebElement leadSrcTxtBox;
	  
	  
	  
	  public CreateNewContactsPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver,this);
	  }
	  
	 /**
	 * @return the contactLastName
	 */
	public WebElement getContactLastName() {
		return contactLastName;
	}
     /**
	 * @return the contactSaveButton
	 */
	public WebElement getContactSaveButton() {
		return contactSaveButton;
	}
    /**
	 * @return the createContactLookUpicon
	 */
	public WebElement getCreateContactLookUpicon() {
		return createContactLookUpicon;
	}
     /**
	 * @return the leadSrcTxtBox
	 */
	private WebElement getLeadSrcTxtBox() {
		return leadSrcTxtBox;
	}

	/**
	 * @param leadSrcTxtBox the leadSrcTxtBox to set
	 */
	private void setLeadSrcTxtBox(WebElement leadSrcTxtBox) {
		this.leadSrcTxtBox = leadSrcTxtBox;
	}

	/**
	 * @param createContactLookUpicon the createContactLookUpicon to set
	 */
	public void setCreateContactLookUpicon(WebElement createContactLookUpicon) {
		this.createContactLookUpicon = createContactLookUpicon;
	}
	
	public void getClickOnSaveButton()
	{
		contactSaveButton.click();
	}
	  public void getClickOnCreateContactLookUpIcon()
	  {
		  createContactLookUpicon.click();
	  }
	  public void getCraeteContact(String LastName)
	  {
		  contactLastName.sendKeys(LastName);
		  getClickOnSaveButton();
	  }
	  
	  public void getClickOnSearchNow(String OrgName)
	  {
		 searchTextfied.sendKeys(OrgName);
		 searchNowButton.click();
	  }
	  /**
	   * this method will create contact with orginasition
	   * @param driver
	   * @param LastName
	   * @param OrgName
	   */
	  public void getCraeteNewContact(WebDriver driver,String LastName,String OrgName)
	  {
		  contactLastName.sendKeys(LastName);
		  getClickOnCreateContactLookUpIcon();
		  getSwitchToWindow(driver, "Accounts");
		  searchTextfied.sendKeys(OrgName);
		 
		  getSwitchToWindow(driver, "Contacts");
		  getClickOnSaveButton();
		  
	  }
	  public void getCreateContactwithLeads(String LastName, String leadSrc)
	  {
		  contactLastName.sendKeys(LastName);
		  getHandledropDown(leadSrcTxtBox, leadSrc);
		  getClickOnSaveButton();
		 
		  
	  }
	  
	  

}

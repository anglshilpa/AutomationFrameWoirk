package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vt.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	@FindBy(name="accountname")
	private WebElement orgNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropdown;
	
	@FindAll({@FindBy(xpath="//input[@title='Save [Alt+S]']"),@FindBy(xpath="//input[@accesskey='S']")})
	private WebElement OrgsaveButton;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	/**
	 * @return the orgNameTextField
	 */
	public WebElement getOrgNameTextField() {
		return orgNameTextField;
	}


	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return OrgsaveButton;
	}
	/**
	 * When u call this method it will directly click on save button
	 */
	public void getClickOnSaveButton()
	{
		OrgsaveButton.click();
	}
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}


	public WebElement getOrgsaveButton() {
		return OrgsaveButton;
	}
	
	 public WebElement getTypeDropdown() {
		return typeDropdown;
	}


	/**
	 * This method will pass value to OrgName text field
	 * @param orgName
	 */
	
	public void getCreateOrganization(String orgName)
	{
		orgNameTextField.sendKeys(orgName);
		getClickOnSaveButton();
	}
	/**
	 * This method will enter orgname name n select industry from 
	 * dropdown click on save button
	 */
	  public void getOrgNameWithIndustryType(String orgName,String industryDD)
	  {
		  orgNameTextField.sendKeys(orgName);
		  getHandledropDown(industryDropdown, industryDD);
		  getClickOnSaveButton();
	  }
	  public void getOrgnameWithTypeDropdown(String orgName,String IndusrtyDD, String TypeDD)
	  {
		  orgNameTextField.sendKeys(orgName);
		  getHandledropDown(industryDropdown, IndusrtyDD);
		  getHandledropDown(typeDropdown, TypeDD);
		  getClickOnSaveButton();
	  }
}

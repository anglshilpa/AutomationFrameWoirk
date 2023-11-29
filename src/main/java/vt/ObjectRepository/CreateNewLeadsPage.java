package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadsPage {
	
	
	 @FindBy(name="lastname")
	 private WebElement lastNameTextox;
	 
	 @FindBy(name="company")
	 private WebElement companyTxtBox;
	 
	 @FindBy(name="leadsource")
	 private WebElement leadSourceDropdown;
	 
	 @FindBy(name="industry")
	 private WebElement industryDropdown;
	 
	 @FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement saveButton;
	 
	 public CreateNewLeadsPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }

	/**
	 * @return the lastNameTextox
	 */
	private WebElement getLastNameTextox() {
		return lastNameTextox;
	}

	/**
	 * @return the companyTxtBox
	 */
	private WebElement getCompanyTxtBox() {
		return companyTxtBox;
	}

	/**
	 * @return the leadSourceDropdown
	 */
	private WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	/**
	 * @return the industryDropdown
	 */
	private WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	/**
	 * @return the saveButton
	 */
	private WebElement getSaveButton() {
		return saveButton;
	}
	
	

	
	
	 
	 

}

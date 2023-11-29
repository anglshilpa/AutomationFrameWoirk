package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	 private WebElement orgLookupIcon;
	
 public OrganizationPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }

/**
 * @return the orgLookupIcon
 */
public WebElement getOrgLookupIcon() {
	return orgLookupIcon;
}

 public void getClickOrganizationLookUpIcon()
 {
	 orgLookupIcon.click();
 }
 
}

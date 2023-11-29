package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgNameTitle;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	/**
	 * @return the orgNameTitle
	 */
	public WebElement getOrgNameHearder() {
		return OrgNameTitle;
	}
	public String getOrgHeader()
	{
		return OrgNameTitle.getText();
	}

}

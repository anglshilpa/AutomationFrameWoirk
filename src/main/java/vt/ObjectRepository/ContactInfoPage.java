package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderfield;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the contactHeaderfield
	 */
	public WebElement getContactHeader() {
		return contactHeaderfield;
	}
	
	public String getTextFromContactInfoPage()
	{
		return contactHeaderfield.getText();
	}

}

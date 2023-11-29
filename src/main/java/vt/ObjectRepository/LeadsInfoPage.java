package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadHeaderdaetils;
	
	public LeadsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the leadHeaderdaetils
	 */
	private WebElement getLeadHeaderdaetils() {
		return leadHeaderdaetils;
	}
	
	

}

package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LeadsPage {
	
	@FindBy(linkText = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createLeadsIcon;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	/**
	 * @return the leadsIcon
	 */
	public WebElement getLeadsIcon() {
		return createLeadsIcon;
	}

	/**
	 * @param leadsIcon the leadsIcon to set
	 */
	public void setLeadsIcon(WebElement leadsIcon) {
		this.createLeadsIcon = leadsIcon;
	}
	/**
	 * this method will click on craeteLeadsIcon
	 */
	public void getClickOnCreateLeadsIcon()
	{
		createLeadsIcon.click();
	}
	
	

}

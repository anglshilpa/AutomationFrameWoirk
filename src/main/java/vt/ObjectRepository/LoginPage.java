package vt.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Dudes.co
 *
 */
public class LoginPage {
	//Rule No 1: create clas for every pompage
	// Rule 2 : find the webElment by @Findby , @FindAll, @FindBys
	
	@FindBy(name="user_name")
	private WebElement usernametxtfield;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement passwardtxtfield;
	
	@FindBy (id="submitButton")
	private WebElement loginButton;
	
	//rule no 3: create constructor to initalize webElement
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Provide getters to access the elemnts

	/**
	 * @return the usernametxtfield
	 */
	public WebElement getUsernametxtfield() {
		return usernametxtfield;
	}

	/**
	 * @return the passwardtxtfield
	 */
	public WebElement getPasswardtxtfield() {
		return passwardtxtfield;
	}

	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
		return loginButton;
	}
	//create business library if necessry , which seems lk generic method 
	/**
	 * this is generic method which is collects username, passwar n click on login
	 * @param username
	 * @param passward
	 */
	  public void getLoginToApp(String username,String passward)
	  {
		  usernametxtfield.sendKeys(username);
		  passwardtxtfield.sendKeys(passward);
		  loginButton.click();
	  }
	

}

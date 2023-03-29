package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(id="password")})
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBt() {
		return SubmitBtn;
	}
	// Business libraries - generic methods : specific to current project
	/**
	 * This method will login to app with uname and pwd
	 */
	public void loginToApp(String Username, String Password) {
		UsernameEdt.sendKeys(Username);
		PasswordEdt.sendKeys(Password);
		SubmitBtn.click();
		
	}
	 
	
}
 
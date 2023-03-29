package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility  {
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement Logoutlnk;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Getters
	public WebElement getContactsLnk() {
		return ContactsLnk;
	}
	
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}
	
	// Business library
	
	public void clickContact() {
		ContactsLnk.click();
	}
	public void clickOrganization() {
		OrganizationsLnk.click();
	}
	public void logOut(WebDriver driver) {
		mouseHoverAction(driver, Adminimg);
		Logoutlnk.click();
	}
	
	
	
	
}

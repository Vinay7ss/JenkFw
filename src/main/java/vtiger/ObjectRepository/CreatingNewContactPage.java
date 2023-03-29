package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility{
	
	@FindBy(name = "lastname")
	private WebElement LastnameEdt;
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactItn;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement OrgnameImg;
	
	@FindBy(name = "search_text")
	private WebElement SearchEdt;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	
	@FindBy(name = "button")
	private WebElement SaveBtn;
	
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameEdt() {
		return LastnameEdt;
	}
	// Business library
	
	public void saveContact(WebDriver driver, String Lastname, String Orgname){
		LastnameEdt.sendKeys(Lastname);
		OrgnameImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdt.sendKeys(Orgname);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();	
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
		}

}
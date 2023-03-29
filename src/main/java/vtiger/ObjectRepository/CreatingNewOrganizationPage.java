package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility {
	@FindBy(name = "accountname")
	private WebElement OrgnameEdt;
	
	@FindBy(name = "industry")
	private WebElement Industrydropdown;
	
	@FindBy(name = "button")
	private WebElement SaveBtn;
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Business library
		public void saveOrg(String Orgname) {
			OrgnameEdt.sendKeys(Orgname);
			SaveBtn.click();
			}
		
		public void saveOrg(String Orgname, String Industrytype) {
			OrgnameEdt.sendKeys(Orgname);
			handleDropdown(Industrydropdown, Industrytype);
			SaveBtn.click();
			}

}

package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrganizationBtn;
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Getters
	
	public WebElement getCreateOrganizationBtn() {
		return CreateOrganizationBtn;
	}
	// Business library
	
			public void clickCreateOrg() {
				
				CreateOrganizationBtn.click();
				
			}
}

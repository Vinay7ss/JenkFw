package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderTxt;
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Business Logic
	public String getOrgname(String Orgname) {
		return OrgHeaderTxt.getText();
		
		
		
}
}
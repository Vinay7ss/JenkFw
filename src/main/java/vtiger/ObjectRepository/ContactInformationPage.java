package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderTxt;
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Getter
	
	public WebElement getContactHeaderTxt() {
		return ContactHeaderTxt;
	}



	// Business Logic
	public String getLastname(String Lastname) {
		return ContactHeaderTxt.getText();
		
		
	}
	
	
}

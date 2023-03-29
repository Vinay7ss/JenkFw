package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class POMLoginPage {

	public static void main(String[] args) {
		// NOTE : sample pom without xl and prop file utilities
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
		/*lp.getUsernameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBt().click();
		*/
		
		lp.loginToApp("admin", "admin");
		
		HomePage hp = new HomePage(driver);
		hp.clickContact();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickCreateContact();
		
		
		
		
		
		
		
		
	}

}

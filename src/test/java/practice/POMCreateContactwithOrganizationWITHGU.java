package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class POMCreateContactwithOrganizationWITHGU {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PropertyFileUtility pUtil = new PropertyFileUtility ();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		String CONTACT = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();
		
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser");
		}
		
		wUtil.maximisewindow(driver);
		wUtil.waitForPage(driver);
		driver.get(URL);
	
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.clickOrganization();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickCreateOrg();
		CreatingNewOrganizationPage cr = new CreatingNewOrganizationPage(driver);
		cr.saveOrg(ORGNAME, "Banking");
		OrganizationInformationPage oi = new OrganizationInformationPage(driver);
		String Orgheader = oi.getOrgname(ORGNAME);
		if(Orgheader.contains(ORGNAME))
		{
			System.out.println(Orgheader+" --- Org created ---");
		}
		else
		{
			System.out.println("-- Org not created --");
		}
		hp.clickContact();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickCreateContact();
		CreatingNewContactPage cn = new CreatingNewContactPage(driver);	
		cn.saveContact(driver, CONTACT, ORGNAME);
		ContactInformationPage ci = new ContactInformationPage(driver);	
		String contactHeader = ci.getLastname(CONTACT);
		if(contactHeader.contains(CONTACT))
				{
					System.out.println(Orgheader+" --- Pass ---");
				}
				else
				{
					System.out.println("-- Fail --");
				}
		//Step 7: Logout of Application
		hp.logOut(driver);
		System.out.println("Sign out successfull");	
				
}
}

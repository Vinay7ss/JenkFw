package Testng;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
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
@Listeners(vtiger.GenericUtilities.ListernersImplementation.class)// append .class with class name
public class BaseClassPOMCreateContactwithOrganizationWITHGUTest extends BaseClass{
	
	@Test (groups = {"SmokeSuite","RegressionSuite"})
	public void createContactwithOrganizationTest() throws IOException{
		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		String CONTACT = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganization();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickCreateOrg();
		CreatingNewOrganizationPage cr = new CreatingNewOrganizationPage(driver);
		cr.saveOrg(ORGNAME, "Banking");
		OrganizationInformationPage oi = new OrganizationInformationPage(driver);
		String Orgheader = oi.getOrgname(ORGNAME);
		Assert.assertTrue(Orgheader.contains(ORGNAME));
		hp.clickContact();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickCreateContact();
		CreatingNewContactPage cn = new CreatingNewContactPage(driver);	
		cn.saveContact(driver, CONTACT, ORGNAME);
		ContactInformationPage ci = new ContactInformationPage(driver);	
		String contactHeader = ci.getLastname(CONTACT);
		Assert.assertTrue(contactHeader.contains(CONTACT));
		
		
		
}
	@Test 
	public void demo () {
		System.out.println(" --- demo ---");
		Assert.fail();
	}
}

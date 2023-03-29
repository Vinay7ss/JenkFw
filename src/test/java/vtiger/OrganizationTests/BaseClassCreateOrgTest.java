package vtiger.OrganizationTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.HomePage;

public class BaseClassCreateOrgTest extends BaseClass {
	@Test (groups = {"SmokeSuite","RegressionSuite"})
	public void createContactwithOrganizationTest()  throws IOException{
		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		String CONTACT = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();
		
		
		
		
		/*HomePage hp = new HomePage(driver);
		hp.clickOrganization();*/
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4:Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5: Create contact with mandatory fields and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 6: Verification for contact
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains(ORGNAME))
		{
			System.out.println(ContactHeader+" --- PASS ---");
		}
		else
		{
			System.out.println("-- FAIL --");
		}
		
		
		
		



}
}

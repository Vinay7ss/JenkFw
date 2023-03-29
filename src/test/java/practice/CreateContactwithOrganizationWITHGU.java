package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactwithOrganizationWITHGU {
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4:Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5: Create contact with mandatory fields and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 6: Verification for contact
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader+"Org created");
		}
		else
		{
			System.out.println("Org not created");
		}
		
		driver.findElement(By.linkText("Contacts")).click();
		//Step 4:Click on create contact look up image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//Step 5: Create contact with mandatory fields and save
				driver.findElement(By.name("lastname")).sendKeys(CONTACT);
				
				driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
				wUtil.switchToWindow(driver, "Accounts");
				
				driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();			
				wUtil.switchToWindow(driver, "Contacts");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//step 6: Verification for contact
				String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(ContactHeader.contains(CONTACT))
				{
					System.out.println(ContactHeader+" --- PASS ---");
				}
				else
				{
					System.out.println("-- FAIL --");
				}
				
				//Step 7: Logout of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Sign out successfull");
}
}

package Testng;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(vtiger.GenericUtilities.ListernersImplementation.class)// append .class with class name
public class CreateOrgTest {

	   @Test (groups = {"SmokeSuite", "RegionalSuite"})
	   public void createOrgTest() throws IOException{
		
		Random r = new Random();// random class is used to handle the duplicate values
		int random = r.nextInt(1000);

		
		// Step 1: Read all the necessary Data
		/* Read data from property File - Common Data */

			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommomData.properties");
			Properties p = new Properties();
			p.load(fis);
			String BROWSER = p.getProperty("browser");
			String URL = p.getProperty("url");
			String USERNAME = p.getProperty("username");
			String PASSWORD = p.getProperty("password");
			
			/* Read data from excel sheet - Test data */
			FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			String ORGNAME = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue()+random;
			
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
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//Step 3:Navigate to Contacts Link
			driver.findElement(By.linkText("Organizations")).click();
			Reporter.log("Organization clicked");
			
			
			//Step 4:Click on create contact look up image
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//Step 5: Create contact with mandatory fields and save
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Reporter.log("Organization saved");
			
			
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
			
			//Step 7: Logout of Application
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Sign out successfull");

	}
	   @Test
	   public void regional() {
		   System.out.println("-- Regional --");
		   //Assert.fail();
	   }

}

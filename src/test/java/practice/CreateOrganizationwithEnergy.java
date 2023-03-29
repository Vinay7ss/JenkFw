package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationwithEnergy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2:Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3:Navigate to Contacts Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4:Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5: Create contact with mandatory fields and save
		driver.findElement(By.name("accountname")).sendKeys("Vinay2");
		Select dropdown = new Select(driver.findElement(By.name("industry")));
		dropdown.selectByValue("Energy");
		Select dropdown1 = new Select(driver.findElement(By.name("accounttype")));
		dropdown1.selectByValue("Customer");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 6: Verification for contact
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains("Vinay"))
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

}

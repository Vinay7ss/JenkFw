package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactwithOrganization {

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
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4:Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 5: Create contact with mandatory fields and save
		driver.findElement(By.name("lastname")).sendKeys("Vinay1");
		
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		driver.findElement(By.linkText("er")).click();
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 6: Verification for contact
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains("Vinay1"))
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

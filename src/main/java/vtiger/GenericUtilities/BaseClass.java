package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility ();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public static WebDriver sDriver;// this sDriver is used only for listners as its not recommended to create object for base class for data protection
	public WebDriver driver;
	
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
		System.out.println("DB connected");
	}
	
	//@Parameters("browser") // this is for cross browser execution which is defined in suite xml and dont read from property file(line 42) for cross browser execution 
	//@BeforeTest  // this is for cross browser execution 
	
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/ ) throws IOException { // String BROWSER is passed from parameters for cross browsing only
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");// comment this line if running cross browsers
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("----- "+BROWSER+" Launched succesfully-----");
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser");
		}
		sDriver = driver; // this sDriver is used only for listners as its not recommended to create object for base class for data protection
		wUtil.maximisewindow(driver);
		wUtil.waitForPage(driver);
		driver.get(URL);
	}
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("----- Login successful -----");
		
	}
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logOut(driver);
		System.out.println("Sign out successfull");	
	}
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig() {
		driver.quit();
		System.out.println("----- Browser Closed successfully -----");
	}
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig() {
		System.out.println("DB closed");
	}
	
	

}

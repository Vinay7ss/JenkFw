package practice;

import org.testng.annotations.Test;

public class Readdatafromcmdline {
	@Test
	public void readData() {
		String BROWSER = System.getProperty("browser");// browser is key
		System.out.println(BROWSER);
		
		String URL = System.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = System.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD = System.getProperty("password");
		System.out.println(PASSWORD);
		
		System.out.println("s");
	}
}

package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
       
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password) throws IOException 
	{
		 driver.get(prop.getProperty("url"));	
        // One is inheritance
        // Creating object to that class and invoke of it methods   
        LoginPage l = new LoginPage(driver);
        l.getEmail().sendKeys(Username);
      //  getscreenshot("errorscreen");
        l.getPassword().sendKeys(Password);
        l.getLogin().click();
       // driver.close();
        log.info("Logged in successfully");
	}
	@Test(priority=1)
	public void baselandingpage() {
		 LandingPage lp = new LandingPage(driver);
	     lp.getlogin().click();
	}
	@AfterTest
	public void teardown() {
		driver.close();
		// It clears heap memory
		driver=null;
	}

	@DataProvider
	public Object[][] getData() {
		// Row statnd for how many different data type test should run
		// Column stands for how many values per each test
		Object[][] data = new Object[2][2];
		// 0th Row
		data[0][0] = "ravi@gmail.com";
		data[0][1] = "Password1";
		// 1st Row
		data[1][0] = "ravisec@gmail.com";
		data[1][1] = "Password2";
		
		return data;
	}
}

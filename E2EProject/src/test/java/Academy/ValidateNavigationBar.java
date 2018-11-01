package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class ValidateNavigationBar extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
        driver.get(prop.getProperty("url"));	
	}
	
	@Test
	public void validateAppNavBar() throws IOException 
	{
        // One is inheritance
        // Creating object to that class and invoke of it methods
        LandingPage lp = new LandingPage(driver);
        AssertJUnit.assertTrue(lp.getNavigationBar().isDisplayed()); 
        driver.close();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		// It clears heap memory
		driver=null;
	}
	}

package Academy;

import org.testng.annotations.Test;
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

public class ValidateTitle extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
        driver.get(prop.getProperty("url"));	
        log.info("navigated to  Home page");
	}
	@Test
	public void validateAppTitle() throws IOException 
	{
        // One is inheritance
        // Creating object to that class and invoke of it methods
        LandingPage lp = new LandingPage(driver);
       String Title =  lp.gettitle().getText();
       System.out.println(Title);
      // getscreenshot("Error-log-1");
       // Compare the text from the browser with actual text...Throws error, if not match
       Assert.assertEquals(lp.gettitle().getText(), "Featured Coursessss");
	}
	@AfterTest
	public void teardown() {
		driver.close();
		// It clears heap memory
		driver=null;
	}
	}
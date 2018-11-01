package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("/home/ravindranath/eclipse-workspace/E2EProject/src/main/java/resources/Config.properties");
	  	
		prop.load(fis);
		String BrowserName = prop.getProperty("Browser");
        System.out.println(BrowserName);
        
        //Registering log4j properties file
        String log4jConfigpath = System.getProperty("user.dir")+"/src/main/java/resources/log4j.xml";
	 	PropertyConfigurator.configure(log4jConfigpath);
        
		if(BrowserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","/home/ravindranath/Downloads/chromedriver_linux64/chromedriver");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("firefox")){
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getscreenshot(String result) throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("/home/ravindranath/Downloads/Screenshot/"+result+".png"));
		
		String dest = System.getProperty("user.dir")+"/ErrorScreenshots/"+result+".png";
		File destination = new File(dest); 
	    FileUtils.copyFile(src, destination);
		
	}
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;
	
	  /*  @FindBy(id="user_email")
	    WebElement username1; */
	 	
		By Email = By.id("user_email");
		By Pwd = By.id("user_password");
		By Submit = By.name("commit");
		
		public LoginPage(WebDriver driver) {
			this.driver=driver;
		}
		
		public WebElement getEmail() {
			return driver.findElement(Email);
		}
		
		public WebElement getPassword() {
			return driver.findElement(Pwd);
		}
		
		public WebElement getLogin() {
			return driver.findElement(Submit);
		}
		
}

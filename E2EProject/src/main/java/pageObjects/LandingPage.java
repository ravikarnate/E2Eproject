package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	public WebDriver driver;
	
   /*  @FindBy(css="a[href*='sign_in']");
	WebElement signin;	*/	
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By Navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getlogin() {
		return driver.findElement(signin);
	}
	
	public WebElement gettitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(Navbar);
	}
}

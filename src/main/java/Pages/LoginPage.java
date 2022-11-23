package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.SeleniumWrappers;

public class LoginPage  extends SeleniumWrappers{
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // for Findby parefactory
}
	
	@FindBy(css="ul input[id='log']") 
	public WebElement usernameField;
	
	//public By usernameField = By.cssSelector("ul input[id='log']");
	//WebElement element = driver.findElement(usernameField)
	
	
	@FindBy(css="ul input[id='password']") 
	public WebElement passwordField;
	//public By passwordField = By.cssSelector("ul input[id='password']");
	
	@FindBy(css="ul input[class='submit_button']") 
	public WebElement submitButton;
	
	//public By submitButton = By.cssSelector("ul input[class='submit_button']");
	
	@FindBy(css="div[class*='sc_infobox_style_error']") 
	public WebElement loginErrorMessage;
	
	//public By loginErrorMessage = By.cssSelector("div[class*='sc_infobox_style_error']");
	
	@FindBy(css="div[class*='sc_infobox_style_success']") 
	public WebElement loginSuccessMessage;
	
	//public By loginSuccessMessage = By.cssSelector("div[class*='sc_infobox_style_success']");
	
	@FindBy(css="li[class='menu_user_logout']") 
	public WebElement logoutButton;
	
	
	//public By logoutButton = By.cssSelector("li[class='menu_user_logout']");
	
	@FindBy(css="a[class='popup_close']") 
	public WebElement closePupupButton;
	
	//public By closePupupButton = By.cssSelector("a[class='popup_close']");
	
	public void closeLoginPopup() {
		closePupupButton.click();
	}
	
	public void loginInApp(String username, String password) {
		sendKeys(usernameField,username);
		sendKeys(passwordField,password);
		click(submitButton);
		
	}
	
	public void logoutFromApp() {
		click(logoutButton);
	}
	
	public boolean loginSuccessMessageIsDisplayed() {
		return loginSuccessMessage.isDisplayed();
	}
	
public boolean loginErrorMessageIsDisplayed() {
		return loginErrorMessage.isDisplayed();
	}

public boolean loginMessageIsDisplayed(WebElement element) {
	return element.isDisplayed();
	}


}

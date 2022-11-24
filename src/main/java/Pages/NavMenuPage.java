package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers {
	//public WebDriver driver;
	
	public NavMenuPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
		PageFactory.initElements(driver, this); // for Findby parefactory
	}
	
	//locatori
	
	
	@FindBy(linkText="BOOKS") 
	public WebElement shopLink;
	
	@FindBy(linkText="Login") 
	public WebElement loginLink;
	
	@FindBy(linkText="CONTACTS") 
	public WebElement contactLink;
	
	@FindBy(linkText="SINGLE AUTHOR") 
	public WebElement singleAuthor;

	@FindBy(xpath="//a[contains(text(),'Blog')]") 
	public WebElement blogLink;
	
	@FindBy(xpath="//li[@id='menu-item-114']/a[@href = 'https://keybooks.ro/category/classic/']") 
	public WebElement openClassic;
	
	@FindBy(xpath="//li[@id='menu-item-120']/a[@class= 'sf-with-ul']") 
	public WebElement openPortfolio;
	
	@FindBy(linkText="Portfolio 2 columns") 
	public WebElement openPortfolio2Columns;
	
	@FindBy(xpath="//li[@id='menu-item-232']/a[@href = 'https://keybooks.ro/category/post-formats/']") 
	public WebElement openPostFOrmats;
	
	@FindBy(linkText="HOME") 
	public WebElement homePageLink;
	
	@FindBy(css ="button[class*='search_submit']") 
	public WebElement searchIcon;
	
	@FindBy(css ="input[class*='search_field']") 
	public WebElement searchField;
	
	@FindBy(linkText ="BLOG") 
	public WebElement bloglink;
	

	@FindBy(linkText ="ABOUT") 
	public WebElement aboutLink;
	
	@FindBy(linkText ="Post Formats") 
	public WebElement postFormatsBlogLink;
	
	@FindBy(css ="h6>a[href='https://keybooks.ro/shop/the-wicked-king/']") 
	public WebElement selectTheWickedKing;
	
	
	public void navigateTo(WebElement element) {
		click(element);
		
	}

	
	public void openPortfolio2MenuOption() {
		click(blogLink);
		click(openPortfolio);
		click(openPortfolio2Columns);
		
	}
	
	
	public void openPostFormatsMenuOption() {
		click(openPostFOrmats);
		
	}
	public void searchBook(String value) {
		click(searchIcon);
		sendKeys(searchField, value);
		click(searchIcon);
	}
	public boolean isBookPictureDisplayed(String picture) {
		WebElement element =  driver.findElement(By.cssSelector("div[data-image*='"+picture+"']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}
	public void openClassicsMenuOption() {
		click(openClassic);
	}
	public void searchBookwithoutclick(String value) {
		click(searchIcon);
		sendKeys(searchField, value);
	}
}

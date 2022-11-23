package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utils.SeleniumWrappers;

public class ShopPage extends SeleniumWrappers{

	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css ="a[href='https://keybooks.ro/product-category/cookbooks/']") 
	public WebElement filterCookbooks;
	
	
	@FindBy(css ="li[class*='column-1_4']") 
	public List<WebElement> cookbooksList;
	
	@FindBy(css ="span[class='onsale']") 
	public List<WebElement> onSale;
	
		
}

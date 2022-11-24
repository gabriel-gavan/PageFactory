package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(css ="span>a[href='https://keybooks.ro/product-category/new-releases/']") 
	public WebElement bookCategoryNewRelease;
	
	@FindBy(css ="span[class='product_id']") 
	public WebElement ProductId;
	
	@FindBy(css ="ol[class*='flex-control-nav']>li>img[src*='https://keybooks.ro/wp-content/uploads/2022/11/TheWickedKing1-100x100.png']") 
	public WebElement picturesBook1;
	@FindBy(css ="ol[class*='flex-control-nav']>li>img[src*='https://keybooks.ro/wp-content/uploads/2022/11/TheWickedKing2-100x100.png']") 
	public WebElement picturesBook2;
	@FindBy(css ="ol[class*='flex-control-nav']>li>img[src*='https://keybooks.ro/wp-content/uploads/2022/11/TheWickedKing3-100x100.png']") 
	public WebElement picturesBook3;
	@FindBy(css ="ol[class*='flex-control-nav']>li>img[src*='https://keybooks.ro/wp-content/uploads/2022/11/TheWickedKing4-100x100.png']") 
	public WebElement picturesBook4;
	

	
public String findPictureURLText(WebElement element) {
	String picturesBook = element.getAttribute("src");
	return picturesBook;
}
}

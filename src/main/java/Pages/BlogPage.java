package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers{

	public BlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css ="input[title*='Search for:']") 
	public WebElement searchField;
	@FindBy(css ="button[class='search_button icon-search']") 
	public WebElement searchIcon;
	
	@FindBy(css ="a[href='https://keybooks.ro/2016/02/02/why-i-wont-stop-buying-books/'") 
	public WebElement selectBlogIwonStopBuyingBooks;
	
	@FindBy(css ="span[class='post_info_item post_info_tags']>a[href='https://keybooks.ro/category/classic/']") 
	public WebElement IsinClassic;
	
	@FindBy(css ="span[class='post_info_item post_info_tags']>a[href='https://keybooks.ro/category/news/']") 
	public WebElement IsinNews;
	
	@FindBy(css ="span[class='post_info_item post_info_tags']>a[href='https://keybooks.ro/category/recommend/']") 
	public WebElement IsinRecommend;

	public void searchForBlog(WebElement element, String text) {
		click(element);
		sendKeys(element, text);
		}
	
	public void selectBlog(WebElement element) {
		click(element);
	}
}

package Tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.BlogPage;
import Pages.NavMenuPage;
import Pages.ShopPage;
import Utils.BaseTest;

public class Curs23Tema extends BaseTest{
	@Test (priority=0)
	public void Test1() throws InterruptedException {
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.bloglink);
		navMenu.openClassicsMenuOption();

		Actions action  = new Actions(driver);
	
		BlogPage blogpage = new BlogPage(driver);
				
		action.moveToElement(blogpage.searchField).perform();
		blogpage.searchField.click();
		
		blogpage.searchForBlog(blogpage.searchField,"stop buying books");
		blogpage.searchIcon.click();
		blogpage.selectBlog(blogpage.selectBlogIwonStopBuyingBooks);
		
		assertTrue(blogpage.IsinClassic.isDisplayed());
		assertTrue(blogpage.IsinNews.isDisplayed());
		assertTrue(blogpage.IsinRecommend.isDisplayed());
		
		Thread.sleep(3000);
	}
	
	@Test (priority=1)
	public void Test2() throws InterruptedException {
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.shopLink);
	    Actions action  = new Actions(driver);
		
		ShopPage shoppage = new ShopPage(driver);
				
		action.moveToElement(shoppage.filterCookbooks).perform();
		shoppage.filterCookbooks.click();
		
		//check if all the books have the onsale tag
		assertTrue(shoppage.cookbooksList.size()==shoppage.onSale.size());
		Thread.sleep(3000);
	}
}

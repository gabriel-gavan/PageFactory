package Tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.NavMenuPage;
import Pages.ShopPage;
import Utils.BaseTest;

public class Curs24Tema extends BaseTest{
	@Test (priority=0)
	public void Test1() throws InterruptedException {
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.searchBookwithoutclick("King");
		navMenu.click(navMenu.selectTheWickedKing);
		
		ShopPage shoppage = new ShopPage(driver);
		assertTrue(shoppage.bookCategoryNewRelease.isDisplayed());
		System.out.println(shoppage.ProductId.getText());
	    assertTrue(shoppage.ProductId.getText().contains("1709"));
		Thread.sleep(3000);

		JavascriptExecutor jse =  (JavascriptExecutor) driver;
		
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		assertTrue(shoppage.findPictureURLText(shoppage.picturesBook1).contains("TheWickedKing1"));
		assertTrue(shoppage.findPictureURLText(shoppage.picturesBook2).contains("TheWickedKing2"));
		assertTrue(shoppage.findPictureURLText(shoppage.picturesBook3).contains("TheWickedKing3"));
		assertTrue(shoppage.findPictureURLText(shoppage.picturesBook4).contains("TheWickedKing4"));

		Thread.sleep(3000);
	}

}

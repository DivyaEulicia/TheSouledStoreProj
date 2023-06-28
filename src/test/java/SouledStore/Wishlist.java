package SouledStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Wishlist {
	WebDriver driver;

	Wishlist(WebDriver d) {
		driver = d;
	}

	By wishlistbtn = By.xpath("//*[@class='btn pointer wishList_Btn']");
	By wish = By.xpath("//*[@class='btn pointer wishList_Btn']/span");
	By wishicon = By.xpath("(//*[@class='count'])[1]");
	By wishmessage = By.xpath("//*[@class='toasted wishlistADD primary default']");

	public void Click_on_Wishlist_Button() {

		driver.findElement(wishlistbtn).click();
	}

	public void Added_to_Wishlist_Message() {

		String wishmess = driver.findElement(wishmessage).getText();
		Assert.assertEquals(wishmess, "Product Added to your Wishlist");
		System.out.println(wishmess + " -->message appears");
	}

	public void Wishlist_Button_Enabled() {

		String wishenabled = driver.findElement(wish).getText();
		Assert.assertEquals(wishenabled, "ADDED TO WISHLIST");
		System.out.println("Wishlist is enabled");
	}

	public void Wishlist_Icon() {

		String wishic = driver.findElement(wishicon).getText();
		Assert.assertEquals(wishic, "1");
		System.out.println("Wishlist icon displays the number of product added to wishlist");
	}

	public void Removed_from_Wishlist_Message() {

		String wishmess1 = driver.findElement(wishmessage).getText();
		Assert.assertEquals(wishmess1, "Product removed from your Wishlist");
		System.out.println(wishmess1 + " -->message is appearing");
	}

	public void Wishlist_Button_Disabled() {

		String wishdisabled = driver.findElement(wish).getText();
		Assert.assertEquals(wishdisabled, "ADD TO WISHLIST");
		System.out.println("Wishlist is disabled");
	}
}

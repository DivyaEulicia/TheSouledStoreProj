package SouledStore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddToCart {
	WebDriver driver;

	AddToCart(WebDriver d) {
		driver = d;
	}

	By cartbtn = By.xpath("//*[@class='col btnRow']/button");
	By notification = By.id("moe-dontallow_button");
	By size = By.xpath("//*[@class='oval unselectedSize']");
	By size_not_chosen = By.xpath("//*[@class='alert alert-danger']");
	By quantity = By.xpath("//*[@class='qtyOption']/option[5]");
	By cart = By.xpath("//*[@class='btn btn-primary btn-lg btn-block  pointer text-uppercase btnWidth']");
	By carticon = By.xpath("//*[@class='count']");
	By cartmessage = By.xpath("//*[@class='toasted toasted-customred primary default']");
	
	public void Size_not_Chosen() {
		
		driver.findElement(cartbtn).click();
		String alertmessage = driver.findElement(size_not_chosen).getText();
		Assert.assertEquals(alertmessage, "Please select a size.");
		System.out.println("Alert message '"+alertmessage+"' is displayed" );
	}

	public void Add_Size(int siz) {

		List <WebElement> sz = driver.findElements(size);
		int count = sz.size();
		System.out.println("Different sizes available = " + count);
		sz.get(siz).click();
	}

	public void Choose_Quantity() {

		driver.findElement(quantity).click();
	}

	public void Click_on_AddToCart_Button() {

		driver.findElement(cartbtn).click();
	}

	public void Added_to_Cart_Message() {

		String cartmess = driver.findElement(cartmessage).getText();
		Assert.assertEquals(cartmess, "Product added to your cart successfully.");
		System.out.println(cartmess + " -->message is appearing");
	}

	public void AddToCart_Button_Change() {

		String strcart = driver.findElement(cart).getText();
		Assert.assertEquals(strcart, "GO TO CART");
		System.out.println("ADD TO CART button has changed to GO To CART");
	}

	public void Cart_Icon() {

		String cartic = driver.findElement(carticon).getText();
		Assert.assertEquals(cartic, "5");
		System.out.println("Quantity of the product added is shown in the cart icon");
	}

}

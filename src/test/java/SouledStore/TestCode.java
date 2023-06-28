package SouledStore;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCode {
	WebDriver driver;
	Wishlist wl;
	AddToCart ct;
	ExtentReports extent;
	ExtentTest extenttest;
	TakesScreenshot ts = (TakesScreenshot)driver;
	
@BeforeTest
public void setup() {
	
	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/TheSouledStore_TS6Wishlist_TS7AddToCart.html");
	extent.loadConfig(new File(System.getProperty("user.dir") + "/src/test/java/extent-config.xml"));
	
	WebDriverManager.chromedriver().setup();
	ChromeOptions co = new ChromeOptions();
	co.addArguments("--disable-notifications");
	driver = new ChromeDriver(co);
	driver.get("https://www.thesouledstore.com/product/the-office-dunder-mifflin-uniform-men-relaxed-shirt?gte=0");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

@Test(priority = 1)	
public void wishlst() throws InterruptedException, IOException {
	
	extenttest = extent.startTest("TheSouledStore_TS6Wishlist_TS7AddToCart");
	wl = new Wishlist(driver);
	
	wl.Click_on_Wishlist_Button();
	extenttest.log(LogStatus.PASS, "Wishlist button is clicked");
	
	wl.Added_to_Wishlist_Message();
	extenttest.log(LogStatus.PASS, "'Product Added to your Wishlist' message has appeared");
	
    wl.Wishlist_Button_Enabled();
    ts = (TakesScreenshot)driver;
	File filesrc = ts.getScreenshotAs(OutputType.FILE);
	File filedest = new File("/test-output/Images/wishlistenabled.png");
	FileUtils.copyFile(filesrc, filedest );
	extenttest.log(LogStatus.PASS, extenttest.addScreenCapture("/test-output/Images/wishlistenabled.png") +"Wishlist is enabled");
	
	wl.Wishlist_Icon();
	extenttest.log(LogStatus.PASS, "Wishlist icon has displayed the number of product added to wishlist");
	
	Thread.sleep(3000);
	wl.Click_on_Wishlist_Button();
	extenttest.log(LogStatus.PASS, "Wishlist button is clicked again");
	
	Thread.sleep(1000);
	wl.Removed_from_Wishlist_Message();
	extenttest.log(LogStatus.PASS, "'Product removed from your Wishlist' message has appeared");
	
	Thread.sleep(3000);
	wl.Wishlist_Button_Disabled();
	ts = (TakesScreenshot)driver;
	File filesrc1 = ts.getScreenshotAs(OutputType.FILE);
	File filedest1 = new File("/test-output/Images/wishlistdisabled.png");
	FileUtils.copyFile(filesrc1, filedest1 );
	extenttest.log(LogStatus.PASS, extenttest.addScreenCapture("/test-output/Images/wishlistdisabled.png") +"Wishlist is disabled");
	
}

@Test(priority = 2)
public void cart() throws InterruptedException, IOException {
	
	ct = new AddToCart(driver);
	ct.Size_not_Chosen();
	ts = (TakesScreenshot)driver;
	File filesrc2 = ts.getScreenshotAs(OutputType.FILE);
	File filedest2 = new File("/test-output/Images/SizeNotChosenAlert.png");
	FileUtils.copyFile(filesrc2, filedest2 );
	extenttest.log(LogStatus.PASS, extenttest.addScreenCapture("/test-output/Images/SizeNotChosenAlert.png") +"If size is not chosen, alert message has appeared");
	
	ct.Add_Size(2);
	extenttest.log(LogStatus.PASS, "Size of the product is chosen");
	
	ct.Choose_Quantity();
	extenttest.log(LogStatus.PASS, "Quantity of the product is chosen");
	
	ct.Click_on_AddToCart_Button();
	extenttest.log(LogStatus.PASS, "Add to Cart button is clicked");
	
	ct.Added_to_Cart_Message();
	extenttest.log(LogStatus.PASS, "'Product Added to your Cart successfully' message has appeared");
	
	ct.AddToCart_Button_Change();
	extenttest.log(LogStatus.PASS, "ADD TO CART button has changed to GO To CART");
	
	ct.Cart_Icon();
	extenttest.log(LogStatus.PASS, "Cart icon has displayed the quantity of product added");
	
	ts = (TakesScreenshot)driver;
	File filesrc3 = ts.getScreenshotAs(OutputType.FILE);
	File filedest3 = new File("/test-output/Images/Addtocart.png");
	FileUtils.copyFile(filesrc3, filedest3 );
	extenttest.log(LogStatus.PASS,extenttest.addScreenCapture("/test-output/Images/Addtocart.png") +"Product added to Cart successfully");
	
	extent.endTest(extenttest);
	extent.flush();
	extent.close();
	
}

}

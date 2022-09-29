package Framework.EndtoEndEcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder 
{
	WebDriver driver;//this driver object is null
public PlaceOrder(WebDriver Idriver)
{
	
	this.driver=Idriver;//idriver scope is within this constructor only so before its getting lost we are assigning this to local class by using this.driver
	PageFactory.initElements(Idriver, this);
}
	
	
	@FindBy(xpath="//span[text()=' India']")
	WebElement country;
	@FindBy(xpath="//button[text()=' Sign Out ']") 
	WebElement signout;
	By buynow=By.xpath("//button[text()='Buy Now']");
	By countrytoselect=By.xpath("//div[text()=' Shipping Information ']//ancestor::div[@class='payment__shipping']//input[@class='input txt text-validated']");
	By placeorder=	By.xpath("//a[text()='Place Order ']");
	
	public void order() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 45);
		WebElement buynowbutton =wait.until(ExpectedConditions.visibilityOfElementLocated(buynow));
		buynowbutton.click();
		WebElement selectcountry =wait.until(ExpectedConditions.visibilityOfElementLocated(countrytoselect));
		selectcountry.sendKeys("India");
		Thread.sleep(6000);
		country.click();
		System.out.println("India is selected from options");
		WebElement placeanorder =wait.until(ExpectedConditions.visibilityOfElementLocated(placeorder));
		placeanorder.click();
		System.out.println("Order has been placed");
	}
	public void logout()
	{
		signout.click();
		
		
		
	}
}

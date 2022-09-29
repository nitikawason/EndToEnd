package Framework.EndtoEndEcommerce;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginOther extends Utility
{
	@Parameters({"UserName","Password"})
	@Test(priority=2,testName="Complete Flow")
	public void ApplicationOperation(String User,String pass) throws Throwable
	{
		//test=extent.createTest("Login and Place Order");
	LoginToApplication login=new LoginToApplication(driver);
	login.credentials(User,pass);
	ProductSelection prod=new ProductSelection(driver);
	prod.AddProduct();
	WebDriverWait wait=new WebDriverWait(driver, 45);
	PlaceOrder order=new PlaceOrder(driver);
	order.order();
	order.logout();
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5/b[text()='zara coat 3']//ancestor::div[@class='card-body']//button[text()=' Add To Cart']"))).click();
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@routerlink='/dashboard/cart']"))).click();
	
	/*WebElement buynowbutton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Buy Now']")));
	buynowbutton.click();
	WebElement selectcountry =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Shipping Information ']//ancestor::div[@class='payment__shipping']//input[@class='input txt text-validated']")));
	selectcountry.sendKeys("India");
	Thread.sleep(6000);
	selectcountry.findElement(By.xpath("//span[text()=' India']")).click();
	System.out.println("India is selected from options");
	WebElement placeanorder =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Place Order ']")));
	placeanorder.click();
	System.out.println("Order has been placed");*/
	}
}

package Cucu.StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.EndtoEndEcommerce.LoginOther;
import Framework.EndtoEndEcommerce.LoginToApplication;
import Framework.EndtoEndEcommerce.PlaceOrder;
import Framework.EndtoEndEcommerce.ProductSelection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login 
{
	WebDriver driver;
	 
	 LoginToApplication login=null;
	 ProductSelection prod=null;
	 PlaceOrder order=null;
	 
	@Given("User launch the URL")
	public void User_launch_the_URL()
	{
		WebDriverManager.chromedriver().setup();
		System.out.println("Application is Started");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Input the URL");
		
		driver.get("https://rahulshettyacademy.com/client/");
		System.out.println("URL has been inputted");
	}

	@Given("^User enter(.+) and (.+)$")//REgular expression we are using and it always start with ^ and ends with $
	public void User_enter_username_and_password(String Username,String Password)
	{
		 login=new LoginToApplication(driver);
		login.credentials(Username,Password);	
	}
	
	@When(" User add Product to cart")
	public void User_add_Product_to_cart() throws Throwable
	{
		 prod=new ProductSelection(driver);
		prod.AddProduct();
	}
	@And("check out the product and place the order")
	public void check_out_the_product_and_place_the_order() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 45);
		 order=new PlaceOrder(driver);
		order.order();
	}
	
	@Then("User is logged out successfully")
	public void User_is_logged_out_successfully()
	{
		 order=new PlaceOrder(driver);
		
		order.logout();
	}
}

package Framework.EndtoEndEcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Parameters;


public class Login extends Utility

{
    @Parameters({"UserName","Password"})
	@Test(priority=1,groups= {"Regression"},testName="Login Only",retryAnalyzer=ListenerForRerun.class)
	public  void logintoapplication(String UN,String PW) throws Throwable
	
	{	
	
	//test=extent.createTest("Login and LogOUT");
	LoginToApplication login=new LoginToApplication(driver);
	login.credentials(UN,PW);
	PlaceOrder order=new PlaceOrder(driver);
	
	order.logout();
	Thread.sleep(2000);
	
	
	}
}
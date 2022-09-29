package Framework.EndtoEndEcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToApplication 
{

    WebDriver driver;	
	public LoginToApplication(WebDriver Idriver)
	{
		
		this.driver=Idriver;
		PageFactory.initElements(Idriver, this);
	
	}
	
	@FindBy(id="userEmail")
	WebElement userid;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement LoginButton;
	
	
	
	
	public void credentials( String UserName,String Password)
	{
		userid.sendKeys(UserName);
		password.sendKeys(Password);
		LoginButton.click();
		System.out.println("Button is clicked after entering Username and Password");
	}
	

	
}

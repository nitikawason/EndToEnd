package Framework.EndtoEndEcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonutility 
{


    WebDriver driver;	
	public commonutility(WebDriver Idriver)
	{
		
		this.driver=Idriver;
		PageFactory.initElements(Idriver, this);
	}
	
	public void waitforelements(By xpath)
	
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 45);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@routerlink='/dashboard/cart']"))).click();
	}
	
	
	
	
}

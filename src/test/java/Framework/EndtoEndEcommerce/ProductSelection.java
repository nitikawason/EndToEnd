package Framework.EndtoEndEcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductSelection extends commonutility

{

    WebDriver driver;	
	public ProductSelection(WebDriver Idriver)
	{
		super(Idriver);
		this.driver=Idriver;
		PageFactory.initElements(Idriver, this);
	}
	

	By coatselectedZara=By.xpath("//h5/b[text()='zara coat 3']//ancestor::div[@class='card-body']//button[text()=' Add To Cart']");
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement AddtoCart;
	
	By ItemAddedVerified=By.xpath("//h3[text()='zara coat 3']");
	
	
	
	
	
	
	public void AddProduct() throws InterruptedException
	
	{
		WebDriverWait wait=new WebDriverWait(driver, 45);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(coatselectedZara)).click();
		Thread.sleep(6000);
		AddtoCart.click();
		WebElement expected =wait.until(ExpectedConditions.visibilityOfElementLocated(ItemAddedVerified));
		String ele1=expected.getText();
		System.out.println(ele1);
		boolean verify= ele1.equalsIgnoreCase("zara coat 3");
		Assert.assertTrue(verify);
		System.out.println("Item added is verified in cart");
		//waitforelements(coatselectedZara);
		
		/*WebElement expected =wait.until(ExpectedConditions.visibilityOfElementLocated((By) AddedElementInCart));
		String ele1=expected.getText();
		System.out.println(ele1);
		boolean verify= ele1.equalsIgnoreCase("zara coat 3");
		Assert.assertTrue(verify);
		System.out.println("Item added is verified in cart");*/
	}





	private By By(By coatselectedZara2) {
		// TODO Auto-generated method stub
		return null;
	}
}

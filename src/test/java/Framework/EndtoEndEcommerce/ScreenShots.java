package Framework.EndtoEndEcommerce;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ScreenShots 
{
    WebDriver driver;
   
	public ScreenShots(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(Idriver, this);
		
	}
	
	public static String screenshotfailure(WebDriver driver,String screenshotsname) throws IOException
	{
		try
		{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		
				File destination=new File(System.getProperty("user.dir")+"//screenshots//"+screenshotsname+".png");
			//String errflpath=	destination.getAbsolutePath();
			//System.out.println(errflpath);
			FileUtils.copyFile(Source, destination);
		
		
		
			return System.getProperty("user.dir")+"//screenshots//"+screenshotsname+".png";
	}
		
	catch(Exception e)
	
	{
		
		System.out.println("Exception is :"+e);
		return e.getMessage();
	}
}

}
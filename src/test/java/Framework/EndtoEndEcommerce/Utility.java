package Framework.EndtoEndEcommerce;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility 
{
	public static WebDriver driver;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	//ThreadLocal<ExtentTest> local=new ThreadLocal();
	
	
	//@BeforeMethod(alwaysRun=true)
	public static ExtentReports extenreports()
	{

		String path = System.getProperty("user.dir") + "\\Reports\\testreport.html";

		reporter = new ExtentHtmlReporter(path);

		reporter.config().setReportName("Web Automation");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
		
	}
	
	
	@BeforeTest
	public void setupdriver()
	{
		/*String path = System.getProperty("user.dir") + "\\Reports\\testreport.html";

		reporter = new ExtentHtmlReporter(path);

		reporter.config().setReportName("Web Automation");

		extent = new ExtentReports();
		extent.attachReporter(reporter);*/		
		
		
		
		WebDriverManager.chromedriver().setup();
		System.out.println("Application is Started");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Input the URL");
		
		driver.get("https://rahulshettyacademy.com/client/");
		System.out.println("URL has been inputted");
	}
	
	//@AfterMethod(alwaysRun=true)
	@AfterTest
	public void close()
	{
		driver.quit();
		System.out.println("Application is closed");
		extent.flush();
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


/*	@AfterMethod
	public void captureScreenshot(ITestResult result) throws IOException 
	{
		System.out.println("hello");
if (result.getStatus() == ITestResult.FAILURE)
{
String screenShotPath = ScreenShots.screenshotfailure(driver, result.getMethod().getMethodName());
System.out.println(screenShotPath);
try 
{
test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
ExtentColor.RED));
test.fail(result.getThrowable());
}

catch(Exception e)
{
	
	System.out.println(e);
}
test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
// test.fail(result.getThrowable().getMessage(),
// MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
// test.fail("Details",
// MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotandReports.takeScreenshots(driver,
// screenShotPath).get("").toAbsolutePath().toString() +
// "/screenshotFolder/screenshot.png").build());
} else if (result.getStatus() == ITestResult.SUCCESS) {
	test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
} else {
test.log(Status.SKIP,
MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
	test.skip(result.getThrowable());
}

}*/


}
	
	
	


package Framework.EndtoEndEcommerce;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners extends Utility implements ITestListener 
{
	ExtentTest test;
	ExtentReports extent=Utility.extenreports();
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		//local.set(test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("hello");
		if (result.getStatus() == ITestResult.FAILURE)
		{
		String screenShotPath = null;
		try {
			screenShotPath = screenshotfailure(driver, result.getMethod().getMethodName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		try {
			test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

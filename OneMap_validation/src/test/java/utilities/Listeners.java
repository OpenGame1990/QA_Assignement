package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners extends CaptureScreenshot implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" is "+result.getStatus());
		try {
			getScreenshot();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" is "+result.getStatus()+" and screenshot is captured");
		try {
			getScreenshot();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test case failed-because of timeout");
		try {
			getScreenshot();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Case is finnished");
	}

}

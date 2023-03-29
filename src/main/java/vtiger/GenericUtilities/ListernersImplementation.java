package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernersImplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"...Execution started");
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"...Passed");
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		/*WebDriverUtility wUtil = new WebDriverUtility();
		 JavaUtility jUtil = new JavaUtility();
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"...Failed");
		
		String ScreenshotName = methodname+".."+jUtil.getSystemDateInFormat();
		try {
			wUtil.takeScreenShot(BaseClass.sDriver, ScreenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"...Skipped");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite execution started");
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite execution finished");
	}
		

}

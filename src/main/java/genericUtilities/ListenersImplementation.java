package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This Class provides Implementation to ITestListener Interface of TestNG
 * @author Jija
 */
public class ListenersImplementation implements ITestListener  {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//@Test- Method
		String methodName = result.getMethod().getMethodName();
		
		System.out.println("--------Test Execution Started--------");
		
		test= report.createTest(methodName);
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
      String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"--------Test Pass--------");
		test.log(Status.PASS,methodName+"--------Test Pass--------");
		}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 String methodName = result.getMethod().getMethodName();
			
			System.out.println(methodName+"--------Test Fail--------");
			System.out.println(result.getThrowable());
			
			test.log(Status.FAIL, methodName+"--------Test Fail--------");
			test.log(Status.INFO, result.getThrowable());
			
			
			//Capture ScreenShot
			SeleniumUtility s = new SeleniumUtility();
			JavaUtility j = new JavaUtility();
		
			String screenshotName = methodName+"-"+j.getSystemDate();
			try {
				String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
				
				test.addScreenCaptureFromPath(path);
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 String methodName = result.getMethod().getMethodName();
			
			System.out.println(methodName+"--------Test Skip--------");
			System.out.println(result.getThrowable());
			
			test.log(Status.SKIP, methodName+"--------Test Skip--------");
			test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
			}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--------Suite Execution Started--------");
		
	    ExtentSparkReporter htmlrep= new ExtentSparkReporter(".\\ExtentReports\\Report."+new JavaUtility().getSystemDate()+".html");
	    htmlrep.config().setDocumentTitle("Extent Report");
     	htmlrep.config().setReportName("Vtiger Report");
	    htmlrep.config().setTheme(Theme.DARK);
	
	    report= new ExtentReports();
	    report.attachReporter(htmlrep);
	    report.setSystemInfo("Base Platform", "Windows");
	    report.setSystemInfo("Base Browser", "Chrome");
	    report.setSystemInfo("Base Env", "Test Env");
	    report.setSystemInfo("Reporter Name", "Jija");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--------Suite Execution Finished--------");
		
		report.flush();
	}

}

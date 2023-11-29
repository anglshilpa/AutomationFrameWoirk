package vt.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentation  implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		 String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" "+"------onTestStart");
		
	}
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" "+"--------passed");
		
	}

	public void onTestFailure(ITestResult result) {

		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String MethodName=result.getMethod().getMethodName();
		String ScreenShot = MethodName+" "+jutil.getsystemDateInFormat();
		
		try {
			wutil.getTakeScreenShot(BaseClass.sdriver, ScreenShot);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		System.out.println(MethodName+" "+"--------failed");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		System.out.println(MethodName+" "+"------skipped");
	}

	

	public void onTestFailedWithTimeout(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		System.out.println(MethodName+" "+"------Failed");
	}

	public void onStart(ITestContext context) {

		System.out.println("Execute Before Suite");
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./Extentreports/Report"+new JavaUtility().getsystemDateInFormat()+".html");
		 htmlReport.config().setDocumentTitle("V-Tiger exe reports");
		 htmlReport.config().setTheme(Theme.DARK);
		 htmlReport.config().setReportName("VTIGER EXCUTION REPORT");
		 
		 ExtentReports eReport=new ExtentReports();
		 eReport.attachReporter(htmlReport);
		 eReport.setSystemInfo("url", "localhost:8888");
		 eReport.setSystemInfo("baseBrowser","fireFox");
		 
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execute after Suite");
	}
	
	
	

}

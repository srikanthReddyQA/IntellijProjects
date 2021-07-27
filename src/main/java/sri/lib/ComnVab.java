package sri.lib;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ComnVab {

	
	protected static String CommVar_ProjectName;
	protected static String Current_TestCase_Name;
	protected static String CommVar_currentfolder;
	protected static  WebDriver driver;
	protected  static ExtentReports TestReport;
	protected static ExtentTest CommVar_test;
	protected static String ScreenshotsFolderPath;
	protected static String CommVar_DataFilesPath;
	protected static String CommVar_CurrentModule;
	protected static HashMap<String,String> CurrentTestData;
	protected static String CommVar_UserName;
	protected static String CommVar_Password;
	
	protected static boolean CommVar_TakeScreenshotForEveryStep =true;
	
	
}

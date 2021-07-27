package sri.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

public class Base extends Util {
	

	
	 
	 
	// ComnVab v = new ComnVab();
	
	@BeforeSuite
	 //@Parameters({"Browser"})
	public void beforeSuite() {

		Properties prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream("E:\\srikanth\\Config\\config.properties");
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Unable to load data from configuraton.properties file");
		}

		CommVar_UserName = prop.getProperty("UserName");
		CommVar_Password = prop.getProperty("password");

		// create folder
		CommVar_currentfolder = System.getProperty("user.dir") + "\\Results";

		// create folder with date and time stamp
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
		String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
		DateTimeStamp = DateTimeStamp.replace(",", "");
		DateTimeStamp = DateTimeStamp.replace(" ", "_");
		DateTimeStamp = DateTimeStamp.replace(":", "-");
		CommVar_currentfolder = CommVar_currentfolder + "\\" + DateTimeStamp;

		File dir = new File(CommVar_currentfolder);
		dir.mkdir();
		ScreenshotsFolderPath = CommVar_currentfolder + "\\Screenshorts";
		File dir1 = new File(CommVar_currentfolder);
		dir1.mkdir();

		CommVar_DataFilesPath = System.getProperty("user.dir") + "\\DataFile";

		TestReport = new ExtentReports(CommVar_currentfolder + "\\Summary.html", true);

	}

	
	@BeforeMethod

	public void beforeMethod(Method name ) {

		if (CurrentTestData != null) {
			CurrentTestData.clear();
		}

		CommVar_CurrentModule =name.getName();

		System.out.println(CommVar_CurrentModule);
		
		System.out.println("#################");
		Current_TestCase_Name = this.getClass().getSimpleName();
		System.out.println(Current_TestCase_Name);
		CurrentTestData = elib_loadData(Current_TestCase_Name,CommVar_CurrentModule);
		//System.out.println(CurrentTestData);

		CommVar_test = TestReport.startTest(Current_TestCase_Name);
		
		
		
		
		driver = Lanchbrowser("chrome");
		lanchapp("http://rumbleonqa.tracker.bike/");
		

	}

	@AfterMethod
	public void afterMethod() {
		TestReport.endTest(CommVar_test);
	

	//	elib_UploadData(Current_TestCase_Name, CommVar_CurrentModule);
		//driver.close();
	}

	@BeforeClass
	public void beforeClass() {

	}

	@AfterSuite
	public void afterSuite() {
		TestReport.close();

	}

}

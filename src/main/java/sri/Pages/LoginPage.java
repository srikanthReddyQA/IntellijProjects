package sri.Pages;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import sri.ObjectRep.Login_Obj;
import sri.lib.Util;

public class LoginPage extends Util {
	boolean status;

	public void Signin() throws IOException, InterruptedException {
		Thread.sleep(1000);
		status = click(Login_Obj.Signin);
		Logevents(status, "clicked on signin", "Un able to click on signin");

	}

	public void Are_you_Acustomer() throws IOException {

		status = click(Login_Obj.Are_you_Acustomer);
		Logevents(status, "clicked Are_you_Acustomer", "Un able to click Are_you_Acustomer");

	}

	public void Username() throws IOException {
		// getdata("UserName")
		System.out.println(getdata("UserName"));

		status = settext(Login_Obj.UserName, getdata("UserName"));
		// status = settext(Login_Obj.UserName,CommVar_UserName );
		Logevents(status, "Username sent", "Un able to sent Username");

	}

	public void Password() throws IOException {

		// getdata("Password")s
		status = settext(Login_Obj.Password, getdata("Password"));
		// status = settext(Login_Obj.Password,CommVar_Password);
		Logevents(status, "Password sent", "Un able to sent Password");

	}

	public void Login() throws IOException {

		status = click(Login_Obj.Login);
		Logevents(status, "Login clicked", "Un able to click Login");

	}

}

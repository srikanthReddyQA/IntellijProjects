package sri.srikanth;


import java.io.IOException;

import org.testng.annotations.Test;

import sri.Pages.LoginPage;
import sri.lib.Base;

public class Login_App extends Base{
	LoginPage Login_p =new LoginPage();
	
	@Test
	public void Login() throws IOException, InterruptedException  {
		Login_p.Signin();
		Login_p.Are_you_Acustomer();
		Login_p.Username();
		Login_p.Password();
		Login_p.Login();
		
		
	}

}

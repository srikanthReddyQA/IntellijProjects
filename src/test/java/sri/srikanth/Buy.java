package sri.srikanth;

import java.io.IOException;

import org.testng.annotations.Test;

import sri.Pages.BuyPage;
import sri.Pages.LoginPage;
import sri.lib.Base;

public class Buy extends Base {
	BuyPage buy_p = new BuyPage();
	LoginPage Login_p = new LoginPage();


	@Test
	public void buy() throws IOException, InterruptedException {
		System.out.println("Srikanth");
		Login_p.Signin();
		Login_p.Are_you_Acustomer();
		Login_p.Username();
		Login_p.Password();
		Login_p.Login();
		buy_p.Buy();
		buy_p.Buy_Search();
		//buy_p.Buy_Search_icon();
		
		
		
	   
	}

}

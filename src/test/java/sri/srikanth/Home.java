	
package sri.srikanth;

import java.io.IOException;

import org.testng.annotations.Test;

import sri.Pages.HomePage;
import sri.lib.Base;

public class Home extends Base{
	
	HomePage Home = new HomePage ();
	@Test
	public void verifyHomeScreen() throws IOException, InterruptedException {
		System.out.println("home page");
		Home.verifyLogo();
		Home.verify_Buy_Sell_TradeMotorcycles();
		Home.verify_search_bar();
		
	}
	
}

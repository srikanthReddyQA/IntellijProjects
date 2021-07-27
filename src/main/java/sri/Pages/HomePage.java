package sri.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import sri.ObjectRep.Home_Obj;
import sri.lib.Util;

public class HomePage extends Util {
	
	
	
	
	Home_Obj Home = new Home_Obj();
	
	boolean status = false;
	
	
	public void verifyLogo() throws IOException, InterruptedException {
		
		status=	displayed(Home.Logo);
		Logevents(status, "RumbleON Logo displayed", "RumbleON Logo not displayed");
		System.out.println(status);
		
	}
		
	public void verify_Buy_Sell_TradeMotorcycles() throws IOException {
	
		status=	displayed(Home.Buy_Sell_TradeMotorcycles);
		Logevents(status, "Buy_Sell_TradeMotorcycles text displayed", "Buy_Sell_TradeMotorcycles text not  displayed");
			System.out.println(status);
		
	}
	public void verify_search_bar() throws IOException {
		
		status=	displayed(Home.search_box);
		Logevents(status, "search bar present", "search bar not present");
			System.out.println(status);
		
	}
	
	
	
	
	
	
		
	}
	
	
	


package sri.Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import sri.ObjectRep.Buy_Obj;
import sri.lib.Util;

public class BuyPage extends Util {
	boolean status;

	public void Buy() throws IOException, InterruptedException {

		Thread.sleep(6000);
		status = click(Buy_Obj.Buy);
		//Logevents(status, "clicked on Buy", "Un able to click on Buy");
		


//driver.findElement(By.xpath("//*[@id='enable_scroll']/div[1]/nav/div/ul/li[2]/a")).click();



		


	}
	

	public void Buy_Search() throws IOException, InterruptedException {

		status = settext(Buy_Obj.search, getdata("search"));
		Logevents(status, "click on search icon", "Un able to click on search icon");
		
Thread.sleep(1000);
		
		
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//*[@class='jss142']"));
		actions.moveToElement(mainMenu);

		
	List<WebElement> itr =	driver.findElements(By.xpath("//*[@class='jss135']/../h2[1]"));
		
		
		
	System.out.println(itr.size()+"%%%%%%%%%%");
	
	Iterator<WebElement> itr1 = itr.iterator();
	int i=0;
	
	while(itr1.hasNext()) {
		
		if(i==5) {
			
		break;	
		}
		System.out.println(i);
		WebElement ele =itr1.next();
		
		String xx =ele.getText();
		
		
	//	System.out.println(xx);
		 String[] s = xx.split(" ");
		 System.out.println(s[0]);
		 System.out.println(s[1]);
		 
		 
		 
		i++; 
	}
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
	
	
		

	}

	public void Buy_Search_icon() throws IOException, InterruptedException {

		status = click(Buy_Obj.search_icon);
		Logevents(status, "enter value", "Un able to enter value");
		
		
		
		
	}

	
			  
	
		
		
		
		
		
		
		
	
	

}

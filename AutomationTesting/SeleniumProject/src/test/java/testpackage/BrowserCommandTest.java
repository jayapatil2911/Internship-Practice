package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommandTest 
{

	public static void main(String[] args) 
	{
		 WebDriver driver = new ChromeDriver();

	        driver.get("https://www.google.com");

	       
	        String title = driver.getTitle();                   // Get Title
	        System.out.println("Page Title: " + title);
	        
	        
	        String currentURL =  driver.getCurrentUrl();                  // Get url
	        System.out.println("current URL:" +currentURL) ;
	       
	        System.out.println(driver.getPageSource());                  //  html page
	        System.out.println(driver.getWindowHandle());            
	       
	        driver.quit();
	        
	        

	    }

	}



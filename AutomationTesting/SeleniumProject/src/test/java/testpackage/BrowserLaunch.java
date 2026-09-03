package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

	public static void main(String[] args)
	{
		

		        WebDriver driver = new ChromeDriver();

		      driver.get("https://www.google.com");
		        
		     //  driver.get("https://www.myntra.com");
		       
		      
		      driver.manage().window().maximize();

		       
		        String title = driver.getTitle();                   // Get Title
		        System.out.println("Page Title: " + title);

		       
		        String url = driver.getCurrentUrl();                         // Get Current URL
		        System.out.println("Current URL: " + url);

		        driver.quit();
		                                                    // Close Browser 
		    }
		}










//  driver.findElement(By.name("q"))
//    .sendKeys("myntra.com");

// Press Enter
// driver.findElement(By.name("q"))
   // .sendKeys(Keys.ENTER);



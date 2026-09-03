package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	 WebDriver driver;

	    @BeforeMethod    
	    public void setup() throws InterruptedException 
	    {
           Thread.sleep(2000);
	       
          driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.get("https://www.saucedemo.com");
	    }

	    @AfterMethod

	    public void tearDown() throws InterruptedException 
	    {
         
	    	 Thread.sleep(3000);
	       
          driver.quit();
       }
}

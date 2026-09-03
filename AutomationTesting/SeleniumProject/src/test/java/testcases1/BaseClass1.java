package testcases1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass1 
{
	WebDriver driver;

    @BeforeMethod    
    public void setup() 
    {
       
       
      driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod

    public void tearDown() throws InterruptedException 
    {
     
    	 Thread.sleep(3000);
       
      driver.quit();
   }
}

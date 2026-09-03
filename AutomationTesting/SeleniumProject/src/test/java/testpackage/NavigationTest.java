package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest 
{

	public static void main(String[] args) throws InterruptedException 
	{

		
		        WebDriver driver = new ChromeDriver();

		        driver.manage().window().maximize();

		        driver.get("https://demoqa.com");
		         
		        driver.navigate().to("https://demoqa.com/elements");
		        
		       Thread.sleep(10000);
		       
		       if (driver.getCurrentUrl().equals("https://demoqa.com/elements")) {
		            System.out.println("Navigate To : PASS");
		        } else {
		            System.out.println("Navigate To : FAIL");
		        }

		        driver.navigate().back();
		        Thread.sleep(10000);
		        
		        if (driver.getCurrentUrl().equals("https://demoqa.com/")) {
		            System.out.println("Back Navigation : PASS");
		        } else {
		            System.out.println("Back Navigation : FAIL");
		        }

		        driver.navigate().forward();
		        Thread.sleep(10000);
		        
		        if (driver.getCurrentUrl().equals("https://demoqa.com/elements")) {
		            System.out.println("Forward Navigation : PASS");
		        } else {
		            System.out.println("Forward Navigation : FAIL");
		        }

		        driver.navigate().refresh();
		        
		        
		        

		        driver.quit();

		    }

		}
		
		
	



package testpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoExplicitTest
{

	public static void main(String[] args) throws InterruptedException 
	{
		  WebDriver driver = new ChromeDriver();
		  
		 driver.get("https://demoqa.com");
	    
		// driver.navigate().to("https://demoqa.com/elements");
	        
		 driver.navigate().to("https://demoqa.com/text-box");

	        driver.manage().window().maximize();
	       
	        Thread.sleep(200);
		   
		 driver.findElement(By.id("userName")) .sendKeys("jaya patil") ;    //textbox
	       driver.findElement(By.id("userEmail")).sendKeys("jayapatil2911@gmail.com");
	       
	      driver.findElement(By.id("currentAddress")).sendKeys("pune, maharashtra");
	       
	    driver.findElement(By.id("permanentAddress"))  .sendKeys("Buldhana, Maharashtra");
	   
	   
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));        //EXPLICIT
	   
	    WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

		  JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", submit);

	    	Thread.sleep(1000);

	    	submit.click();
	        
	       driver.quit();
	      
	       
	}
	
}


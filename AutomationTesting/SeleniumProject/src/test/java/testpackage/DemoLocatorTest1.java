package testpackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLocatorTest1 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();

	        driver.manage().window().maximize();
	      

	        driver.get("https://testautomationpractice.blogspot.com");
	        
	        driver.findElement(By.cssSelector("#Wikipedia1_wikipedia-search-input")).sendKeys("Testing");  // cssselector id

	        driver.findElement(By.cssSelector(".wikipedia-search-button")).click();  // cssselector using classnsme
	        
	        driver.findElement(By.cssSelector(".start")).click();          // cssselector using classnsme
	        
	        driver.findElement(By.id("alertBtn")).click();            // id
	       // driver.findElement(By.id("confirmBtn")).click(); 
	        
	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();
	        
	        
	        driver.findElement(By.xpath("//button[text()='New Tab']")).click();      //xpath
	      
	       
	        driver.navigate().back();
	      
	      
	     // driver.findElement(By.linkText("Apple"));        // linktext
	       
	        //  driver.findElement(By.partialLinkText("App"));            //partiallinktext
	       // driver.findElement(By.xpath("//a[text()='Apple']"));     //xpath
	        
	        
	        
	        // driver.findElement(By.xpath("//*[text()='New Tab']")).click();
	        
	        
	        
	        
	      
	        
	        
	        
	}

}

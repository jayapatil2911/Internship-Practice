package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoLocatorTest
{

	public static void main(String[] args) throws InterruptedException
	{
	
		 WebDriver driver = new ChromeDriver();

	       // driver.manage().window().maximize();
	      

	        driver.get("https://testautomationpractice.blogspot.com");

  // 1. ID Locator
	      
	        driver.findElement(By.id("name"))
	              .sendKeys("Jaya Patil");
//2.name
	        driver.findElement(By.id("email"))
            .sendKeys("jayapatil2911@gmail.com");
	       
	      //  driver.findElement(By.name("email"))        //   not found
          //  .sendKeys("jayapatil2911@gmail.com");
	        
	//3 classname        
	      //  driver.findElement(By.className("form-control")) // not found
           // .sendKeys("9765399688");
	      
	       driver.findElement(By.id("phone"))
            .sendKeys("9765399688");
	        
	        
	        driver.findElement(By.id("textarea"))
	        .sendKeys("This is my address.");
	        
	        driver.findElement(By.id("female")).click();
	        driver.findElement(By.id("tuesday")).click();
	        
	        //driver.findElement(By.xpath("//option[@value='india']")).click();   //xpath
	        
	        driver.findElement(By.xpath("//*[@id='country']/option[10]")).click();  //xpath
	    
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,600)");

	        driver.findElement(By.xpath("//*[@id=\"colors\"]/option[6]")).click();   //xpath
	        
	        Select animals = new Select(driver.findElement(By.id("animals")));
	        animals.selectByVisibleText("Dog");
	        
	       // Thread.sleep(10000);
	        
	        driver.findElement(By.id("datepicker"))
            .sendKeys("27/7/2026");
	        
	        driver.findElement(By.id("txtDate"))
            .sendKeys("31/7/2026");
	        driver.findElement(By.id("start-date")).sendKeys("27/7/2026");
	        
	        driver.findElement(By.id("end-date")).sendKeys("31/7/2026");
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();   //xpath
	        
	        Thread.sleep(10000);
	        driver.findElement(By.linkText("Home")).click();
	      
              
	        
	}

	
		
	}



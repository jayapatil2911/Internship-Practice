package testcases1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMAutomationTest extends BaseClass1

{
	 // TC_LOGIN_001
    // Verify Login with valid username and password
	@Test(priority = 1)
	public void validLoginTest()
	{

	    System.out.println("Current URL: " + driver.getCurrentUrl());
	    System.out.println("Page Title: " + driver.getTitle());

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.name("username")
	    )).sendKeys("Admin");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.name("password")
	    )).sendKeys("admin123");

	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[@type='submit']")
	    )).click();

	    wait.until(ExpectedConditions.urlContains("/dashboard"));

	    Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"),"User was not redirected to Dashboard" );
	            
		   
	            
	}
	
	  // TC_LOGIN_002
    // Verify Login with invalid username
	@Test(priority = 2)
	public void invalidUsername()
	{
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.visibilityOfElementLocated( By.name("username"))).sendKeys("abc");
	           
	    

	    wait.until(
	    		ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
	        

	   wait.until(
			   ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	    WebElement error = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")));
	                   
	         
	    Assert.assertEquals(error.getText(),"Invalid credentials","Incorrect error message displayed");
	            
	            
	            
	    
	}
	
	
	
	// TC_LOGIN_003
    // Verify Login with invalid password
    @Test(priority = 3)
    public void invalidPassword() {

    	 // Open Login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
               

                
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
                       
               
      

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("xyz");
              
              
         wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
                      
              
         WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")));
                        
        
  Assert.assertEquals(error.getText(), "Invalid credentials", "Incorrect error message displayed" );
               
               
               
       
    }
}

    
	
	
                
   

	
	
	
	
	
	

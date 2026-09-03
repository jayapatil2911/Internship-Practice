package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabTest extends BaseClass   // testng keywords
{

	  @Test(priority = 1)
	    public void loginTest() 
	  {

	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();
	        
	        Assert.assertEquals(driver.getCurrentUrl(),
	                "https://www.saucedemo.com/inventory.html");
	  }
	  
	  
	  @Test(priority = 2)
	    public void verifyTitle() 
	  {

	        Assert.assertEquals(driver.getTitle(), "Swag Labs");
       }
	        
	        
	     
@Test(priority = 3)
public void invalidLogin() 
{

    driver.findElement(By.id("user-name")).sendKeys("abc");

    driver.findElement(By.id("password")).sendKeys("xyz");

    driver.findElement(By.id("login-button")).click();

    String error = driver.findElement(By.tagName("h3")).getText();

    Assert.assertTrue(error.contains("Username and password do not match"));

}
@Test(priority = 4)
public void emptyUsername() 
{

    driver.findElement(By.id("password")).sendKeys("secret_sauce");

    driver.findElement(By.id("login-button")).click();

    String error = driver.findElement(By.tagName("h3")).getText();

    Assert.assertEquals(error, "Epic sadface: Username is required");

}


@Test(priority = 5)
public void emptyPassword()
{

    driver.findElement(By.id("user-name")).sendKeys("standard_user");

    driver.findElement(By.id("login-button")).click();

    String error = driver.findElement(By.tagName("h3")).getText();

    Assert.assertEquals(error, "Epic sadface: Password is required");
}

@Test(priority = 6)
public void emptyCredentials()
{

    driver.findElement(By.id("login-button")).click();

    WebElement error = driver.findElement(By.tagName("h3"));

    Assert.assertEquals(error.getText(),
            "Epic sadface: Username is required");

}
@Test(priority = 7)
public void logoutTest()
{

    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.findElement(By.id("react-burger-menu-btn")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
    wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();

    Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));

}







}











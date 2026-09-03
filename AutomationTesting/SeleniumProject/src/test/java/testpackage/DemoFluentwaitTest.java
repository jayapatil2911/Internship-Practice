package testpackage;



import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoFluentwaitTest {

	public static void main(String[] args) throws InterruptedException 
	{
	
		        WebDriver driver = new ChromeDriver();

		        driver.manage().window().maximize();
		        
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		        Thread.sleep(5000);
		        
		   
		     FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		             .withTimeout(Duration.ofSeconds(20))
		             .pollingEvery(Duration.ofSeconds(2))
		             .ignoring(NoSuchElementException.class);                  // Fluent Wait

		     Thread.sleep(5000);

		     System.out.println("Current URL: " + driver.getCurrentUrl());
		     System.out.println("Title: " + driver.getTitle());

		     WebElement username = fluentWait.until( d -> d.findElement(By.name("username")));
		            

		     username.sendKeys("Admin");

		     System.out.println("Username entered successfully.");

              Thread.sleep(5000);

           
              WebElement password = fluentWait.until(
                      d -> d.findElement(By.name("password")));           // Password
              password.sendKeys("admin123");

             
              WebElement loginButton = fluentWait.until(
                      d -> d.findElement(By.xpath("//button[@type='submit']")));    // Login button
              loginButton.click();

              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

              WebElement dashboard = wait.until(
                      ExpectedConditions.visibilityOfElementLocated( By.xpath("//h6[text()='Dashboard']")));  // dashboard
                             

              System.out.println("Login Successful");
              System.out.println(dashboard.getText());


		        driver.quit();
		    }
		

		
		
		
		
	}
	

	



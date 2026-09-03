package testpackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitExplicitTest {

	//implicit      //explicit
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));     // 1. Implicit Wait (Global wait)

		driver.get("https://demoqa.com/text-box");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));     // 2. Explicit Wait (Specific element wait)

		WebElement fullName = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("userName"))    // Wait until Full Name textbox is visible
		);

		fullName.sendKeys("Jaya Patil");
		System.out.println("enter name successully");
		
		driver.findElement(By.id("userEmail"))
		      .sendKeys("jaya@gmail.com");
 
		System.out.println("enter email successully");
		
		driver.findElement(By.id("currentAddress"))
		      .sendKeys("Pune Maharashtra");
		System.out.println("enter address successully");
		
		driver.findElement(By.id("permanentAddress"))
		      .sendKeys("Buldana Maharashtra");
System.out.println("enter perment address successully");
		
		WebElement submit = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("submit")));    // Wait until Submit button is clickable
		

		JavascriptExecutor js = (JavascriptExecutor) driver;

		
		js.executeScript(
		        "arguments[0].scrollIntoView({block:'center'});",        // Scroll button into center of screen
		        submit
		);

		Thread.sleep(1000);


		js.executeScript("arguments[0].click();", submit);       		// Click using JavaScript to avoid footer interception
		
		System.out.println("submit Successful");

		driver.quit();
		
		
		

	}

}

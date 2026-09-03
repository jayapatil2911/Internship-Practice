package testpackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DemoImplicitTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));      //implicit

		driver.get("https://demoqa.com/automation-practice-form");
		
		
		driver.findElement(By.id("firstName")).sendKeys("Jaya");
		driver.findElement(By.id("lastName")).sendKeys("Patil");
		driver.findElement(By.id("userEmail")).sendKeys("jaya@gmail.com");
		
		driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
		
		driver.findElement(By.id("userNumber")).sendKeys("9876543210");
		
		driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
		
  driver.findElement(By.id("subjectsInput")).sendKeys("Computer Science", Keys.ENTER);
  
	
  WebElement music = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")); // hobby checkbox

  JavascriptExecutor js = (JavascriptExecutor) driver;
  js.executeScript("arguments[0].click();", music);
		
  Thread.sleep(1000);
 
  WebElement address = driver.findElement(By.id("currentAddress"));

  js.executeScript("arguments[0].scrollIntoView({block:'center'});", address);

  Thread.sleep(1000);

  address.sendKeys("Pune, Maharashtra");
  
		driver.quit();
		

	}

}

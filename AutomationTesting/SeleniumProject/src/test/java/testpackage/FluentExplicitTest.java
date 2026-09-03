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

public class FluentExplicitTest {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/dynamic-properties");


		
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)    //  Fluent Wait
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);


		WebElement visibleButton = fluentWait.until(driver1 -> 
				driver1.findElement(By.id("visibleAfter")));

		
		visibleButton.click();

		System.out.println("Visible button clicked");


		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));   //  Explicit Wait


		WebElement enableButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
						
		enableButton.click();

		System.out.println("Enable button clicked");

		driver.quit();


		

	}

}

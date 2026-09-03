package testpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentImplicitTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/dynamic-properties");


		// Fluent Wait
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);


		// Wait until button becomes visible
		WebElement visibleButton = fluentWait.until(driver1 -> 
				driver1.findElement(By.id("visibleAfter")));

		visibleButton.click();

		System.out.println("Visible button clicked");


		// Using implicit wait for Enable button
		WebElement enableButton = driver.findElement(By.id("enableAfter"));

		enableButton.click();

		System.out.println("Enable button clicked");


		driver.quit();

	}

}

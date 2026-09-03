package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLocatorTest2 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@id='user-name']/parent::div"));       //XPath using parent Axis
	    
		System.out.println(driver.getCurrentUrl());
		System.out.println("Parent XPath found");	
		
		
		driver.findElement(By.xpath("//input[@id='user-name']"))                 // Username xpath by attribute id
		      .sendKeys("standard_user");
		
		
		driver.findElement(By.xpath("//input[@id='password']"))                  // Password   xpath by attribute id
        .sendKeys("secret_sauce");
		
		driver.findElement(By.xpath("//input[contains(@id,'login')]"))         // login   XPATH BY Contains
		.click();
	
		
	driver.findElement(By.xpath("//button[contains(text(),'Add')]"))          //XPath using contains(text())
				.click();
		
		
	
//	driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"))     // XPath with Index 
			//			.sendKeys("standard_user");
	
		//	driver.findElement(By.xpath("//input[@name='user-name']"))              //xpath by name      username
	//	.sendKeys("standard_user");
		
	//	driver.findElement(By.xpath("//input[@class='input_error form_input']"))       // xpath by class      username
	//	.sendKeys("standard_user");
		
//		driver.findElement(By.xpath(
//				"//input[@id='user-name' and @name='user-name']"))                  //XPath using Multiple Attributes (AND)   username
//				.sendKeys("standard_user");
		
		
		
//		driver.findElement(By.xpath("//input[@type='password']"))              //xpath by attribute     password
//		.sendKeys("secret_sauce");
		
//  driver.findElement(By.xpath("//input[@id='user-name' or @name='user-name']"))   //XPath using OR Operator
//	.sendKeys("standard_user");		
		
//		driver.findElement(By.xpath("//input[starts-with(@id,'user')]"))         //xpath by  start-with
				
//				.sendKeys("standard_user");
	
		
	
	
//	driver.findElement(By.xpath("//input[@id='user-name']/parent::div/child::input"));
			
		
//	driver.findElement(By.xpath("//input[@id='user-name']/parent::div/child::*"));
			
//			System.out.println("Child XPath found");         //XPath using Child Axis
			   
			
		
		
		
	
	}
	
	
	

}

package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseClass   // writing test script task for swaglab product page
{
	
	 public void login() 
	 {

	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	              

	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	             

	        driver.findElement(By.id("login-button")).click();
	    	
	              
	 }
	
	
	@Test(priority = 1)
	public void TC_001_verifyProductsPageAfterLogin() 
	{
     login();
     
	    Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
                    
	}
	
	@Test(priority = 2)
	public void TC_002_verifyProductsPageTitle()
    {

	   login();

	    String pageTitle = driver.findElement(By.className("title")).getText();
	           
	            Assert.assertEquals( pageTitle,"Products");
	           
	            
	}
	
	@Test(priority = 3)
	public void TC_003_verifyProductsDisplayed() 
	{
        login();
	         

	    java.util.List<WebElement> products =driver.findElements( By.className("inventory_item"));
	            
	      Assert.assertTrue(products.size() > 0,"No products are displayed");
	            
	            
	}
	@Test(priority = 4)
	public void TC_004_verifyProductImages() {

	    login();
	         

	    java.util.List<WebElement> images = driver.findElements( By.cssSelector(".inventory_item_img img"));
	           
	                   

	    Assert.assertTrue( images.size() > 0, "Product images are not displayed");
	           
	           

	    for (WebElement image : images) 
	    {

	        Assert.assertTrue(image.isDisplayed());

	                
	        Assert.assertNotNull( image.getAttribute("src"));
	               
	    }
	    
	    
	    
	  }
	
	@Test(priority = 5)
	public void TC_005_verifyProductNames()
	{

	    login();

	          
	    java.util.List<WebElement> names =driver.findElements( By.className("inventory_item_name"));
	            
	                   

	    Assert.assertTrue(names.size() > 0);
	            

	    for (WebElement name : names) 
	      {

	        Assert.assertTrue(name.isDisplayed());
	                

	        Assert.assertFalse( name.getText().trim().isEmpty());
	               
	     }
	 }
	
	@Test(priority = 6)
	public void verifyProductPrices() 
	{

	    // Login
	   login();
	          

	    // Find prices
	    java.util.List<WebElement> prices = driver.findElements( By.className("inventory_item_price"));
	           
	                   

	    Assert.assertTrue(prices.size() > 0,"Product prices are not displayed");
	            
	            

	    for (WebElement price : prices) 
	    {

	        Assert.assertTrue(price.isDisplayed(),"Price is not displayed");
	                
	                

	        Assert.assertTrue( price.getText().startsWith("$"),"Invalid price format");
	               
	                
	    }
	}
	
	@Test(priority = 7)
	public void verifyAddToCartButtons() {

	    // Login
	    login();

	    // Find Add to Cart buttons
	    java.util.List<WebElement> buttons = driver.findElements( By.cssSelector("button[id^='add-to-cart']"));
        
	           

	    Assert.assertTrue( buttons.size() > 0,"Add to Cart buttons are not displayed");
	           
	            

	    for (WebElement button : buttons) 
	    {

	        Assert.assertTrue(
	                button.isDisplayed(),"Add to Cart button is not displayed");
	                

	        Assert.assertTrue( button.isEnabled(),"Add to Cart button is disabled");
	               
	                
	    }
	}
	
	
	@Test(priority = 8)
	public void addSingleProductToCart() 
	{

	    // Login
	    login();

	    // Click first Add to Cart button
	    driver.findElements(By.cssSelector("button[id^='add-to-cart']")) .get(0).click();
        
	            
	            

	    // Open Cart
	    driver.findElement( By.className("shopping_cart_link")) .click();
	           

	           
	    // Find cart items
	    java.util.List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
	           
	                    

	    // Verify one product
	    Assert.assertEquals( cartItems.size(), 1, "Product was not added to cart");
        
	           
	           
	}
	
	@Test(priority = 9)
	public void verifyCartItemCount() 
	{

	                                                                            // Login
	   login();
	          

	     driver.findElements(By.cssSelector("button[id^='add-to-cart']")).get(0).click(); // Add first product
	            
	            
	      String cartCount =driver.findElement(By.className("shopping_cart_badge")).getText(); // Get cart count
	            
	                    
	                     Assert.assertEquals( cartCount, "1");              // Verify
	           
	  }
	
	@Test(priority = 10)
	public void TC_010_addMultipleProductsToCart()
	{
	    login();

	    java.util.List<WebElement> buttons =
	            driver.findElements(
	                By.cssSelector("button[id^='add-to-cart']"));

	    System.out.println("Add to Cart buttons found: " + buttons.size());

	    Assert.assertTrue(buttons.size() >= 2,
	            "Less than 2 Add to Cart buttons found");

	    buttons.get(0).click();
	    buttons.get(1).click();

	    driver.findElement(
	            By.className("shopping_cart_link")).click();

	    java.util.List<WebElement> cartItems =
	            driver.findElements(
	                By.className("cart_item"));

	    System.out.println("Cart items found: " + cartItems.size());

	    Assert.assertEquals(cartItems.size(), 2,
	            "Expected 2 products in cart");
	}
	
	@Test(priority = 11)
	public void TC_011_removeProductFromCart()
	{
	    login();

	    driver.findElements(
	            By.cssSelector("button[id^='add-to-cart']"))
	            .get(0)
	            .click();

	    driver.findElement(
	            By.className("shopping_cart_link"))
	            .click();

	    driver.findElement(
	            By.cssSelector("button[id^='remove']"))
	            .click();

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions
	            .invisibilityOfElementLocated(
	                By.className("cart_item")));

	    java.util.List<WebElement> items =
	            driver.findElements(
	                By.className("cart_item"));

	    Assert.assertEquals(items.size(), 0,
	            "Product was not removed from cart");
	}
	
	@Test(priority = 12)
	public void TC_012_sortNameAToZ() 
	{

	    login();

	    Select sort = new Select(driver.findElement( By.className("product_sort_container")));
	            
	    sort.selectByValue("az") ;            

	   

	    java.util.List<WebElement> products = driver.findElements( By.className("inventory_item_name"));
	           
	                   

	    String firstProduct = products.get(0).getText();

	    Assert.assertEquals( firstProduct,"Sauce Labs Backpack");
	           
	            
	}

	@Test(priority = 13)
	public void TC_013_sortNameZToA()
	{

	    login();

	    Select sort = new Select( driver.findElement(By.className("product_sort_container")));
	           
	    sort.selectByValue("za");

	    java.util.List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
	           
	      String firstProduct = products.get(0).getText();

	    Assert.assertEquals( firstProduct,"Test.allTheThings() T-Shirt (Red)") ;
	           
	           
	}
	
	
	@Test(priority = 14)
	public void TC_014_sortPriceLowToHigh()
	{

	    login();

	    Select sort = new Select(driver.findElement(By.className("product_sort_container")));
	            

	                    
	    sort.selectByValue("lohi");

	    String firstPrice =driver.findElements( By.className("inventory_item_price")) .get(0).getText();
	            
	    Assert.assertEquals(firstPrice, "$7.99");          
	                   
	   }
	
	
	@Test(priority = 15)
	public void TC_015_sortPriceHighToLow() 
	{

	    login();

	    Select sort = new Select(driver.findElement(By.className("product_sort_container")));
	            
	     sort.selectByValue("hilo");

	    String firstPrice = driver.findElements(By.className("inventory_item_price")).get(0).getText();
        
	     Assert.assertEquals(firstPrice, "$49.99");             
	   
	}
	
	
	@Test(priority = 16)
	public void TC_016_verifyCartNavigation()
	{

	    login();

	    driver.findElement( By.className("shopping_cart_link")).click();
	           
	     String actualTitle =driver.findElement(By.className("title")) .getText();
	            
	    Assert.assertEquals(actualTitle,"Your Cart")  ;            
	                   

	 }
}

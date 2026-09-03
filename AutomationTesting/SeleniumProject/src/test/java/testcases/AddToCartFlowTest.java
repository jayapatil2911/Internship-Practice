package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFlowTest extends BaseClass
{
	

	    @Test
	    public void addProductToCart() 
	    {

	        // 1. Login
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");

	             
	        driver.findElement(By.id("password")) .sendKeys("secret_sauce");

	             
	        driver.findElement(By.id("login-button")).click();
	             

	        // 2. Verify Products page
	        String title = driver.findElement(By.className("title")).getText();
	                            

	        Assert.assertEquals(title, "Products");

	        // 3. Select product
	        driver.findElement(By.id("item_4_title_link")).click();
	              

	        // 4. Add product to cart
	        driver.findElement(By.id("add-to-cart")).click();
	             

	        // 5. Open cart
	        driver.findElement(By.className("shopping_cart_link")).click();
	             

	        // 6. Verify product is in cart
	        String product = driver.findElement( By.className("inventory_item_name")).getText();

	               
	                
	        Assert.assertEquals(product, "Sauce Labs Backpack");

	        System.out.println("PASS: Product successfully added to cart");
	    }
	}


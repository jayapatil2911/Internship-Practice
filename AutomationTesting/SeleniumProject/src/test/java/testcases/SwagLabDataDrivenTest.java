package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ReadExcel;

public class SwagLabDataDrivenTest extends BaseClass 
{

	@DataProvider(name = "LoginData")                  
	    public Object[][] getLoginData() throws IOException 
	    {

	        String filePath = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
	                                                                
	               

	        ReadExcel.openExcel(filePath, "LoginData");

	        int rows = ReadExcel.getRowCount();

	        Object[][] data = new Object[rows - 1][5];

	        for (int i = 1; i < rows; i++)
	         {

	            data[i - 1][0] = ReadExcel.getCellData(i, 0); // TC_ID
	            data[i - 1][1] = ReadExcel.getCellData(i, 1); // Username
	            data[i - 1][2] = ReadExcel.getCellData(i, 2); // Password
	            data[i - 1][3] = ReadExcel.getCellData(i, 3); // Expected Result
	            data[i - 1][4] = ReadExcel.getCellData(i, 4); // expected message
	         }
	        

	        ReadExcel.closeExcel();

	        return data;
	    }


	     @Test(dataProvider = "LoginData")     	    // Data Driven Login Test
	    public void loginTest(String tcId,  String username,String password, String expectedResult,
	    		String expectedMessage) 
         {

	        System.out.println("=================================");
	        System.out.println("Test Case ID: " + tcId);
	        System.out.println("Username: " + username);
	        System.out.println("Password: " + password);
	        System.out.println("Expected Result: " + expectedResult);
	        System.out.println("Expected message: " +expectedMessage );

	        
	        if (!username.equalsIgnoreCase("blank")) {
	            driver.findElement(By.id("user-name")).sendKeys(username);
	        }

	        if (!password.equalsIgnoreCase("blank")) {
	            driver.findElement(By.id("password")).sendKeys(password);
	        }
	                
	        
	        driver.findElement(By.id("login-button")).click();  // Click Login

	                

	        if (expectedResult.equalsIgnoreCase("Pass"))  // validation
	         {

	            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html" );
	                    
	            System.out.println("Actual Result: Login Successful")   ;   
	           
              }

	        else if (expectedResult.equalsIgnoreCase("Fail"))
	         {

	            String actualMessage = driver.findElement(By.tagName("h3")).getText();
	                    
	            Assert.assertEquals(actualMessage, expectedMessage,"Error message does not match" );
	                    
	            System.out.println("Actual Result: Login Failed");
	           
	            System.out.println("Actual Message: " + actualMessage);
	         }

	        System.out.println("Test completed: " + tcId);
         }

}
	



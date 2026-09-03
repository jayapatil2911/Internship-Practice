package testcases;

import java.io.IOException;

import utilities.ReadExcel;

public class ExcelReadTest 
{

       public static void main(String[] args) throws IOException 
         {

		     String filePath = System.getProperty("user.dir")+ "/src/test/resources/TestData.xlsx"; 
		                                          
		                                                       //Finds the location of your TestData.xlsx file.

		        ReadExcel.openExcel(filePath, "LoginData");   //Opens the Excel file and selects the LoginData sheet.

		        int rows = ReadExcel.getRowCount();          //Gets the total number of rows in Excel.

		        System.out.println("Total Rows: " + rows);

		        for (int i = 1; i < rows; i++)
		        {

		            String tcId = ReadExcel.getCellData(i, 0);        //Reads TC_ID.
		            String username = ReadExcel.getCellData(i, 1);    //Reads Username.
		            String password = ReadExcel.getCellData(i, 2);     //Reads Password.
		            String expectedResult = ReadExcel.getCellData(i, 3);  //Reads Expected Result.

		            System.out.println(tcId + " | " + username + " | "+ password + " | " + expectedResult );
		                    
		          }

		        ReadExcel.closeExcel();
		   }
		

}



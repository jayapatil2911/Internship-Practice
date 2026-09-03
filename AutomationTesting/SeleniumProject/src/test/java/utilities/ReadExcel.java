package utilities;



import java.io.FileInputStream;                  
import java.io.IOException;                      

import org.apache.poi.ss.usermodel.DataFormatter;    
import org.apache.poi.ss.usermodel.Sheet;            
import org.apache.poi.ss.usermodel.Workbook;         
import org.apache.poi.xssf.usermodel.XSSFWorkbook;     

public class ReadExcel
{

    static FileInputStream file;    
    static Workbook workbook;      
    static Sheet sheet;

    public static void openExcel(String filePath, String sheetName) throws IOException
                
    {

        file = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(file);

        sheet = workbook.getSheet(sheetName);
    }

    public static int getRowCount()             
    {

        return sheet.getPhysicalNumberOfRows();          
    }

    public static String getCellData(int row, int column)  
    {

        DataFormatter formatter = new DataFormatter();      

     return formatter.formatCellValue(sheet.getRow(row).getCell(column));
                                              
                                                       
                                                      
    }

    public static void closeExcel() throws IOException 
    {

        workbook.close();

        file.close();
    }

	
}



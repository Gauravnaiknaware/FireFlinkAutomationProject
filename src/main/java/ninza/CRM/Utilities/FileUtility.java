 package ninza.CRM.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
  *  
  * This class consist of genric method relate to
  * File Operation like Property File,Excel File etc
  * @author Gaurav Ganesh Naikna
  */
public class FileUtility {
	
	/**
	 * This method will read data from property File
	 * @param key 
	 *  @param key
	 *  @return
	 *  @throws IOException
	 *  
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		           FileInputStream fis=new FileInputStream("src/test/resources/CommonData.properties");
		           Properties p=new Properties();
		           p.load(fis);
		          String value= p.getProperty(key);
		          return value;
		           
	}
	/**
	 * This method will read data from excel File and return
	 * the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
     public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
    	 FileInputStream fis= new FileInputStream("src/test/resources/CommonData.properties");
    	 Workbook wb = WorkbookFactory.create(fis);
        return wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).toString();
    	  
     }
     
     public String readmultipleDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
    	 FileInputStream fis= new FileInputStream("src/test/resources/CommonData.properties");
    	 List <String>li= new ArrayList<String>();
    	  
    	 Workbook wb = WorkbookFactory.create(fis);
    	 return  wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).toString();
    	  
     }
}


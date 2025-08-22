 package ninzaCRM.genricUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;

/**
 * This class consist of generic methods related to
 * capture Random numbers and capture the system current date
 * @author Gaurav Ganesh Naikna
 */
public class JavaUtility {

	//capture Random Number
	//capture System date
	/**
	 * This method will genrate random number and return it to caller
	 * @return
	 * @throws FileNotFoundException
	 */
	public int CaptureRandomNumber() throws FileNotFoundException {
		             Random r=new Random();
		             int random= r.nextInt(1000);
		             return random;
		             
	}
	
	public String getsystemDate() {
        Date d=new Date(0);
        SimpleDateFormat s=new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
        String date = s.format(d);
        return date;
        
    }
}
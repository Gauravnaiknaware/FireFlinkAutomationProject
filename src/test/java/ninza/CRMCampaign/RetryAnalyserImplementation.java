 
package ninza.CRMCampaign;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnslyser intrercae of testng
 * @author Gaurav Ganesh Naikna
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count = 0;
	int retrycount = 3; //Manual Analysis //FAIL
	
	public boolean retry(ITestResult result) {
		//0 - T, 1-T, 2-T, 3-f
		while(count<retrycount) //recounts = 3
		{
			count++; //1 2 3
			return true; //retry retry retry
		}
		
		return false; //Stop retry
	}

}
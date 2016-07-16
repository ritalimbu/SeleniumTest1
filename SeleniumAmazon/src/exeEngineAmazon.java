import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class exeEngineAmazon {
	public static void main(String[] args) throws IOException, InterruptedException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			  
			String[][]recData = AutomationScriptsAmazon.readExcel("C:/Users/Rita/Desktop/TestSuite_Amazon.xlsx","Sheet1"); 
			String automationScript;
			for (int row = 1; row < recData.length; row++) {
				automationScript = recData[row][2];
				 System.out.println(automationScript);
				 try {
					 Method ts = AutomationScriptsAmazon.class.getMethod(automationScript);
					 ts.invoke(ts);
				 } catch (NoSuchMethodException e) {
					 
				 }
			}
			
			  
			
		}	 
				
		/*AutomationScriptsAmazon.launchAmazonApp();
		AutomationScriptsAmazon.verifyDropDownOption();
		AutomationScriptsAmazon.clickSearchButton();
		AutomationScriptsAmazon.verifyShowResults();
		AutomationScriptsAmazon.showResultsComputerAccessories();
		AutomationScriptsAmazon.showResultsElectronics();
		AutomationScriptsAmazon.checkMainTab();
		AutomationScriptsAmazon.deptDropDownlist();
		AutomationScriptsAmazon.yourAccountDropDown();
		AutomationScriptsAmazon.tryPrimeDropDown();
		AutomationScriptsAmazon.listsDropDown();*/
	}




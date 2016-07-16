
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class ReusableMethodsAmazon{
	//	static WebDriver driver;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	/* Name of the Method: enterText
	 * Brief description: Enter text value to text boxes 
	 * Arguments: obj --> webelement Object, textVal --> text to be entered, objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException{
		
		
		if(obj.isDisplayed()){
			obj.sendKeys(textVal);
			Update_Report("Pass", "enterText", textVal+ "  is entered in " + objName + " field");
		}else{
			Update_Report("Fail", "enterText", objName + " field is not displayed please check your application ");
		}
		
	}
	
	
	/* Name of the Method: clickElement
	 * Brief description: Click on a web element 
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void clickElement(WebElement obj,String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass", "clickElement", objName + "  is clicked ");
		}else{
			Update_Report("Fail", "clickElement", objName + " field is not displayed please check your application ");
		}
		
	}
	
	/* Name of the Method: ValidateErrorMessage
	 * Brief description: Validate the error message
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void validateTextMessage(WebElement obj,String expectedTextMsg, String objName) throws IOException{
		if(obj.isDisplayed()){
			String actualTextMsg = obj.getText();
			if (actualTextMsg.equals(expectedTextMsg)){
				Update_Report("Pass", "validateTextMessage","Expected message matched with actual message'" +expectedTextMsg +"'");
			}else{
				Update_Report("Fail", "validateTextMessage","Expected message'"+ expectedTextMsg +" ' did not match with actual message'" +  actualTextMsg +"'");
			}
		}else{
				Update_Report("Fail", "validateTextMessage", objName + " is not displayed please check your application ");
			}
		}
	
	/* Name of the Method: ValidateMessage
	 * Brief description: Validate the text message
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void validateTextMessageOnly(WebElement obj,String expectedTextMsg, String objName) throws IOException{
		if(obj.isDisplayed()){
			String actualTextMsg = obj.getText();
			if (actualTextMsg.equals(expectedTextMsg)){
				Update_Report("Pass", "validateTextMessage","Expected message matched with actual message'" +expectedTextMsg +"'");
			}else{
				Update_Report("Fail", "validateTextMessage","Expected message'"+ expectedTextMsg +" ' did not match with actual message'" +  actualTextMsg +"'");
			}
	}else{
				Update_Report("Fail", "validateTextMessage", objName + " is not displayed please check your application ");
			}
	}
	
	/* Name of the Method: validate Text on web page
	 * Brief description: validate the Text the web page
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: July 10 2016
	 * Last Modified: July 10 2016
	 * */
	public static void validateText(WebElement obj,String expectedText, String objName)  throws IOException{
		if(obj.isDisplayed()){
		String actualText = obj.getText();
		   if (actualText.equals(expectedText)){
			  Update_Report("Pass", "validateText","Expected Text matched with actual Text'" +expectedText +"'");
		   }else{
			  Update_Report("Fail", "validateText","Expected Text'"+ expectedText +" ' did not match with actual Text'" +  actualText +"'");
		   }
	}else{
			  Update_Report("Fail", "validateText", objName + " is not displayed please check your application ");
		   }
	}	

	/* Name of the Method: validate items in the dropdown list
	 * Brief description: validate the Textitems  in the dropdown list
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	public static void validateMenuItem(WebElement obj,String expectedMenuItem,String objName)  throws IOException{
		if(obj.isDisplayed()){
		String actualMenuItem = obj.getText();
		   if (actualMenuItem.equals(expectedMenuItem)){
			  Update_Report("Pass", "validateText","Expected Item matched with actual Item'" +expectedMenuItem +"'");
		   }else{
			  Update_Report("Fail", "validateText","Expected Item'"+ expectedMenuItem +" ' did not match with actual Item'" +  actualMenuItem +"'");
		   }
	}else{
			  Update_Report("Fail", "validateText", objName + " is not displayed please check your application ");
		   }
	}	

	
	
	/* Name of the Method: SelectRememberMeCheckbox
	 * Brief description: Select the Remember Me Checkbox 
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void selectChkbox(WebElement obj,String objName) throws IOException{
		if(obj.isDisplayed()){
			if(!(obj.isSelected())){
			obj.click();
			Update_Report("Pass", "selectChkbox", objName + "  checkbox is selected.");
			}else{
				Update_Report("Pass", "selectChkbox",objName + "  checkbox is Already selected. ");
			}
		}else{
				Update_Report("Fail", "selectChkbox", objName + " is not displayed please check your application ");
			}
		}
	/* Name of the Method: DeSelectRememberMeCheckbox
	 * Brief description: DeSelect the Remember Me Checkbox 
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void deSelectChkbox(WebElement obj,String objName) throws IOException{
		if(obj.isDisplayed()){	
		  if (obj.isSelected()){
				obj.click();
				Update_Report("Pass", "deSelectChkbox",objName+ " is deselected ");
			}else{
				Update_Report("Pass", "deSelectChkbox",objName+ " is already deselected ");
			}
		
	}else{
		Update_Report("Fail", "deSelectChkBox",objName+" is not displayed please check your application ");
	  }

	}
	/* Name of the Method: VerifyingElementStyleMatches(color,font,width etc)
	 * Brief description: Verify the style of the element.
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */

	public static void validateElementStyleMatches(WebElement webElement,String cssClassName, String expectedCSSValue) throws IOException   {
		String actualCSSValue = webElement.getCssValue(cssClassName);
		if (expectedCSSValue.equals(actualCSSValue)) {
			Update_Report("Pass", "validatedElementStyle", cssClassName + " has value -> " + expectedCSSValue);
		} else {
			Update_Report("Fail", "validatedElementStyle", cssClassName + " does not hava value -> " + expectedCSSValue);
		}
		
	}
	
	
	/* Name of the Method: hover over element and validate the element link
	 * Brief description: hover over element and validate the element link
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */

	public static void validateElementLink(WebElement webElement,WebDriver webDriver) throws IOException  {
		Actions builder = new Actions(webDriver);
		builder.moveToElement(webElement).perform();
		String expectedCSSValue = "pointer";
		String actualCSSValue = webElement.getCssValue("cursor");
		if (expectedCSSValue.equals(actualCSSValue)) {
			Update_Report("Pass", "validatedElementLink", webElement.getText()+ " link is available");
		} else {
			Update_Report("Fail", "validatedElementLink", webElement.getText()+ " link is not available");
		}
		
	}
	
	
	/* Name of the Method: VerifyingElementStyleDoesNotMatches(color,font,width etc)
	 * Brief description: Verify the style of the element.
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	
	public static void validateElementStyleDoesNotMatcheOnMouseHover(WebDriver webDriver, WebElement webElement ,String cssClassName) throws IOException   {
		String cssClassValueBeforeMouseHover = webElement.getCssValue(cssClassName);
		
		Actions builder = new Actions(webDriver);
		builder.moveToElement(webElement).perform();
		
		String cssClassValueAfterMouseHover = webElement.getCssValue(cssClassName);
		
		if (cssClassValueBeforeMouseHover.equals(cssClassValueAfterMouseHover)) {
			Update_Report("Fail", "validatedElementStyle", cssClassName + " does not change value of " + webElement.getText() );
		} else {
			Update_Report("Pass", "validatedElementStyle", cssClassName + " does change of " + webElement.getText() );
		}
		
	}
		
	/* Name of the Method: validating the drop down items
	 * Brief description: validating the drop down items
	 * Arguments: obj --> webElement Object, objName --> Object name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
		
	public static void validateDropDownItems(WebElement webElement ,String cssClassName,String expectedMenu) throws IOException   {


		List<WebElement> deptDropDownMenu= webElement.findElements(By.className(cssClassName));
		String[] expectedMenuItems = expectedMenu.split(";");
			for (String expectedMenuItem : expectedMenuItems){
				
				boolean found=false;
				for(WebElement actualMenuItem : deptDropDownMenu){
					if(expectedMenuItem.equals(actualMenuItem.getText())){
						found=true;
						Update_Report("Pass","validateDropDownItems",actualMenuItem.getText() + " deptDropDownItems is displayed ");
					}
				}
				
				if(!found)
					
				{
					Update_Report("Fail", "validateDropDownItems", expectedMenuItem + " deptDropDownItems is not displayed ");	
				}
			}	 
	
	}

	
		/* 
		 * Name of Method: writeExcel
		 * Brief Description: Write to excel sheet
		 * Arguments: dtTablePath--> path of excel sheet, sheetName --> name of the sheet, iRow --> Row number, iCol --> column number, textVal --> text to be entered
		 * Created By: Tech-Pirates
		 * Creation Date: 23 Jun 2016
		 * Last Modified: 23 Jun 2016
		 * 
		 * */
		
		public static void writeExcel(String dtTablePath, String sheetName, int iRow, int iCol, String textVal) throws IOException{
			
			
			/*Step 1: Get the XL Path*/
			File xlFile = new File(dtTablePath);

			/*step2: Access the Xl File*/
			FileInputStream xlDoc = new FileInputStream(xlFile);

			/*Step3: Access the work book (POI jar file) */
			XSSFWorkbook wb = new XSSFWorkbook(xlDoc);

			/*Step4: Access the Sheet */
			XSSFSheet sheet = wb.getSheet(sheetName);

			/*Access Row*/
			XSSFRow   row = sheet.getRow(iRow);
			
			/*Access Cell*/
			XSSFCell cell = row.getCell(iCol);
			
			cell.setCellValue(XSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(textVal);
			
//			HSSFCellStyle titleStyle = wb.createCellStyle();
//			titleStyle.setFillForegroundColor(new HSSFColor.BLUE_GREY().getIndex());
//			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
//			cell.setCellStyle(titleStyle);
			
			
			FileOutputStream fout = new FileOutputStream(dtTablePath);
			wb.write(fout);
			fout.flush();
			fout.close();
			
		}

		/* 
		 * Name of Method: readExcel
		 * Brief Description: Write to excel sheet
		 * Arguments: dtTablePath--> path of excel sheet, sheetName --> name of the sheet, iRow --> Row number, iCol --> column number, textVal --> text to be entered
		 * Created By: Tech-Pirates
		 * Creation Date: 23 Jun 2016
		 * Last Modified: 23 Jun 2016
		 * 
		 * */
		
		public static String[][] readExcel(String dtTablePath, String sheetName ) throws IOException{

			/*Step 1: Get the XL Path*/
			File xlFile = new File(dtTablePath);

			/*step2: Access the Xl File*/
			FileInputStream xlDoc = new FileInputStream(xlFile);

			/*Step3: Access the work book (POI jar file) */
			//HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
			XSSFWorkbook wb = new XSSFWorkbook(xlDoc);

			/*Step4: Access the Sheet */
			//HSSFSheet sheet = wb.getSheet(sheetName);
            XSSFSheet sheet = wb.getSheet(sheetName);
			int iRowCount = sheet.getPhysicalNumberOfRows();
			int iColCount = sheet.getRow(0).getLastCellNum();


			String[][] xlData = new String[iRowCount][iColCount];

			for(int i =0; i<iRowCount; i++){
				for(int j = 0; j <iColCount; j++){
					System.out.print("Row: " + i + ", Col: " + j);
					if (i > 0 && j == 0) {
						double slNum = sheet.getRow(i).getCell(j).getNumericCellValue();
						xlData[i][j] = String.valueOf(slNum);
					} else {
						if (sheet.getRow(i).getCell(j) == null) {
							xlData[i][j] = "";
						} else {
							xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
						}
					}
					System.out.println(" " + xlData[i][j]);	
				}

			}
			return xlData;
		}

	

	
	@Test
	public void test() throws Exception {

		startReport("Decending order sort","C:/Users/Rita/Desktop/Report");

		Update_Report( "Pass", "Decending order sort",  "Decending order sort executing is complete.");
		Update_Report( "Fail", "Decending order sort",  "Decending order sort executing is complete.");
				bw.close();

	}


	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
}


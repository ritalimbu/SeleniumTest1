import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;



public class AutomationScriptsAmazon extends ReusableMethodsAmazon{
	
	static WebDriver driver;
	//static RemoteWebDriver je;
	
//TCID001 Launch The Amazon Application	
	public static void launchAmazonApp() throws IOException, InterruptedException{
	
		startReport("launchAmazonApp","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
		driver.get("http://www.amazon.com/");
		
		Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
		driver.manage().window().maximize();
		
		bw.close();
		
    }
	

//TCID002 Verify Drop Down Option after Iphone is Typed in Search 
	public static void verifyDropDownOption() throws IOException, InterruptedException{
	
		startReport("verifyDropDownOption","C:/Users/Rita/Desktop/Report");
		String expectedMenuItem1 = "iphone 6s case in All Departments";
		String expectedMenuItem2 = "iphone 6s case in All Departments";
		String expectedMenuItem3 = "iphone 6s case in All Departments";
		
		driver = new FirefoxDriver();
	
		driver.get("https://www.amazon.com/");
		
		Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
		driver.manage().window().maximize();
		
		WebElement searchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		enterText(searchBox,"Iphone","Search box"); 
		
		WebElement searchBoxMenuItem1 = driver.findElement(By.xpath(".//*[@id='issDiv0']"));
		validateMenuItem(searchBoxMenuItem1,expectedMenuItem1,"Search Box Menu Item 1"); 
		
		WebElement searchBoxMenuItem2 = driver.findElement(By.xpath(".//*[@id='issDiv0']"));
		validateMenuItem(searchBoxMenuItem2,expectedMenuItem2,"Search Box Menu Item 2"); 
		
		WebElement searchBoxMenuItem3 = driver.findElement(By.xpath(".//*[@id='issDiv0']"));
		validateMenuItem(searchBoxMenuItem3,expectedMenuItem3,"Search Box Menu Item 3"); 
		
		bw.close();
	}

	
//TCID003 Click on Search Button after "Iphone " is entered 
    public static void clickSearchButton() throws IOException, InterruptedException{
		
		startReport("clickSearchButton","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		
		Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
		driver.manage().window().maximize();
		
		WebElement searchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		enterText(searchBox,"Iphone","Search box"); 
		
		WebElement searchButton = driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div"));
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).perform();
		
		validateElementStyleMatches(searchButton, "cursor", "pointer");
		validateElementStyleDoesNotMatcheOnMouseHover(driver, searchButton, "background-color");
		
		bw.close();    
		
}		
         		
//TCID004 Verify Show results for Column on the left -"Cell Phones & Accessories "Header 
	public static void verifyShowResults() throws IOException, InterruptedException{
		
		startReport("verifyShowResults","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
		String[][]recData = readExcel("C:/Users/Rita/Desktop/TestDataAmazon/showResultsComputerAccessories.xls","Sheet1");
		
		String URL = recData[1][1];
		String SI = recData[1][2];
	
		ModuleAmazon.searchItemInSearchBox(URL,SI);
       
		WebElement anyCategoryLink = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[1]/a"));
		clickElement(anyCategoryLink, "Any Category ");
		
		Thread.sleep(5000);
		WebElement optionsLink = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[1]/a")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, optionsLink, "color");
		
	    WebElement unlockedLink = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[2]/a")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, unlockedLink, "color");
	    
	    WebElement cellPhoneAccLink = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[4]/a")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, cellPhoneAccLink, "color");
	    
	
	    WebElement phoneCasesLink = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[5]/a")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, phoneCasesLink, "color");

	    WebElement seeMoreLink = driver.findElement(By.xpath(".//*[@id='seeMoreRefinementValuesClosed1']/li/span/a")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, seeMoreLink, "color");
	    
	    bw.close();  
		
		}
		
		
//TCID005 Verify Show results for Column  on the left -" Computers & Accessories "Header  
	public static void showResultsComputerAccessories() throws IOException, InterruptedException{
		
		startReport("showResultsComputerAccessories","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
		
        String[][]recData = readExcel("C:/Users/Rita/Desktop/TestDataAmazon/showResultsComputerAccessories.xls","Sheet1");
		
		
		String URL = recData[1][1];
		String SI = recData[1][2];
		
		ModuleAmazon.searchItemInSearchBox(URL,SI);
				
		WebElement anyCategoryLink = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[1]/a"));
		clickElement(anyCategoryLink, "Any Category ");
		
		Thread.sleep(5000);
		WebElement seeAllDeptLink = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]")); 
		clickElement(seeAllDeptLink, "See All 35 Department");
		
		WebElement compComponentLink = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[1]/ul/li/a")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, compComponentLink, "color");
	    
	    bw.close();  
		
		}
//TCID006 Verify Show results for Column  on the left -" Electronics "Header  
	public static void showResultsElectronics() throws IOException, InterruptedException{
		
		startReport("showResultsElectronics","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
        
        String[][]recData = readExcel("C:/Users/Rita/Desktop/TestDataAmazon/showResultsComputerAccessories.xls","Sheet1");
		
		String URL = recData[1][1];
		String SI = recData[1][2];
		
		ModuleAmazon.searchItemInSearchBox(URL,SI);
				
		WebElement anyCategoryLink = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[1]/a"));
		clickElement(anyCategoryLink, "Any Category ");
		
		Thread.sleep(5000);
		WebElement seeAllDeptLink = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]")); 
		validateElementStyleDoesNotMatcheOnMouseHover(driver, seeAllDeptLink, "color");
		clickElement(seeAllDeptLink, "See All 35 Department");
		
		WebElement electronicsLink = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/a/span[1]")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, electronicsLink, "color");
	    
	    WebElement smartWatchedLink = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/ul/li[1]/a/span")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, smartWatchedLink, "color");
	    
	    WebElement portableBlueSpkLink = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/ul/li[2]/a/span")); 
	    validateElementStyleDoesNotMatcheOnMouseHover(driver, portableBlueSpkLink, "color");
	    
	    bw.close();  
		
		}			

//TCID008 Check main Tab 
	public static void checkMainTab() throws IOException, InterruptedException{
			
		startReport("checkMainTab","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
        driver.get("https://www.amazon.com/");
		
		Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		WebElement departmentLink = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(departmentLink).perform();
		WebElement deptDropDown = driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]"));
		if(deptDropDown != null){
			Update_Report("Pass","validateDeptDropDown","Dept Drop Down is present");
		}
		else{
			Update_Report("Fail","validateDeptDropDown","Dept Drop Down is not present");
		}	
		
		
		WebElement yourAmazonMainTabLink = driver.findElement(By.xpath(".//*[@id='nav-your-amazon']"));
		validateElementLink(yourAmazonMainTabLink, driver);
			
		
		WebElement todayDealsMainTabLink = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[2]"));
		validateElementLink(todayDealsMainTabLink, driver);
		
		WebElement giftCardsMainTabLink = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[3]"));
		validateElementLink(giftCardsMainTabLink, driver);
		
		WebElement sellMainTabLink = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[4]"));
		validateElementLink(sellMainTabLink, driver);
		
		WebElement helpMainTabLink = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]"));
		validateElementLink(helpMainTabLink, driver);
		
		WebElement helloSignInLink = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(helloSignInLink).perform();
		WebElement helloDropDown = driver.findElement(By.xpath(".//*[@id='nav-flyout-yourAccount']"));
		if(helloDropDown != null){
			Update_Report("Pass","validateDeptDropDown","Hello Drop Down is present");
		}
		else{
			Update_Report("Fail","validateDeptDropDown","Hello Drop Down is not present");
		}	
		
		WebElement tryPrimeLink = driver.findElement(By.xpath(".//*[@id='nav-link-prime']"));
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(tryPrimeLink).perform();
		WebElement tryPrimeDropDown = driver.findElement(By.xpath(".//*[@id='nav-flyout-prime']"));
		if(tryPrimeDropDown != null){
			Update_Report("Pass","validateDeptDropDown","Try Prime Drop Down is present");
		}
		else{
			Update_Report("Fail","validateDeptDropDown","Try Prime Drop Down is not present");
		}	
	    
		
		WebElement yoursListLink = driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']/span[2]"));
		Actions builder3 = new Actions(driver);
		builder3.moveToElement(yoursListLink).perform();
		WebElement yoursListDropDown = driver.findElement(By.xpath(".//*[@id='nav-flyout-wishlist']"));
		if(yoursListDropDown != null){
			Update_Report("Pass","validateDeptDropDown","Yours List Drop Down is present");
		}
		else{
			Update_Report("Fail","validateDeptDropDown","Yours List Drop Down is not present");
		}	
		

		WebElement cartLink = driver.findElement(By.xpath(".//*[@id='nav-cart']/span[2]"));
		validateElementLink(cartLink, driver);
		
		
	    bw.close();  
		
		}			
	
//TCID009 Validate 'Department' dropdown list
		public static void deptDropDownlist() throws IOException, InterruptedException{
		
		startReport("deptDropDownlist","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		
		Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
		driver.manage().window().maximize();
		
		WebElement deptLinkItems = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(deptLinkItems).perform();
		
		WebElement deptMenu = driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]"));
		
		String expectedMenu = "Amazon Video;Digital & Prime Music;Appstore for Android;Amazon Photos & Drive;Kindle E-readers & Books;Fire Tablets;Fire TV;Echo & Alexa;AmazonFresh;Books & Audible;Movies, Music & Games;Electronics & Computers;Home, Garden & Tools;Beauty, Health & Grocery;Toys, Kids & Baby;Clothing, Shoes & Jewelry;Sports & Outdoors;Automotive & Industrial;Handmade;Home Services;Credit & Payment Products;Full Store Directory";
		validateDropDownItems(deptMenu, "nav-text", expectedMenu);
		
	    bw.close();
	}		
							
		
//TCID010 Validate 'Your Account' dropdown list
		public static void yourAccountDropDown() throws IOException, InterruptedException{
		
		startReport("yourAccountDropDown","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		
		Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
		driver.manage().window().maximize();
		
		WebElement yourAcclink = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(yourAcclink).perform();
		
		WebElement yourAccDropDown = driver.findElement(By.xpath(".//*[@id='nav-flyout-yourAccount']/div[3]"));
		
		String expectedMenu = "Your Account;Your Orders;Your Lists;Your Recommendations;Your Subscribe & Save Items;Your Digital Subscriptions;Your Service Requests;Your Amazon Drive;Your Prime Video;Your Kindle Unlimited;Your Amazon Credit Card Accounts;Manage Your Content and Devices;Your Video Subscriptions;Your Prime Music;Your Music Library;Your Amazon Drive;Your Prime Video;Your Kindle Unlimited;Your Watchlist;Your Video Library;Your Android Apps & Devices";
		validateDropDownItems(yourAccDropDown, "nav-item", expectedMenu);
		
	    bw.close();
		}
		
//TCID011 Validate 'Try Prime' dropdown list
	public static void tryPrimeDropDown() throws IOException, InterruptedException{
				
		startReport("tryPrimeDropDown","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		
		Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
		driver.manage().window().maximize();
		
		WebElement tryPrimelink = driver.findElement(By.xpath(".//*[@id='nav-link-prime']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(tryPrimelink).perform();
		
		WebElement tryPrimeMainDiv = driver.findElement(By.xpath(".//*[@id='nav-flyout-prime']"));
		WebElement tryPrimeHeader = driver.findElement(By.xpath(".//*[@id='nav-npm-header']"));
		validateText(tryPrimeHeader,"Start your free trial and join millions of Amazon Prime members who enjoy: ", "Try Prime Header");
		
		
		String expectedMenuTexts = "Watch thousands of movies and TV episodes on your favorite device;Free Two-Day Shipping;Over a Million Songs, Ad-Free;Kindle Owners' Lending Library;Try Prime";
		String[] expectedMenuTextArray = expectedMenuTexts.split(";");
		
		
	    List<WebElement> tryPrimeSubDivs = tryPrimeMainDiv.findElements(By.className("nav-npm-content"));
	    
	    for (WebElement tryPrimeInnerDiv : tryPrimeSubDivs) {
	    	WebElement textElement = tryPrimeInnerDiv.findElement(By.className("nav-npm-text-detail"));
	    	String actualDivText = textElement.getText();
	    	boolean found = false;
	    	for (String expectedText : expectedMenuTextArray) {
	    		if (expectedText.equals(actualDivText)) {
	    			found = true;
	    			Update_Report("Pass", "tryPrimeDropDown", actualDivText + " is available");
	    		}
	    	}
	    	if (!found) {
	    		Update_Report("Fail", "tryPrimeDropDown", actualDivText + " is not available");
	    	}
	    }
		
	    bw.close();
			
		}
	
//TCID012 Validate 'Lists' dropdown list
	public static void listsDropDown() throws IOException, InterruptedException{
					
		startReport("listsDropDown","C:/Users/Rita/Desktop/Report");
		
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		
		Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
		driver.manage().window().maximize();
		
		WebElement listlink = driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']/span[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(listlink).perform();
		
		WebElement listDropDown = driver.findElement(By.xpath(".//*[@id='nav-flyout-wishlist']/div[2]"));
		
		String expectedMenu = "Create a List;Find a List or Registry;Find a Gift;Save Items from the Web;Wedding Registry;Baby Registry;Kids' Birthdays;School Lists;Friends & Family Gifting;Pantry Lists;Your Hearts (in Fashion)";
		validateDropDownItems(listDropDown, "nav-text", expectedMenu);
		
	    bw.close();
		}
	
  }
	
	




import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationScriptWellsFargo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver ;
		
		String expectedText = "About Wells Fargo";
	    driver =new FirefoxDriver(); //launch firefox driver
		driver.get("http://www.WellsFargo.com/");  //launch WellsFargo webpage
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		// Verifying Personal Tab
		String personalTabName = driver.findElement(By.className("current")).getText();
        if (personalTabName.equals("Personal"))
        {
            System.out.println("Personal Tab is selected");
        }
        else
        {
            System.out.println("Personal Tab is not selected");
        } 
		
        Thread.sleep(5000);
        
		//Clicking About Wells Fargo
		WebElement aboutWellsFargoLink = driver.findElement(By.xpath(".//*[@id='headerTools']/nav/ul/li[2]/a"));
		aboutWellsFargoLink.click();
		Thread.sleep(5000);
		
		//Verifying About Wells Fargo Page
		WebElement aboutWellsFargoPage = driver.findElement(By.xpath(".//*[@id='shell']/div[1]/h1"));
		String actualText = aboutWellsFargoPage.getText();
		
			if (actualText.equals(expectedText)){
				 System.out.println("About Wells Fargo heading is present");
	        }
	        else
	        {
	            System.out.println("About Wells Fargo heading is not present");
	        } 
		

        //clicking Back button
		driver.navigate().back();
		
		//Verifying Personal Tab
		String personalTab = driver.findElement(By.className("current")).getText();
        if (personalTab.equals("Personal"))
        {
            System.out.println("Personal Tab is selected");
        }
        else
        {
            System.out.println("Personal Tab is not selected");
        } 
	    
		//Clicking on Insurance Tab
        WebElement insuranceTab = driver.findElement(By.xpath(".//*[@id='insuranceTab']/a"));
        insuranceTab.click();
       
        WebElement homeownersInsuLink = driver.findElement(By.xpath(".//*[@id='insurance']/div[1]/div[2]/ul/li[1]/a"));
	       if (homeownersInsuLink.isDisplayed()){
	    	   System.out.println("homeownersInsuLink is present");
	    	   homeownersInsuLink.click();
	       }
	       else
	       {
	           System.out.println("homeownersInsuLink is not present");
	       } 
	    
	    Thread.sleep(5000); 
	    
	    //Entering Zip code
	    WebElement zipCode = driver.findElement(By.id("zipCode"));
	    zipCode.sendKeys("94538");
	    
	    Thread.sleep(5000);
	    //Taking a screenshot
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:/Users/Rita/Desktop/SF.jpg"));
      
		driver.quit();		       
		   
	}
	
}



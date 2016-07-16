
	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	public class ModuleAmazon extends AutomationScriptsAmazon {
		
		public static void searchItemInSearchBox(String URL,String SI) throws IOException, InterruptedException{
				
			driver.get("URL");
			
			Update_Report("Pass","Launch Amazon Application","Amazon Application is launched");
			Thread.sleep(4000);
			driver.manage().window().maximize();
			Thread.sleep(4000);
			
			WebElement searchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
			enterText(searchBox,"SI","Search box"); 
			
			Thread.sleep(5000);
			
			WebElement searchButton = driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input"));
			clickElement(searchButton, "Search Button");
			
			Thread.sleep(5000);
		}

	}
	
	


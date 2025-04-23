package PraticeApplication;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FromAndToSelection 
{

	public static void main(String[] args) 
	{
		
		String[]itemsNeeded= {"Cucumber","Cauliflower","Beetroot"};
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		addItems(driver,itemsNeeded);
		driver.findElement(By.xpath("//*[@alt='Cart']")).click();
		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//*[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//*[@class='promoBtn']")).click();
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//*[@class='promoInfo']")).getText());
		
		
	}
	
	
	public static void addItems(WebDriver driver, String[]itemsNeeded)
	{
		int l=0;
		List<WebElement>Items=driver.findElements(By.xpath("//*[@class='product-name']"));
		for(int i=0;i<Items.size();i++)
			
		{
			
			String[] name=Items.get(i).getText().split("-");
			String cuc=name[0].trim();
			
			List<String> itemsAddedList=Arrays.asList(itemsNeeded);
					
			if(itemsAddedList.contains(cuc))
			{
				
				driver.findElements(By.xpath("//*[@class='product-action']/button")).get(i).click();
				if(l==itemsNeeded.length) 
				{
					break;
				}
				
			}
			
			
		}
			
	}	

}




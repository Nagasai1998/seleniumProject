package PraticeApplication;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleDemo {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.xpath("//*[@class='blinkingText']")).click();
		Set<String>Han=driver.getWindowHandles();
		Iterator<String>it=Han.iterator();
		String parentID=it.next();
		String childID=it.next();
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.xpath("//*[@class='im-para red']")).getText());
		driver.findElement(By.xpath("//*[@class='im-para red']")).getText();
		String EmailId=driver.findElement(By.xpath("//*[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0].trim();
        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(EmailId);
        
        

	}

}

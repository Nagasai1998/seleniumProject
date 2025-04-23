package PraticeApplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo2 {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.icicibank.com/");
		Actions act=new Actions(driver);
		WebElement Lo=driver.findElement(By.xpath("//*[@class='mega-menu-items']/li[5]"));
		act.moveToElement(Lo).build().perform();
		act.moveToElement(driver.findElement(By.id("search-chatInput"))).click().keyDown(Keys.SHIFT).sendKeys("Loans").build().perform();
	}

}

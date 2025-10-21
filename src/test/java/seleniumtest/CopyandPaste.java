package seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyandPaste {
	
	@Test
	public void copypaste() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		driver.manage().window().maximize();
		
		WebElement fullname = driver.findElement(By.xpath("//input[@placeholder = 'Full name']"));
		fullname.sendKeys("hello world");
		
		WebElement AdditionalDetails = driver.findElement(By.tagName("textarea"));
		
		WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
		
		/*fullname.sendKeys("Rohith");
		fullname.sendKeys(Keys.CONTROL , "a");
		fullname.sendKeys(Keys.CONTROL,"c");
		AdditionalDetails.sendKeys(Keys.CONTROL,"v");*/
		
		Actions actions = new Actions(driver);
		actions.keyDown(fullname,Keys.CONTROL)
		       .sendKeys("a")
		       .sendKeys("c")
		       .keyUp(Keys.CONTROL)
		       .perform();
		
		actions.keyDown(AdditionalDetails,Keys.CONTROL)
		        .sendKeys("v")
		        .keyUp(Keys.CONTROL)
		        .perform();
		
		actions.click(button).perform();
		
		
	}
}

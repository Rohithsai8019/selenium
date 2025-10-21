package seleniumtest;

import java.time.Duration;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles {
	
	@Test
	public void windowhandle() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");	
		
		driver.manage().window().maximize();
		
		WebElement searchBar = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
		searchBar.sendKeys("watches");
		searchBar.sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-id='WATGYFJHHRV8XSKG']"))).click();
		
		String parent = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		
		Set <String> multipleHandles = driver.getWindowHandles();
		for(String handle : multipleHandles) {
			if(!handle.equals(parent)) {
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				System.out.println(driver.getTitle());
			}
		}
			
		
	}
}

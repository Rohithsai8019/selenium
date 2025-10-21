package seleniumtest;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
//implicit and explicit waits
	@Test
	public void explicitwait() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/ajax");
		
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement button = driver.findElement(By.xpath("//button[@class='ui violet button']"));
		button.click();
		

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));

		WebElement message = driver.findElement(By.tagName("h3"));
		System.out.println("Final Text: " + message.getText());

        /* 
           Wait <WebDriver> wait = new FluentWait<>(driver)
           				.withTimeout(Duration.ofSeconds(20))
           				.pollingEvery(Duration.ofSeconds(1))
           				.ignoring(NoSuchElementException.class);
           				
           	WebElement element = wait.until(driver -> driver.findElement(By.id("ele-id)));
         
         
         * */


	}
	
}

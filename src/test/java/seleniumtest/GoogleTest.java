package seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	
	@Test
	public void openGooglePage() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		WebElement input = driver.findElement(By.name("q"));

        input.sendKeys("Hello World");
        input.submit();
        
        System.out.println("operation successfull");

	}
	

}

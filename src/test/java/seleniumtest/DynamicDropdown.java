package seleniumtest;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDropdown {
	
	@Test
	public void dynamic() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		driver.manage().window().maximize();
		
		String input1 = "realme 8 5g mobile";
		
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.sendKeys(input1);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-flyout-searchAjax")));
		
		List <WebElement> elements = driver.findElements(By.cssSelector("div[id ^= 'sac-suggestion-row']"));
		
		for( WebElement ele : elements) {
			if(ele.getText().toLowerCase().contains(input1.toLowerCase())) {
				ele.click();
				break;
			}
		}
		
		
	}
}

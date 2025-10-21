package seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Class {
	
	@Test
	public void drag_and_drop() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/drag-drop");
		
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		
		WebElement input = driver.findElement(By.id("ball"));
		
		WebElement output1 = driver.findElement(By.id("dropzone1"));
		WebElement output2 = driver.findElement(By.id("dropzone2"));
		
		//action.dragAndDrop(input, output1).pause(2000).dragAndDrop(input, output2).perform();

        action.clickAndHold(input).moveToElement(output1).release()
              .pause(2000)
              .clickAndHold(input).moveToElement(output2).release().perform();

;
	}

}

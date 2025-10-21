package seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {
	@Test
	public void iframes() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/iframes");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//iframe[@title='Frame1']"));
		WebElement ele1 = driver.findElement(By.xpath("//iframe[@title='Frame2']"));
		
		
		driver.switchTo().frame(ele);
		
		driver.findElement(By.xpath("//button[text()='Click me!']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(ele1);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Click me!']")).click();
		
		
	}
}

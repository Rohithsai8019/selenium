package seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
	@Test
	public void Multipleselect() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/selects");
		
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//option[text()='Rust']/parent::select"));
		Select select = new Select(ele);
		
		select.deselectByIndex(0);
		
		select.selectByVisibleText("JavaScript");
		
		select.selectByIndex(3);
		select.selectByIndex(4);
		select.selectByIndex(5);
		
		select.selectByValue("nodejs");
		
		select.deselectByIndex(4);
		
		String text = driver.getTitle();
		System.out.println(text);
		
		
		


		
	}
	
}

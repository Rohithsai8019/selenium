package seleniumtest;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

@Test
public void alertexample() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://training-support.net/webelements/alerts");
	WebElement element=driver.findElement(By.id("prompt"));
	element.click();
	
	Alert alert=driver.switchTo().alert();
	String text = alert.getText();
	System.out.println(text);
	
	alert.sendKeys("hello all");
	Thread.sleep(2000);
	alert.accept();

}
}

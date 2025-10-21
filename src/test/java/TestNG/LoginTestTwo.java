package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
@Listeners(ListenerClass.class)
public class LoginTestTwo extends BaseClass {
 
	@Test
	public void loginTest() {
		 WebElement uname = driver.findElement(By.id("username")); //.sendKeys("admin2");
		uname.sendKeys("admin2");
		 driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		String targetText = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(targetText, "Welcome Back, Admin!");
	}
	@Test
	public void sample() {
		Assert.assertEquals(false, false);
	}
}

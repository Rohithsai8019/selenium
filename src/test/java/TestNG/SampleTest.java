package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {
	WebDriver driver;
	@BeforeClass
	public void sampleMethod() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		;
	}
	
	@Test
	public void Login() {
		System.out.println("login page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button")).click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Orangehrm");
	}
	
	@Test(dependsOnMethods= {"Login"},alwaysRun=true)
	public void Dashboard() {
		System.out.println("dashboard page");
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
}

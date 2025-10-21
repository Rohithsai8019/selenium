package seleniumtest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_and_drop {

	    @Test
	    public void dragDrop() throws InterruptedException {
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://training-support.net/webelements/drag-drop");

	        driver.manage().window().maximize();

	        Actions actions = new Actions(driver);

	        WebElement ball = driver.findElement(By.id("ball"));
	        WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
	        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

	        int offsetX1 = dropzone1.getLocation().getX() - ball.getLocation().getX();
	        int offsetY1 = dropzone1.getLocation().getY() - ball.getLocation().getY();

	        actions.clickAndHold(ball).moveByOffset(offsetX1, offsetY1).release().perform();

	        Thread.sleep(2000); 


	        int offsetX2 = dropzone2.getLocation().getX() - ball.getLocation().getX();
	        int offsetY2 = dropzone2.getLocation().getY() - ball.getLocation().getY();

	        actions.clickAndHold(ball).moveByOffset(offsetX2, offsetY2).release().perform();

	    }
	}


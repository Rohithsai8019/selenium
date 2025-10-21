package seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {
	@Test
	public void usingSearchContext() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://shop.polymer-project.org/");
		
		WebElement ele = driver.findElement(By.cssSelector("shop-app"));
		
		SearchContext context = ele.getShadowRoot();
		WebElement ele1 = context.findElement(By.cssSelector("iron-pages > shop-home"));
		
		SearchContext newcontext = ele1.getShadowRoot();
		WebElement ele2= newcontext.findElement(By.cssSelector("div:nth-of-type(1)>shop-button>a"));
		
		System.out.println(ele2.getTagName());
		ele2.click();
		
		//using Javascript executor
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement targetElement = (WebElement) js.executeScript("return document.querySelector('shop-app')"
//				+ ".shadowRoot.querySelector('iron-pages').querySelector('shop-home')"
//				+ ".shadowRoot.querySelector('div:nth-of-type(1) > shop-button > a')");
//		targetElement.click();
		
	}
}

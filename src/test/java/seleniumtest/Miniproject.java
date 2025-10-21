package seleniumtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Miniproject {

    WebDriver driver;
    WebDriverWait wait;
    Properties properties;

    @Test
    public void sampleTest() {
        loadProperties();
        setup();

        String query = properties.getProperty("search.query");
        System.out.println("Loaded query from properties: " + query);

        if (query != null && !query.isEmpty()) {
            searchProduct(query);
            validateSearchResultFormat();
            printDropdownOptions();
            applyNewestArrivalsFilter();
            verifyNewestArrivalsApplied();
        } else {
            System.out.println("Search query not found or empty in properties file.");
        }

        closeBrowser();
    }

    public void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\2440846\\eclipse-workspace\\selenium\\src\\test\\java\\seleniumtest\\config.properties");
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load properties file: " + e.getMessage());
        }
    }

    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
    }

    public void searchProduct(String query) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(query);

        WebElement searchKey = driver.findElement(By.id("nav-search-submit-button"));
        searchKey.click();
    }

    public void validateSearchResultFormat() {
        try {
            WebElement ele = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']"));
            String result = ele.getText();
            System.out.println("Search result text: " + result);

            String pattern = "\\d+[-–]\\d+ of (over )?\\d+(,\\d+)* results for \\\"mobile smartphones under 30000\\\"";
            if (result.matches(pattern)) {
                System.out.println("Valid format");
            } else {
                System.out.println("Invalid format");
            }
        } catch (Exception e) {
            System.out.println("Could not validate search result format: " + e.getMessage());
        }
    }

    public void printDropdownOptions() {
        try {
            WebElement dropdown = driver.findElement(By.className("a-dropdown-container"));
            dropdown.click();

            WebElement dropdownList = driver.findElement(By.cssSelector(".a-nostyle.a-list-link"));
            List<WebElement> listItems = dropdownList.findElements(By.tagName("li"));

            System.out.println(listItems.size() + " options are present in the dropdown");
        } catch (Exception e) {
            System.out.println("Error while printing dropdown options: " + e.getMessage());
        }
    }

    public void applyNewestArrivalsFilter() {
        try {
            driver.findElement(By.linkText("Newest Arrivals")).click();
        } catch (Exception e) {
            System.out.println("Could not click on Newest Arrivals: " + e.getMessage());
        }
    }

    public void verifyNewestArrivalsApplied() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("s=date-desc-rank")) {
            System.out.println("Newest Arrivals filter applied successfully.");
        } else {
            System.out.println("Newest Arrivals filter not applied.");
        }
    }

    public void closeBrowser() {
        driver.close();
    }
}
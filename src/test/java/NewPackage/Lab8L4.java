package NewPackage;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Lab8L4
{
    WebDriver driver;

    @Test
    public void ecomFlowTest() throws InterruptedException {
        System.out.println("Executing TutorialsNinja E-commerce Flow Test");

        // Step 1: Open website
        driver.get("https://tutorialsninja.com/demo/index.php?");
        
        // Step 2: Verify title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Step 3: Desktops > Mac
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("//a[text()='Mac (1)']")).click();

        // Step 4: Verify Mac heading
        WebElement macHeading = driver.findElement(By.xpath("//h2[text()='Mac']"));
        System.out.println("Mac Heading Displayed: " + macHeading.isDisplayed());

        // Step 5: Sort by Name (A-Z)
        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Name (A - Z)");

        // Step 6: Add to cart
        driver.findElement(By.xpath("(//button[contains(@onclick,'cart.add')])[1]")).click();

        // Step 7: Search for "Monitors"
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        // Step 8: Wait for page to load
        Thread.sleep(2000);

        // Step 9: Clear and search with description
        searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        WebElement descCheckbox = driver.findElement(By.name("description"));
        if (!descCheckbox.isSelected()) {
            descCheckbox.click();
        }

        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(2000);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before Method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is After Suite");
    }
}

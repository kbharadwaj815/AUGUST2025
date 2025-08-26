package NewPackage;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC10TestNg2 {
    WebDriver driver;

    @Test(dataProvider = "logindata")
    public void f(String username, String password) {
        System.out.println("This is the test");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement uname = driver.findElement(By.name("username"));
        if (uname.isDisplayed()) {
            uname.sendKeys(username);
            System.out.println("Get placeholder: " + uname.getAttribute("placeholder"));
        } else {
            System.out.println("Username is not displayed");
        }

        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
    }

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
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

    @DataProvider
    public Object[][] logindata() {
        return new Object[][] {
            new Object[] { "Admin", "admin123" },
            new Object[] { "pooja", "welcome" },
        };
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

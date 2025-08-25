package NewPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        Thread.sleep(3000); // wait for the page to load

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("username")).sendKeys(Keys.TAB);
        driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
		//driver.findElement(By.name("username")).sendKeys(Keys.TAB);
    }
}

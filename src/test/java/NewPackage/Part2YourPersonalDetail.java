package NewPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Part2YourPersonalDetail {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        driver.findElement(By.id("input-firstname")).sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZ123456");
        driver.findElement(By.id("input-lastname")).sendKeys("ZYXWVUTSRQPONMLKJIHGFEDCBA123456");
        driver.findElement(By.id("input-email")).sendKeys("test" + System.currentTimeMillis() + "@mail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        WebElement error = driver.findElement(By.cssSelector(".text-danger"));
        System.out.println("Error Message: " + error.getText());

        driver.quit();
    }
}

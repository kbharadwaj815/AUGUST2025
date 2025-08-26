package NewPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Lab3 {
    public static void main(String[] args) {
        
    	WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://tutorialsninja.com/demo/index.php?");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("//a[text()='Mac (1)']")).click();

        // Select "Name (A - Z)" from sort dropdown
        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Name (A - Z)");

        // Click "Add to Cart" on first product
        driver.findElement(By.xpath("(//button[contains(@onclick,'cart.add')])[1]")).click();

        

        // Close the browser
        driver.quit();
    }
}
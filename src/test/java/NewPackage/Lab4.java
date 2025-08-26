package NewPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab4 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
        

       

        // 2. Verify the title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // 3. Click on Desktops > Mac
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("//a[text()='Mac (1)']")).click();

        // 4. Verify Mac heading
        WebElement macHeading = driver.findElement(By.xpath("//h2[text()='Mac']"));
        System.out.println("Mac Heading Displayed: " + macHeading.isDisplayed());

        // 5. Sort by Name (A - Z)
        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Name (A - Z)");

        // 6. Click Add to Cart
        driver.findElement(By.xpath("(//button[contains(@onclick,'cart.add')])[1]")).click();

        // 7. Search for "Monitors"
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        // 8. Wait for page to load
        Thread.sleep(2000);

        // 9. Clear search box and check "Search in product descriptions"
        searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        WebElement descCheckbox = driver.findElement(By.name("description"));
        if (!descCheckbox.isSelected()) {
            descCheckbox.click();
        }

        // 10. Click Search again
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        // 11. Wait and close browser
        Thread.sleep(3000);
        driver.quit();
    }
}

package NewPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Lab5 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/index.php?");

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        if (title.contains("Your Store")) {
            System.out.println("Title verified");
        } else {
            System.out.println("Title mismatch");
        }

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();

        WebElement heading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        if (heading.isDisplayed() && heading.getText().equals("Register Account")) {
            System.out.println("Heading 'Register Account' is verified");
        } else {
            System.out.println("Heading 'Register Account' verification failed");
        }

        // Click Continue without filling to get warning for Privacy Policy
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Wait and verify warning for Privacy Policy
        try {
            WebElement warn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-danger')]")));
            String warningText = warn.getText();
            if (warningText.contains("Warning: You must agree to the Privacy Policy!")) {
                System.out.println("Warning appeared: " + warningText);
            } else {
                System.out.println("Warning message is different: " + warningText);
            }
        } catch (Exception e) {
            System.out.println("Warning message not found");
        }

        // Part 2: Personal Details

        // First Name with 33 chars (should trigger error)
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        String longFirstName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; // 33 chars
        firstName.sendKeys(longFirstName);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        try {
            WebElement firstNameError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")));
            System.out.println("First Name validation error displayed: " + firstNameError.getText());
        } catch (Exception e) {
            System.out.println("First Name validation error not displayed");
        }

        // Clear and enter valid first name
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Keshav");

        // Last Name with 33 chars (should trigger error)
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        String longLastName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; // 33 chars
        lastName.sendKeys(longLastName);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        try {
            WebElement lastNameError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")));
            System.out.println("Last Name validation error displayed: " + lastNameError.getText());
        } catch (Exception e) {
            System.out.println("Last Name validation error not displayed");
        }

        // Clear and enter valid last name
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Bharadwaj");

        // Enter valid email
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("Keshav" + System.currentTimeMillis() + "@gmail.com");

        // Enter valid telephone
        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

        System.out.println("Personal details entered successfully");

        // Password section

        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("Test@1234");

        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm")).sendKeys("Test@1234");

        // Newsletter

        driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();

        // Agree to Privacy Policy
        driver.findElement(By.name("agree")).click();

        // Click Continue to submit the form
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        // Verify Account Created Message
        try {
            WebElement confirmMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content h1")));
            if (confirmMsg.getText().equals("Your Account Has Been Created!")) {
                System.out.println("Confirmation Message: " + confirmMsg.getText());
            } else {
                System.out.println("Unexpected confirmation message: " + confirmMsg.getText());
            }
        } catch (Exception e) {
            System.out.println("Confirmation message not found");
        }

        // Click Continue on confirmation page
        driver.findElement(By.linkText("Continue")).click();

        // Click on 'View your order history' link under 'My Orders'
        try {
            WebElement orderHistoryLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View your order history")));
            orderHistoryLink.click();
            System.out.println("Clicked on 'View your order history' link.");
        } catch (Exception e) {
            System.out.println("'View your order history' link not found.");
        }

        driver.quit();
    }
}

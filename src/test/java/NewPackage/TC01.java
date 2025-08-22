package NewPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println("Hello");
	
	//Part 1: Launch Application

	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://tutorialsninja.com/demo/index.php?");
	System.out.println("Tile of the page:"+driver.getTitle());
	driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Register")).click();
	System.out.println("Tile of the page:"+driver.getTitle());
	driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	assert driver.getPageSource().contains("Warning: You must agree to the Privacy Policy!");
	

	
//Part 2: For 'Your Personal Details'
	/*WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://tutorialsninja.com/demo/index.php?");
	driver.findElement(By.id("input-firstname")).sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZ123456"); // 33 chars
	driver.findElement(By.id("input-lastname")).sendKeys("ZYXWVUTSRQPONMLKJIHGFEDCBA123456");
	driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
	driver.findElement(By.id("input-telephone")).sendKeys("123456");
	driver.findElement(By.name("agree")).click();
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	
	
	/*
	driver.get("https://www.google.com/");
	System.out.println("Title of this page:" +driver.getTitle());
	WebElement search=driver.findElement(By.id("APjFqb"));
	search.sendKeys("Automation Testing tool");
	search.submit();
	*/
	
	
	
	}

}

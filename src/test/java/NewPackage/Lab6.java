package NewPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {

	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("input-email")).sendKeys("keshav@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Test@1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Components")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Monitors (2)")).click();
		Thread.sleep(1000);
		Select show = new Select(driver.findElement(By.id("input-limit")));
		show.selectByIndex(0);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Specification")).click();
		Thread.sleep(1000);
		WebElement spec = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/table/tbody/tr/td[2]"));
		Thread.sleep(1000);
		if(spec.isDisplayed())
			
		{
			System.out.println("Specifications are displayed");
		}
		else
		{
			System.out.println("Specifications are not displayed");
		}
		driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
		Thread.sleep(1000);
		
		WebElement sucess = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		if(sucess.isDisplayed())
		{
			System.out.println(sucess.getText());
		}
		else
		{
			System.out.println("Sucess message not displyed");
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Mobile");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='description']")).click();
		driver.findElement(By.xpath("//input[@id='button-search']")).click();
		driver.findElement(By.linkText("HTC Touch HD")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("3");
		Thread.sleep(1000);
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(4000);
		WebElement suc2 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		if(suc2.isDisplayed())
		{
			System.out.println(suc2.getText());
		}
		else
		{
			System.out.println("Sucess message not displyed");
		}
		
		driver.findElement(By.xpath("//span[@id='cart-total']")).click();
		Thread.sleep(2000);
		try
		{
			WebElement name = driver.findElement(By.linkText("HTC Touch HD"));
			if(name.isDisplayed())
			{
				System.out.println(name.getText()+" is displyed");
			}
			else
			{
				System.out.println("Phone name not displyd");
			}
		}
		catch(Exception e)
		{}
			
		driver.findElement(By.linkText("Checkout")).click();
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Logout")).click();
		WebElement logout = driver.findElement(By.xpath("/html/body/div[2]/div/div/h1"));
		if(logout.isDisplayed())
		{
			System.out.println(logout.getText());
		}
		else
		{
			System.out.println("Logout message not displyed");
		}
		Thread.sleep(3000);
		driver.findElement(By.linkText("Continue")).click();
	}
}
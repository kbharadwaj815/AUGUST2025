package NewPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC09Executor {

	public static void main(String[] args)
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://amazon.in");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('Hello,Click OK')");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

}

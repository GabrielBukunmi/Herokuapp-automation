package resources;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base{
 //class to invoke chrome browser
	public WebDriver driver;
	public WebDriver initializeDriver()throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		return driver;
	}
	
	
}
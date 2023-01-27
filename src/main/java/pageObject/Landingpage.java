package pageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
;

public class Landingpage {
	public WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	By formAuthentication = By.xpath("//a[contains(text(),'Form Authentication')]");
	

	public WebElement formAuthentication() {
		return driver.findElement(formAuthentication);
	}
}
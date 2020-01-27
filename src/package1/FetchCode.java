package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class FetchCode {
	
	public static void main (String[] args) throws InterruptedException
	{
		
		 System.setProperty("webdriver.chrome.driver", "C://Users//abc//Desktop//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		driver.get("https://signin.simplemobilecloud.com/");
		WebDriverWait wait = new WebDriverWait (driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='EligibiltyRequest.mdn']")));
		element.sendKeys("1111111102");
	//	driver.findElement(By.id("EligibiltyRequest.mdn")).sendKeys("9999999902");
		driver.findElement(By.xpath("//button[text()='Check Eligibility']")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@type='email'][@aria-label='Email or phone']")).sendKeys("tweettest14@gmail.com");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		driver.findElement(By.xpath("//*[@type='password'][@aria-label='Enter your password']")).sendKeys("demouser1234");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		//driver.findElement(By.cssSelector("#signIn")).click();
		Thread.sleep(7000);
		String code=driver.findElement(By.id("SmsRequestObj.access_code")).getAttribute("value");
		System.out.println(code);
		driver.findElement(By.id("SmsRequestObj.rx_access_code")).sendKeys(code);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}

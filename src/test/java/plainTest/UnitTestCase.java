package plainTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UnitTestCase 
{
	public static void main(String[]args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","E:\\FlipKart_Final\\Flipkart\\src\\test\\resources\\DRIVERS\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.flipkart.com");
		
		//Cancel window
		driver.findElement(By.xpath("//*[@class='_2KpZ6l _2doB4z']")).click();
		//move to Login
		Actions act=new Actions(driver);
		WebElement a=driver.findElement(By.xpath("//*[@class='_1_3w1N']"));
		act.moveToElement(a).build().perform();
			
		//Click on profile
		driver.findElement(By.xpath("(//*[@class='_3vhnxf'])[1]")).click();
		
		Thread.sleep(500);
		//Enter Email/mobile
		driver.findElementByXPath("//*[@class='_2IX_2- VJZDxU']").sendKeys("9371005445");
		//Enter password
		driver.findElementByXPath("//*[@type='password']").sendKeys("harsh1012");
		//Click on Login
		driver.findElementByXPath("(//*[@type='submit'])[2]").click();
	}

}

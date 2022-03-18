package methods;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumOperations 
{
	public static WebDriver driver=null;
	public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
	public static Hashtable<String,Object> BrowserLaunch(Object[] inputParameters)
	{	
		try
	    {
		String browserName=(String) inputParameters[0];
		String exe=(String) inputParameters[1];
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", exe);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", exe);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
	    
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE", "Methodused:BrowserLaunch,Input Given:"+inputParameters[1].toString());
	    }
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Methodused:BrowserLaunch,Input Given:"+inputParameters[1].toString());
		}
		return outputParameters;
		
	}
	
	public static Hashtable<String,Object> openApplication(Object[]inputParameters) 
	{	
		try
		{
			
		String exe=(String) inputParameters[0];
		driver.get(exe);
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE", "Methodused:openApplication,Input Given:"+inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Methodused:openApplication:"+inputParameters[0].toString());
		}
		return outputParameters;
		
	}
	
	public static Hashtable<String,Object> clickOnElement(Object[]inputParameters)   //same method used for My_profile & Login
	{
		try
		{
		String xpath=(String) inputParameters[0];
		driver.findElement(By.xpath(xpath)).click();
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE", "Methodused:clickOnElement,Input Given:"+inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Methodused:clickOnElement,Input Given:"+inputParameters[0].toString());
		}
		return outputParameters;
		
		
	}
	
	public static Hashtable<String,Object> loginWindow(Object[]inputParameters)
	{	
		try
		{
		String log=(String) inputParameters[0];
		WebElement w=driver.findElement(By.xpath(log));
		Actions action=new Actions(driver);
		action.moveToElement(w).build().perform();
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Methodused:loginWindow,Input Given:"+inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Methodused:loginWindow,Input Given:"+inputParameters[0].toString());
		}
		return outputParameters;
		
	}
	public static Hashtable<String,Object> Email(Object[]inputParameters)
	{	
		try
		{
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String email=(String) inputParameters[0];
		driver.findElement(By.xpath(email)).sendKeys("9371005445");
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE", "Methodused:Email,Input Given:"+inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Methodused:Email,Input Given:"+inputParameters[0].toString());
		}
		return outputParameters;
		
	}
	public static Hashtable<String,Object> passWord(Object[]inputParameters)
	{	
		
		try
		{
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String pass=(String) inputParameters[0];
		driver.findElement(By.xpath(pass)).sendKeys("harsh1012");
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE", "Methodused:passWord,Input Given:"+inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Methodused:passWord,Input Given:"+inputParameters[0].toString());
		}
		return outputParameters;
	}
	public static Hashtable<String,Object> Login_validation(Object[]inputParameters)
	{   try
	    {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String givenText=(String) inputParameters[0];
		String xpath=(String) inputParameters[1];
		String actualText=driver.findElement(By.xpath(xpath)).getText();
		if(givenText.equalsIgnoreCase(actualText))
		{
			System.out.println("Test case Pass");
		}
		else
		{
			System.out.println("Test case fail");
		}
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE", "Methodused:Login_validation,Input Given:"+inputParameters[1].toString());
	    }
	    catch(Exception e) 
	    {
	    	outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Methodused:Login_validation,Input Given:"+inputParameters[1].toString());
	    }
	return outputParameters;
	}
	
	public static void main(String[]args) throws InterruptedException
	{
		//Launch Browser
		Object[] input=new Object[2];
		input[0]="Chrome";
		input[1]="E:\\FlipKart_Final\\Flipkart\\src\\test\\resources\\DRIVERS\\chromedriver.exe";
		SeleniumOperations.BrowserLaunch(input);
		
		//Open Application
		Object[] input1=new Object[1];
		input1[0]="http://www.flipkart.com";
		SeleniumOperations.openApplication(input1);
		
		//Click on cancel
		Object[] input2=new Object[1];
		input2[0]="//*[@class='_2KpZ6l _2doB4z']";
		SeleniumOperations.clickOnElement(input2);
		
		//Login
		Object[] input3=new Object[1];
		input3[0]="//*[@class='_1_3w1N']";
		SeleniumOperations.loginWindow(input3);
		
		//Click on my profile
		Thread.sleep(50);
		Object[] input4=new Object[1];
		input4[0]="(//*[@class='_3vhnxf'])[1]";
		SeleniumOperations.clickOnElement(input4);
		
		//Enter email/Mobile 
		Object[] input5=new Object[1];
		input5[0]="//*[@class='_2IX_2- VJZDxU']";
		SeleniumOperations.Email(input5);
		
		//Enter Password
		Object[] input6=new Object[1];
		input6[0]="//*[@type='password']";
		SeleniumOperations.passWord(input6);
		
		//Click on Login
		Object[]input7=new Object[1];
		input7[0]="(//*[@type='submit'])[2]";
		SeleniumOperations.clickOnElement(input7);
		
		//Login Validation
		Object[] input8=new Object[2];
		input8[0]="Hello";
	    input8[1]="//*[@class='_14mvAI']";
		
		
	}

	public static Hashtable<String, Object> sendKey(Object[] input5) {
		// TODO Auto-generated method stub
		return null;
	}
}

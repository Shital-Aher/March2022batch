package cucumbermap;

import java.util.Hashtable;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.HTMLReportGenerator;
import methods.SeleniumOperations;

public class Login 
{
	@Given ("^User opens \"(.*)\" with exe as \"(.*)\"$")
	public void launchBrowser(String bname, String exe)
	{
		Object[] input=new Object[2];
		input[0]=bname;
		input[1]=exe;
		SeleniumOperations.BrowserLaunch(input);
	    
	}
	@Given("^User opens URL as \"(.*)\"$")
	public void openApp(String url) 
	{
		Object[] input1=new Object[1];
		input1[0]=url;
		SeleniumOperations.openApplication(input1);
	}
	@When("^User Click on Cancel Login Window")
	public void user_click_on_cancel_login_window() 
	{
		Object[] input2=new Object[1];
		input2[0]="//*[@class='_2KpZ6l _2doB4z']";
		SeleniumOperations.clickOnElement(input2);
	}
	@When("^User MoveTo Login")
	public void move_to_login() 
	{
		Object[] input3=new Object[1];
		input3[0]="//*[@class='_1_3w1N']";
		SeleniumOperations.loginWindow(input3);
	}
	@When("^User Clicks on My Profile")
	public void user_clicks_on_my_profile() throws InterruptedException 
	{	
		Thread.sleep(3000);
		Object[] input4=new Object[1];
		input4[0]="(//*[@class='_3vhnxf'])[1]";
		Hashtable<String,Object>input4op=SeleniumOperations.clickOnElement(input4);
		HTMLReportGenerator.StepDetails(input4op.get("STATUS").toString(),"User Clicks on My Profile",input4op.get("MESSAGE").toString());
	}
	@When("^User Enters \"(.*)\" as Mobile$")
	public void user_enters_as_mobile(String email) throws Throwable
	{
		Thread.sleep(3000);
		Object[] input5=new Object[2];
		input5[0]="//*[@class='_2IX_2- VJZDxU']";
		input5[1]=email;
		Hashtable<String,Object>input5op= SeleniumOperations.Email(input5);
		HTMLReportGenerator.StepDetails(input5op.get("STATUS").toString(),"User Enters \"(.*)\" as Mobile",input5op.get("MESSAGE").toString());
	}
	@When("^User Enters \"(.*)\" as Password$")
	public void user_enters_as_password(String pass) throws Throwable
	{	
		
		Thread.sleep(3000);
		Object[] input6=new Object[2];
		input6[0]="//*[@type='password']";
		input6[1]=pass;
		Hashtable<String,Object>input6op= SeleniumOperations.passWord(input6);
		HTMLReportGenerator.StepDetails(input6op.get("STATUS").toString(),"User Enters \"(.*)\" as Password",input6op.get("MESSAGE").toString());
		
	}
	@When("^User Clicks on Login Button")
	public void user_clicks_on_login_button() throws Throwable
	{
		Object[]input7=new Object[1];
		input7[0]="(//*[@type='submit'])[2]";
		Hashtable<String,Object>input7op= SeleniumOperations.clickOnElement(input7);
		HTMLReportGenerator.StepDetails(input7op.get("STATUS").toString(),"User Clicks on Login Button",input7op.get("MESSAGE").toString());
	}
	@Then("^Application Shows Login Successfully") 
	public void application_shows_login_successfully() throws Throwable 
	{
	    Thread.sleep(3000);
	    Object[]input8= new Object[2];
	    input8[0]="Hello";
	    input8[1]="//*[@class='_14mvAI']";
	    Hashtable<String,Object>input8op= SeleniumOperations.Login_validation(input8);
		HTMLReportGenerator.StepDetails(input8op.get("STATUS").toString(),"Application Shows Login Successfully",input8op.get("MESSAGE").toString());
	    
	}




	
}
Feature: Login Functionality

Background: User is successfully LaunchedApplication
Given User opens "Chrome" with exe as "E:\\FlipKart_Final\\Flipkart\\src\\test\\resources\\DRIVERS\\chromedriver.exe"
Given User opens URL as "http://www.flipkart.com"

@SmokeTest
Scenario: Login Functionality with valid Email or Mobile & valid Password
When User Click on Cancel Login Window
When User MoveTo Login
When User Clicks on My Profile
When User Enters "9371005445" as Mobile 
When User Enters "harsh1012" as Password
When User Clicks on Login Button
Then Application Shows Login Successfully
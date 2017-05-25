package com.ohrm.pom;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ohrm.res.ResultUtility;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {

	WebDriver driver;	
	WebDriverWait wait;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	//identification Methods
	public WebElement txtUserName(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtUsername']")));
		return driver.findElement(By.xpath("//input[@id='txtUsername']"));	
	}
	
	public WebElement txtPassword(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtPassword']")));
		return driver.findElement(By.xpath("//input[@name='txtPassword']"));		
	}

	public WebElement btnLogin(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='LOGIN']")));
		return driver.findElement(By.xpath("//input[@value='LOGIN']"));		
	}

	//operating methods
	public void enterTextOnUserName(String txtToEnter){
		txtUserName().sendKeys(txtToEnter);
		System.out.println(txtToEnter+" entered on UserName Textbox");
		ResultUtility.test.log(LogStatus.PASS,"Login",txtToEnter+" entered on UserName Textbox");
	}

	public void enterTextOnPassword(String txtToEnter){
		txtPassword().sendKeys(txtToEnter);
		System.out.println(txtToEnter+" entered on Password Textbox");
		ResultUtility.test.log(LogStatus.PASS,"Login",txtToEnter+" entered on Password Textbox");
	}
	
	public void clickOnLoginButton(){
		btnLogin().click();
		System.out.println("Clicked on Login Button");
		ResultUtility.test.log(LogStatus.PASS,"Login","Clicked on Login Button");
	}
	
	//login
	
	public void login(HashMap<String, String> loginData){
		enterTextOnUserName(loginData.get("username"));
		enterTextOnPassword(loginData.get("password"));
		clickOnLoginButton();
	}
	
	
}

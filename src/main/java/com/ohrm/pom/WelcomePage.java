package com.ohrm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

	WebDriver driver;	
	WebDriverWait wait;
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public WebElement lnkPIM(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("PIM")));
		return driver.findElement(By.linkText("PIM"));
	}
	public WebElement lnkAddEmployee(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add Employee")));
		return driver.findElement(By.linkText("Add Employee"));
	}
	
	//operating methods
		
	public void clickOnPIMLink(){
		lnkPIM().click();
		System.out.println("Clicked on PIM Link");
	}
	public void clickOnAddEmployeeLink(){
		lnkAddEmployee().click();
		System.out.println("Clicked on AddEmployee Link");
	}
	
}

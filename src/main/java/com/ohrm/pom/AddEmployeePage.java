package com.ohrm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {

	WebDriver driver;	
	WebDriverWait wait;
	
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	//identification Methods
	public WebElement txtFirstName(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='firstName']")));
		return driver.findElement(By.xpath("//input[@id='firstName']"));	
	}
	
	public WebElement txtLastName(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='lastName']")));
		return driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement btnSave(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='btnSave']")));
		return driver.findElement(By.xpath("//input[@id='btnSave']"));		
	}

	//operating methods
	public void enterTextOnFirstName(String txtToEnter){
		txtFirstName().sendKeys(txtToEnter);
		System.out.println(txtToEnter+" entered on FirstName Textbox");
	}

	public void enterTextOnLastName(String txtToEnter){
		txtLastName().sendKeys(txtToEnter);
		System.out.println(txtToEnter+" entered on LastName Textbox");
	}
	
	public void clickOnSaveButton(){
		btnSave().click();
		System.out.println("Clicked on Save Button");
	}
	
	//verify AddEmployee Page displayed
	public boolean isAddEmployeePageOpened(){
		
		if(txtFirstName().isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
	
}








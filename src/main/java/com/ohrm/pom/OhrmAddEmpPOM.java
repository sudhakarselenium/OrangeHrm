package com.ohrm.pom;

public class OhrmAddEmpPOM {

	public static void main(String[] args) {
		
		OhrmPOM ohrm = new OhrmPOM();
		ohrm.openApplication("chrome", "http://opensource.demo.orangehrmlive.com/");
		
		ohrm.loginPage.enterTextOnUserName("admin");
		ohrm.loginPage.enterTextOnPassword("admin");
		ohrm.loginPage.clickOnLoginButton();
		
		ohrm.welcomePage.clickOnPIMLink();
		ohrm.welcomePage.clickOnAddEmployeeLink();
		ohrm.addEmpPage.enterTextOnFirstName("selenium");
		ohrm.addEmpPage.enterTextOnLastName("hq");
		ohrm.addEmpPage.clickOnSaveButton();
	}

}

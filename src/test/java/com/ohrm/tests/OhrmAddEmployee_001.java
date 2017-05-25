package com.ohrm.tests;

import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ohrm.data.OhrmData;
import com.ohrm.pom.OhrmPOM;

public class OhrmAddEmployee_001 {
	OhrmPOM ohrm;
	HashMap<String, String> tcData;
	
	@BeforeClass
	@Parameters({"brName"})
	public void setup(String brName) {
		ohrm = new OhrmPOM();
		ohrm.testClassName=this.getClass().getSimpleName();
		tcData = ohrm.data.getTcData(OhrmData.dataFilePath,
				OhrmData.dataSheetName, this.getClass().getSimpleName());
		ohrm.openApplication(brName, OhrmData.applicationUrl);
	}

	@Test
	public void Login() {

		ohrm.loginPage.enterTextOnUserName(tcData.get("username"));
		ohrm.loginPage.enterTextOnPassword(tcData.get("password"));
		ohrm.loginPage.clickOnLoginButton();

	}

	@Test(dependsOnMethods = "Login")
	public void AddEmployee() {
		ohrm.welcomePage.clickOnPIMLink();
		ohrm.welcomePage.clickOnAddEmployeeLink();
		ohrm.addEmpPage.enterTextOnFirstName(tcData.get("firstname"));
		ohrm.addEmpPage.enterTextOnLastName(tcData.get("lastname"));
		ohrm.addEmpPage.clickOnSaveButton();
	}

	@AfterClass
	public void closeApplication() {
		ohrm.closeApplication();
	}

}

package com.ohrm.res;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ohrm.data.OhrmData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ResultUtility {
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public ResultUtility(String ClsName) {
		reports = new ExtentReports(OhrmData.resultsFilePath + "\\" + ClsName
				+ getUniqueId() + ".html");
		test = reports.startTest("Ohrm");
	}

	public String getUniqueId() {
		Date dt = new Date();
		return new SimpleDateFormat("YYYYMMddhhmmss").format(dt);
	}

	public void endTest(){
		reports.endTest(test);
		reports.flush();
	}
	
}

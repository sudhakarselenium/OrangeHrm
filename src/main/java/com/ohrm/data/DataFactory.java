package com.ohrm.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFactory {

	public static HashMap<String, String> getTcData(String flPath,
			String shtName, String tcId) {

		// get work book
		Workbook wb;
		HashMap<String, String> tcMap = new HashMap<String, String>();
		
		try {
			wb = new XSSFWorkbook(new FileInputStream(flPath));
			// get sheet
			Sheet sht = wb.getSheet(shtName);

			// get row count
			int rc = sht.getLastRowNum();
			for (int r = 1; r <= rc; r++) {
				if (sht.getRow(r).getCell(0).toString().equalsIgnoreCase(tcId)) {
					int cc = sht.getRow(r).getLastCellNum();
					for (int c = 0; c < cc; c++) {
						String kName = sht.getRow(0).getCell(c).toString();
						String kVal = sht.getRow(r).getCell(c).toString();
						tcMap.put(kName, kVal);
					}
					break;
				}
			}

			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tcMap;
	}

}

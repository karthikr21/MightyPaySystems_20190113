package com.qa.base;

import org.testng.annotations.DataProvider;

import com.qa.utils.ExcelReaderPoi;

public class PreAndTest {

	public String dataWorkBookName, dataSheetName;

	@DataProvider(name = "fetchData")
	public Object[][] fetchTestData() throws Exception {
		ExcelReaderPoi excel = new ExcelReaderPoi();
		return excel.readFilenSheet(dataWorkBookName, dataSheetName);
	}
}

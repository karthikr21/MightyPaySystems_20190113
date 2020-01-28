package com.qa.res.excel.builder;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.res.excel.AccessList;
import com.qa.pojo.res.excel.Login_Res;
import com.qa.utils.Xls_Reader;

import io.restassured.response.Response;

public class LoginResBuilder {

	public static String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\";

	Login_Res login_Res;

	Xls_Reader xlsReader;

	String shtName;

	public void loginResponse(ObjectMapper mapper, Response response, String workBookName, String sheetName,
			Map<String, String> map) throws JsonMappingException, JsonProcessingException {

		login_Res = mapper.readValue(response.asString(), Login_Res.class);

		xlsReader = new Xls_Reader(currentDir + workBookName);

		// Verify the sheet exists already or not
		int rowNum = xlsReader.returnRowNumFromTC(map.get("TestCaseID"));

		if (rowNum == 1) {

			if (xlsReader.isSheetExist(sheetName + "_Res")) {
				xlsReader.removeSheet(sheetName + "_Res");
			}

			shtName = xlsReader.addSheet(sheetName + "_Res");

			xlsReader.addColumn(shtName, "Test Case ID");
			xlsReader.addColumn(shtName, "Auth Secret");
			xlsReader.addColumn(shtName, "Auth Token");
			xlsReader.addColumn(shtName, "Expiry Date");
			xlsReader.addColumn(shtName, "Message");
			xlsReader.addColumn(shtName, "Response Code");
			xlsReader.addColumn(shtName, "Access Type");
			xlsReader.addColumn(shtName, "Function");
		}
		xlsReader.setCellData(sheetName + "_Res", "Test Case ID", rowNum, map.get("TestCaseID"));
		xlsReader.setCellData(sheetName + "_Res", "Auth Secret", rowNum, login_Res.authSecret);
		xlsReader.setCellData(sheetName + "_Res", "Auth Token", rowNum, login_Res.authToken);
		xlsReader.setCellData(sheetName + "_Res", "Expiry Date", rowNum, login_Res.expiryDate);
		xlsReader.setCellData(sheetName + "_Res", "Message", rowNum, login_Res.message);
		xlsReader.setCellData(sheetName + "_Res", "Response Code", rowNum, login_Res.responseCode);

		if (login_Res.accessList == null || login_Res.accessList.isEmpty()) {
			System.out.println("Access List NUll or Empty");
		} else {
			for (AccessList digital : login_Res.accessList) {
				xlsReader.addColumn(shtName, "Access Type");
				xlsReader.setCellData(sheetName + "_Res", "Access Type", rowNum, digital.accessType);
				xlsReader.addColumn(shtName, "Function");
				xlsReader.setCellData(sheetName + "_Res", "Function", rowNum, digital.function);
			}
		}
		verifyRespCode(sheetName, map.get("Response Code"), rowNum, "Result");
	}

	private void verifyRespCode(String sheetName, String respCode, int rowNum, String colName) {
		if (login_Res.responseCode.equals(respCode)) {
			xlsReader.setCellData(sheetName, colName, rowNum, "PASS");
		} else {
			xlsReader.setCellData(sheetName, colName, rowNum, "FAIL");
		}
	}
}
package com.qa.res.excel.builder;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.res.excel.UpdateUserEntity_Res;
import com.qa.utils.Xls_Reader;

import io.restassured.response.Response;

public class UpdateUserEntityResBuilder {

	public static String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\";

	UpdateUserEntity_Res UpdateRes;

	Xls_Reader xlsReader;

	public void UpdateUserEntityResponse(ObjectMapper mapper, Response response, String workBookName, String sheetName,
			Map<String, String> map) throws JsonMappingException, JsonProcessingException {

		UpdateRes = mapper.readValue(response.asString(), UpdateUserEntity_Res.class);

		xlsReader = new Xls_Reader(currentDir + workBookName);

		// Verify the sheet exists already or not
		int rowNum = xlsReader.returnRowNumFromTC(map.get("TestCaseID"));

		if (rowNum == 1) {

			if (xlsReader.isSheetExist(sheetName + "_Res")) {
				xlsReader.removeSheet(sheetName + "_Res");
			}
			
			String shtName = xlsReader.addSheet(sheetName + "_Res");
			xlsReader.addColumn(shtName, "Test Case ID");
		    xlsReader.addColumn(shtName, "Auth ID Response Code");
			xlsReader.addColumn(shtName, "Message");
			xlsReader.addColumn(shtName, "Response Code");
			xlsReader.addColumn(shtName, "RRN");
			xlsReader.addColumn(shtName, "Transaction Time");
			xlsReader.addColumn(shtName, "Transaction Time Zone");
			xlsReader.addColumn(shtName, "Transaction UID");
			xlsReader.addColumn(shtName, "User Entity ID");
			xlsReader.addColumn(shtName, "user Entity Type");
		}
		xlsReader.setCellData(sheetName + "_Res", "Test Case ID", rowNum, map.get("TestCaseID"));
		xlsReader.setCellData(sheetName + "_Res", "Response Code", rowNum, UpdateRes.responseCode);
		xlsReader.setCellData(sheetName + "_Res", "Message", rowNum, UpdateRes.message);
		xlsReader.setCellData(sheetName + "_Res", "RRN", rowNum, UpdateRes.rrn);
		xlsReader.setCellData(sheetName + "_Res", "Auth ID Response Code", rowNum, UpdateRes.authidresp);
		xlsReader.setCellData(sheetName + "_Res", "Transaction UID", rowNum, UpdateRes.txnUid);
		xlsReader.setCellData(sheetName + "_Res", "User Entity ID", rowNum, UpdateRes.userEntityId);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time", rowNum, UpdateRes.trxnTime);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time Zone", rowNum, UpdateRes.trxnTimeZone);
		xlsReader.setCellData(sheetName + "_Res", "user Entity Type", rowNum, UpdateRes.userEntityType);
		verifyRespCode(sheetName, map.get("Response Code"), rowNum, "Result");
	}

	private void verifyRespCode(String sheetName, String respCode, int rowNum, String colName) {
		if (UpdateRes.responseCode.equals(respCode)) {
			xlsReader.setCellData(sheetName, colName, rowNum, "PASS");
		} else {
			xlsReader.setCellData(sheetName, colName, rowNum, "FAIL");
		}
	}
}

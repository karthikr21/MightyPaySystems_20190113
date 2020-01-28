package com.qa.res.excel.builder;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.res.excel.OnboardUserEntity_Res;
import com.qa.utils.Xls_Reader;

import io.restassured.response.Response;

public class OnBoardUserEntityResBuilder {

	public static String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\";

	OnboardUserEntity_Res onBrdRes;

	Xls_Reader xlsReader;

	public void OnBoardResponse(ObjectMapper mapper, Response response, String workBookName, String sheetName,
			Map<String, String> map) throws JsonMappingException, JsonProcessingException {

		onBrdRes = mapper.readValue(response.asString(), OnboardUserEntity_Res.class);

		xlsReader = new Xls_Reader(currentDir + workBookName);

		// Verify the sheet exists already or not
		int rowNum = xlsReader.returnRowNumFromTC(map.get("TestCaseID"));

		if (rowNum == 1) {

			if (xlsReader.isSheetExist(sheetName + "_Res")) {
				xlsReader.removeSheet(sheetName + "_Res");
			}
			
			String shtName = xlsReader.addSheet(sheetName + "_Res");
			xlsReader.addColumn(shtName, "Test Case ID");
			xlsReader.addColumn(shtName, "Wallet ID");
			xlsReader.addColumn(shtName, "Auth ID Response Code");
			xlsReader.addColumn(shtName, "Message");
			xlsReader.addColumn(shtName, "Response Code");
			xlsReader.addColumn(shtName, "RRN");
			xlsReader.addColumn(shtName, "Transaction Time");
			xlsReader.addColumn(shtName, "Transaction Time Zone");
			xlsReader.addColumn(shtName, "Transaction UID");
			xlsReader.addColumn(shtName, "User Entity ID");
		}
		xlsReader.setCellData(sheetName + "_Res", "Test Case ID", rowNum, map.get("TestCaseID"));
		xlsReader.setCellData(sheetName + "_Res", "Response Code", rowNum, onBrdRes.responseCode);
		xlsReader.setCellData(sheetName + "_Res", "Message", rowNum, onBrdRes.message);
		xlsReader.setCellData(sheetName + "_Res", "Auth ID Response Code", rowNum, onBrdRes.authidresp);
		xlsReader.setCellData(sheetName + "_Res", "RRN", rowNum, onBrdRes.rrn);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time", rowNum, onBrdRes.trxnTime);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time Zone", rowNum, onBrdRes.trxnTimeZone);
		xlsReader.setCellData(sheetName + "_Res", "Transaction UID", rowNum, onBrdRes.txnUid);
		xlsReader.setCellData(sheetName + "_Res", "User Entity ID", rowNum, onBrdRes.userEntityId);
		xlsReader.setCellData(sheetName + "_Res", "Wallet ID", rowNum, onBrdRes.walletId);

		verifyRespCode(sheetName, map.get("Response Code"), map.get("Message"), rowNum, "Result");
	}

	private void verifyRespCode(String sheetName, String respCode, String message, int rowNum, String colName) {
		if (onBrdRes.responseCode.equals(respCode) && onBrdRes.message.equals(message)) {
			xlsReader.setCellData(sheetName, colName, rowNum, "PASS");
		} else {
			xlsReader.setCellData(sheetName, colName, rowNum, "FAIL");
		}
	}
}

package com.qa.res.excel.builder;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.res.excel.Topup_Res;
import com.qa.utils.Xls_Reader;

import io.restassured.response.Response;

public class TopupResBuilder {

	public static String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\";

	Topup_Res t_upRes;

	Xls_Reader xlsReader;

	public void TopupResponse(ObjectMapper mapper, Response response, String workBookName, String sheetName,
			Map<String, String> map) throws JsonMappingException, JsonProcessingException {

		t_upRes = mapper.readValue(response.asString(), Topup_Res.class);

		xlsReader = new Xls_Reader(currentDir + workBookName);

		// Verify the sheet exists already or not
		int rowNum = xlsReader.returnRowNumFromTC(map.get("TestCaseID"));

		if (rowNum == 1) {

			if (xlsReader.isSheetExist(sheetName + "_Res")) {
				xlsReader.removeSheet(sheetName + "_Res");
			}
			
			String shtName = xlsReader.addSheet(sheetName + "_Res");
			xlsReader.addColumn(shtName, "Test Case ID");
			xlsReader.addColumn(shtName, "Response Code");
			xlsReader.addColumn(shtName, "Message");
			xlsReader.addColumn(shtName, "RRN");
			xlsReader.addColumn(shtName, "Auth ID Resp");
			xlsReader.addColumn(shtName, "Transaction UID");
			xlsReader.addColumn(shtName, "User Entity ID");
			xlsReader.addColumn(shtName, "Wallet ID");
			xlsReader.addColumn(shtName, "Digital Asset Type Code");
			xlsReader.addColumn(shtName, "Platform Ref");
			xlsReader.addColumn(shtName, "Available Quantity");
			xlsReader.addColumn(shtName, "Transaction Time");
			xlsReader.addColumn(shtName, "Transaction Time Zone");
		}
		xlsReader.setCellData(sheetName + "_Res", "Test Case ID", rowNum, map.get("TestCaseID"));
		xlsReader.setCellData(sheetName + "_Res", "Response Code", rowNum, t_upRes.responseCode);
		xlsReader.setCellData(sheetName + "_Res", "Message", rowNum, t_upRes.message);
		xlsReader.setCellData(sheetName + "_Res", "RRN", rowNum, t_upRes.rrn);
		xlsReader.setCellData(sheetName + "_Res", "Auth ID Response Code", rowNum, t_upRes.authidresp);
		xlsReader.setCellData(sheetName + "_Res", "Transaction UID", rowNum, t_upRes.txnUid);
		xlsReader.setCellData(sheetName + "_Res", "User Entity ID", rowNum, t_upRes.userEntityId);
		xlsReader.setCellData(sheetName + "_Res", "Wallet ID", rowNum, t_upRes.walletId);
		xlsReader.setCellData(sheetName + "_Res", "Digital Asset Type Code", rowNum, t_upRes.digitalAssetTypeCode);
		xlsReader.setCellData(sheetName + "_Res", "Platform Ref", rowNum, t_upRes.platformRef);
		xlsReader.setCellData(sheetName + "_Res", "Available Quantity", rowNum, t_upRes.availableQuantity);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time", rowNum, t_upRes.trxnTime);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time Zone", rowNum, t_upRes.trxnTimeZone);


		verifyRespCode(sheetName, map.get("Response Code"), rowNum, "Result");
	}

	private void verifyRespCode(String sheetName, String respCode, int rowNum, String colName) {
		if (t_upRes.responseCode.equals(respCode)) {
			xlsReader.setCellData(sheetName, colName, rowNum, "PASS");
		} else {
			xlsReader.setCellData(sheetName, colName, rowNum, "FAIL");
		}
	}
}

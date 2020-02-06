package com.qa.res.excel.builder;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.res.excel.Redeem_Res;
import com.qa.utils.Xls_Reader;

import io.restassured.response.Response;

public class RedeemResBuilder {

	public static String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\";

	Redeem_Res RedeemRes = null;

	Xls_Reader xlsReader;

	public void RedeemResponse(ObjectMapper mapper, Response response, String workBookName, String sheetName,
			Map<String, String> map) throws JsonMappingException, JsonProcessingException {

		RedeemRes = mapper.readValue(response.asString(), Redeem_Res.class);

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
			xlsReader.addColumn(shtName, "Quantity");
			xlsReader.addColumn(shtName, "Available Quantity");
			xlsReader.addColumn(shtName, "Merchant Id");
			xlsReader.addColumn(shtName, "Merchant Ref");
			xlsReader.addColumn(shtName, "Platform Ref");
			xlsReader.addColumn(shtName, "Transaction Time");
			xlsReader.addColumn(shtName, "Transaction Time Zone");
		}
		xlsReader.setCellData(sheetName + "_Res", "Test Case ID", rowNum, map.get("TestCaseID"));
		xlsReader.setCellData(sheetName + "_Res", "Response Code", rowNum, RedeemRes.responseCode);
		xlsReader.setCellData(sheetName + "_Res", "Message", rowNum, RedeemRes.message);
		xlsReader.setCellData(sheetName + "_Res", "RRN", rowNum, RedeemRes.rrn);
		xlsReader.setCellData(sheetName + "_Res", "Auth ID Response Code", rowNum, RedeemRes.authidresp);
		xlsReader.setCellData(sheetName + "_Res", "Transaction UID", rowNum, RedeemRes.txnUid);
		xlsReader.setCellData(sheetName + "_Res", "User Entity ID", rowNum, RedeemRes.userEntityId);
		xlsReader.setCellData(sheetName + "_Res", "Wallet ID", rowNum, RedeemRes.walletId);
		xlsReader.setCellData(sheetName + "_Res", "Digital Asset Type Code", rowNum, RedeemRes.digitalAssetTypeCode);
		xlsReader.setCellData(sheetName + "_Res", "Quantity", rowNum, RedeemRes.quantity);
		xlsReader.setCellData(sheetName + "_Res", "Available Quantity", rowNum, RedeemRes.availableQuantity);
		xlsReader.setCellData(sheetName + "_Res", "Merchant Id", rowNum, RedeemRes.merchantId);
		xlsReader.setCellData(sheetName + "_Res", "Merchant Ref", rowNum, RedeemRes.merchantRef);
		xlsReader.setCellData(sheetName + "_Res", "Platform Ref", rowNum, RedeemRes.platformRef);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time", rowNum, RedeemRes.trxnTime);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time Zone", rowNum, RedeemRes.trxnTimeZone);

		verifyRespCode(sheetName, map.get("Response Code"), map.get("Message"), rowNum, "Result");
	}

	private void verifyRespCode(String sheetName, String respCode, String message, int rowNum, String colName) {
		if (RedeemRes.responseCode.equals(respCode) && RedeemRes.message.equals(message)) {
			xlsReader.setCellData(sheetName, colName, rowNum, "PASS");
		} else {
			xlsReader.setCellData(sheetName, colName, rowNum, "FAIL");
		}
	}
}

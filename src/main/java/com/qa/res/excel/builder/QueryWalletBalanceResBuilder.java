package com.qa.res.excel.builder;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.res.excel.DigitalAssetList_Res;
import com.qa.pojo.res.excel.QueryWalletBalance_Res;
import com.qa.utils.Xls_Reader;

import io.restassured.response.Response;

public class QueryWalletBalanceResBuilder {

	public static String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\";

	QueryWalletBalance_Res QueryWalletBalance;

	Xls_Reader xlsReader;

	public void QueryWalletBalanceResponse(ObjectMapper mapper, Response response, String workBookName,
			String sheetName, Map<String, String> map) throws JsonMappingException, JsonProcessingException {

		QueryWalletBalance = mapper.readValue(response.asString(), QueryWalletBalance_Res.class);

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
			xlsReader.addColumn(shtName, "Auth ID Response Code");
			xlsReader.addColumn(shtName, "Transaction UID");
			xlsReader.addColumn(shtName, "User EntityId");
			xlsReader.addColumn(shtName, "walletId");
			xlsReader.addColumn(shtName, "platformRef");
			xlsReader.addColumn(shtName, "Transaction Time");
			xlsReader.addColumn(shtName, "Transaction Time Zone");

			// Digital Asset List
			xlsReader.addColumn(shtName, "Digital Asset Type Code");
			xlsReader.addColumn(shtName, "Digital Asset Name");
			xlsReader.addColumn(shtName, "Available Quantity");
			xlsReader.addColumn(shtName, "Status");

		}

		xlsReader.setCellData(sheetName + "_Res", "Test Case ID", rowNum, map.get("TestCaseID"));
		xlsReader.setCellData(sheetName + "_Res", "Response Code", rowNum, QueryWalletBalance.responseCode);
		xlsReader.setCellData(sheetName + "_Res", "Message", rowNum, QueryWalletBalance.message);
		xlsReader.setCellData(sheetName + "_Res", "RRN", rowNum, QueryWalletBalance.rrn);
		xlsReader.setCellData(sheetName + "_Res", "Auth ID Response Code", rowNum, QueryWalletBalance.authidresp);
		xlsReader.setCellData(sheetName + "_Res", "Transaction UID", rowNum, QueryWalletBalance.txnUid);
		xlsReader.setCellData(sheetName + "_Res", "User EntityId", rowNum, QueryWalletBalance.userEntityId);
		xlsReader.setCellData(sheetName + "_Res", "walletId", rowNum, QueryWalletBalance.walletId);
		xlsReader.setCellData(sheetName + "_Res", "platformRef", rowNum, QueryWalletBalance.platformRef);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time", rowNum, QueryWalletBalance.trxnTime);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time Zone", rowNum, QueryWalletBalance.trxnTimeZone);

		if (QueryWalletBalance.digitalAssetList == null || QueryWalletBalance.digitalAssetList.isEmpty()) {
			System.out.println("Digital Asset List is NUll");
		} else {
			for (DigitalAssetList_Res digital : QueryWalletBalance.digitalAssetList) {
				xlsReader.setCellData(sheetName + "_Res", "Available Quantity", rowNum, digital.availableQuantity);
				xlsReader.setCellData(sheetName + "_Res", "Digital Asset Name", rowNum, digital.digitalAssetName);
				xlsReader.setCellData(sheetName + "_Res", "Digital Asset Type Code", rowNum, digital.digitalAssetTypeCode);
				xlsReader.setCellData(sheetName + "_Res", "Status", rowNum, digital.status);
			}

		}

		verifyRespCode(sheetName, map.get("Response Code"), rowNum, "Result");
	}

	private void verifyRespCode(String sheetName, String respCode, int rowNum, String colName) {
		if (QueryWalletBalance.responseCode.equals(respCode)) {
			xlsReader.setCellData(sheetName, colName, rowNum, "PASS");
		} else {
			xlsReader.setCellData(sheetName, colName, rowNum, "FAIL");
		}
	}
}

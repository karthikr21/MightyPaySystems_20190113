package com.qa.res.excel.builder;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.res.excel.P2PTransfer_Res;
import com.qa.utils.Xls_Reader;

import io.restassured.response.Response;

public class P2PTransferResBuilder {

	public static String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\";

	P2PTransfer_Res P2pTransfer;

	Xls_Reader xlsReader;

	public void P2PTransferResponse(ObjectMapper mapper, Response response, String workBookName, String sheetName,
			Map<String, String> map) throws JsonMappingException, JsonProcessingException {

		P2pTransfer = mapper.readValue(response.asString(), P2PTransfer_Res.class);

		xlsReader = new Xls_Reader(currentDir + workBookName);

		// Verify the sheet exists already or not
		int rowNum = xlsReader.returnRowNumFromTC(map.get("TestCaseID"));

		if (rowNum == 1) {

			if (xlsReader.isSheetExist(sheetName + "_Res")) {
				xlsReader.removeSheet(sheetName + "_Res");
			}
			
			String shtName = xlsReader.addSheet(sheetName + "_Res");
			xlsReader.addColumn(shtName, "Test Case ID");
			xlsReader.addColumn(shtName, "From Wallet Id");
			xlsReader.addColumn(shtName, "Digital Asset TypeCode");
			xlsReader.addColumn(shtName, "Auth ID Response Code");
			xlsReader.addColumn(shtName, "Message");
			xlsReader.addColumn(shtName, "Response Code");
			xlsReader.addColumn(shtName, "RRN");
			xlsReader.addColumn(shtName, "Transaction Time");
			xlsReader.addColumn(shtName, "Transaction Time Zone");
			xlsReader.addColumn(shtName, "Transaction UID");
			xlsReader.addColumn(shtName, "From User EntityId");
			xlsReader.addColumn(shtName, "availableQuantity");
			xlsReader.addColumn(shtName, "quantity");
			xlsReader.addColumn(shtName, "platformRef");
			
		}
		xlsReader.setCellData(sheetName + "_Res", "Test Case ID", rowNum, map.get("TestCaseID"));
		xlsReader.setCellData(sheetName + "_Res", "Response Code", rowNum, P2pTransfer.responseCode);
		xlsReader.setCellData(sheetName + "_Res", "Message", rowNum, P2pTransfer.message);
		xlsReader.setCellData(sheetName + "_Res", "Auth ID Response Code", rowNum, P2pTransfer.authidresp);
		xlsReader.setCellData(sheetName + "_Res", "RRN", rowNum, P2pTransfer.rrn);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time", rowNum, P2pTransfer.trxnTime);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time Zone", rowNum, P2pTransfer.trxnTimeZone);
		xlsReader.setCellData(sheetName + "_Res", "Transaction UID", rowNum, P2pTransfer.txnUid);
		xlsReader.setCellData(sheetName + "_Res", "User Entity ID", rowNum, P2pTransfer.fromUserEntityId);
		xlsReader.setCellData(sheetName + "_Res", "Wallet ID", rowNum, P2pTransfer.fromWalletId);
		xlsReader.setCellData(sheetName + "_Res", "User Entity ID", rowNum, P2pTransfer.digitalAssetTypeCode);
		xlsReader.setCellData(sheetName + "_Res", "Wallet ID", rowNum, P2pTransfer.quantity);
		xlsReader.setCellData(sheetName + "_Res", "Wallet ID", rowNum, P2pTransfer.availableQuantity);

		verifyRespCode(sheetName, map.get("Response Code"), rowNum, "Result");
	}

	private void verifyRespCode(String sheetName, String respCode, int rowNum, String colName) {
		if (P2pTransfer.responseCode.equals(respCode)) {
			xlsReader.setCellData(sheetName, colName, rowNum, "PASS");
		} else {
			xlsReader.setCellData(sheetName, colName, rowNum, "FAIL");
		}
	}
}

package com.qa.res.excel.builder;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.res.excel.StatementList_Res;
import com.qa.pojo.res.excel.TransactionHistoryInquiry_Res;
import com.qa.utils.Xls_Reader;

import io.restassured.response.Response;

public class TransactionHistoryInquiryResBuilder {

	public static String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\";

	TransactionHistoryInquiry_Res TransactionHistoryInquiryRes;

	Xls_Reader xlsReader;

	public void TransactionHistoryInquiryResponse(ObjectMapper mapper, Response response, String workBookName, String sheetName,
			Map<String, String> map) throws JsonMappingException, JsonProcessingException {

		TransactionHistoryInquiryRes = mapper.readValue(response.asString(), TransactionHistoryInquiry_Res.class);

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
			xlsReader.addColumn(shtName, "Wallet ID");
			xlsReader.addColumn(shtName, "User Entity ID");	
			xlsReader.addColumn(shtName, "Transaction Date");
			xlsReader.addColumn(shtName, "Transaction UID");
			xlsReader.addColumn(shtName, "Statement Description");	
			xlsReader.addColumn(shtName, "print Code");	
			xlsReader.addColumn(shtName, "Status");	
			xlsReader.addColumn(shtName, "Transaction Impact");	
			xlsReader.addColumn(shtName, "Transaction Quantity");	
			xlsReader.addColumn(shtName, "Digital Asset Type Code");	
			xlsReader.addColumn(shtName, "Available Quantity");	
			xlsReader.addColumn(shtName, "Transaction Source");	
			xlsReader.addColumn(shtName, "Transaction Reference Number");	
			xlsReader.addColumn(shtName, "Transaction Time");
			
		}
		xlsReader.setCellData(sheetName + "_Res", "Test Case ID", rowNum, map.get("TestCaseID"));
		xlsReader.setCellData(sheetName + "_Res", "Response Code", rowNum, TransactionHistoryInquiryRes.responseCode);
		xlsReader.setCellData(sheetName + "_Res", "Message", rowNum, TransactionHistoryInquiryRes.message);
		xlsReader.setCellData(sheetName + "_Res", "RRN", rowNum, TransactionHistoryInquiryRes.rrn);
		xlsReader.setCellData(sheetName + "_Res", "Auth ID Resp", rowNum, TransactionHistoryInquiryRes.authidresp);
		xlsReader.setCellData(sheetName + "_Res", "Transaction UID", rowNum, TransactionHistoryInquiryRes.txnUid);
		xlsReader.setCellData(sheetName + "_Res", "Wallet ID", rowNum, TransactionHistoryInquiryRes.walletId);
		xlsReader.setCellData(sheetName + "_Res", "User Entity ID", rowNum, TransactionHistoryInquiryRes.userEntityId);
		xlsReader.setCellData(sheetName + "_Res", "Transaction Time", rowNum, TransactionHistoryInquiryRes.trxnTime);
		
		/*if (TransactionHistoryInquiryRes.statementList == null || TransactionHistoryInquiryRes.statementList.isEmpty()) {
			System.out.println("Statement List is NUll");
		} else {*/
		if (TransactionHistoryInquiryRes.statementList == null || TransactionHistoryInquiryRes.statementList.isEmpty()) {
			System.out.println("Digital Asset List is NUll");
		} else {
			for (StatementList_Res statement : TransactionHistoryInquiryRes.statementList) {
				xlsReader.setCellData(sheetName + "_Res", "Transaction Date", rowNum, statement.trxnDate);
				xlsReader.setCellData(sheetName + "_Res", "Transaction UID", rowNum, statement.txnUid);
				xlsReader.setCellData(sheetName + "_Res", "Statement Description", rowNum, statement.stmtDesc);
				xlsReader.setCellData(sheetName + "_Res", "print Code", rowNum, statement.printCode);
				xlsReader.setCellData(sheetName + "_Res", "Status", rowNum, statement.status);
				xlsReader.setCellData(sheetName + "_Res", "Transaction Impact", rowNum, statement.trxnImpact);
				xlsReader.setCellData(sheetName + "_Res", "Transaction Quantity", rowNum, statement.trxnQuantity);
				xlsReader.setCellData(sheetName + "_Res", "Digital Asset Type Code", rowNum, statement.digitalAssetTypeCode);
				xlsReader.setCellData(sheetName + "_Res", "Available Quantity", rowNum, statement.availableQuantity);
				xlsReader.setCellData(sheetName + "_Res", "Transaction Source", rowNum, statement.trxnSource);
				xlsReader.setCellData(sheetName + "_Res", "Transaction Reference Number", rowNum, statement.trxnRefNum);				
			
			}
			
		}

		verifyRespCode(sheetName, map.get("Response Code"), map.get("Message"), rowNum, "Result");
	}

	private void verifyRespCode(String sheetName, String respCode, String message, int rowNum, String colName) {
		if (TransactionHistoryInquiryRes.responseCode.equals(respCode) && TransactionHistoryInquiryRes.message.equals(message)) {
			xlsReader.setCellData(sheetName, colName, rowNum, "PASS");
		} else {
			xlsReader.setCellData(sheetName, colName, rowNum, "FAIL");
		}
	}
}

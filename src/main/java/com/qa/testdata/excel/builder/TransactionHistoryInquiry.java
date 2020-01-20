package com.qa.testdata.excel.builder;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.pojo.req.excel.TransactionHistoryInquiry_Req;

public class TransactionHistoryInquiry {

	public TransactionHistoryInquiry_Req addTransactionHistoryInquiryData(Map<String, String> map) throws JsonProcessingException {

		TransactionHistoryInquiry_Req TransactionHistoryInquiry = new TransactionHistoryInquiry_Req();
		TransactionHistoryInquiry.platformCode = map.get("platformCode");
		TransactionHistoryInquiry.userEntityId = map.get("userEntityId");
		TransactionHistoryInquiry.walletId = map.get("walletId");
		TransactionHistoryInquiry.terminalId = map.get("terminalId");
		TransactionHistoryInquiry.trxnDateFrom = map.get("trxnDateFrom");
		TransactionHistoryInquiry.trxnDateTo = map.get("trxnDateTo");
		TransactionHistoryInquiry.txnUid = map.get("txnUid");
		TransactionHistoryInquiry.digitalAssetTypeCode = map.get("digitalAssetTypeCode");
		
		
		return TransactionHistoryInquiry;
	}

}

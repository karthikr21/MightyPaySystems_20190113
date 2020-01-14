package com.qa.testdata.excel.builder;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.pojo.req.excel.QueryWalletBalance_Req;

public class QueryWalletBalance {

	public QueryWalletBalance_Req addQueryWalletBalanceData(Map<String, String> map) throws JsonProcessingException {

		QueryWalletBalance_Req QueryWalletBalance = new QueryWalletBalance_Req();
		QueryWalletBalance.platformCode = map.get("platformCode");
		QueryWalletBalance.userEntityId = map.get("userEntityId");
		QueryWalletBalance.walletId = map.get("walletId");
		QueryWalletBalance.digitalAssetTypeCode = map.get("digitalAssetTypeCode");
		QueryWalletBalance.terminalId = map.get("terminalId");
		QueryWalletBalance.platformRef = map.get("platformRef");
		QueryWalletBalance.timestamp = map.get("timestamp");
		QueryWalletBalance.timeZone = map.get("timeZone");
		QueryWalletBalance.remarks = map.get("remarks");
     	return QueryWalletBalance;
	}

}

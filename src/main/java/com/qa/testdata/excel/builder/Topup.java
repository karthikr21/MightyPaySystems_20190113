package com.qa.testdata.excel.builder;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.pojo.req.excel.Topup_Req;

public class Topup {

	public Topup_Req addTopupData(Map<String, String> map) throws JsonProcessingException {

		Topup_Req Topup = new Topup_Req();
		Topup.platformCode = map.get("platformCode");
		Topup.userEntityId = map.get("userEntityId");
		Topup.walletId = map.get("walletId");
		Topup.digitalAssetTypeCode = map.get("digitalAssetTypeCode");
		Topup.quantity = map.get("quantity");
		Topup.terminalId = map.get("terminalId");
		Topup.platformRef = map.get("platformRef");
		Topup.timestamp = map.get("timestamp");
		Topup.timeZone = map.get("timeZone");
		Topup.remarks = map.get("remarks");
		
		return Topup;
	}

}

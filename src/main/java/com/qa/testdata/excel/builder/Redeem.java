package com.qa.testdata.excel.builder;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.pojo.req.excel.Redeem_Req;

public class Redeem {

	public Redeem_Req addRedeemData(Map<String, String> map) throws JsonProcessingException {

		Redeem_Req Redeem = new Redeem_Req();
		Redeem.platformCode = map.get("platformCode");
		Redeem.userEntityId = map.get("userEntityId");
		Redeem.walletId = map.get("walletId");
		Redeem.digitalAssetTypeCode = map.get("digitalAssetTypeCode");
		Redeem.quantity = map.get("quantity");
		Redeem.merchantId = map.get("merchantId");
		Redeem.merchantRef = map.get("merchantRef");
		Redeem.terminalId = map.get("terminalId");
		Redeem.platformRef = map.get("platformRef");
		Redeem.remarks = map.get("remarks");
		Redeem.timestamp = map.get("timestamp");
		Redeem.timeZone = map.get("timeZone");
		
		return Redeem;
	}

}

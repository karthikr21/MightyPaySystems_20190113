package com.qa.testdata.excel.builder;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.pojo.req.excel.P2PTransfer_Req;

public class P2PTransfer {

	public P2PTransfer_Req addP2PTransferData(Map<String, String> map) throws JsonProcessingException {

		P2PTransfer_Req P2PTransfer = new P2PTransfer_Req();
		P2PTransfer.platformCode = map.get("platformCode");
		P2PTransfer.fromUserEntityId = map.get("fromUserEntityId");
		P2PTransfer.fromWalletId = map.get("fromWalletId");
		P2PTransfer.toUserEntityId = map.get("toUserEntityId");
		P2PTransfer.toWalletId = map.get("toWalletId");
		P2PTransfer.digitalAssetTypeCode = map.get("digitalAssetTypeCode");
		P2PTransfer.quantity = map.get("quantity");
		P2PTransfer.registerToUserEntity = Boolean.parseBoolean(map.get("registerToUserEntity"));
		P2PTransfer.terminalId = map.get("terminalId");
		P2PTransfer.platformRef = map.get("platformRef");
		P2PTransfer.remarks = map.get("remarks");
		P2PTransfer.timestamp = map.get("timestamp");
		P2PTransfer.timeZone = map.get("timeZone");
		return P2PTransfer;
	}

}

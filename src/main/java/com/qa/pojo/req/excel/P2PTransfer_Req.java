package com.qa.pojo.req.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qa.utils.NoTagFilter;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
@JsonPropertyOrder({ "platformCode", "fromUserEntityId", "fromWalletId", "toUserEntityId", "toWalletId", "digitalAssetTypeCode",
		"quantity", "registerToUserEntity", "terminalId", "platformRef", "remarks", "timestamp", "timeZone"

})
public class P2PTransfer_Req {

	@JsonProperty("platformCode")
	public String platformCode;
	@JsonProperty("fromUserEntityId")
	public String fromUserEntityId;
	@JsonProperty("fromWalletId")
	public String fromWalletId;
	@JsonProperty("toUserEntityId")
	public String toUserEntityId;
	@JsonProperty("toWalletId")
	public String toWalletId;
	@JsonProperty("digitalAssetTypeCode")
	public String digitalAssetTypeCode;
	@JsonProperty("quantity")
	public String quantity;
	@JsonProperty("registerToUserEntity")
	public boolean registerToUserEntity;
	@JsonProperty("terminalId")
	public String terminalId;
	@JsonProperty("platformRef")
	public String platformRef;
	@JsonProperty("remarks")
	public String remarks;
	@JsonProperty("timestamp")
	public String timestamp;
	@JsonProperty("timeZone")
	public String timeZone;
	

	public P2PTransfer_Req() {

	}

}

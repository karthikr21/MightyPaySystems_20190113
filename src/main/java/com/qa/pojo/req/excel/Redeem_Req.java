package com.qa.pojo.req.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qa.utils.NoTagFilter;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
@JsonPropertyOrder({ "platformCode", "userEntityId", "walletId", "digitalAssetTypeCode", "quantity", "merchantId",
		"merchantRef", "terminalId", "platformRef", "remarks","timestamp","timeZone"})

public class Redeem_Req {

	@JsonProperty("platformCode")
	public String platformCode;
	@JsonProperty("userEntityId")
	public String userEntityId;
	@JsonProperty("walletId")
	public String walletId;
	@JsonProperty("digitalAssetTypeCode")
	public String digitalAssetTypeCode;
	@JsonProperty("quantity")
	public String quantity;
	@JsonProperty("merchantId")
	public String merchantId;
	@JsonProperty("merchantRef")
	public String merchantRef;
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
	

	public Redeem_Req() {

	}

}

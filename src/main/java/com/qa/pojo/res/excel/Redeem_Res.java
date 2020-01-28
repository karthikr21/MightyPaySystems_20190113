package com.qa.pojo.res.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "message", "rrn", "authidresp", "txnUid", "userEntityId", "walletId","digitalAssetTypeCode","quantity",
		"availableQuantity","merchantId","merchantRef","platformRef", "trxnTime","trxnTimeZone" })

public class Redeem_Res {

	@JsonProperty("responseCode")
	public String responseCode;
	@JsonProperty("message")
	public String message;
	@JsonProperty("rrn")
	public String rrn;
	@JsonProperty("authidresp")
	public String authidresp;
	@JsonProperty("txnUid")
	public String txnUid;
	@JsonProperty("userEntityId")
	public String userEntityId;
	@JsonProperty("walletId")
	public String walletId;
	@JsonProperty("digitalAssetTypeCode")
	public String digitalAssetTypeCode;
	@JsonProperty("availableQuantity")
	public String quantity;
	@JsonProperty("quantity")
	public String availableQuantity;
	@JsonProperty("merchantId")
	public String merchantId;
	@JsonProperty("merchantRef")
	public String merchantRef;
	@JsonProperty("platformRef")
	public String platformRef;
	@JsonProperty("trxnTime")
	public String trxnTime;
	@JsonProperty("trxnTimeZone")
	public String trxnTimeZone;

	public Redeem_Res() {

	}

}
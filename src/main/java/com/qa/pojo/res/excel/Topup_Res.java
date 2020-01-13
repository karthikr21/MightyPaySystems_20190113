package com.qa.pojo.res.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "message", "rrn", "authidresp", "txnUid", "userEntityId", "walletId","digitalAssetTypeCode","platformRef","availableQuantity", "trxnTime",
		"trxnTimeZone" })

public class Topup_Res {

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
	@JsonProperty("platformRef")
	public String platformRef;
	@JsonProperty("availableQuantity")
	public String availableQuantity;
	@JsonProperty("trxnTime")
	public String trxnTime;
	@JsonProperty("trxnTimeZone")
	public String trxnTimeZone;

	public Topup_Res() {

	}

}
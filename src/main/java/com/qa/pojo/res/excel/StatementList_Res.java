package com.qa.pojo.res.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "trxnDate", "txnUid", "stmtDesc", "printCode", "status", "trxnImpact", "trxnQuantity", "digitalAssetTypeCode","availableQuantity",
		"trxnSource","trxnRefNum"})

public class StatementList_Res {

	@JsonProperty("trxnDate")
	public String trxnDate;
	@JsonProperty("txnUid")
	public String txnUid;
	@JsonProperty("stmtDesc")
	public String stmtDesc;
	@JsonProperty("printCode")
	public String printCode;
	@JsonProperty("status")
	public String status;
	@JsonProperty("trxnImpact")
	public String trxnImpact;
	@JsonProperty("trxnQuantity")
	public String trxnQuantity;
	@JsonProperty("digitalAssetTypeCode")
	public String digitalAssetTypeCode;
	@JsonProperty("availableQuantity")
	public String availableQuantity;
	@JsonProperty("trxnSource")
	public String trxnSource;
	@JsonProperty("trxnRefNum")
	public String trxnRefNum;
	

}
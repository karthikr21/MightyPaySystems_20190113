package com.qa.pojo.res.excel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "message", "rrn", "authidresp", "txnUid", "walletId", "userEntityId","trxnTime"})

public class TransactionHistoryInquiry_Res {

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
	@JsonProperty("walletId")
	public String walletId;
	@JsonProperty("userEntityId")
	public String userEntityId;
	@JsonProperty("statementList")
	public List<StatementList_Res> statementList;
	@JsonProperty("trxnTime")
	public String trxnTime;
	

	
}
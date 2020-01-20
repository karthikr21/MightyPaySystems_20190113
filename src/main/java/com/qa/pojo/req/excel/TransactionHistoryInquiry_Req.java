package com.qa.pojo.req.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qa.utils.NoTagFilter;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
@JsonPropertyOrder({ "platformCode", "userEntityId", "walletId", "terminalId", "trxnDateFrom", "trxnDateTo",
		"txnUid", "digitalAssetTypeCode"})

public class TransactionHistoryInquiry_Req {

	@JsonProperty("platformCode")
	public String platformCode;
	@JsonProperty("userEntityId")
	public String userEntityId;
	@JsonProperty("walletId")
	public String walletId;
	@JsonProperty("terminalId")
	public String terminalId;
	@JsonProperty("trxnDateFrom")
	public String trxnDateFrom;
	@JsonProperty("trxnDateTo")
	public String trxnDateTo;
	@JsonProperty("txnUid")
	public String txnUid;
	@JsonProperty("digitalAssetTypeCode")
	public String digitalAssetTypeCode;
	

	public TransactionHistoryInquiry_Req() {

	}

}

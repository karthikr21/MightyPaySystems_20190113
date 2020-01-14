package com.qa.pojo.req.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qa.utils.NoTagFilter;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
@JsonPropertyOrder({ "platformCode", "fromUserEntityId", "fromWalletId", "toUserEntityId", "toWalletId", "digitalAssetTypeCode",
		"quantity", "registerToUserEntity", "terminalId", "platformRef", "remarks", "timestamp", "timeZone"

})
public class QueryWalletBalance_Req {

	@JsonProperty("platformCode")
	public String platformCode;
	@JsonProperty("userEntityId")
	public String userEntityId;
	@JsonProperty("walletId")
	public String walletId;
	@JsonProperty("digitalAssetTypeCode")
	public String digitalAssetTypeCode;
	@JsonProperty("terminalId")
	public String terminalId;
	@JsonProperty("platformRef")
	public String platformRef;
	@JsonProperty("timestamp")
	public String timestamp;
	@JsonProperty("timeZone")
	public String timeZone;
	@JsonProperty("remarks")
	public String remarks;
		

	public QueryWalletBalance_Req() {

	}

}

package com.qa.pojo.req.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qa.utils.NoTagFilter;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
@JsonPropertyOrder({ "platformCode", "userEntityId", "terminalId", "userEntityDetails",	"timestamp", "timeZone"	})
public class UpdateUserEntity_Req {

	@JsonProperty("platformCode")
	public String platformCode;
	@JsonProperty("userEntityId")
	public String userEntityId;
	@JsonProperty("terminalId")
	public String terminalId;
	@JsonProperty("userEntityDetails")
	public UserEntityDetails_Req userEntityDetails;
	@JsonProperty("timestamp")
	public String timestamp;
	@JsonProperty("timeZone")
	public String timeZone;



}

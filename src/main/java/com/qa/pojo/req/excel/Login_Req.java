
package com.qa.pojo.req.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qa.utils.NoTagFilter;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
@JsonPropertyOrder({ "platformCode", "userName", "password", "terminalId", "acquirerId" })
public class Login_Req {

	@JsonProperty("platformCode")
	public String platformCode;
	@JsonProperty("userName")
	public String userName;
	@JsonProperty("password")
	public String password;
	@JsonProperty("terminalId")
	public String terminalId;
	@JsonProperty("acquirerId")
	public String acquirerId;
}
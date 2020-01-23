package com.qa.pojo.res.excel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "expiryDate", "authSecret", "authToken", "accessList", "message", "responseCode" })
public class Login_Res {

	@JsonProperty("expiryDate")
	public String expiryDate;
	@JsonProperty("authSecret")
	public String authSecret;
	@JsonProperty("authToken")
	public String authToken;
	@JsonProperty("accessList")
	public List<AccessList> accessList = null;
	@JsonProperty("message")
	public String message;
	@JsonProperty("responseCode")
	public String responseCode;

}
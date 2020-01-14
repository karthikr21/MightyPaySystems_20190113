package com.qa.pojo.req.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qa.utils.NoTagFilter;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
@JsonPropertyOrder({ "name", "userEntityIdentityType", "userEntityIdentity", "address1", "address2", "address3", "postalCode", "city",
	"countryCode", "state",	"emailId", "mobileNo", "kycFlag", "status" })

public class UserEntityDetails_Req {

	@JsonProperty("name")
	public String name;
	@JsonProperty("userEntityIdentityType")
	public String userEntityIdentityType;
	@JsonProperty("userEntityIdentity")
	public String userEntityIdentity;
	@JsonProperty("address1")
	public String address1;
	@JsonProperty("address2")
	public String address2;
	@JsonProperty("address3")
	public String address3;
	@JsonProperty("postalCode")
	public String postalCode;
	@JsonProperty("city")
	public String city;
	@JsonProperty("countryCode")
	public String countryCode;
	@JsonProperty("state")
	public String state;
	@JsonProperty("emailId")
	public String emailId;
	@JsonProperty("mobileNo")
	public String mobileNo;
	@JsonProperty("kycFlag")
	public String kycFlag;
	@JsonProperty("status")
	public String status;

	

}

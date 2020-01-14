package com.qa.pojo.res.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "digitalAssetTypeCode", "digitalAssetName", "availableQuantity", "status" })

public class DigitalAssetList_Res {

	@JsonProperty("digitalAssetTypeCode")
	public String digitalAssetTypeCode;
	@JsonProperty("digitalAssetName")
	public String digitalAssetName;
	@JsonProperty("availableQuantity")
	public String availableQuantity;
	@JsonProperty("status")
	public String status;

}
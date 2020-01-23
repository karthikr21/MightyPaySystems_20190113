package com.qa.pojo.res.excel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"accessType",
"function"
})
public class AccessList {

@JsonProperty("accessType")
public String accessType;
@JsonProperty("function")
public String function;

}

package com.qa.testng;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.APIResources;
import com.qa.base.RestAssuredBase;
import com.qa.res.excel.builder.TransactionHistoryInquiryResBuilder;
import com.qa.testdata.excel.builder.TransactionHistoryInquiry;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TransactionHistoryInquiryTest extends RestAssuredBase {
	ResponseSpecification resspec;
	Response response;
	RequestSpecification res;
	TransactionHistoryInquiry data = new TransactionHistoryInquiry();
	TransactionHistoryInquiryResBuilder responseBuilder = new TransactionHistoryInquiryResBuilder();

	@BeforeTest
	public void setValues() {
		dataWorkBookName = "TransactionHistoryInquiry.xlsx";
		dataSheetName = "TransactionHistoryInquiry";
	}

	@Test(dataProvider = "fetchData")
	public void verifyTransactionHistoryInquiry(Map<String, String> map) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String reqData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.addTransactionHistoryInquiryData(map));
		APIResources resourceAPI = APIResources.valueOf("TransactionHistoryInquiry");
		res = given().spec(requestSpecification()).body(reqData);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().post(resourceAPI.getResource());
		System.out.println(map.get("TestCaseID") + " is in Progress");
		if (response != null) {
			response.prettyPrint();
			writeFile(resourceAPI.toString(), reqData, response, map.get("TestCaseID"));
			responseBuilder.TransactionHistoryInquiryResponse(mapper, response, dataWorkBookName, dataSheetName, map);
		} else {
		}
	}
}
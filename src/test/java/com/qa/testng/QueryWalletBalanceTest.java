package com.qa.testng;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.APIResources;
import com.qa.base.RestAssuredBase;
import com.qa.res.excel.builder.P2PTransferResBuilder;
import com.qa.res.excel.builder.QueryWalletBalanceResBuilder;
import com.qa.testdata.excel.builder.P2PTransfer;
import com.qa.testdata.excel.builder.QueryWalletBalance;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class QueryWalletBalanceTest extends RestAssuredBase {
	ResponseSpecification resspec;
	Response response;
	RequestSpecification res;
	QueryWalletBalance data = new QueryWalletBalance();
	QueryWalletBalanceResBuilder responseBuilder = new QueryWalletBalanceResBuilder();

	@BeforeTest
	public void setValues() {
		dataWorkBookName = "QueryWalletBalance.xlsx";
		dataSheetName = "QueryWalletBalance";
	}

	@Test(dataProvider = "fetchData")
	public void verifyQueryWalletBalance(Map<String, String> map) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String reqData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.addQueryWalletBalanceData(map));
		APIResources resourceAPI = APIResources.valueOf("queryWalletBalance");
		res = given().spec(requestSpecification()).body(reqData);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().post(resourceAPI.getResource());
		System.out.println( map.get("TestCaseID")   +"is in Progress");
		if (response != null) {
			response.prettyPrint();
			writeFile(resourceAPI.toString(), reqData, response, map.get("TestCaseID"));
			responseBuilder.QueryWalletBalanceResponse(mapper, response, dataWorkBookName, dataSheetName, map);
		} else {
		}
	}
}
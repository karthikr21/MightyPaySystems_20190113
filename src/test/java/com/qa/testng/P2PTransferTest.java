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
import com.qa.testdata.excel.builder.P2PTransfer;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class P2PTransferTest extends RestAssuredBase {
	ResponseSpecification resspec;
	Response response;
	RequestSpecification res;
	P2PTransfer data = new P2PTransfer();
	P2PTransferResBuilder responseBuilder = new P2PTransferResBuilder();

	@BeforeTest
	public void setValues() {
		dataWorkBookName = "P2PTransfer.xlsx";
		dataSheetName = "P2PTransfer";
	}

	@Test(dataProvider = "fetchData")
	public void verifyP2PTransfer(Map<String, String> map) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String reqData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.addP2PTransferData(map));
		APIResources resourceAPI = APIResources.valueOf("p2ppayment");
		res = given().spec(requestSpecification()).body(reqData);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().post(resourceAPI.getResource());
		System.out.println( map.get("TestCaseID")   +"is in Progress");
		if (response != null) {
			response.prettyPrint();
			writeFile(resourceAPI.toString(), reqData, response, map.get("TestCaseID"));
			responseBuilder.P2PTransferResponse(mapper, response, dataWorkBookName, dataSheetName, map);
		} else {
		}
	}
}
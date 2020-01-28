package com.qa.testng;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.APIResources;
import com.qa.base.RestAssuredBase;
import com.qa.res.excel.builder.LoginResBuilder;
import com.qa.testdata.excel.builder.Login;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LoginTest extends RestAssuredBase {

	ResponseSpecification resspec;
	Response response;
	RequestSpecification res;
	Login data = new Login();
	LoginResBuilder resBuilder = new LoginResBuilder();

	@BeforeTest
	public void setValues() {
		dataWorkBookName = "Login.xlsx";
		dataSheetName = "login";
	}

	@Test(dataProvider = "fetchData")
	public void verifyOnBoardUserEntity(Map<String, String> map) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String reqData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.loginReqBuilder(map));
		APIResources resourceAPI = APIResources.valueOf("login");
		res = given().spec(requestSpecification()).body(reqData);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().post(resourceAPI.getResource());
		System.out.println(map.get("TestCaseID") + "is in Progress");
		if (response != null) {
			response.prettyPrint();
			writeFile(resourceAPI.toString(), reqData, response, map.get("TestCaseID"));
			resBuilder.loginResponse(mapper, response, dataWorkBookName, dataSheetName, map);
		} else {
			System.out.println("Response Onject is NULL or Empty");
		}
	}
}
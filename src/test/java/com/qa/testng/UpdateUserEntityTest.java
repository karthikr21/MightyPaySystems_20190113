package com.qa.testng;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.APIResources;
import com.qa.base.RestAssuredBase;
import com.qa.res.excel.builder.UpdateUserEntityResBuilder;
import com.qa.testdata.excel.builder.UpdateUserEntity;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UpdateUserEntityTest extends RestAssuredBase {
	ResponseSpecification resspec;
	Response response;
	RequestSpecification res;
	UpdateUserEntity data = new UpdateUserEntity();
	UpdateUserEntityResBuilder responseBuilder = new UpdateUserEntityResBuilder();

	@BeforeTest
	public void setValues() {
		dataWorkBookName = "UpdateUserEntity.xlsx";
		dataSheetName = "UpdateUserEntity";
	}

	@Test(dataProvider = "fetchData")
	public void verifyUpdateUserEntity(Map<String, String> map) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String reqData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.addUpdateUserEntityData(map));
		APIResources resourceAPI = APIResources.valueOf("updateUserEntity");
		res = given().spec(requestSpecification()).body(reqData);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().post(resourceAPI.getResource());
		System.out.println( map.get("TestCaseID")   +"is in Progress");
		if (response != null) {
			response.prettyPrint();
			writeFile(resourceAPI.toString(), reqData, response, map.get("TestCaseID"));
			responseBuilder.UpdateUserEntityResponse(mapper, response, dataWorkBookName, dataSheetName, map);
		} else {
		}
	}
}
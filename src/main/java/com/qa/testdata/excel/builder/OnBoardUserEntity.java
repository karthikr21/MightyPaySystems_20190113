package com.qa.testdata.excel.builder;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.pojo.req.excel.OnboardUserEntity_Req;

public class OnBoardUserEntity {

	public OnboardUserEntity_Req addOnBoardUserData(Map<String, String> map) throws JsonProcessingException {

		OnboardUserEntity_Req OnBoardUserEntity = new OnboardUserEntity_Req();
		OnBoardUserEntity.platformCode = map.get("platformCode");
		OnBoardUserEntity.terminalId = map.get("terminalId");
		OnBoardUserEntity.name = map.get("name");
		OnBoardUserEntity.mobileNo = map.get("mobileNo");
		OnBoardUserEntity.userEntityIdentityType = map.get("userEntityIdentityType");
		OnBoardUserEntity.userEntityIdentity = map.get("userEntityIdentity");
		OnBoardUserEntity.userEntityType = map.get("userEntityType");
		OnBoardUserEntity.address1 = map.get("address1");
		OnBoardUserEntity.address2 = map.get("address2");
		OnBoardUserEntity.address3 = map.get("address3");
		OnBoardUserEntity.postalCode = map.get("postalCode");
		OnBoardUserEntity.city = map.get("City");
		OnBoardUserEntity.countryCode = map.get("countryCode");
		OnBoardUserEntity.timestamp = map.get("timestamp");
		OnBoardUserEntity.timeZone = map.get("timeZone");
		OnBoardUserEntity.state = map.get("State");
		OnBoardUserEntity.emailId = map.get("emailId");
		OnBoardUserEntity.kycFlag = map.get("kycFlag");
		return OnBoardUserEntity;
	}

}

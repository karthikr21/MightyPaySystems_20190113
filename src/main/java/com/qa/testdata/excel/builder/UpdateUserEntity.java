package com.qa.testdata.excel.builder;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.qa.pojo.req.excel.UpdateUserEntity_Req;
import com.qa.pojo.req.excel.UserEntityDetails_Req;


public class UpdateUserEntity {

	public UpdateUserEntity_Req addUpdateUserEntityData(Map<String, String> map) throws JsonProcessingException {

		UpdateUserEntity_Req UpdateUserEntity = new UpdateUserEntity_Req();
		UpdateUserEntity.platformCode = map.get("platformCode");
		UpdateUserEntity.terminalId = map.get("terminalId");
		UpdateUserEntity.userEntityId = map.get("userEntityId");
		UpdateUserEntity.timestamp = map.get("timestamp");
		UpdateUserEntity.timeZone = map.get("timeZone");
		
		//UserEntityDetails
		UserEntityDetails_Req UserEntityDetails = new UserEntityDetails_Req();
		
		
		UserEntityDetails.mobileNo = map.get("mobileNo");
		UserEntityDetails.name = map.get("name");
		UserEntityDetails.status = map.get("status");
		UserEntityDetails.userEntityIdentityType = map.get("userEntityIdentityType");
		UserEntityDetails.userEntityIdentity = map.get("userEntityIdentity");
		UserEntityDetails.address1 = map.get("address1");
		UserEntityDetails.address2 = map.get("address2");
		UserEntityDetails.address3 = map.get("address3");
		UserEntityDetails.postalCode = map.get("postalCode");
		UserEntityDetails.city = map.get("city");
		UserEntityDetails.countryCode = map.get("countryCode");
		UserEntityDetails.state = map.get("state");
		UserEntityDetails.emailId = map.get("emailId");
		UserEntityDetails.kycFlag = map.get("kycFlag");
		
		return UpdateUserEntity;
	}

}

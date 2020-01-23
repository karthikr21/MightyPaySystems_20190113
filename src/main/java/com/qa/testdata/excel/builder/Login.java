package com.qa.testdata.excel.builder;

import java.util.Map;

import com.qa.pojo.req.excel.Login_Req;

public class Login {

	public Login_Req loginReqBuilder(Map<String, String> map) {

		Login_Req login = new Login_Req();
		login.userName = map.get("userName");
		login.password = map.get("password");
		login.acquirerId = map.get("acquirerId");
		login.platformCode = map.get("platformCode");
		login.terminalId = map.get("terminalId");
		return login;
	}
}

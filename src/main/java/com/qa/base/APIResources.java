package com.qa.base;

//enum is special class in java which has collection of constants or  methods

public enum APIResources {

	OnBoard("/onboard"), 
	Topup("/topup"),
	p2ppayment("/p2p-payment");
	

	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}

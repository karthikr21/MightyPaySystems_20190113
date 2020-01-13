package com.qa.base;

public class TestSubstring {

	public static void main(String[] args) {

		String a = "TC_OUE-0001";
		String[] str = a.split("-");
		String ab = str[1];
		int no = Integer.parseInt(ab);
		System.out.println(no);
	}

}

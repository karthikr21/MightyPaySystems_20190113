package com.qa.utils;

public class NoTagFilter {

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof String)) {
			return false;
		}
		String val = obj.toString();
		return "NO_TAG".equalsIgnoreCase(val);
	}
}
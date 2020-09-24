package com.he.addressBook;

public class Address {

	private String label;
	private String address;

	public Address(String label, String address) throws Exception {
		if ((!label.isEmpty()) && (label.length() > 255) && (!label.matches("[a-zA-Z\\s\'\"]+"))) {
			throw new Exception();
		} else {
			this.label = label;
			this.address = address;
		}
	}

	public String getLabel() {
		return this.label;
	}

	public String getAddress() {
		return this.address;
	}
}

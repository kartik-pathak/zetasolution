package com.he.addressBook;

public class PhoneNumber {
	private String label;
	private String phoneNumber;

	public PhoneNumber(String label, String phoneNumber) throws Exception {
		if ((!label.isEmpty()) && (label.length() > 255) && (!label.matches("[a-zA-Z\\s\'\"]+"))) {
			throw new Exception();
		} else if ((phoneNumber.length() > 10) && (!label.matches("[0-9]"))) {
			throw new Exception();
		} else {
			this.label = label;
			this.phoneNumber = phoneNumber;
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) throws Exception {
		if ((!label.isEmpty()) && (label.length() > 255) && (!label.matches("[a-zA-Z\\s\'\"]+"))) {
			throw new Exception();
		} else {
			this.label = label;
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws Exception {
		if ((phoneNumber.length() > 10) && (label.matches("[0-9]"))) {
			throw new Exception();
		} else {
			this.phoneNumber = phoneNumber;
		}
	}
}

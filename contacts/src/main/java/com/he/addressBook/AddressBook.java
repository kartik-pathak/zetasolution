package com.he.addressBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

	private List<Contact> lstContacts = new ArrayList<Contact>();

	public AddressBook() {
		// TODO
	}

	public void addContact(Contact contact) throws Exception {
		if (this.lstContacts.isEmpty()) {
			this.lstContacts.add(contact);
		} else {
			for (Contact existingContact : this.lstContacts) {
				if (existingContact.getName().equals(contact.getName())) {
					throw new Exception();
				}
			}
			this.lstContacts.add(contact);
		}
	}

	public void deleteContact(String name) throws Exception {
		boolean flag = false;
		Iterator<Contact> itr = this.lstContacts.iterator();
		while (itr.hasNext()) {
			Contact contact = itr.next();
			if (contact.getName().equals(name)) {
				itr.remove();
				flag = true;
			}
		}
		if (!flag) {
			throw new Exception();
		}
	}

	public void updateContact(String name, Contact contact) throws Exception {
		List<Contact> existingRecord = this.lstContacts.stream()
				.filter(existingContact -> existingContact.getName().equals((name))).collect(Collectors.toList());
		if(existingRecord.isEmpty()) {
			throw new Exception();
		}
		for (Contact existingContact : this.lstContacts) {
			if (existingContact.getName().equals(contact.getName())) {
				throw new Exception();
			}
			if (existingContact.getName().equals(name)) {
				Iterator<Contact> itr = this.lstContacts.iterator();
				while (itr.hasNext()) {
					Contact testContact = itr.next();
					if (testContact.getName().equals(name)) {
						itr.remove();
					}
				}
				this.lstContacts.add(contact);
			}
		}
		this.lstContacts.add(contact);
	}

	public List<Contact> searchByName(String name) {
		if (name.isEmpty()) {
			return this.lstContacts;
		} else {
			return this.lstContacts.stream()
					.filter(contact -> contact.getName().toUpperCase().contains(name.toUpperCase()))
					.collect(Collectors.toList());
		}
	}

	public List<Contact> searchByOrganisation(String organisation) {
		if (organisation.isEmpty()) {
			return this.lstContacts;
		} else {
			return this.lstContacts.stream()
					.filter(contact -> contact.getOrganisation().toUpperCase().contains(organisation.toUpperCase()))
					.collect(Collectors.toList());
		}
	}

}
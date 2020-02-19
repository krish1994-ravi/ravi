package com.tekleads.service;

import com.tekleads.model.Contact;

public interface ContactService {

	public boolean saveContact(Contact c);
	
	public Iterable<Contact> getActiveContacts();
	
	public Contact getContactById(Integer id);
	
	
	
	public boolean deleteContact(Integer id);
}

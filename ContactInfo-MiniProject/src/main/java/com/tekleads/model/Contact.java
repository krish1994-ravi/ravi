package com.tekleads.model;

import lombok.Data;

@Data
public class Contact {
	
	private Integer contactId;
	private String contactName;
	private Long phNo;
	private String activeSwitch;
	private String contactEmail;

}

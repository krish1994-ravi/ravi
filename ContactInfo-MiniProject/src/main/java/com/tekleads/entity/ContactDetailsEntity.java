package com.tekleads.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_INFO")
public class ContactDetailsEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID",length=10)
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="CONTACT_NUMBER")
	private Long phNo;
	
	@Column(name="ACTIVE_SWITCH")
	private String activeSwitch;
	
	@Column(name="CREATE_DATE",updatable = false)
	@CreationTimestamp
	@Temporal(value = TemporalType.DATE)
    private Date createdDate;
	
	@Column(name="UPDATE_DATE")
	@UpdateTimestamp
	@Temporal(value = TemporalType.DATE)
	private Date updatedDate;

}

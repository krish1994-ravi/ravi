package com.tekleads.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekleads.entity.ContactDetailsEntity;
import com.tekleads.model.Contact;
import com.tekleads.repository.ContactDetailsRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	private static Logger logger=LoggerFactory.getLogger(ContactService.class);
	
	public ContactServiceImpl() {
		logger.info("ContactService class Initialized");
	}
	
	@Autowired
	private ContactDetailsRepository repository;

	@Override
	public boolean saveContact(Contact c) {
		logger.debug("ContactServiceImpl.saveContact()-->start");
		ContactDetailsEntity contactEntity=new ContactDetailsEntity();
		//convert model class object to entity class object
		BeanUtils.copyProperties(c, contactEntity);
		contactEntity.setActiveSwitch("Y");
		logger.info("Contact saved report");
		ContactDetailsEntity saveEntity = repository.save(contactEntity);
		//use repository
		logger.debug("ContactServiceImpl.saveContact()-->ended");
		return saveEntity.getContactId()!=null;
	}

	@Override
	public Iterable<Contact> getActiveContacts() {
		logger.debug("method started");
		// use repository
		
		logger.info("get All Active contacts summary");
		Iterable<ContactDetailsEntity> findAll = repository.findAll();
		//convert Iterable to List Collection
		List<ContactDetailsEntity> list=new ArrayList();
		findAll.forEach(entity->{
			list.add(entity);
		});
		List<ContactDetailsEntity> collectedEntity = list.stream().filter(entity->entity.getActiveSwitch()=="Y").collect(Collectors.toList());
		//convert list Entity to Iterable entity
		List<Contact> listContact=new ArrayList();
		collectedEntity.forEach(entiy->{
			Contact c=new Contact();
			BeanUtils.copyProperties(entiy, c);
			listContact.add(c);
			});
		logger.debug("method ended");
		return listContact;
	}

	@Override
	public Contact getContactById(Integer id) {
		logger.debug("method started");
		logger.info("get Contact By Id summary");
		Optional<ContactDetailsEntity> findById = repository.findById(id);
		if(findById.isPresent()) {
			ContactDetailsEntity entity=findById.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		logger.debug("method ended");
		return null;
		
	}

	

	@Override
	public boolean deleteContact(Integer id) {
		logger.debug("method is started");
		ContactDetailsEntity entity=null;
		// get record
		Optional<ContactDetailsEntity> findById = repository.findById(id);
		if(findById.isPresent()) {
			entity=findById.get();
			//modify the record
		logger.info("contact delete summary");
		entity.setActiveSwitch("N");
		//save object
		repository.save(entity);
		}
		logger.debug("method is ended");
		return entity!=null;
	}

}

package com.tekleads.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tekleads.model.Contact;
import com.tekleads.service.ContactService;

@Controller
public class ContactController {
	
	private static Logger logger=LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService service;
	
	@RequestMapping("/showForm")
	public String showContactHome(@ModelAttribute("contact")Contact contact) {
		logger.info("method executed");
		return "contact_info";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String handleSubmitButton(Map<String,Object> map,@ModelAttribute("contact")Contact contact,RedirectAttributes attributes) {
		logger.debug("method started");
		//use service
		boolean saveContact = service.saveContact(contact);
		if(saveContact) {
		   attributes.addFlashAttribute("msg", "contact added successfully");
		}
		else {
			logger.error("saveContact() method not executed");
			attributes.addFlashAttribute("msg", "contact not added");
		}
		logger.debug("method ended");
		return "redirect:/showForm";
		
	}
	@RequestMapping("/allContacts")
	public String HandleAllActiveContacts(Map<String,Object> map) {
		logger.info("get All Contats Summary in controller");
		Iterable<Contact> activeContacts = service.getActiveContacts();
		map.put("activeContacts",activeContacts);
		return "all_contacts";
	}
	@RequestMapping("/edit")
	public String HandleEditContact(@ModelAttribute("contact")Contact contact,Map<String,Object> map,HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		//use service
		logger.info("get COntact By Id summary");
		Contact con= service.getContactById(id);
		BeanUtils.copyProperties(con, contact);
		return "contact_info";
	}
	@RequestMapping("/delete")
	public String HandleDeleteContact(RedirectAttributes attributes,HttpServletRequest request,@ModelAttribute("contact")Contact contact) {
        logger.debug("method started");
		Integer id=Integer.parseInt(request.getParameter("id"));
		logger.info("delete contact summary");
		boolean deleteContact = service.deleteContact(id);
		if(deleteContact)
			attributes.addFlashAttribute("msg", "record deleted");
		else
			attributes.addFlashAttribute("msg", "record not deleted");
		logger.debug("method ended");
		return "redirect:/allContacts";
	}
}

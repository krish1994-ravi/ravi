package com.tekleads.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tekleads.entity.ContactDetailsEntity;

@Repository
public interface ContactDetailsRepository extends CrudRepository<ContactDetailsEntity, Integer> {

}

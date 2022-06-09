package com.mycompany.PropertyManagement.repository;

import com.mycompany.PropertyManagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;



public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}

package com.mycompany.PropertyManagement.repository;

import com.mycompany.PropertyManagement.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}

package com.mycompany.PropertyManagement.repository;

import com.mycompany.PropertyManagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
//@Query("SELECT p FROM PropertyEntity p WHERE p.userEntity.Id = :userId AND p.title = :title")
    //List<PropertyEntity> findAllByUserEntityId(@Param("userId")Long userId,@Param("title")Long title);
    List<PropertyEntity> findAllByUserEntityId(@Param("userId")Long userId);

}

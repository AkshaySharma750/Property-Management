package com.mycompany.PropertyManagement.repository;
import com.mycompany.PropertyManagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}

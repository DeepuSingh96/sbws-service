package com.tcs.sbws.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tcs.sbws.entity.UserEntity;

public interface UsersRepository extends MongoRepository<UserEntity, String> {
	
//  Optional<UserEntity> findByUsername(String username);
  
  Optional<UserEntity> findByemployeeNo(String empid);
  
}
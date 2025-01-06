package com.demo.authentication_service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.authentication_service.Entity.UserCredentialsEntity;

public interface UserCredentialDao extends JpaRepository<UserCredentialsEntity,Integer>{
	public Optional<UserCredentialsEntity> findByName(String name);
}

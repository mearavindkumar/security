package com.security.auth.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.auth.data.entity.AuthGroup;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
	
	List<AuthGroup> findByUsername(String username);

}

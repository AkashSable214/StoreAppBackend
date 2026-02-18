package com.cjc.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.app.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Long> {
	
	Optional<Admin> findByUsernameAndPassword(String username,String password);


}

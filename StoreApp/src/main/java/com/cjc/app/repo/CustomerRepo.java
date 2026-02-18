package com.cjc.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.app.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Optional<Customer> findByUsernameAndPassword(String username, String password);

}

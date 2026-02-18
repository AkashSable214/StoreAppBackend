package com.cjc.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.app.entity.Dealer;

public interface DealerRepo extends JpaRepository<Dealer, Long> {

	Optional<Dealer> findByUsernameAndPassword(String username, String password);
	
	long countById(Long id);

}

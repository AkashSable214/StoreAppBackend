package com.cjc.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.entity.Dealer;
import com.cjc.app.service.DealerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/dealer")
public class DealerController {

	@Autowired
	private DealerService service;

	@PostMapping
	public Dealer save(@RequestBody Dealer dealer) {
		return service.saveDealer(dealer);
	}

	@GetMapping
	public List<Dealer> getAll() {
		return service.getAllDealer();
	}

	@GetMapping("/{id}")
	public Dealer getById(@PathVariable Long id) {
		return service.getDealerById(id);
	}

	@PutMapping("/{id}")
	public Dealer update(@PathVariable Long id, @RequestBody Dealer dealer) {
		return service.updateDealer(id, dealer);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteDealer(id);
		return "Dealer Deleted";
	}
	
	@GetMapping("/summery")
	public List<Map<String, Object>> getSummeryOfDealer() {
	    return service.getDealerSummary();
	}

}

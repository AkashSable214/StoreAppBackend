package com.cjc.app.controller;

import java.util.HashMap;
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

import com.cjc.app.entity.Admin;
import com.cjc.app.service.AdminService;
import com.cjc.app.service.CustomerService;
import com.cjc.app.service.DealerService;
import com.cjc.app.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@Autowired
	private ProductService ps;
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private DealerService ds;

	@PostMapping
	public Admin save(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@GetMapping
	public List<Admin> getAll() {
		return service.getAllAdmins();
	}

	@GetMapping("/{id}")
	public Admin getById(@PathVariable Long id) {
		return service.getAdminById(id);
	}

	@PutMapping("/{id}")
	public Admin update(@PathVariable Long id, @RequestBody Admin admin) {
		return service.updateAdmin(id, admin);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteAdmin(id);
		return "Admin Deleted Successfully";
	}

	@GetMapping("/dashboard")
	public Map<String, Long> getDashboard() {
		Map<String, Long> stats = new HashMap<>();

		long totalDealers =  ds.countDealers();// service.countDealers(); 
		long totalProducts = ps.countProducts() ; 
		long totalCustomers = cs.countCustomers(); 
		
		stats.put("totalDealers", totalDealers);
		stats.put("totalProducts", totalProducts);
		stats.put("totalCustomers", totalCustomers);

		return stats;
	}

}

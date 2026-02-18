package com.cjc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.entity.Admin;
import com.cjc.app.repo.AdminRepo;

@Service
public class AdminServiceIMPL  implements AdminService{
	 @Autowired
	    private AdminRepo repo;

	    @Override
	    public Admin saveAdmin(Admin admin) {
	        return repo.save(admin);
	    }

	    @Override
	    public List<Admin> getAllAdmins() {
	        return repo.findAll();
	    }

	    @Override
	    public Admin getAdminById(Long id) {
	        return repo.findById(id).orElse(null);
	    }

	    @Override
	    public Admin updateAdmin(Long id, Admin admin) {
	        admin.setId(id);
	        return repo.save(admin);
	    }

	    @Override
	    public void deleteAdmin(Long id) {
	        repo.deleteById(id);
	    }
	    
	    

	   

}

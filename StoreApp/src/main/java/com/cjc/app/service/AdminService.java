package com.cjc.app.service;

import java.util.List;

import com.cjc.app.entity.Admin;

public interface AdminService {

	Admin saveAdmin(Admin admin);

	List<Admin> getAllAdmins();

	Admin getAdminById(Long id);

	Admin updateAdmin(Long id, Admin admin);

	void deleteAdmin(Long id);

}

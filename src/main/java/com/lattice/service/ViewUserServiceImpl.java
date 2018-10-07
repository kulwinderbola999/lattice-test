package com.lattice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lattice.dao.ViewUserDAO;
import com.lattice.model.Protocol;
import com.lattice.model.User;

@Transactional(readOnly = true)
@Service
public class ViewUserServiceImpl implements ViewUserService{
	
	@Autowired
	private ViewUserDAO viewUserDAO;

	@Override
	public List<User> viewUser() throws Exception {
		try {
		List<User> users= viewUserDAO.viewUser();
		return users;
		}
		catch(Exception e) {
			throw e;
		}
	}

}

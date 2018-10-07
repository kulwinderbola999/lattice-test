package com.lattice.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lattice.dao.AddUserDAO;
import com.lattice.model.Device;
import com.lattice.model.Protocol;
import com.lattice.model.User;

@Transactional(readOnly = true)
@Service
public class AddUserServiceImpl implements AddUserService{

	@Autowired
	private AddUserDAO addUserDAO;
	
	@Override
	@Transactional(readOnly = false , propagation=Propagation.REQUIRES_NEW)
	public Integer addUser(User user, Device device) throws Exception {
		Integer userId = addUserDAO.addUser(user,device);
		return null;
	}

}

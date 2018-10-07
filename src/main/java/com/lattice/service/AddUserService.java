package com.lattice.service;


import com.lattice.model.Device;
import com.lattice.model.User;

public interface AddUserService {
	public Integer addUser(User user, Device device) throws Exception;
}

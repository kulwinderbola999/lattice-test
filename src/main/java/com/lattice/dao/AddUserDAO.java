package com.lattice.dao;

import java.util.List;

import com.lattice.model.Device;
import com.lattice.model.Protocol;
import com.lattice.model.User;

public interface AddUserDAO {

	public Integer addUser(User user, Device device) throws Exception;
}

package com.lattice.dao;

import java.util.List;


import com.lattice.model.User;

public interface ViewUserDAO {

	public List<User> viewUser() throws Exception;
}

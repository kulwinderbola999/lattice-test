package com.lattice.api;

import java.util.List;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.model.Protocol;
import com.lattice.model.User;
import com.lattice.service.ViewUserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("viewUserAPI")
public class ViewUserAPI {

	@Autowired
	private ViewUserServiceImpl viewUserService;
	
	@RequestMapping(value= {"viewUser"}, method= RequestMethod.GET)
	private ResponseEntity<List<User>> viewUser() throws Exception{
//		logger.info("fetching user for User_id : ");
		try {
		List<User> users = viewUserService.viewUser();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

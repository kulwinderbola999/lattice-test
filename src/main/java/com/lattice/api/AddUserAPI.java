package com.lattice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lattice.model.Device;
import com.lattice.model.Protocol;
import com.lattice.model.User;
import com.lattice.service.AddUserServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("addUserAPI")
public class AddUserAPI {

@Autowired
	private AddUserServiceImpl addUserService;
	
	
	@RequestMapping(value= {"addUser"}, method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user,Device device) {
		try {
		Integer userId = addUserService.addUser(user, device);
		return new ResponseEntity<String>("User added successfully "+userId,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("User could no be added "+e.getMessage(),HttpStatus.BAD_REQUEST);	
		}
		
	}
}

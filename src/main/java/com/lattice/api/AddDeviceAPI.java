package com.lattice.api;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.model.Device;
import com.lattice.model.Protocol;
import com.lattice.model.User;
import com.lattice.service.AddDeviceServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("addDeviceAPI")
public class AddDeviceAPI {
	
	@Autowired
	private AddDeviceServiceImpl addDeviceService;
	
	@RequestMapping(value= {"addDevice"}, method=RequestMethod.POST)
	public ResponseEntity<String> addDevice(@RequestBody Device device,Protocol protocol) {
		try {
		Integer deviceId = addDeviceService.addDevice(device , protocol);
		return new ResponseEntity<String>("Device Added Successfully",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
}

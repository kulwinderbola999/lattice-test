package com.lattice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.event.internal.DefaultEvictEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lattice.dao.AddDeviceDAO;
import com.lattice.model.Device;
import com.lattice.model.Protocol;

@Transactional(readOnly = true)
@Service
public class AddDeviceServiceImpl implements AddDeviceService{

	@Autowired
	private AddDeviceDAO addDeviceDAO;
	
	@Override
	@Transactional(readOnly = false , propagation=Propagation.REQUIRES_NEW)
	public Integer addDevice(Device device, Protocol protocol) throws Exception {
		try {
		List<Device> devList=addDeviceDAO.getDevices();
		
			for (Device result : devList) {
				if(device.getDeviceId()==result.getDeviceId()) {
					throw new Exception("DEVICE ALREADY EXISTS");
				}
				for (Protocol pro : result.getProtocols()) {
					if(pro.getProtocolId()==protocol.getProtocolId())
						throw new Exception("PROTOCOL IS ALREADY LINKED TO ANOTHER DEVICE");
				}
			}
		if(!protocol.getEffectivityDate().isBefore(LocalDateTime.now())) {
			throw new Exception("PROTOCOL NOT EFFECTIVE");
		}
		Integer userId = addDeviceDAO.addDevice(device,protocol);
		return userId;
		}
		catch (Exception e) {
			throw e;
		}
	}
	

}

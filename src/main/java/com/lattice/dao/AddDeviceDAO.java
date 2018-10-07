package com.lattice.dao;

import java.util.List;

import com.lattice.model.Device;
import com.lattice.model.Protocol;

public interface AddDeviceDAO {

	public Integer addDevice(Device device, Protocol protocol) throws Exception;
	
	public List<Device> getDevices() ;
}

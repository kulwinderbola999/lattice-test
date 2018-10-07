package com.lattice.service;

import com.lattice.model.Device;
import com.lattice.model.Protocol;

public interface AddDeviceService {

	public Integer addDevice(Device device, Protocol protocol) throws Exception;
}

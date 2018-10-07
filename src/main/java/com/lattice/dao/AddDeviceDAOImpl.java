package com.lattice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lattice.entity.DeviceEntity;
import com.lattice.entity.IsActive;
import com.lattice.entity.ProtocolEntity;
import com.lattice.entity.Status;
import com.lattice.entity.TagEntity;
import com.lattice.entity.UserEntity;
import com.lattice.model.Device;
import com.lattice.model.Protocol;
import com.lattice.model.Tag;
import com.lattice.model.User;

import repository.DeviceInterface;

@Repository
public class AddDeviceDAOImpl implements AddDeviceDAO{

	@PersistenceContext
	private EntityManager EntityManager;
	@Autowired
	DeviceInterface interface1;
	
	@Override
	public List<Device> getDevices() {
		List<Device> deviceList=new ArrayList<>();
		List<DeviceEntity> entityList= interface1.findAll();
		for (DeviceEntity deviceEntity : entityList) {
			Device device=new Device();
			List<Protocol> proList=new ArrayList<>();
			device.setDeviceId(deviceEntity.getDeviceId());
			List<ProtocolEntity> proEntityList=deviceEntity.getProtocolEntities();
			for (ProtocolEntity proEntity : proEntityList) {
				Protocol protocol = new Protocol();
				protocol.setProtocolId(proEntity.getProtocolId());
				proList.add(protocol);
				
			}
			device.setProtocols(proList);
			deviceList.add(device);
		}
		return deviceList;
	}

	@Override
	public Integer addDevice(Device device, Protocol protocol) throws Exception {
		DeviceEntity deviceEntity = new DeviceEntity();
		deviceEntity.setDeviceId(device.getDeviceId());
		Status status = (Status) device.getStatus();
		deviceEntity.setStatus(status);
		deviceEntity.setDescription(device.getDescription());
		List<User> users = device.getUsers();
		List<UserEntity> userEntities = new ArrayList<>();
		for(User user:users) {
			UserEntity userEntity = new UserEntity();
			userEntity.setEmail(user.getEmail());
			userEntity.setUserId(user.getUserId());
			userEntity.setUserName(user.getUserName());
			TagEntity tagEntity = new TagEntity();
			tagEntity.setCreatedOn(user.getTag().getCreatedOn());
			tagEntity.setDescription(user.getTag().getDescription());
			IsActive isActive = (IsActive) user.getTag().getIsActive();
			tagEntity.setIsActive(isActive);
			tagEntity.setTagId(user.getTag().getTagId());
			userEntity.setTagEntity(tagEntity);
			userEntities.add(userEntity);
		}
		ProtocolEntity protocolEntity = new ProtocolEntity();
		protocolEntity.setCreatedOn(protocol.getCreatedOn());
		protocolEntity.setEffectivityDate(protocol.getEffectivityDate());
		protocolEntity.setProtocolId(protocol.getProtocolId());
		protocol.setTitle(protocol.getTitle());
		List<ProtocolEntity> protocolEntities = new ArrayList<>();
		protocolEntities.add(protocolEntity);
		deviceEntity.setProtocolEntities(protocolEntities);
		deviceEntity.setOperatorEntities(userEntities);
		DeviceEntity savedDevice =interface1.save(deviceEntity);
		return savedDevice.getDeviceId();
	}

}

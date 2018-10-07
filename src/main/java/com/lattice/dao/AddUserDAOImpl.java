package com.lattice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.lattice.model.User;

import repository.UserInterface;

@Repository
public class AddUserDAOImpl implements AddUserDAO{

	@PersistenceContext
	private EntityManager EntityManager;
	
	@Autowired
	private UserInterface userInterface;
	
	@Override
	public Integer addUser(User user, Device device) throws Exception {
		Optional<UserEntity> resultuserEntity=userInterface.findById(user.getUserId());
		if(resultuserEntity.isPresent()) { 
			UserEntity userEntity=resultuserEntity.get();
			List<DeviceEntity> deviceEntities= userEntity.getDeviceEntities();
			for (DeviceEntity deviceEntity : deviceEntities) {
				if(deviceEntity.getDeviceId()==device.getDeviceId())
					throw new Exception("User already exists with device");
				else {
					/*If user exists but device doesn't exist*/
					DeviceEntity newDeviceEntity= new DeviceEntity();
					newDeviceEntity.setDeviceId(device.getDeviceId());
					Status status = (Status) device.getStatus();
					newDeviceEntity.setStatus(status);
					newDeviceEntity.setDescription(device.getDescription());
					List<Protocol> protocols = device.getProtocols();
					List<ProtocolEntity> protocolEntities = new ArrayList<>();
					for (Protocol protocol : protocols) {
						ProtocolEntity protocolEntity = new ProtocolEntity();
						protocolEntity.setCreatedOn(protocol.getCreatedOn());
						protocolEntity.setEffectivityDate(protocolEntity.getEffectivityDate());
						protocolEntity.setProtocolId(protocol.getProtocolId());
						protocolEntity.setTitle(protocol.getTitle());
						protocolEntities.add(protocolEntity);
					}
					newDeviceEntity.setProtocolEntities(protocolEntities);
					deviceEntities.add(newDeviceEntity);
					userEntity.setDeviceEntities(deviceEntities);
					userInterface.save(userEntity);
					
				}
			}
			}
		
		UserEntity newUserEntity= new UserEntity();
		DeviceEntity deviceEntity=new DeviceEntity();
		TagEntity tagEntity=new TagEntity();
		newUserEntity.setUserId(user.getUserId());
		newUserEntity.setEmail(user.getEmail());
		newUserEntity.setUserName(user.getUserName());
		tagEntity.setTagId(user.getTag().getTagId());
		tagEntity.setCreatedOn(user.getTag().getCreatedOn());
		tagEntity.setDescription(user.getTag().getDescription());
		IsActive isActive = (IsActive) user.getTag().getIsActive();
		tagEntity.setIsActive(isActive);
//		newUserEntity.(user.getTag().getTagId());
//		tagEntity.setDescription(user.getTag().getDescription());
//		tagEntity.setCreatedOn(user.getTag().getCreatedOn());
//		tagEntity.setIsActive(user.getTag().getIsActive());
		newUserEntity.setTagEntity(tagEntity);
		List<DeviceEntity> newDeviceEntities=new ArrayList<>();
		newDeviceEntities.add(deviceEntity);
		return null;
	}

}

package com.lattice.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lattice.entity.DeviceEntity;
import com.lattice.entity.ProtocolEntity;
import com.lattice.entity.UserEntity;
import com.lattice.model.Device;
import com.lattice.model.Protocol;
import com.lattice.model.Tag;
import com.lattice.model.User;


@Repository
public class ViewUserDAOImpl implements ViewUserDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<User> viewUser() throws Exception {
		List<User> users= new ArrayList<>();
		try {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
		Root root= criteriaQuery.from(UserEntity.class);
		criteriaQuery.multiselect(root.get("userId"),root.get("userName"),root.get("deviceEntities"),root.get("tagEntity"));
		Query query = entityManager.createQuery(criteriaQuery);
		List<UserEntity> userEntities=query.getResultList();
		if(userEntities.isEmpty()) {
			throw new Exception("NO USERS FOUND");
		}
		for (UserEntity userEntity : userEntities) {
			User user= new User();
			Tag tag = new Tag();
			tag.setTagId(userEntity.getTagEntity().getTagId());
			tag.setCreatedOn(userEntity.getTagEntity().getCreatedOn());
			tag.setDescription(userEntity.getTagEntity().getDescription());
			tag.setIsActive(userEntity.getTagEntity().getIsActive());
			user.setTag(tag);
			user.setUserId(userEntity.getUserId());
			user.setUserName(userEntity.getUserName());
			List<DeviceEntity> deviceEntities = userEntity.getDeviceEntities();
			List<Device> devices = new ArrayList<>();
			for (DeviceEntity deviceEntity : deviceEntities) {
				Device device = new Device();
				device.setDescription(deviceEntity.getDescription());
				device.setDeviceId(deviceEntity.getDeviceId());
				device.setStatus(deviceEntity.getStatus());
				List<ProtocolEntity> protocolEntities = new ArrayList<>();
				List<Protocol> protocols = new ArrayList<>();
				for (ProtocolEntity protocolEntity : protocolEntities) {
					Protocol protocol = new Protocol();
					protocol.setProtocolId(protocolEntity.getProtocolId());
					protocol.setTitle(protocolEntity.getTitle());
					protocol.setEffectivityDate(protocolEntity.getEffectivityDate());
					protocol.setCreatedOn(protocolEntity.getCreatedOn());
					protocols.add(protocol);
				}
				device.setProtocols(protocols);
				devices.add(device);
			}
			user.setDevices(devices);
			users.add(user);
		}
		return users;
		}
		 catch(Exception exception) {
			 throw exception;
		 }
		
	}

}

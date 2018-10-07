package com.lattice.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="device_user_map")
public class DeviceUserMap {

	@Id
	private DeviceEntity deviceEntity;
	@Id
	private UserEntity userEntity;
	
	private LocalDateTime createOn;
	
	private IsActive isActive;
}

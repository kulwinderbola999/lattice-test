package com.lattice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
@GenericGenerator(name="idGen",strategy="increment")
public class UserEntity {

	@Id
	@GeneratedValue(generator="idGen")
	@Column(name="User_id")
	private Integer userId;
	@Column(name="User_name")
	private String userName;
	@Column(name="Email")
	private String email;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="device_user_map", joinColumns = @JoinColumn(name = "User_id", referencedColumnName= "User_id"),
	inverseJoinColumns = @JoinColumn(name="Device_id", referencedColumnName ="Device_id"))
	private List<DeviceEntity> deviceEntities;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Tag_id" , unique=true)
	private TagEntity tagEntity;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<DeviceEntity> getDeviceEntities() {
		return deviceEntities;
	}
	public void setDeviceEntities(List<DeviceEntity> deviceEntities) {
		this.deviceEntities = deviceEntities;
	}
	public TagEntity getTagEntity() {
		return tagEntity;
	}
	public void setTagEntity(TagEntity tagEntity) {
		this.tagEntity = tagEntity;
	}
	
}

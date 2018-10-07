package com.lattice.model;

import java.util.List;

public class Device {

	private Integer deviceId;
	private String description;
	private Enum status;
	private List<User> users;
	private List<Protocol> protocols;
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Enum getStatus() {
		return status;
	}
	public void setStatus(Enum status) {
		this.status = status;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Protocol> getProtocols() {
		return protocols;
	}
	public void setProtocols(List<Protocol> protocols) {
		this.protocols = protocols;
	}
	
}

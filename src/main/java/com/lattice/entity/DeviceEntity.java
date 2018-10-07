package com.lattice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Device")
@GenericGenerator(name="idGen",strategy="increment")
public class DeviceEntity {
	@Id
	@GeneratedValue(generator="idGen")
	@Column(name="Device_id")
	private Integer deviceId;
	@Column(name="Description")
	private String description;
	@Column(name= "Status" ,columnDefinition ="enum('')")
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToMany(mappedBy="devices")
	private List<UserEntity> operatorEntities;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="DEVICE_PROTOCOL_MAPPING", joinColumns=@JoinColumn(name= "Device_id"),
	inverseJoinColumns = @JoinColumn(name= "Protocol_id" , unique=true))
	private List<ProtocolEntity> protocolEntities;
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
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<UserEntity> getOperatorEntities() {
		return operatorEntities;
	}
	public void setOperatorEntities(List<UserEntity> operatorEntities) {
		this.operatorEntities = operatorEntities;
	}
	public List<ProtocolEntity> getProtocolEntities() {
		return protocolEntities;
	}
	public void setProtocolEntities(List<ProtocolEntity> protocolEntities) {
		this.protocolEntities = protocolEntities;
	}
	
}

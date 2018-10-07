package com.lattice.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="protocol")
@GenericGenerator(name="idGen",strategy="increment")
public class ProtocolEntity {
	@Id
	@GeneratedValue(generator="idGen")
	@Column(name="Protocol_id")
	private Integer protocolId;
	@Column(name="Title")
	private String title;
	@Column(name="Created_on")
	private LocalDateTime createdOn;
	@Column(name ="Effectivity_date")
	private LocalDateTime effectivityDate;
	public Integer getProtocolId() {
		return protocolId;
	}
	public void setProtocolId(Integer protocolId) {
		this.protocolId = protocolId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getEffectivityDate() {
		return effectivityDate;
	}
	public void setEffectivityDate(LocalDateTime effectivityDate) {
		this.effectivityDate = effectivityDate;
	}
	
	
}

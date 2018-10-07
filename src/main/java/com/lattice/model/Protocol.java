package com.lattice.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Protocol {

	private Integer protocolId;
	private String title;
	private LocalDateTime createdOn;
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

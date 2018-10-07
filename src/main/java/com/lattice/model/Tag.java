package com.lattice.model;

import java.util.Date;

public class Tag {

	private Integer tagId;
	private String description;
	private Enum isActive;
	private Date createdOn;
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Enum getIsActive() {
		return isActive;
	}
	public void setIsActive(Enum isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}

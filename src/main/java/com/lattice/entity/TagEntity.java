package com.lattice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tag")
@GenericGenerator(name="idGen",strategy="increment")
public class TagEntity {

	@Id
	@GeneratedValue(generator="idGen")
	@Column(name="Tag_id")
	private Integer tagId;
	@Column(name="Description")
	private String Description;
	@Column(columnDefinition ="enum('')" , name="Is_active")
	@Enumerated(EnumType.STRING)
	private IsActive isActive;
	@Column(name="Created_on")
	private Date createdOn;
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public IsActive getIsActive() {
		return isActive;
	}
	public void setIsActive(IsActive isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}

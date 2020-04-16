package com.YE.rest.practice.practice.user;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;

@ApiModel(description="All details about the user")
@Entity
public class post {

	private Integer id;
	private String description;
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

package com.YE.rest.practice.practice.user;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@ApiModel(description="All details about the posts")
@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore //if this is not kept it will find user details again and that will be recursive loop while converting user to json
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
	public void setUser(User user2) {
		this.user=user2;
		
	}
	
}

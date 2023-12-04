package com.API.request;

public class CreateUserPOJO {
	
	private String name;
	private String description;
	private String homepage;
	private Boolean privatevalue;
	
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public Boolean getPrivatevalue() {
		return privatevalue;
	}
	public void setPrivatevalue(Boolean privatevalue) {
		this.privatevalue = privatevalue;
	}


}
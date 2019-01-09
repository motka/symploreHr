package com.symplore.onboarding.service;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class Tasks {
	
	String name;
	String assignTo;
	String assignToEmail; 
	Date dueDate;
	String description;
	File attachedfile; 
	Map<String, Object> model;
	String sender;
	
	public String getAssignToEmail() {
		return assignToEmail;
	}
	
	public void setAssignToEmail(String assignToEmail) {
		this.assignToEmail = assignToEmail;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public Map<String, Object> getModel() {
		return model;
	}
	
	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAssignTo() {
		return assignTo;
	}
	
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public File getAttachedfile() {
		return attachedfile;
	}
	
	public void setAttachedfile(File attachedfile) {
		this.attachedfile = attachedfile;
	}
	
	
	
	
	
	

}

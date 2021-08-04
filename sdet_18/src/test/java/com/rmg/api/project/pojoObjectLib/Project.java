package com.rmg.api.project.pojoObjectLib;

public class Project {
 String createdBy;
 String projectName;
 String Status;
 int teamSize;
public Project(String createdBy, String projectName, String status, int teamSize) {
	
	this.createdBy = createdBy;
	this.projectName = projectName;
	this.Status = status;
	this.teamSize = teamSize;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public int getTeamSize() {
	return teamSize;
}
public void setTeamSize(int teamSize) {
	this.teamSize = teamSize;
}
 
}

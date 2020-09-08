package com.tcs.sbws.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Created by 1430208-Yamini S
 * Entity Class for UserDetails.
 */

@Document
public class UserDetailsEntity {

	@Id
	private String slNo;
	private String employeeNo;
	private String employeeName;
	private String accountId;
	private String teamName;
	private String coId;
	private String presentLocation;
	private String workLocation;
	private String parentUnit;
	private String modeOfWorking;
	private String assetId;
	private String sbwsEnabled;
	private String leadSupervisorName;
	private String stayingInPg;
	private String tcsDesktop;
	private String typeOfInternetConnection;
	private String createdBy;
	private String createdOn;
	private String laptopTagged;
	private String laptopAssetId;
	//change for admin request to add manager/otherUser -1430208
	private String status;
	private String deleteBy;
	private String deleteOn;
	private String backupResource;
	
	public String getLaptopTagged() {
		return laptopTagged;
	}

	public void setLaptopTagged(String laptopTagged) {
		this.laptopTagged = laptopTagged;
	}

	public String getLaptopAssetId() {
		return laptopAssetId;
	}

	public void setLaptopAssetId(String laptopAssetId) {
		this.laptopAssetId = laptopAssetId;
	}
	public String getBackupResource() {
		return backupResource;
	}

	public void setBackupResource(String backupResource) {
		this.backupResource = backupResource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSlNo() {
		return slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getPresentLocation() {
		return presentLocation;
	}

	public void setPresentLocation(String presentLocation) {
		this.presentLocation = presentLocation;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getParentUnit() {
		return parentUnit;
	}

	public void setParentUnit(String parentUnit) {
		this.parentUnit = parentUnit;
	}

	public String getModeOfWorking() {
		return modeOfWorking;
	}

	public void setModeOfWorking(String modeOfWorking) {
		this.modeOfWorking = modeOfWorking;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getSbwsEnabled() {
		return sbwsEnabled;
	}

	public void setSbwsEnabled(String sbwsEnabled) {
		this.sbwsEnabled = sbwsEnabled;
	}

	public String getLeadSupervisorName() {
		return leadSupervisorName;
	}

	public void setLeadSupervisorName(String leadSupervisorName) {
		this.leadSupervisorName = leadSupervisorName;
	}

	public String getStayingInPg() {
		return stayingInPg;
	}

	public void setStayingInPg(String stayingInPg) {
		this.stayingInPg = stayingInPg;
	}

	public String getTcsDesktop() {
		return tcsDesktop;
	}

	public void setTcsDesktop(String tcsDesktop) {
		this.tcsDesktop = tcsDesktop;
	}

	public String getTypeOfInternetConnection() {
		return typeOfInternetConnection;
	}

	public void setTypeOfInternetConnection(String typeOfInternetConnection) {
		this.typeOfInternetConnection = typeOfInternetConnection;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdby) {
		this.createdBy = createdby;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdon) {
		this.createdOn = createdon;
	}

	public String getDeleteBy() { return deleteBy; }

	public void setDeleteBy(String deleteBy) { this.deleteBy = deleteBy; }

	public String getDeleteOn() { return deleteOn; }

	public void setDeleteOn(String deleteOn) {this.deleteOn = deleteOn; }
}

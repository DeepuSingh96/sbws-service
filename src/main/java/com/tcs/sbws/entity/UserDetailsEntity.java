package com.tcs.sbws.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserDetailsEntity {

	@Id
	private String sl_no;
	
	private String employee_no;
	private String employee_name;
	private String account_name;
	private String team_name;
	private String coid;
	private String contact_no;
	private String alternate_contact_no;
	private String address;
	private String present_location;
	private String work_location;
	private String parent_unit;
	private String mode_of_working;
	private String asset_id;
	private String sbws_enabled;
	private String lead_supervisor_name;
	private String staying_in_pg;
	private String tcs_desktop;
	private String type_of_internetConnection;
	public String getSl_no() {
		return sl_no;
	}
	public void setSl_no(String sl_no) {
		this.sl_no = sl_no;
	}
	public String getEmployee_no() {
		return employee_no;
	}
	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getCoid() {
		return coid;
	}
	public void setCoid(String coid) {
		this.coid = coid;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getAlternate_contact_no() {
		return alternate_contact_no;
	}
	public void setAlternate_contact_no(String alternate_contact_no) {
		this.alternate_contact_no = alternate_contact_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPresent_location() {
		return present_location;
	}
	public void setPresent_location(String present_location) {
		this.present_location = present_location;
	}
	public String getWork_location() {
		return work_location;
	}
	public void setWork_location(String work_location) {
		this.work_location = work_location;
	}
	public String getParent_unit() {
		return parent_unit;
	}
	public void setParent_unit(String parent_unit) {
		this.parent_unit = parent_unit;
	}
	public String getMode_of_working() {
		return mode_of_working;
	}
	public void setMode_of_working(String mode_of_working) {
		this.mode_of_working = mode_of_working;
	}
	public String getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}
	public String getSbws_enabled() {
		return sbws_enabled;
	}
	public void setSbws_enabled(String sbws_enabled) {
		this.sbws_enabled = sbws_enabled;
	}
	public String getLead_supervisor_name() {
		return lead_supervisor_name;
	}
	public void setLead_supervisor_name(String lead_supervisor_name) {
		this.lead_supervisor_name = lead_supervisor_name;
	}
	public String getStaying_in_pg() {
		return staying_in_pg;
	}
	public void setStaying_in_pg(String staying_in_pg) {
		this.staying_in_pg = staying_in_pg;
	}
	public String getTcs_desktop() {
		return tcs_desktop;
	}
	public void setTcs_desktop(String tcs_desktop) {
		this.tcs_desktop = tcs_desktop;
	}
	public String getType_of_internetConnection() {
		return type_of_internetConnection;
	}
	public void setType_of_internetConnection(String type_of_internetConnection) {
		this.type_of_internetConnection = type_of_internetConnection;
	}
	
	
	
	
}

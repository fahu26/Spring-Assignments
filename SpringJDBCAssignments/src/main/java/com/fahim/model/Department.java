package com.fahim.model;

public class Department {
	
	private int departmentId;
	private String departmentName;
	private int departmentManagerId;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getDepartmentManagerId() {
		return departmentManagerId;
	}
	public void setDepartmentManagerId(int departmentManagerId) {
		this.departmentManagerId = departmentManagerId;
	}
	public Department(int departmentId, String departmentName, int departmentManagerId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentManagerId = departmentManagerId;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentManagerId=" + departmentManagerId + "]";
	}
	
}

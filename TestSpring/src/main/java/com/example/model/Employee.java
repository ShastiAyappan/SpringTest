package com.example.model;

public class Employee {
	private int empId_i;
	private String empName_str;
	public int getEmpId_i() {
		return empId_i;
	}
	public void setEmpId_i(int empId_i) {
		this.empId_i = empId_i;
	}
	public String getEmpName_str() {
		return empName_str;
	}
	public void setEmpName_str(String empName_str) {
		this.empName_str = empName_str;
	}
	@Override
	public String toString() {
		return "Employee [empId_i=" + empId_i + ", empName_str=" + empName_str + "]";
	}
	
}

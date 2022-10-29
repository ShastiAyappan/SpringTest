package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;
import com.example.model.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {

	@Autowired
	private EmployeeDAO empDao;
	
	public Integer saveEmployee(Employee employee) {
		
		EmployeeEntity employeeEntity=new EmployeeEntity();
		
		BeanUtils.copyProperties(employee, employeeEntity);
		
		EmployeeEntity resultEmpEntity=empDao.save(employeeEntity);
		
		return resultEmpEntity.getEmpId();
	}
	
	public List<Employee>getAllEmployeeDetails(){
		
		Iterable<EmployeeEntity> listEntity = empDao.findAll();
		
		List<Employee> listEmpBeanObj = new ArrayList<Employee>();//result List obj
		
		listEntity.forEach(empEntity->{
									
									Employee employeeBean = new Employee();
									
									BeanUtils.copyProperties(empEntity, employeeBean);
									
									listEmpBeanObj.add(employeeBean);
									});
		return listEmpBeanObj;
	}
	
	public Employee getOneEmployeeDetails(int id) {
		
		Optional<EmployeeEntity> oneEntity = empDao.findById(id);
		
		Employee employee = null;
		if(oneEntity != null)
		{	
			employee = new Employee();
			BeanUtils.copyProperties(oneEntity, employee);
			
			return employee;
		}
		return employee;
	}
	 public Integer updateEmployeeDetails(Employee employee) {
		 	 
		 Optional<EmployeeEntity> oneEntity = empDao.findById(employee.getEmpId_i());
		 
		 BeanUtils.copyProperties(employee, oneEntity);
		 
		 empDao.save(oneEntity.get());
		 
		 return employee.getEmpId_i();
	 }
	 public Integer deleteEmployeeDetails(Integer id) {
		 
		 empDao.deleteById(id);
		 
		 return id;
	 }
}

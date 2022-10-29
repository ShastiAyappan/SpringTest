package com.example.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeDAOWrapper;
import com.example.model.Employee;

@RestController
public class EmployeeService {
	Employee emp1 = new Employee();
	EmployeeDAOWrapper empwrap = new EmployeeDAOWrapper();
	
	@RequestMapping("/hello")
    public String welcomepage(String str) {
        return "hello "+ str + " Welcome to Spring REST Controller";
    }
    
	@RequestMapping(value="/findEmployee",method= RequestMethod.GET)
    public Employee homepage(int id) {
        emp1=empwrap.getOneEmployeeDetails(id);
        return emp1;
    }
    
    @RequestMapping(value="/addEmployee",method= RequestMethod.POST)
    public int addEmployee(@RequestBody Employee emp) {
    	int id = empwrap.saveEmployee(emp);
        return id;
    }
    
    @RequestMapping(value="/updateEmployee",method= RequestMethod.PUT)
    public int modifyEmployee(@RequestBody Employee emp) {
        int id = empwrap.updateEmployeeDetails(emp);
    	return id;
    }
 
    @RequestMapping(value="/removeEmployee",method= RequestMethod.DELETE)
    public String removeEmployee(@RequestBody Employee emp) {
        
    	return "Deleted record with id : "+empwrap.deleteEmployeeDetails(emp.getEmpId_i());
    }
}

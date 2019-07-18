package com.cg.empapp.service;


import java.util.HashMap;
import java.util.regex.Pattern;

import com.cg.empapp.exception.*;
import com.cg.empapp.dto.*;
import com.cg.empapp.dao.*;



public class EmployeeServiceImpl implements EmployeeService
{
	EmployeeDaoImpl  employeeDaoImplObj=new  EmployeeDaoImpl();
    public void insertEmployee(Employee emp) {
        employeeDaoImplObj.insertEmployee(emp);
    }
    public HashMap<Integer,Employee>getAllEmployees() throws EmployeeException{
        try {
        HashMap<Integer,Employee> hm;
        hm=employeeDaoImplObj.getAllEmployees();
        return  hm;
    }catch(Exception e) {
        System.out.println(e);
    }
        return null;
    }
    public Employee getEmployeeById(int id)throws EmployeeException{
        try {
       Employee e= employeeDaoImplObj.getEmployeeById( id);
       return e;
    }catch(Exception e) {
        System.out.println(e);
    }
        return null;
        } //public boolean isEmpNameValid(String empName)
    
    public boolean isEmpNameValid(String empName) {
        
  
        if(Pattern.matches("[A-Z][a-z]*", empName)&&empName.length()>=3) {
            return true;
    }else
      return false;
       
}
    public boolean isEmpSalValid(int empSal) {
        if(empSal<0)
            return false;
        else 
            return true;
    }
  
	
}
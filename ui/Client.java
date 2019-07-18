package com.cg.empapp.ui;


import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

import com.cg.empapp.dto.*;
import com.cg.empapp.exception.*;
import com.cg.empapp.service.*;

public class Client {

	public static void main(String[] args) {
		 EmployeeServiceImpl employeeServiceImplObj = new EmployeeServiceImpl();
	        
	        @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
	        int ch;
	        int id, salary;
	        String name;
	        
	        while(true){
	            System.out.println("1-Add Employee");
	            System.out.println("2-Get All Employee Details");
	            System.out.println("3-Get Employee By Id");
	            
	            System.out.println("4-Exit");
	            System.out.println("Enter your choice:");
	            ch = sc.nextInt();
	            switch(ch){
	                case 1:
	                    System.out.println("Enter the id");
	                    id = sc.nextInt();
	                    System.out.println("Enter the name");
	                    name = sc.next();
	                    boolean res=employeeServiceImplObj.isEmpNameValid(name);
	                    while(!res){
	                    if(res==false)
	                        System.out.println("Name is invalid");
	                    //System.out.println("enter again");
	                    name=sc.next();
	                    res=employeeServiceImplObj.isEmpNameValid(name);
	                    }
	                    System.out.println("Enter the salary");
	                    salary = sc.nextInt();
	                    boolean res1=employeeServiceImplObj. isEmpSalValid(salary);
	                    while(!res1){
	                        if(res1==false)
	                            System.out.println("salary should be greater than zero");
	                        System.out.println("enter again");
	                        salary=sc.nextInt();
	                        res=employeeServiceImplObj. isEmpSalValid(salary);
	                        }
	                    Employee employeeAddObj = new Employee(id, name, salary);
	                    employeeServiceImplObj.insertEmployee(employeeAddObj);
	                    break;
	                case 2:
	                HashMap<Integer, Employee> hmaps;
	                try {
	                    hmaps = employeeServiceImplObj.getAllEmployees();
	                    
	                    if(hmaps!=null)
	                    for (Entry<Integer, Employee> maps : hmaps.entrySet()) {
	                        System.out.println(maps.getKey() + " = " + maps.getValue());
	                    }
	                } catch (EmployeeException e) {
	                    System.out.println(e);
	                } 
	                    break;
	                case 3:
	                    System.out.println("Enter id");
	                    id = sc.nextInt();
	                    Employee employee;
	                    try {
	                        employee = employeeServiceImplObj.getEmployeeById(id);
	                        if(employee!=null) {
	                        System.out.println("ID  Name   Salary");
	                        System.out.println(employee.getEmpId()+ " " +employee.getEmpName()+ " " +employee.getEmpSal());
	                    } }catch (EmployeeException e) {
	                        System.out.println("There is no Employee with this ID");;
	                    }
	                    break;
	                    
	               
	                case 4:
	                    System.out.println("END");
	                    System.exit(0);
	                default:
	                    System.out.println("Enter correct choice");
	            }
	        }
	        
	    }
		
		}
		




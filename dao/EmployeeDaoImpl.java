package com.cg.empapp.dao;
//import com.cg.empapp.dto.*;
//import com.cg.empapp.service.*;
//import com.cg.empapp.ui.*;
import com.cg.empapp.exception.*;

import java.util.HashMap;

import com.cg.empapp.dto.Employee;

/**
 * class to perform business logic
 */
public class EmployeeDaoImpl implements EmployeeDao{
	
	/**
    * map to hold the data
    */
	private static HashMap<Integer,Employee> map=new HashMap<Integer,Employee>();
	
    
    
    /**
    * getter for map
    */   
    public static void setMap(HashMap<Integer,Employee> map)
    {
		EmployeeDaoImpl.map=map;
    }  
    
    /**
     * Setter for the map
     */

    public static HashMap<Integer,Employee> getMap()
    {
		return map;
    }  

    //implement interface methods
    public void insertEmployee(Employee employee){
        map.put(employee.getEmpId(), employee);
        System.out.println("Employee Information stored successfully for " +employee.getEmpId());
    }
    
    public HashMap<Integer, Employee> getAllEmployees() throws EmployeeException{
        if(map.isEmpty()){
//            System.out.println(" No employee found");
         throw new EmployeeException();
            //throw Employee Exception;
        }
        else
            return map;
        
    }
    public Employee getEmployeeById(int id) throws EmployeeException{
        if(map.containsKey(id)){
            return map.get(id);
        }
        else
  throw new EmployeeException(); 
        
    }

}
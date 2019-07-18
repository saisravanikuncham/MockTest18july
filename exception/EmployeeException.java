package com.cg.empapp.exception;

@SuppressWarnings("serial")
public class EmployeeException extends Exception 
{

	
	public EmployeeException() {
	    System.out.println("There is no Employee with this ID");
	}
	
}

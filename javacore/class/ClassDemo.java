package com.net.javacore;

import java.lang.reflect.Constructor;

public class ClassDemo {

	public static void main(String[] args) {
		try {
			Class employeeClass = Class.forName("com.net.javacore.Employee");
			
			Employee employee = (Employee)employeeClass.newInstance();
			employee.setName("Tom");
			System.out.println(employee.getName());
			
			Class c3 = Double[].class;
			System.out.println(c3.getName());
			
			Class c2 = int.class;
			System.out.println(c2.getName());
			
			System.out.println(employee.getClass() == Employee.class);
			
			Constructor[] cs = employeeClass.getConstructors();
			
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}

	}

	
}

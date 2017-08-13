package com.net.javacore;

public class Employee {
	private String name;
	
	public Employee ( )
	{
		super();
	}
	
	public Employee (String name )
	{
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

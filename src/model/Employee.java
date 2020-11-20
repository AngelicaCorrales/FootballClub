package model;

public abstract class Employee{

	//attributes
	private String name;
	private String id;
	private double salary;
	private boolean activeStatus;

	public Employee(String name, String id, double salary, boolean activeStatus){
		this.name=name;
		this id=id;
		this.salary=salary;
		this.activeStatus=activeStatus;

	}

}
package model;

public abstract class Employee{

	//attributes
	private String name;
	private String id;
	private double salary;
	private boolean activeStatus;

	public Employee(String name, String id, double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
		this.activeStatus=true;

	}
	public boolean getActiveStatus(){
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus){
		this.activeStatus=activeStatus;
	}

	public String getId(){
		return id;
	}

	public void setSalary(double salary){
		this.salary=salary;
	}

}
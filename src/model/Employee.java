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

	public double getSalary(){
		return salary;
	}

	public void setSalary(double salary){
		this.salary=salary;
	}

	public String statusToString(){
		String status="";
		if(activeStatus){
			status="ACTIVO";
		}
		else{
			status="INACTIVO";
		}
		return status;
	}

	public String toString(){
		return "**EMPLEADO**\n"+
				"*Nombre: "+name+"\n"+
				"*Identificador: "+id+"\n"+
				"*Salario: $"+salary+"\n"+
				"*Estado: "+statusToString()+"\n";

	}

}
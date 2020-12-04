package model;

public abstract class Employee{

	//attributes
	private String name;
	private String id;
	private double salary;
	private boolean activeStatus;

	/**
	*<b>name:</b> Employee <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the attributes of the class have been initialized<br>
	*@param name Is the name of the employee. name!=null and name!=""<br>
	*@param id Is the identifier of the employee. id!=null, id!=""<br>
	*@param salary Is the salary of the employee. salary greater than 0<br>
	*/
	public Employee(String name, String id, double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
		this.activeStatus=true;

	}

	/**
	*<b>name:</b> getName <br>
	*This method gets the name of the employee <br>
	*<b>post:</b> the name of the employee has been gotten <br>
	*@return a <code>string</code> specifying name, the name of the employee 
	*/
	public String getName(){
		return name;
	}

	/**
	*<b>name:</b> setName<br>
	*This method sets the name of the employee <br>
	*<b>post:</b> the name of the employee has been set <br>
	*@param name Is the name of the employee. name!=null and name!=""<br>
	*/
	public void setName(String name){
		this.name=name;
	}

	/**
	*<b>name:</b> getId <br>
	*This method gets the identifier of the employee <br>
	*<b>post:</b> the identifier of the employee has been gotten <br>
	*@return a <code>string</code> specifying id, the identifier of the employee 
	*/
	public String getId(){
		return id;
	}

	/**
	*<b>name:</b> seId<br>
	*This method sets the identifier of the employee <br>
	*<b>post:</b> the identifier of the employee has been set <br>
	*@param id Is the identifier of the employee. id!=null and id!=""<br>
	*/
	public void setId(String id){
		this.id=id;
	}

	/**
	*<b>name:</b> getSalary <br>
	*This method gets the salary of the employee <br>
	*<b>post:</b> the salary of the employee has been gotten <br>
	*@return a <code>double</code> specifying salary, the salary of the employee 
	*/
	public double getSalary(){
		return salary;
	}

	/**
	*<b>name:</b> setSalary<br>
	*This method sets the salary of the employee <br>
	*<b>post:</b> the salary of the employee has been set <br>
	*@param salary Is the salary of the employee. salary greater than 0<br>
	*/
	public void setSalary(double salary){
		this.salary=salary;
	}

	/**
	*<b>name:</b> getActiveStatus <br>
	*This method gets the status of the employee <br>
	*<b>post:</b> the status of the employee has been gotten <br>
	*@return a <code>boolean</code> specifying activeStatus, the status of the employee 
	*/
	public boolean getActiveStatus(){
		return activeStatus;
	}

	/**
	*<b>name:</b> setActiveStatus<br>
	*This method sets the status of the employee <br>
	*<b>post:</b> the status of the employee has been set <br>
	*@param activeStatus Is the status of the employee.<br>
	*/
	public void setActiveStatus(boolean activeStatus){
		this.activeStatus=activeStatus;
	}

	/**
	*<b>name:</b> statusToString <br>
	*This method returns the status as a string<br>
	*<b>post:</b> the status has been returned as a string<br>
	*@return a <code>string</code> specifying status, the status if the employee is active or not
	*/
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

	/**
	*<b>name:</b> toString <br>
	*This method return the name, id, salary and status of the employee on a string<br>
	*<b>post:</b> the name, id, salary and status of the employee have been returned<br>
	*@return a <code>string</code> specifying the name, id, salary and status of the employee
	*/
	public String toString(){
		return "**EMPLEADO**\n"+
				"*Nombre: "+name+"\n"+
				"*Identificador: "+id+"\n"+
				"*Salario: $"+salary+"\n"+
				"*Estado: "+statusToString()+"\n";

	}

}
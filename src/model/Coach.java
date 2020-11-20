package model;

public abstract class Coach extends Employee{
	//attributes
	private int yearsExperience;

	public Coach(String name, String id, double salary, boolean activeStatus, int yearsExperience){
		super( name,  id,  salary,  activeStatus);
		this.yearsExperience=yearsExperience;
	}
	
}
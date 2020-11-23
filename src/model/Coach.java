package model;

public abstract class Coach extends Employee{
	//attributes
	private int yearsExperience;

	public Coach(String name, String id, double salary, int yearsExperience){
		super( name,  id,  salary);
		this.yearsExperience=yearsExperience;
	}
	
}
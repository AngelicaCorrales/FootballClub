package model;

public abstract class Coach extends Employee{
	//attributes
	private int yearsExperience;

	public Coach(String name, String id, double salary, int yearsExperience){
		super( name,  id,  salary);
		this.yearsExperience=yearsExperience;
	}

	public int getYearsExperience(){
		return yearsExperience;
	}

	public void setYearsExperience(int yearsExperience){
		this.yearsExperience=yearsExperience;
	}
	
	@Override
	public String toString(){
		return super.toString()+"*Anios de experiencia: "+yearsExperience+"\n";
	}
}
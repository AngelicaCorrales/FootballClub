package model;

public class HeadCoach extends Coach implements Price, Level{
	//attributes
	private int numberTeams;
	private int numberChampionships;

	public HeadCoach(String name, String id, double salary, int yearsExperience, int numberTeams, int numberChampionships){
		super(name,  id,  salary, yearsExperience);
		this.numberTeams=numberTeams;
		this.numberChampionships=numberChampionships;
	}

	public double calculatePrice(){
		return 1;
	}

	public double calculateLevel(){
		return 1;
	}
}
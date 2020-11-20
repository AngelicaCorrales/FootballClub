package model;

public class HeadCoach extends Coach implements Price, Level{
	//attributes
	private int numberTeams;
	private int numberChampionships;

	public HeadCoach(String name, String id, double salary, boolean activeStatus, int yearsExperience, int numberTeams, int numberChampionships){
		super(name,  id,  salary,  activeStatus, yearsExperience);
		this.numberTeams=numberTeams;
		this.numberChampionships=numberChampionships;
	}
}
package model;
public class AssistantCoach extends Coach implements Price, Level{
	//attributes
	private boolean wasPlayer;
	private Skill skill;

	public AssistantCoach(String name, String id, double salary, boolean activeStatus, int yearsExperience, boolean wasPlayer, String skill){
		super(name,  id,  salary,  activeStatus, yearsExperience);
		this.wasPlayer=wasPlayer;
		this.skill=Skill.valueOf(skill);
	}

}
package model;
public class AssistantCoach extends Coach{
	//attributes
	private boolean wasPlayer;
	private Skill skill;

	public AssistantCoach(String name, String id, double salary, int yearsExperience, boolean wasPlayer, String skill){
		super(name,  id,  salary,  yearsExperience);
		this.wasPlayer=wasPlayer;
		this.skill=Skill.valueOf(skill);
	}

}
package model;
public class AssistantCoach extends Coach{
	//constant
	public final static int MAX_SKILLS=6;
	//attributes
	private boolean wasPlayer;
	private Skill[] skills;

	public AssistantCoach(String name, String id, double salary, int yearsExperience, boolean wasPlayer, String[] skills){
		super(name,  id,  salary,  yearsExperience);
		this.wasPlayer=wasPlayer;
		this.skills= new Skill[MAX_SKILLS];
		for(int i=0; i<skills.length;i++){
			if(skills[i]!=null){
				this.skills[i]=Skill.valueOf(skills[i]);	
			}
		}
		
	}

}
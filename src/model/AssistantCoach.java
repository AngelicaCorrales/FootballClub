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

	public void setWasPlayer(boolean wasPlayer){
		this.wasPlayer=true;
	}

	public String wasPlayerToString(){
		String player="";
		if(wasPlayer){
			player="SI";
		}
		else{
			player="NO";
		}
		return player;
	}

	public String skillsToString(){
		String allSkills="";

		for(int i=0; i<skills.length;i++){
			if(skills[i]!=null){
				allSkills+=" -"+skills[i].name();
			}
		}
		return allSkills;
	}


	public String addSkill(String skill){
		String message="";
		boolean exit=false;
		for(int i=0; i<skills.length && !exit;i++){
			if(skills[i]!=null && skills[i].name().equals(skill)){
				exit=true;
			}
		}
		if(!exit){
			for(int i=0; i<skills.length && !exit;i++){
				if(skills[i]==null){
					skills[i]=Skill.valueOf(skill);
					exit=true;
					message="   Experticia agregada";
				}
			}
		}
		else{
			message="   Error. Ya se habia agregado la experticia";
		}
		return message;
	}

	@Override
	public String toString(){
		return super.toString()+ "*Fue jugador: "+wasPlayerToString()+"\n"+
								"*Experticia(s): "+skillsToString()+"\n";
	}

}
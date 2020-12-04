package model;
public class AssistantCoach extends Coach{
	//constant
	public final static int MAX_SKILLS=6;

	//attributes
	private boolean wasPlayer;

	//relationship
	private Skill[] skills;

	/**
	*<b>name:</b> AssistantCoach <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the attributes and relationships of the class have been initialized<br>
	*@param name Is the name of the assistant coach. name!=null and name!=""<br>
	*@param id Is the identifier of the assistant coach. id!=null, id!=""<br>
	*@param salary Is the salary of the assistant coach. salary greater than 0<br>
	*@param yearsExperience Is the years of experience of the assistant coach. yearsEmperience greater than 0 and less than 80<br>
	*@param wasPlayer Is a boolean that is true if the assistant coach was a player, and false if not.<br>
	*@param skills Is an array of skills of the assistant coach. skills!=null<br>
	*/
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

	/**
	*<b>name:</b> getWasPlayer <br>
	*This method gets if the assistant coach was a player<br>
	*<b>post:</b> if the assistant coach was a player has been gotten <br>
	*@return a <code>boolean</code> specifying wasPlayer, if the assistant coach was a player
	*/
	public boolean getWasPlayer(){
		return wasPlayer;
	}

	/**
	*<b>name:</b> setWasPlayer<br>
	*This method sets the wasPlayer of the assistant coach <br>
	*<b>post:</b> the wasPlayer of the assistant coach has been set <br>
	*@param wasPlayer Is a boolean that is true if the assistant coach was a player, and false if not.<br>
	*/
	public void setWasPlayer(boolean wasPlayer){
		this.wasPlayer=wasPlayer;
	}

	/**
	*<b>name:</b> getSkills <br>
	*This method gets the skills of the assistant coach <br>
	*<b>post:</b> the skills of the assistant coach have been gotten <br>
	*@return an array of <code>Skill</code> specifying skills, the skills of the assistant coach 
	*/
	public Skill[] getSkills(){
		return skills;
	}

	/**
	*<b>name:</b> setSkills<br>
	*This method sets the skills of the assistant coach <br>
	*<b>post:</b> the skills of the assistant coach have been set <br>
	*@param skills Is an array of skills of the assistant coach. skills!=null<br>
	*/
	public void setSkills(Skill[] skills){
		this.skills=skills;
	}

	/**
	*<b>name:</b> wasPlayerToString <br>
	*This method returns the wasPlayer as a string<br>
	*<b>post:</b> the wasPlayer has been returned as a string<br>
	*@return a <code>string</code> specifying player, if the assistant coach was a player or not
	*/
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

	/**
	*<b>name:</b> skillsToString <br>
	*This method returns the skills as a string<br>
	*<b>post:</b> the skills has been returned as a string<br>
	*@return a <code>string</code> specifying allSkills, the skills of the assistant coach
	*/
	public String skillsToString(){
		String allSkills="";

		for(int i=0; i<skills.length;i++){
			if(skills[i]!=null){
				allSkills+=" -"+skills[i].name();
			}
		}
		return allSkills;
	}

	/**
	*<b>name:</b> addSkill <br>
	*This method adds a skill to the assistant coach<br>
	*<b>post:</b> the skill may have been added<br>
	*@param skill Is the skill of the assistant coach. skill!=null, skill!=""<br>
	*@return a <code>string</code> specifying message, the message that the skill has been added or not<br>
	*/
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

	/**
	*<b>name:</b> toString <br>
	*This method return the name, id, salary, status, years of experience, wasPlayer and skills of the assistant coach on a string<br>
	*<b>post:</b> the name, id, salary, status, years of experience, wasPlayer and skills of the assistant coach have been returned<br>
	*@return a <code>string</code> specifying the name, id, salary, status, years of experience, wasPlayer and skills of the assistant coach
	*/
	@Override
	public String toString(){
		return super.toString()+ "*Fue jugador: "+wasPlayerToString()+"\n"+
								"*Experticia(s): "+skillsToString()+"\n";
	}

}
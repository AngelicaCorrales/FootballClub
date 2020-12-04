package model;
import java.util.*;

public class HeadCoach extends Coach implements Price, Level{
	//attributes
	private int numberTeams;
	private ArrayList<String> championships;

	/**
	*<b>name:</b> HeadCoach <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the attributes of the class have been initialized<br>
	*@param name Is the name of the head coach. name!=null and name!=""<br>
	*@param id Is the identifier of the head coach. id!=null, id!=""<br>
	*@param salary Is the salary of the head coach. salary greater than 0<br>
	*@param yearsExperience Is the years of experience of the head coach. yearsEmperience greater than 0 and less than 80<br>
	*@param numberTeams Is the number of teams the head coach has managed. numberTeams greater than 0<br>
	*@param championships Is the list of championships won by the head coach.<br>
	*/
	public HeadCoach(String name, String id, double salary, int yearsExperience, int numberTeams, ArrayList<String> championships){
		super(name,  id,  salary, yearsExperience);
		this.numberTeams=numberTeams;
		this.championships= championships;
		
	}

	/**
	*<b>name:</b> getNumberTeams <br>
	*This method gets the number of teams the head coach has managed <br>
	*<b>post:</b> the number of teams the head coach has managed has been gotten <br>
	*@return an <code>integer</code> specifying numberTeams, the number of teams the head coach has managed
	*/
	public int getNumberTeams(){
		return numberTeams;
	}

	/**
	*<b>name:</b> setNumberTeams<br>
	*This method sets the number of teams the head coach has managed <br>
	*<b>post:</b> the number of teams the head coach has managed has been set <br>
	*@param numberTeams Is the number of teams the head coach has managed. numberTeams greater than 0<br>
	*/
	public void setNumberTeams(int numberTeams){
		this.numberTeams=numberTeams;
	}

	/**
	*<b>name:</b> getChampionships <br>
	*This method gets the championships won by the head coach <br>
	*<b>post:</b> the championships won by the head coach have been gotten <br>
	*@return a list of <code>String</code> specifying championships, the championships won by the head coach
	*/
	public ArrayList<String> getChampionships(){
		return championships;
	}

	/**
	*<b>name:</b> setChampionships<br>
	*This method sets the championships won by the head coach <br>
	*<b>post:</b> championships won by the head coach have been set <br>
	*@param championships Is the list of championships won by the head coach.<br>
	*/
	public void setChampionships(ArrayList<String> championships){
		this.championships=championships;
	}

	/**
	*<b>name:</b> addChampionship <br>
	*This method adds a championship to the head coach<br>
	*<b>post:</b> the championship may have been added<br>
	*@param championship Is the championship to be added.<br>
	*@return a <code>string</code> specifying message, the message that the championship has been added or not<br>
	*/
	public String addChampionship(String championship){
		String message="";
		boolean exit=false;
		for(int i=0; i<championships.size() && !exit; i++){
			if(championship.equalsIgnoreCase(championships.get(i))){
				exit=true;
			}
		}
		if(!exit){
			championships.add(championship);	
			message="   Campeonato agregado";
		}
		else{
			message="   Error. Ya se habia agregado el campeonato";
		}

		return message;		
		
	}

	/**
	*<b>name:</b> calculatePrice <br>
	*This method calculates the market price of the head coach<br>
	*<b>post:</b> the market price of the head coach has been calculated <br>
	*@return a <code>double</code> specifying the market price of the head coach
	*/
	public double calculatePrice(){
		return (getSalary()*10)+(getYearsExperience()*100)+(championships.size()*50);
	}
	
	/**
	*<b>name:</b> calculateLevel <br>
	*This method calculates the level of the head coach<br>
	*<b>post:</b> the level of the head coach has been calculated <br>
	*@return an <code>integer</code> specifying the level of the head coach
	*/
	public int calculateLevel(){
		return 5+(championships.size()/10);
	}
	
	/**
	*<b>name:</b> championshipsToString <br>
	*This method returns the championships<br>
	*<b>post:</b> the championships have been returned<br>
	*@return a <code>string</code> specifying chString, the championships won by the head coach
	*/
	public String championshipsToString(){
		String chString="";
		for(int i=0; i<championships.size();i++){
			chString+=" -"+championships.get(i);
		}
		if(championships.isEmpty()){
			chString="-";
		}
		return chString;
	}

	/**
	*<b>name:</b> toString <br>
	*This method return the name, id, salary, status, years of experience, numberTeams, championships, market price and level of the head coach on a string<br>
	*<b>post:</b> the name, id, salary, status, years of experience, numberTeams, championships, market price and level of the head coach have been returned<br>
	*@return a <code>string</code> specifying the name, id, salary, status, years of experience, numberTeams, championships, market price and level of the head coach
	*/
	@Override
	public String toString(){
		return super.toString()+"*Numero de equipos a cargo en su carrera como manager: "+numberTeams+"\n"+
								"*Campeonatos conseguidos: "+championshipsToString()+"\n"+
								"*Precio del mercado: $"+calculatePrice()+"\n"+
								"*Nivel: "+calculateLevel()+"\n";
	}
}
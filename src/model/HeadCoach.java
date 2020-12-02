package model;
import java.util.*;

public class HeadCoach extends Coach implements Price, Level{
	//attributes
	private int numberTeams;
	private ArrayList<String> championships;

	public HeadCoach(String name, String id, double salary, int yearsExperience, int numberTeams, ArrayList<String> championships){
		super(name,  id,  salary, yearsExperience);
		this.numberTeams=numberTeams;
		this.championships= championships;
		
	}

	public int getNumberTeams(){
		return numberTeams;
	}

	public void setNumberTeams(int numberTeams){
		this.numberTeams=numberTeams;
	}

	public ArrayList<String> getChampionships(){
		return championships;
	}

	public void setChampionships(ArrayList<String> championships){
		this.championships=championships;
	}

	public String addChampionship(String championship){
		String message="";
		boolean exit=false;
		for(int i=0; i<championships.size() && !exit; i++){
			if(championship.equals(championships.get(i))){
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

	public double calculatePrice(){
		return (getSalary()*10)+(getYearsExperience()*100)+(championships.size()*50);
	}
	
	public int calculateLevel(){
		return 5+(championships.size()/10);
	}
	

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

	@Override
	public String toString(){
		return super.toString()+"*Numero de equipos a cargo en su carrera como manager: "+numberTeams+"\n"+
								"*Campeonatos conseguidos: "+championshipsToString()+"\n"+
								"*Precio del mercado: $"+calculatePrice()+"\n"+
								"*Nivel: "+calculateLevel()+"\n";
	}
}
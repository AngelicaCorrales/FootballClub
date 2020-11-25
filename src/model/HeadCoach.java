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

	public double calculatePrice(){
		return 1;
	}

	public double calculateLevel(){
		return 1;
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

	public String toString(){
		return super.toString()+"*Numero de equipos a cargo en su carrera como manager: "+numberTeams+"\n"+
								"*Campeonatos conseguidos: "+championshipsToString()+"\n"+
								"*Precio del mercado: "+calculatePrice()+"\n"+
								"*Nivel: "+calculateLevel()+"\n";
	}
}
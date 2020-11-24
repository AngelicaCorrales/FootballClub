package model;
import java.util.*;
public class Team{
	//constants
	public final static int MAX_PLAYERS=25;

	public final static int MAX_CR1_ROWS=7;
	public final static int MAX_CR1_COLS=6;

	public final static int MAX_CR2_ROWS=7;
	public final static int MAX_CR2_COLS=7;

	public final static int MAX_AS_COACHES=3;
	

	//attributes
	private char name;
	private Player[] players;
	private Player[][] changingRoom1;
	private Player[][] changingRoom2;

	private AssistantCoach[] assistantCoaches;
	private HeadCoach headCoach;

	private ArrayList<Lineup> lineups;

	public Team(char name){
		this.name=name;
		players=new Player[MAX_PLAYERS];
		changingRoom1=new Player[MAX_CR1_ROWS][MAX_CR1_COLS];
		changingRoom2=new Player[MAX_CR2_ROWS][MAX_CR2_COLS];
		assistantCoaches=new AssistantCoach[MAX_AS_COACHES];
		lineups= new ArrayList<Lineup>();
		headCoach=null;


	}

	public boolean canHirePlayer(){
		boolean hire=false;
		for(int i=0; i<players.length && !hire;i++){
			if(players[i]==null){
				hire=true;
			}
		}
		return hire;
	}

	public boolean numberPlayerAvailable(int number){
		boolean available=true;

		for(int i=0;i<players.length && available;i++){
			if(players[i]!= null && players[i].getNumber()==number){
				available=false;
			}
		}
		return available;
	}

	public Player hirePlayer(String name, String id, double salary, int number, String position){
		boolean exit=false;
		Player objPlayer=null;
		for(int i=0; i<players.length && !exit;i++){
			if(players[i]==null){
				players[i]=new Player(name, id, salary, number, position);
				exit=true;
				objPlayer=players[i];
			}
		}
		return objPlayer;

	}

	public boolean canHireHeadCoach(){
		boolean hire=false;
		if(headCoach==null){
			hire=true;
		}
		return hire;
	}

	public HeadCoach hireHeadCoach(String name, String id, double salary, int yearsExperience, int numberTeams, ArrayList<String> championships){
		headCoach= new HeadCoach(name,  id,  salary,  yearsExperience,  numberTeams,  championships);
		return headCoach;

	}


	public boolean canHireAssistantCoach(){
		boolean hire=false;
		for(int i=0; i<assistantCoaches.length && !hire;i++){
			if(assistantCoaches[i]==null){
				hire=true;
			}
		}
		return hire;
	}

	public AssistantCoach hireAssistantCoach(String name, String id, double salary, int yearsExperience, boolean wasPlayer, String[] skills ){
		boolean exit=false;
		AssistantCoach objAsCoach=null;
		for(int i=0; i<assistantCoaches.length && !exit;i++){
			if(assistantCoaches[i]==null){
				assistantCoaches[i]=new AssistantCoach(name,  id,  salary,  yearsExperience,  wasPlayer,  skills);
				exit=true;
				objAsCoach=assistantCoaches[i];
			}
		}
		return objAsCoach;

	}

}
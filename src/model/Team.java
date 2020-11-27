package model;
import java.util.*;
public class Team{
	//constants
	public final static int MAX_PLAYERS=25;

	public final static int MAX_CRA_ROWS=7;
	public final static int MAX_CRA_COLS=7;

	public final static int MAX_CRB_ROWS=7;
	public final static int MAX_CRB_COLS=6;

	public final static int MAX_AS_COACHES=3;
	

	//attributes
	private char name;
	private Player[] players;
	private Player[][] changingRoom;

	private AssistantCoach[] assistantCoaches;
	private HeadCoach headCoach;

	private ArrayList<Lineup> lineups;

	public Team(char name){
		this.name=name;
		players=new Player[MAX_PLAYERS];
		if(name=='A'){
			changingRoom=new Player[MAX_CRA_ROWS][MAX_CRA_COLS];
		}
		else{
			changingRoom=new Player[MAX_CRB_ROWS][MAX_CRB_COLS];
		}
		
		assistantCoaches=new AssistantCoach[MAX_AS_COACHES];
		lineups= new ArrayList<Lineup>();
		headCoach=null;


	}

	public char getName(){
		return name;
	}

	public Employee findEmployee(Employee objEmployee){
		int counter=0;
		
		for(int i=0; i<players.length; i++){
			if(players[i]!=null && players[i]==objEmployee){
				objEmployee=players[i];
				counter++;
			}
		}
	

	
		if(headCoach!=null && headCoach==objEmployee){
			objEmployee=headCoach;
			counter++;
		}
	

	
		for(int i=0; i<assistantCoaches.length; i++){
			if(assistantCoaches[i]!=null && assistantCoaches[i]==objEmployee){
				objEmployee=assistantCoaches[i];
				counter++;
			}
		}
		
		if(counter==0){
			objEmployee=null;
		}
		return objEmployee;

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

	public void fireEmployee(Employee objEmployee){
		boolean exit=false;
		objEmployee.setSalary(0);

		if(objEmployee instanceof Player){
			((Player)objEmployee).setNumber(0);
			for(int i=0; i<players.length && !exit;i++){
				if(players[i]==objEmployee){
					players[i]=null;
					exit=true;
				}
			}
		}


		if(objEmployee instanceof HeadCoach){
			headCoach=null;
		}


		if(objEmployee instanceof AssistantCoach){
			for(int i=0; i<assistantCoaches.length && !exit;i++){
				if(assistantCoaches[i]==objEmployee){
					assistantCoaches[i]=null;
					exit=true;
				}
			}
		}


	}

}
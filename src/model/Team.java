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
	private char team;
	private String name;
	private Player[] players;
	private Player[][] changingRooms;

	private AssistantCoach[] assistantCoaches;
	private HeadCoach headCoach;

	private ArrayList<Lineup> lineups;

	private int MAX_CR_ROWS;
	private int MAX_CR_COLS;

	public Team(char team, String name){
		this.team=team;
		this.name=name;
		players=new Player[MAX_PLAYERS];
		if(team=='A'){
			MAX_CR_ROWS=MAX_CRA_ROWS;
			MAX_CR_COLS=MAX_CRA_COLS;
			
		}
		else{
			MAX_CR_ROWS=MAX_CRB_ROWS;
			MAX_CR_COLS=MAX_CRB_COLS;
		}
		changingRooms=new Player[MAX_CR_ROWS][MAX_CR_COLS];
		
		assistantCoaches=new AssistantCoach[MAX_AS_COACHES];
		lineups= new ArrayList<Lineup>();
		headCoach=null;


	}

	public char getTeam(){
		return team;
	}

	public String getName(){
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
		//placePlayerInCR(objPlayer);
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
			//removePlayerFromCR((Player)objEmployee);
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

	
	public String changingRoomLocations(){
		String location="";
		boolean exit;

		List<Player> playerList = Arrays.asList(players);

		Collections.shuffle(playerList);

		playerList.toArray(players);

		for(int i=0; i<MAX_CR_ROWS; i++){
			for(int j=0; j<MAX_CR_COLS;j++){
				changingRooms[i][j]=null;
			}
		}
		
		int l;
		for(int i=0; i<players.length;i++){
			if(players[i]!=null){
				exit=false;	
				for(int j=0; j<MAX_CR_ROWS&& !exit;j++){
					if(j%2!=0){
						l=1;
					}
					else{
						l=0;
					}

					for(int k=l; k<MAX_CR_COLS && !exit;k+=2){
							
							if(changingRooms[j][k]==null){
								changingRooms[j][k]=players[i];
								exit=true;
							}					
						}
				}
			}
		}

		for(int i=0; i<MAX_CR_ROWS; i++){
			for(int j=0; j<MAX_CR_COLS;j++){
				if(changingRooms[i][j]!=null){
					location+=" ["+changingRooms[i][j].getName()+"] ";
				}
				else{
					location+=" [ X ] ";
				}
			}
			location+="\n";
		}

		return location;
	}
	/*
	Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 };

		List<Integer> intList = Arrays.asList(intArray);

		Collections.shuffle(intList);

		intList.toArray(intArray);

		System.out.println(Arrays.toString(intArray));
	


	public void placePlayerInCR(Player objPlayer){
		
		boolean exit=false;
			
		for(int j=0; j<MAX_CR_ROWS&& !exit;j+=2){
			for(int k=0; k<MAX_CR_COLS && !exit;k+=2){
				
				if(changingRooms[j][k]==null){
					changingRooms[j][k]=objPlayer;
					exit=true;
				}					
			}
		}
	}

	public void removePlayerFromCR(Player objPlayer){
		boolean exit=false;
			
		for(int j=0; j<MAX_CR_ROWS && !exit;j+=2){
			for(int k=0; k<MAX_CR_COLS && !exit;k+=2){
				if(changingRooms[j][k]!=null && changingRooms[j][k]==objPlayer){
			
						changingRooms[j][k]=null;
						exit=true;
					
						
				}
			}
		}
	}
	*/
	

}
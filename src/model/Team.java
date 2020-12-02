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
	private int MAX_CR_ROWS;
	private int MAX_CR_COLS;

	//relationships
	private Player[] players;
	private Player[][] changingRooms;

	private AssistantCoach[] assistantCoaches;
	private HeadCoach headCoach;

	private ArrayList<Lineup> lineups;

	

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

	public void setTeam(char team){
		this.team=team;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public Player[] getPlayers(){
		return players;
	}

	public void setPlayers(Player[] players){
		this.players=players;
	}

	public AssistantCoach[] getAssistantCoaches(){
		return assistantCoaches;
	}

	public void setAssistantCoaches(AssistantCoach[] assistantCoaches){
		this.assistantCoaches=assistantCoaches;
	}

	public HeadCoach getHeadCoach(){
		return headCoach;
	}

	public void setHeadCoach(HeadCoach headCoach){
		this.headCoach=headCoach;
	}

	public Player[][] getChangingRooms(){
		return changingRooms;
	}

	public void setChangingRooms(Player[][] changingRooms){
		this.changingRooms=changingRooms;
	}

	public ArrayList<Lineup> getLineups(){
		return lineups;
	}

	public void setLineups(ArrayList<Lineup> lineups){
		this.lineups=lineups;
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

	public Player hirePlayer(String name, String id, double salary, int number, double averageRating ,String position){
		boolean exit=false;
		Player objPlayer=null;
		for(int i=0; i<players.length && !exit;i++){
			if(players[i]==null){
				players[i]=new Player(name, id, salary, number, averageRating, position);
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

	
	public String changingRoomLocations(){
		String location="";
		boolean exit;
		boolean[] hasCR= new boolean[players.length];
		boolean allHaveCR=true;

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


		for(int k=0; k<players.length;k++){
			exit=false;
			if(players[k]!=null){
				for(int i=0; i<MAX_CR_ROWS && !exit; i++){
					for(int j=0; j<MAX_CR_COLS && !exit;j++){
						if(changingRooms[i][j]==players[k]){
							hasCR[k]=true;
							exit=true;
						}
						else{
							hasCR[k]=false;
						}
					}
				}
			}
		}

		for(int i=0; i<players.length && allHaveCR; i++){
			if(players[i]!=null && !hasCR[i]){
				allHaveCR=false;
			}
		}

		
		if(!allHaveCR){
			location+="   Jugador(es) sin camerino: ";
			for(int i=0; i<players.length; i++){
				if(players[i]!=null && !hasCR[i]){
					location+="\n    **"+players[i].getName();
				}
			}
		}
		
		return location;
	}

	public Lineup findLineup(String dateLineup){
		Lineup lineup=null;
		boolean exit=false;
		for(int i=0; i<lineups.size() && !exit;i++){
			if(lineups.get(i).getDate().equals(dateLineup)){
				lineup=lineups.get(i);
				exit=true;
			}

		}
		return lineup;
	}

	public String addLineup(String dateLineup, String tactic, int defenders, int midfielders, int fordwards){
		String message="";

		Lineup lineup= findLineup(dateLineup);

		if(lineup==null){
			lineups.add(new Lineup(dateLineup, tactic));
			findLineup(dateLineup).formationMatrix(defenders, midfielders, fordwards);
			message= "   Alineacion agregada";
		}
		else{
			message="   Ya existe una alineacion para esa fecha";
		}
		return message;
	}

	public String employeesToString(){
		String employees="";
		String asCoaches="";
		String playersString="";

		employees+="   **Entrenador principal: ";
		if(headCoach!=null){
			employees+="\n \n"+headCoach.toString();
		}
		else{
			employees+="-";
		}

		for(int i=0; i<assistantCoaches.length;i++){
			if(assistantCoaches[i]!=null){
				asCoaches+=assistantCoaches[i].toString()+"\n";
			}
		}
		if(asCoaches.equals("")){
			asCoaches="-";
		}
		else{
			asCoaches="\n \n"+asCoaches;
		}

		employees+="\n   **Entrenador(es) asistente(s): "+asCoaches;

		for(int i=0; i<players.length;i++){
			if(players[i]!=null){
				playersString+=players[i].toString()+"\n";
			}
		}

		if(playersString.equals("")){
			playersString="-";
		}
		else{
			playersString="\n \n"+playersString;
		}

		employees+="\n   **Jugador(es): "+playersString;

		return employees;
	}

	public String lineupsToString(){
		String lineupsString="";
		for(int i=0; i<lineups.size();i++){
			lineupsString+=lineups.get(i).toString()+"\n";
		}

		if(lineups.isEmpty()){
			lineupsString="      No se han agregado alineaciones. ";
		}
		return lineupsString;
	}

	public String toString(){
		return "               *****EQUIPO*****\n"+
				"   **Equipo: "+team+"\n"+
				"   **Nombre: "+name+"\n"+
				"\n"+employeesToString()+"\n"+
				"   **Camerinos: \n"+changingRoomLocations()+"\n"+
				"   **Alineacion(es): \n"+lineupsToString()+"\n";

				
	}

}
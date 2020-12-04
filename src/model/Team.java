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
	private int crRows;
	private int crCols;

	//relationships
	private Player[] players;
	private Player[][] changingRooms;

	private AssistantCoach[] assistantCoaches;
	private HeadCoach headCoach;

	private ArrayList<Lineup> lineups;

	
	/**
	*<b>name:</b> Team <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the attributes and relationships of the class have been initialized
	*@param team Is the team, A or B. teamX!=''<br>
	*@param name Is the name of the team. name!=null and name!=""<br>
	*/
	public Team(char team, String name){
		this.team=team;
		this.name=name;
		players=new Player[MAX_PLAYERS];
		if(team=='A'){
			crRows=MAX_CRA_ROWS;
			crCols=MAX_CRA_COLS;
			
		}
		else{
			crRows=MAX_CRB_ROWS;
			crCols=MAX_CRB_COLS;
		}
		changingRooms=new Player[crRows][crCols];
		
		assistantCoaches=new AssistantCoach[MAX_AS_COACHES];
		lineups= new ArrayList<Lineup>();
		headCoach=null;


	}

	/**
	*<b>name:</b> getTeam <br>
	*This method gets the team label, A or B <br>
	*<b>post:</b> the team label has been gotten <br>
	*@return a <code>char</code> specifying team, the team A or B
	*/
	public char getTeam(){
		return team;
	}

	/**
	*<b>name:</b> setTeam<br>
	*This method sets the team label <br>
	*<b>post:</b> the label of the team has been set <br>
	*@param team Is the label of the team. team!=null and team!=''<br>
	*/
	public void setTeam(char team){
		this.team=team;
	}

	/**
	*<b>name:</b> getName <br>
	*This method gets the name of the team <br>
	*<b>post:</b> the name of the team has been gotten <br>
	*@return a <code>string</code> specifying name, the name of the team 
	*/
	public String getName(){
		return name;
	}

	/**
	*<b>name:</b> setName<br>
	*This method sets the name of the team <br>
	*<b>post:</b> the name of the team has been set <br>
	*@param name Is the name of the team. name!=null and name!=""<br>
	*/
	public void setName(String name){
		this.name=name;
	}

	/**
	*<b>name:</b> getPlayers <br>
	*This method gets the players of the team <br>
	*<b>post:</b> the players of the team have been gotten <br>
	*@return an array of <code>Player</code> specifying players, the players of the team 
	*/
	public Player[] getPlayers(){
		return players;
	}

	/**
	*<b>name:</b> setPlayers<br>
	*This method sets the players of the team <br>
	*<b>post:</b> the players of the team have been set <br>
	*@param players Is an array of the players of  the team. players!=null<br>
	*/
	public void setPlayers(Player[] players){
		this.players=players;
	}

	/**
	*<b>name:</b> getAssistantCoaches <br>
	*This method gets the assistant coaches of the team <br>
	*<b>post:</b> the assistant coaches of the team have been gotten <br>
	*@return an array of <code>AssistantCoach</code> specifying assistantCoaches, the assistant coaches of the team 
	*/
	public AssistantCoach[] getAssistantCoaches(){
		return assistantCoaches;
	}

	/**
	*<b>name:</b> setAssistantCoaches<br>
	*This method sets the assistant coaches of the team <br>
	*<b>post:</b> the assistant coaches of the team have been set <br>
	*@param assistantCoaches Is an array of the assistant coaches of  the team. assistantCoaches!=null<br>
	*/
	public void setAssistantCoaches(AssistantCoach[] assistantCoaches){
		this.assistantCoaches=assistantCoaches;
	}

	/**
	*<b>name:</b> getHeadCoach <br>
	*This method gets the head coach of the team <br>
	*<b>post:</b> the head coach of the team has been gotten <br>
	*@return a <code>HeadCoach</code> specifying headCoach, the head coach of the team 
	*/
	public HeadCoach getHeadCoach(){
		return headCoach;
	}

	/**
	*<b>name:</b> setHeadCoach<br>
	*This method sets the head coach of the team <br>
	*<b>post:</b> the head coach of the team has been set <br>
	*@param headCoach Is the head coach of  the team. headCoach!=null<br>
	*/
	public void setHeadCoach(HeadCoach headCoach){
		this.headCoach=headCoach;
	}

	/**
	*<b>name:</b> getChangingRooms <br>
	*This method gets the changing rooms of the team <br>
	*<b>post:</b> the changing rooms of the team have been gotten <br>
	*@return a matrix of <code>Player</code> specifying changingRooms, the changing rooms of the players of the team 
	*/
	public Player[][] getChangingRooms(){
		return changingRooms;
	}

	/**
	*<b>name:</b> setChangingRooms<br>
	*This method sets the changing rooms of the team <br>
	*<b>post:</b> the changing rooms of the team have been set <br>
	*@param changingRooms Is a matrix of changing rooms of the players of the team. changingRooms!=null<br>
	*/
	public void setChangingRooms(Player[][] changingRooms){
		this.changingRooms=changingRooms;
	}

	/**
	*<b>name:</b> getLineups <br>
	*This method gets the lineups of the team <br>
	*<b>post:</b> the lineups of the team have been gotten <br>
	*@return a list of <code>Lineup</code> specifying lineups, the lineups of the team 
	*/
	public ArrayList<Lineup> getLineups(){
		return lineups;
	}

	/**
	*<b>name:</b> setLineups<br>
	*This method sets the lineups of the team <br>
	*<b>post:</b> the lineups of the team have been set <br>
	*@param lineups Is a list of lineups of the team. lineups!=null<br>
	*/
	public void setLineups(ArrayList<Lineup> lineups){
		this.lineups=lineups;
	}

	/**
	*<b>name:</b> findEmployee <br>
	*This method finds an employee in the team<br>
	*<b>post:</b> the employee may have been found<br>
	*@param objEmployee Is the employee. employee!=null<br>
	*@return an <code>Employee</code> specifying objEmployee, the employee if it has been found or not
	*/	
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


	/**
	*<b>name:</b> canHirePlayer <br>
	*This method returns true if there's space for a player in the team<br>
	*<b>post:</b> there may be space for a player in the team<br>
	*@return a <code>boolean</code> specifying hire, true if there's space for a player in the team, false if not
	*/	
	public boolean canHirePlayer(){
		boolean hire=false;
		for(int i=0; i<players.length && !hire;i++){
			if(players[i]==null){
				hire=true;
			}
		}
		return hire;
	}

	/**
	*<b>name:</b> numberPlayerAvailable <br>
	*This method returns true if the T-shirt number of the player is available in the team<br>
	*<b>post:</b> the T-shirt number may be available<br>
	*@param number Is the T-shirt number of the player. number from 1 to 99<br>
	*@return a <code>boolean</code> specifying available, true if the T-shirt number of the player is available in the team, false if not
	*/
	public boolean numberPlayerAvailable(int number){
		boolean available=true;

		for(int i=0;i<players.length && available;i++){
			if(players[i]!= null && players[i].getNumber()==number){
				available=false;
			}
		}
		return available;
	}

	/**
	*<b>name:</b> hirePlayer <br>
	*This method hires a player in the team<br>
	*<b>post:</b> the player has been hired<br>
	*@param name Is the name of the player. name!=null and name!=""<br>
	*@param id Is the identifier of the player. id!=null, id!=""<br>
	*@param salary Is the salary of the player. salary greater than 0<br>
	*@param number Is the T-shirt number of the player. number from 1 to 99<br>
	*@param averageRating Is the average rating of the player. averageRating from 1 to 10<br>
	*@param position Is the position of the player on the field. position!=null and position!=""<br>
	*@return a <code>Player</code> specifying objPlayer, the player that has been hired
	*/
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

	/**
	*<b>name:</b> canHireHeadCoach <br>
	*This method returns true if there's space for a head coach in the team<br>
	*<b>post:</b> there may be space for a head coach in the team<br>
	*@return a <code>boolean</code> specifying hire, true if there's space for a head coach in the team, false if not
	*/	
	public boolean canHireHeadCoach(){
		boolean hire=false;
		if(headCoach==null){
			hire=true;
		}
		return hire;
	}

	/**
	*<b>name:</b> hireHeadCoach <br>
	*This method hires a head coach in the team<br>
	*<b>post:</b> the head coach mhas been hired<br>
	*@param name Is the name of the head coach. name!=null and name!=""<br>
	*@param id Is the identifier of the head coach. id!=null, id!=""<br>
	*@param salary Is the salary of the head coach. salary greater than 0<br>
	*@param yearsExperience Is the years of experience of the head coach. yearsEmperience greater than 0 and less than 80<br>
	*@param numberTeams Is the number of teams the head coach has managed. numberTeams greater than 0<br>
	*@param championships Is the list of championships won by the head coach.<br>
	*@return a <code>HeadCoach</code> specifying headCoach, the head that has been hired<br>
	*/
	public HeadCoach hireHeadCoach(String name, String id, double salary, int yearsExperience, int numberTeams, ArrayList<String> championships){
		headCoach= new HeadCoach(name,  id,  salary,  yearsExperience,  numberTeams,  championships);
		return headCoach;

	}

	/**
	*<b>name:</b> canHireAssistantCoach <br>
	*This method returns true if there's space for an assistant coach in the team<br>
	*<b>post:</b> there may be space for an assistant coach in the team<br>
	*@return a <code>boolean</code> specifying hire, true if there's space for an assistant coach in the team, false if not
	*/
	public boolean canHireAssistantCoach(){
		boolean hire=false;
		for(int i=0; i<assistantCoaches.length && !hire;i++){
			if(assistantCoaches[i]==null){
				hire=true;
			}
		}
		return hire;
	}

	/**
	*<b>name:</b> hireAssistantCoach <br>
	*This method hires an assistant coach in the team<br>
	*<b>post:</b> the assistant coach has been hired<br>
	*@param name Is the name of the asssistant coach. name!=null and name!=""<br>
	*@param id Is the identifier of the assistant coach. id!=null, id!=""<br>
	*@param salary Is the salary of the assistant coach. salary greater than 0<br>
	*@param yearsExperience Is the years of experience of the assistant coach. yearsEmperience greater than 0 and less than 80<br>
	*@param wasPlayer Is a boolean that is true if the assistant coach was a player, and false if not.<br>
	*@param skills Is an array of skills of the assistant coach. skills!=null<br>
	*@return an <code>AssistantCoach</code> specifying objAsCoach, the assistant coach that has been hired<br>
	*/
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

	/**
	*<b>name:</b> fireEmployee <br>
	*This method fires an employee in the team<br>
	*<b>post:</b> the employee  may have been fired<br>
	*@param objEmployee Is the employee. employee!=null<br>
	*/
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

	/**
	*<b>name:</b> changingRoomLocations <br>
	*This method shows the changing room locations<br>
	*<b>post:</b> the changing room locations have been shown<br>
	*@return a <code>string</code> specifying location, the changing room locations of the players
	*/
	public String changingRoomLocations(){
		String location="";
		boolean exit;
		boolean[] hasCR= new boolean[players.length];
		boolean allHaveCR=true;

		List<Player> playerList = Arrays.asList(players);

		Collections.shuffle(playerList);

		playerList.toArray(players);

		for(int i=0; i<crRows; i++){
			for(int j=0; j<crCols;j++){
				changingRooms[i][j]=null;
			}
		}
		
		int l;
		for(int i=0; i<players.length;i++){
			if(players[i]!=null){
				exit=false;	
				for(int j=0; j<crRows&& !exit;j++){
					if(j%2!=0){
						l=1;
					}
					else{
						l=0;
					}

					for(int k=l; k<crCols && !exit;k+=2){
							
							if(changingRooms[j][k]==null){
								changingRooms[j][k]=players[i];
								exit=true;
							}					
						}
				}
			}
		}

		for(int i=0; i<crRows; i++){
			for(int j=0; j<crCols;j++){
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
				for(int i=0; i<crRows && !exit; i++){
					for(int j=0; j<crCols && !exit;j++){
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

	/**
	*<b>name:</b> findLineup <br>
	*This method finds a lineup in the team<br>
	*<b>post:</b> the lineup may have been found<br>
	*@param dateLineup Is the date of the lineup. dateLineup!=null and dateLineup!=""<br>
	*@return a <code>Lineup</code> specifying lineup, the lineup if it has been found or not
	*/	
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

	/**
	*<b>name:</b> addLineup <br>
	*This method adds a lineup to a team<br>
	*<b>post:</b> the lineup  may have been added to the team<br>
	*@param dateLineup Is the date of the lineup. dateLineup!=null and dateLineup!=""<br>
	*@param tactic Is the tactic of the lineup. tactic!=null and tactic!=""<br>
	*@param defenders Is the number of defenders of the formation. defenders greater than or equal to 1, defenders less than or equal to 8<br>
	*@param midfielders Is the number of midfielders of the formation. midfielders greater than or equal to 1, midfieldders less than or equal to 8<br>
	*@param fordwards Is the number of fordwards of the formation. fordwars greater than or equal to 1, fordwards less than or equal to 8<br>
	*@return a <code>string</code> specifying message, the message if the lineup has been added or not<br>
	*/
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

	/**
	*<b>name:</b> employeesToString <br>
	*This method shows the employees of the team<br>
	*<b>post:</b> the employees have been shown<br>
	*@return a <code>string</code> specifying employees, the employees of the team
	*/
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

	/**
	*<b>name:</b> lineupsToString <br>
	*This method shows the lineups of the team<br>
	*<b>post:</b> the lineups have been shown<br>
	*@return a <code>string</code> specifying lineupsString, the lineups of the team
	*/
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

	/**
	*<b>name:</b> toString <br>
	*This method return the label, name, employees, changing rooms and lineups of the team on a string<br>
	*<b>post:</b> the label, name, employees, changing rooms and lineups of the team have been returned<br>
	*@return a <code>string</code> specifying the label, name, employees, changing rooms and lineups of the team
	*/
	public String toString(){
		return "               *****EQUIPO*****\n"+
				"   **Equipo: "+team+"\n"+
				"   **Nombre: "+name+"\n"+
				"\n"+employeesToString()+"\n"+
				"   **Camerinos: \n"+changingRoomLocations()+"\n"+
				"   **Alineacion(es): \n"+lineupsToString()+"\n";

				
	}

}
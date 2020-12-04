package model;
import java.util.*;

public class Club{
	//constants
	public final static int MAX_OFFICE_ROWS= 6;
	public final static int MAX_OFFICE_COLS= 6;


	//attributes
	private String name;
	private String nit;
	private String foundationDate;

	//relationships
	private Team teamA;
	private Team teamB;
	private ArrayList<Employee> employees;
	private Coach[][] offices;

	/**
	*<b>name:</b> Club <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the attributes and relationships of the class have been initialized
	*@param name Is the name of the club. name!=null and name!=""<br>
	*@param nit Is the nit of the club. nit!=null and nit!=""<br>
	*@param foundationDate Is the foundation date of the club. foundationDate!=null and foundationDate!=""<br>
	*@param teamNameA Is the name of the team A. teamNameA!=null and teamNameA!=""<br>
	*@param teamNameB Is the name of the team B. teamNameB!=null and teamNameB!=""<br>
	*/
	public Club(String name, String nit, String foundationDate, String teamNameA, String teamNameB){
		this.name=name;
		this.nit=nit;
		this.foundationDate=foundationDate;

		teamA=new Team('A', teamNameA);
		teamB=new Team('B', teamNameB);
		employees=new ArrayList<Employee>();
		offices= new Coach[MAX_OFFICE_ROWS][MAX_OFFICE_COLS];

	}

	/**
	*<b>name:</b> getName <br>
	*This method gets the name of the club <br>
	*<b>post:</b> the name of the club has been gotten <br>
	*@return a <code>string</code> specifying name, the name of the club 
	*/
	public String getName(){
		return name;
	}

	/**
	*<b>name:</b> setName<br>
	*This method sets the name of the club <br>
	*<b>post:</b> the name of the club has been set <br>
	*@param name Is the name of the club. name!=null and name!=""<br>
	*/
	public void setName(String name){
		this.name=name;
	}

	/**
	*<b>name:</b> getNit <br>
	*This method gets the nit of the club <br>
	*<b>post:</b> the nit of the club has been gotten <br>
	*@return a <code>string</code> specifying nit, the nit of the club 
	*/
	public String getNit(){
		return nit;
	}

	/**
	*<b>name:</b> setNit<br>
	*This method sets the nit of the club <br>
	*<b>post:</b> the nit of the club has been set <br>
	*@param nit Is the nit of the club. nit!=null and nit!=""<br>
	*/
	public void setNit(String nit){
		this.nit=nit;
	}	

	/**
	*<b>name:</b> getFoundationDate <br>
	*This method gets the foundation date of the club <br>
	*<b>post:</b> the foundation date of the club has been gotten <br>
	*@return a <code>string</code> specifying foundationDate, the foundation date of the club 
	*/
	public String getFoundationDate(){
		return foundationDate;
	}

	/**
	*<b>name:</b> setFoundationDate<br>
	*This method sets the foundation date of the club <br>
	*<b>post:</b> the foundation date of the club has been set <br>
	*@param foundationDate Is the foundation date of the club. foundationDate!=null and foundationDate!=""<br>
	*/
	public void setFoundationDate(String foundationDate){
		this.foundationDate=foundationDate;
	}	

	/**
	*<b>name:</b> getTeamA <br>
	*This method gets the team A of the club <br>
	*<b>post:</b> the team A of the club has been gotten <br>
	*@return a <code>Team</code> specifying teamA, the team A of the club 
	*/
	public Team getTeamA(){
		return teamA;
	}

	/**
	*<b>name:</b> setTeamA<br>
	*This method sets the team A of the club <br>
	*<b>post:</b> the team A of the club has been set <br>
	*@param teamA Is the team A of the club. teamA!=null<br>
	*/
	public void setTeamA(Team teamA){
		this.teamA=teamA;
	}

	/**
	*<b>name:</b> getTeamB <br>
	*This method gets the team B of the club <br>
	*<b>post:</b> the team B of the club has been gotten <br>
	*@return a <code>Team</code> specifying teamB, the team B of the club 
	*/
	public Team getTeamB(){
		return teamB;
	}

	/**
	*<b>name:</b> setTeamB<br>
	*This method sets the team B of the club <br>
	*<b>post:</b> the team B of the club has been set <br>
	*@param teamB Is the team B of the club. teamB!=null<br>
	*/
	public void setTeamB(Team teamB){
		this.teamB=teamB;
	}

	/**
	*<b>name:</b> getEmployees <br>
	*This method gets the employees of the club <br>
	*<b>post:</b> the employees of the club have been gotten <br>
	*@return a list of <code>Employee</code> specifying employees, the employees of the club 
	*/
	public ArrayList<Employee> getEmployees(){
		return employees;
	}

	/**
	*<b>name:</b> setEmployees<br>
	*This method sets the employees of the club <br>
	*<b>post:</b> the employees of the club have been set <br>
	*@param employees Is a List with the employees of the club. employees!=null<br>
	*/
	public void setEmployees(ArrayList<Employee> employees){
		this.employees=employees;
	}

	/**
	*<b>name:</b> getOffices <br>
	*This method gets the offices of the club <br>
	*<b>post:</b> the offices of the club have been gotten <br>
	*@return a matrix of <code>Coach</code> specifying offices, the offices of the club 
	*/
	public Coach[][] getOffices(){
		return offices;
	}

	/**
	*<b>name:</b> setOffices<br>
	*This method sets the offices of the club <br>
	*<b>post:</b> the offices of the club have been set <br>
	*@param offices Is a matrix with the coaches of the club. offices!=null<br>
	*/
	public void setOffices(Coach[][] offices){
		this.offices=offices;
	}

	/**
	*<b>name:</b> getMAX_SKILLS <br>
	*This method gets the maximun number of skills of an assistant coach <br>
	*<b>post:</b> the maximun number of skills of an assistant coach has been gotten <br>
	*@return an <code>integer</code> specifying AssistantCoach.MAX_SKILLS, the maximun number of skills of an assistant coach
	*/
	public int getMAX_SKILLS(){
		return AssistantCoach.MAX_SKILLS;
	}

	/**
	*<b>name:</b> findEmployee <br>
	*This method finds an employee<br>
	*<b>post:</b> the employee may have been found<br>
	*@param id Is the identifier of the employee. id!=null and id!=""<br>
	*@return an <code>Employee</code> specifying objEmployee, the employee if it has been found or not
	*/	
	public Employee findEmployee(String id){
		boolean exist=false;
		Employee objEmployee=null;

		for(int i=0;i<employees.size() && !exist;i++){
			if(employees.get(i).getId().equalsIgnoreCase(id)){
				exist=true;
				objEmployee=employees.get(i);
			}
		}
		return objEmployee;
	}

	/**
	*<b>name:</b> findTeam <br>
	*This method finds a team<br>
	*<b>post:</b> the team has been found<br>
	*@param teamX Is the team. teamX!=''<br>
	*@return a <code>Team</code> specifying team, the team A or B
	*/
	public Team findTeam(char teamX){
		Team team=null;
		if(teamX==teamA.getTeam()){
			team=teamA;
		}
		else{
			team=teamB;
		}

		return team;
	}


	/**
	*<b>name:</b> hireEmployee <br>
	*This method can hire a player<br>
	*<b>post:</b> the player may have been hired<br>
	*@param team Is the team. team!=''<br>
	*@param name Is the name of the player. name!=null and name!=""<br>
	*@param id Is the identifier of the player. id!=null, id!=""<br>
	*@param salary Is the salary of the player. salary greater than 0<br>
	*@param number Is the T-shirt number of the player. number from 1 to 99<br>
	*@param averageRating Is the average rating of the player. averageRating from 1 to 10<br>
	*@param position Is the position of the player on the field. position!=null and position!=""<br>
	*@return a <code>string</code> specifying message, the message if the player has been hired or not
	*/
	public String hireEmployee(char team, String name, String id, double salary, int number, double averageRating, String position){
		//player
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		Team teamX=findTeam(team);
		if(objEmployee==null){
			
			if(teamX.canHirePlayer()){
				if(teamX.numberPlayerAvailable(number)){
					employees.add(teamX.hirePlayer(name, id, salary, number, averageRating, position));
					message="Nuevo jugador contratado exitosamente.";
				}
				else{
					message="No se pudo agregar el nuevo jugador. El numero de camisa ya esta en uso";
				}

			}
			else{
				message="No se pudo agregar el nuevo jugador. Equipo lleno.";
			}
			
		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
		return message;
	}


	/**
	*<b>name:</b> hireEmployee <br>
	*This method can hire a head coach<br>
	*<b>post:</b> the head coach may have been hired<br>
	*@param team Is the team. team!=''<br>
	*@param name Is the name of the head coach. name!=null and name!=""<br>
	*@param id Is the identifier of the head coach. id!=null, id!=""<br>
	*@param salary Is the salary of the head coach. salary greater than 0<br>
	*@param yearsExperience Is the years of experience of the head coach. yearsEmperience greater than 0 and less than 80<br>
	*@param numberTeams Is the number of teams the head coach has managed. numberTeams greater than 0<br>
	*@param championships Is the list of championships won by the head coach.<br>
	*@return a <code>string</code> specifying message, the message if the head coach has been hired or not<br>
	*/
	public String hireEmployee(char team, String name, String id, double salary, int yearsExperience, int numberTeams, ArrayList<String> championships){
		//headCoach
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		Team teamX=findTeam(team);
		if(objEmployee==null){
			
			if(teamX.canHireHeadCoach()){
					employees.add(teamX.hireHeadCoach(name,  id,  salary,  yearsExperience,  numberTeams,  championships));
					placeCoachInOffice((Coach)findEmployee(id));
					message="Nuevo entrenador principal contratado exitosamente.";

			}
			else{
				message="No se pudo agregar el nuevo entrenador. Ya existe uno en el equipo.";
			}
				
		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
		return message;
	}

	
	/**
	*<b>name:</b> hireEmployee <br>
	*This method can hire an assistant coach<br>
	*<b>post:</b> the assistant coach may have been hired<br>
	*@param team Is the team. team!=''<br>
	*@param name Is the name of the asssistant coach. name!=null and name!=""<br>
	*@param id Is the identifier of the assistant coach. id!=null, id!=""<br>
	*@param salary Is the salary of the assistant coach. salary greater than 0<br>
	*@param yearsExperience Is the years of experience of the assistant coach. yearsEmperience greater than 0 and less than 80<br>
	*@param wasPlayer Is a boolean that is true if the assistant coach was a player, and false if not.<br>
	*@param skills Is an array of skills of the assistant coach. skills!=null<br>
	*@return a <code>string</code> specifying message, the message if the assistant coach has been hired or not<br>
	*/
	public String hireEmployee(char team, String name, String id, double salary, int yearsExperience, boolean wasPlayer, String[] skills){
		//assistantCoach
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		Team teamX=findTeam(team);
		if(objEmployee==null){
			if(teamX.canHireAssistantCoach()){
					employees.add(teamX.hireAssistantCoach(name,  id,  salary,  yearsExperience,  wasPlayer,  skills));
					placeCoachInOffice((Coach)findEmployee(id));
					message="Nuevo entrenador asistente contratado exitosamente.";

			}
			else{
				message="No se pudo agregar el nuevo entrenador. Ya estan completos los cupos de asistentes tecnicos en el equipo.";
			}

		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
		return message;
	}


	
	/**
	*<b>name:</b> fireEmployee <br>
	*This method fires an employee<br>
	*<b>post:</b> the employee  may have been fired<br>
	*@param id Is the identifier of the employee. id!=null, id!=""<br>
	*@return a <code>string</code> specifying message, the message if the employee has been fired or not<br>
	*/
	public String fireEmployee(String id){
		String message="";
		Employee objEmployee=findEmployee(id);
		if(objEmployee==null){
			message="Error. El empleado no existe";
		}
		else{
			if(objEmployee.getActiveStatus()){
				objEmployee.setActiveStatus(false);
				teamA.fireEmployee(objEmployee);
				teamB.fireEmployee(objEmployee);

				if(objEmployee instanceof Coach){
					removeCoachFromOffice((Coach)objEmployee);
				}
				
				message="El empleado ha sido despedido exitosamente";
			}
			else{
				message="El empleado ya estaba despedido";
			}
		}
		return message;
	}


	/**
	*<b>name:</b> searchEmployee <br>
	*This method searches an employee<br>
	*<b>post:</b> the employee  may have been found<br>
	*@param id Is the identifier of the employee. id!=null, id!=""<br>
	*@return an <code>integer</code> specifying searched, a number if the employee has been found or not, and if is a player, head coach, or assistant coach<br>
	*/
	public int searchEmployee(String id){
		Employee objEmployee=findEmployee(id);
		int searched=0;
		if(objEmployee!=null){
			if(objEmployee instanceof Player){
				searched=1;
			}

			if(objEmployee instanceof HeadCoach){
				searched=2;
			}

			if(objEmployee instanceof AssistantCoach){
				searched=3;
			}

			
		}
		return searched;
	}



	/**
	*<b>name:</b> updateSalary <br>
	*This method updates the salary of an employee<br>
	*<b>post:</b> the salary  has been updated<br>
	*@param id Is the identifier of the employee. id!=null, id!=""<br>
	*@param salary Is the salary of the employee. salary greater than 0<br>
	*@return a <code>string</code> specifying message, the message that the salary has been updated<br>
	*/
	public String updateSalary(String id, double salary){
		Employee objEmployee=findEmployee(id);
		objEmployee.setSalary(salary);
		return "  Salario actualizado";
	}

	/**
	*<b>name:</b> findEmployeeInTeam <br>
	*This method finds a team depending on the employee<br>
	*<b>post:</b> the team has been found<br>
	*@param employee Is the employee. employee!=null<br>
	*@return a <code>Team</code> specifying team, the team depending on the employee
	*/	
	public Team findEmployeeInTeam(Employee objEmployee){
		Team team=null;
		Employee employeeA=teamA.findEmployee(objEmployee);
		Employee employeeB=teamB.findEmployee(objEmployee);
		if(employeeA!=null){
			team=teamA;
		}

		if(employeeB!=null){
			team=teamB;
		}

		return team;
	}

	/**
	*<b>name:</b> updateNumberPlayer <br>
	*This method updates the T-shirt number of a player<br>
	*<b>post:</b> the T-shir number  has been updated<br>
	*@param id Is the identifier of the player. id!=null, id!=""<br>
	*@param number Is the T-shirt number of the player. number from 1 to 99<br>
	*@return a <code>string</code> specifying message, the message if the T-shirt number has been updated or not<br>
	*/
	public String updateNumberPlayer(String id, int number){
		String message="";
		Employee objEmployee=findEmployee(id);
		Team team= findEmployeeInTeam(objEmployee);
		
		if(team.numberPlayerAvailable(number)){
			((Player)objEmployee).setNumber(number);
			message="  Numero de camiseta actualizado";
		}
		else{
			message="  Numero de camiseta no disponible";
		}

		return message;
	}

	/**
	*<b>name:</b> updateNumberPlayer <br>
	*This method updates the T-shirt number of a player<br>
	*<b>post:</b> the T-shir number  has been updated<br>
	*@param id Is the identifier of the player. id!=null, id!=""<br>
	*@param goals Is the number of goals the player has scored. goals greater than 0<br>
	*@return a <code>string</code> specifying message, the message that the number of goals has been updated<br>
	*/
	public String updateGoalsPlayer(String id, int goals){
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setGoals(goals);

		return "  Goles actualizados";
	}

	/**
	*<b>name:</b> updateAverageRatingPlayer <br>
	*This method updates the average rating of a player<br>
	*<b>post:</b> the average rating  has been updated<br>
	*@param id Is the identifier of the player. id!=null, id!=""<br>
	*@param averageRating Is the average rating of the player. averageRating from 1 to 10<br>
	*@return a <code>string</code> specifying message, the message that the average rating has been updated<br>
	*/
	public String updateAverageRatingPlayer(String id, double averageRating){
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setAverageRating(averageRating);

		return "  Calificacion promedio actualizada";
	}

	/**
	*<b>name:</b> updatePosition <br>
	*This method updates the position of a player on the field<br>
	*<b>post:</b> the position has been updated<br>
	*@param id Is the identifier of the player. id!=null, id!=""<br>
	*@param position Is the position of the player on the field. position!=null and position!=""<br>
	*@return a <code>string</code> specifying message, the message that the position has been updated<br>
	*/
	public String updatePosition(String id, String position){
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setPosition(position);

		return "  Posicion actualizada";
	}

	/**
	*<b>name:</b> updateYearsExperience <br>
	*This method updates the years of experience of a coach<br>
	*<b>post:</b> the years of experience have been updated<br>
	*@param id Is the identifier of the coach. id!=null, id!=""<br>
	*@param yearsExperience Is the years of experience of the head coach. yearsEmperience greater than 0 and less than 80<br>
	*@return a <code>string</code> specifying message, the message that the years of experience have been updated<br>
	*/
	public String updateYearsExperience(String id, int yearsExperience){
		Employee objEmployee=findEmployee(id);
		
		((Coach)objEmployee).setYearsExperience(yearsExperience);

		return "  Anios de experiencia actualizados";
	}

	/**
	*<b>name:</b> updateNumberTeams <br>
	*This method updates the number of teams the head coach has managed<br>
	*<b>post:</b> the number of teams the head coach has managed has been updated<br>
	*@param id Is the identifier of the head coach. id!=null, id!=""<br>
	*@param numberTeams Is the number of teams the head coach has managed. numberTeams greater than 0<br>
	*@return a <code>string</code> specifying message, the message that the number of teams has been updated<br>
	*/
	public String updateNumberTeams(String id, int numberTeams){
		Employee objEmployee=findEmployee(id);
		
		((HeadCoach)objEmployee).setNumberTeams(numberTeams);

		return "  Numero de equipos actualizados";
	}

	/**
	*<b>name:</b> updateChampionships <br>
	*This method adds a championship to the head coach<br>
	*<b>post:</b> the championship may have been added<br>
	*@param id Is the identifier of the head coach. id!=null, id!=""<br>
	*@param championship Is the championship to be added.<br>
	*@return a <code>string</code> specifying message, the message that the championship has been added or not<br>
	*/
	public String updateChampionships(String id, String championship){
		String message="";
		Employee objEmployee=findEmployee(id);
		
		message=((HeadCoach)objEmployee).addChampionship(championship);

		return message;
	}

	/**
	*<b>name:</b> updateWasPlayer <br>
	*This method updates the status of wasPlayer of the assistant coach<br>
	*<b>post:</b> the number of teams the head coach has managed has been updated<br>
	*@param id Is the identifier of the assistant coach. id!=null, id!=""<br>
	*@return a <code>string</code> specifying message, the message that the assistant coach was a player<br>
	*/
	public String updateWasPlayer(String id){
		Employee objEmployee=findEmployee(id);
		((AssistantCoach)objEmployee).setWasPlayer(true);

		return "   Fue jugador: SI (actualizado)";

	}


	/**
	*<b>name:</b> updateSkill <br>
	*This method adds a skill to the assistant coach<br>
	*<b>post:</b> the skill may have been added<br>
	*@param id Is the identifier of the assistant coach. id!=null, id!=""<br>
	*@param skill Is the skill of the assistant coach. skill!=null, skill!=""<br>
	*@return a <code>string</code> specifying message, the message that the skill has been added or not<br>
	*/
	public String updateSkill(String id, String skill){
		String message="";
		Employee objEmployee=findEmployee(id);
		message=((AssistantCoach)objEmployee).addSkill(skill);

		return message;

	}




	/**
	*<b>name:</b> showEmployeeInfo <br>
	*This method shows the information of an employee<br>
	*<b>post:</b> the information of the employee has been shown<br>
	*@param id Is the identifier of the employee. id!=null, id!=""<br>
	*@return a <code>string</code> specifying info, the information of the employee
	*/
	public String showEmployeeInfo(String id){
		Employee objEmployee=findEmployee(id);
		String info= "";
		if(objEmployee==null){
		 info="Error. El empleado no existe";
		}else{
			info=objEmployee.toString();
		}
		return info;
	}




	/**
	*<b>name:</b> officeLocations <br>
	*This method shows the office locations<br>
	*<b>post:</b> the office locations have been shown<br>
	*@return a <code>string</code> specifying location, the office locations of the coaches
	*/
	public String officeLocations(){
		String location="	***OFICINAS***\n";

		for(int i=0; i<MAX_OFFICE_ROWS; i++){
			for(int j=0; j<MAX_OFFICE_COLS;j++){
				if(offices[i][j]!=null){
					location+=" ["+offices[i][j].getName()+"] ";
				}
				else{
					location+=" [ X ] ";
				}
			}
			location+="\n";
		}

		return location;
	}


	/**
	*<b>name:</b> placeCoachInOffice <br>
	*This method places a coach in an office<br>
	*<b>post:</b> the coach has been placed in an office<br>
	*@param coach Is the coach to be placed in an office
	*/
	public void placeCoachInOffice(Coach coach){
		
		boolean exit=false;
			
		for(int j=0; j<MAX_OFFICE_ROWS && !exit;j+=2){
			for(int k=0; k<MAX_OFFICE_COLS && !exit;k+=2){
				
				if(offices[j][k]==null){
					offices[j][k]=coach;
					exit=true;
				}					
			}
		}
	}

	/**
	*<b>name:</b> removeCoachFromOffice <br>
	*This method removes a coach from an office<br>
	*<b>post:</b> the coach has been removed from an office<br>
	*@param coach Is the coach to be removed from an office
	*/
	public void removeCoachFromOffice(Coach coach){
		boolean exit=false;
			
		for(int j=0; j<MAX_OFFICE_ROWS && !exit;j+=2){
			for(int k=0; k<MAX_OFFICE_COLS && !exit;k+=2){
				if(offices[j][k]!=null && offices[j][k]==coach){
			
						offices[j][k]=null;
						exit=true;
					
						
				}
			}
		}
	}

	/**
	*<b>name:</b> updateTeamName <br>
	*This method updates the name of a team <br>
	*<b>post:</b> the name of the team has been updated<br>
	*@param teamX Is the team, A or B. teamX!=''<br>
	*@param teamName Is the new name of the team. teamName!=null and teamName!=""<br>
	*@return a <code>string</code> specifying message, the message that the team name has been updated<br>
	*/
	public String updateTeamName(char teamX, String teamName){
		findTeam(teamX).setName(teamName);

		return "   Nombre del equipo actualizado";
	}	

	/**
	*<b>name:</b> addLineup <br>
	*This method adds a lineup to a team<br>
	*<b>post:</b> the lineup  may have been added to the team<br>
	*@param teamX Is the team, A or B. teamX!=''<br>
	*@param dateLineup Is the date of the lineup. dateLineup!=null and dateLineup!=""<br>
	*@param tactic Is the tactic of the lineup. tactic!=null and tactic!=""<br>
	*@param defenders Is the number of defenders of the formation. defenders greater than or equal to 1, defenders less than or equal to 8<br>
	*@param midfielders Is the number of midfielders of the formation. midfielders greater than or equal to 1, midfieldders less than or equal to 8<br>
	*@param fordwards Is the number of fordwards of the formation. fordwars greater than or equal to 1, fordwards less than or equal to 8<br>
	*@return a <code>string</code> specifying message, the message if the lineup has been added or not<br>
	*/
	public String addLineup(char teamX, String dateLineup, String tactic, int defenders, int midfielders, int fordwards){
		String message=findTeam(teamX).addLineup(dateLineup, tactic, defenders, midfielders, fordwards);
		return message;
	}


	/**
	*<b>name:</b> showFacilities <br>
	*This method shows the facilities of the club<br>
	*<b>post:</b> the facilities have been shown<br>
	*@return a <code>string</code> specifying the locations of the coaches in the offices and the location of the players in the changing rooms
	*/
	public String showFacilities(){
		return officeLocations()+
				"\n	***CAMERINOS***\n"+
				"\n      Equipo A:\n"+teamA.changingRoomLocations()+
				"\n \n      Equipo B:\n"+teamB.changingRoomLocations();

	}


	/**
	*<b>name:</b> showAllEmployees <br>
	*This method shows the information of the active employees of the club<br>
	*<b>post:</b> the information of the employees has been shown<br>
	*@return a <code>string</code> specifying message, the message with the information of the employees
	*/
	public String showAllEmployees(){
		String message="";
		boolean active=false;
		for(int i=0; i<employees.size();i++){
			if(employees.get(i).getActiveStatus()){
				message+="\n"+employees.get(i).toString()+"\n";
				active=true;
			}
		}

		if(employees.isEmpty() || !active){
			message=" 	No se han contratado empleados aun.";
		}

		return message;
	}


	/**
	*<b>name:</b> showEmployee <br>
	*This method shows the information of an active employee of the club<br>
	*<b>post:</b> the information of the employee has been shown<br>
	*@param id Is the identifier of the employee. id!=null, id!=""<br>
	*@return a <code>string</code> specifying message, the message with the information of the employee
	*/
	public String showEmployee(String id){
		String message="";
		Employee objEmployee= findEmployee(id);
		if(objEmployee!=null && objEmployee.getActiveStatus()){
			message="\n"+objEmployee.toString();
		}
		else{
			message="   El identificador no corresponde a un empleado del club";
		}

		return message;
	}


	/**
	*<b>name:</b> showAllTeams <br>
	*This method shows the information of both teams of the club<br>
	*<b>post:</b> the information of the teams has been shown<br>
	*@return a <code>string</code> specifying the information of team A and B
	*/
	public String showAllTeams(){
		return "\n"+teamA.toString()+
				"\n \n \n"+teamB.toString()+"\n";
	}

	/**
	*<b>name:</b> showTeam <br>
	*This method shows the information of a team of the club<br>
	*<b>post:</b> the information of the team has been shown<br>
	*@param teamX Is the team, A or B. teamX!=''<br>
	*@return a <code>string</code> specifying the information of a team, A or B
	*/
	public String showTeam(char teamX){
		return "\n"+findTeam(teamX).toString()+"\n";
	}

	/**
	*<b>name:</b> showClub <br>
	*This method shows the information of the club<br>
	*<b>post:</b> the information of the club has been shown<br>
	*@return a <code>string</code> specifying the information of the club, including its name, nit, foundation date, information of both teams, and facilities
	*/
	public String showClub(){
		return "                  ****CLUB****\n \n"+
				"**Nombre del club: "+name+"\n"+
				"**NIT: "+nit+"\n"+
				"**Fecha de fundacion: "+foundationDate+"\n"+
				showAllTeams()+"\n"+
				officeLocations()+"\n";
	}
}
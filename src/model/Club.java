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

	public Club(String name, String nit, String foundationDate, String teamNameA, String teamNameB){
		this.name=name;
		this.nit=nit;
		this.foundationDate=foundationDate;

		teamA=new Team('A', teamNameA);
		teamB=new Team('B', teamNameB);
		employees=new ArrayList<Employee>();
		offices= new Coach[MAX_OFFICE_ROWS][MAX_OFFICE_COLS];

	}

	public int getMAX_SKILLS(){
		return AssistantCoach.MAX_SKILLS;
	}

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

	public String hireTeamEmployee(Team team, String name, String id, double salary, int number, String position ){
		//player
		String message="";
		if(team.canHirePlayer()){
			if(team.numberPlayerAvailable(number)){
				employees.add(team.hirePlayer(name, id, salary, number, position));
				message="Nuevo jugador contratado exitosamente.";
			}
			else{
				message="No se pudo agregar el nuevo jugador. El numero de camisa ya esta en uso";
			}

		}
		else{
			message="No se pudo agregar el nuevo jugador. Equipo lleno.";
		}
		return message;
	}

	public String hireEmployee(char team, String name, String id, double salary, int number, String position){
		//player
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			
			message=hireTeamEmployee( findTeam(team),  name,  id,  salary,  number,  position);
		
		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
		return message;
	}

	public String hireTeamEmployee(Team team, String name, String id, double salary, int yearsExperience, int numberTeams, ArrayList<String> championships ){
		//head coach
		String message="";
		if(team.canHireHeadCoach()){
				employees.add(team.hireHeadCoach(name,  id,  salary,  yearsExperience,  numberTeams,  championships));
				placeCoachInOffice((Coach)findEmployee(id));
				message="Nuevo entrenador principal contratado exitosamente.";

		}
		else{
			message="No se pudo agregar el nuevo entrenador. Ya existe uno en el equipo.";
		}
		return message;
	}

	public String hireEmployee(char team, String name, String id, double salary, int yearsExperience, int numberTeams, ArrayList<String> championships){
		//headCoach
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			
			message=hireTeamEmployee( findTeam(team),  name,  id,  salary,  yearsExperience,  numberTeams,  championships);
			
		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
		return message;
	}

	public String hireTeamEmployee(Team team, String name, String id, double salary, int yearsExperience, boolean wasPlayer, String[] skills ){
		//assistant
		String message="";
		if(team.canHireAssistantCoach()){
				employees.add(team.hireAssistantCoach(name,  id,  salary,  yearsExperience,  wasPlayer,  skills));
				placeCoachInOffice((Coach)findEmployee(id));
				message="Nuevo entrenador asistente contratado exitosamente.";

		}
		else{
			message="No se pudo agregar el nuevo entrenador. Ya estan completos los cupos de asistentes tecnicos en el equipo.";
		}
		return message;
	}

	public String hireEmployee(char team, String name, String id, double salary, int yearsExperience, boolean wasPlayer, String[] skills){
		//assistantCoach
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			
			message=hireTeamEmployee( findTeam(team),  name,  id,  salary,  yearsExperience,  wasPlayer,  skills);

		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
		return message;
	}






	

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




	public String updateSalary(String id, double salary){
		Employee objEmployee=findEmployee(id);
		objEmployee.setSalary(salary);
		return "  Salario actualizado";
	}

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

	public String updateGoalsPlayer(String id, int goals){
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setGoals(goals);

		return "  Goles actualizados";
	}

	public String updateAverageRatingPlayer(String id, double averageRating){
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setAverageRating(averageRating);

		return "  Calificacion promedio actualizada";
	}

	public String updatePosition(String id, String position){
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setPosition(position);

		return "  Posicion actualizada";
	}

	public String updateYearsExperience(String id, int yearsExperience){
		Employee objEmployee=findEmployee(id);
		
		((Coach)objEmployee).setYearsExperience(yearsExperience);

		return "  Anios de experiencia actualizados";
	}

	public String updateNumberTeams(String id, int numberTeams){
		Employee objEmployee=findEmployee(id);
		
		((HeadCoach)objEmployee).setNumberTeams(numberTeams);

		return "  Numero de equipos actualizados";
	}

	public String updateChampionships(String id, String championship){
		String message="";
		Employee objEmployee=findEmployee(id);
		
		message=((HeadCoach)objEmployee).addChampionship(championship);

		return message;
	}

	public String updateWasPlayer(String id){
		Employee objEmployee=findEmployee(id);
		((AssistantCoach)objEmployee).setWasPlayer(true);

		return "   Fue jugador: SI (actualizado)";

	}

	public String updateSkill(String id, String skill){
		String message="";
		Employee objEmployee=findEmployee(id);
		message=((AssistantCoach)objEmployee).addSkill(skill);

		return message;

	}





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





	public String officeLocations(){
		String location="";

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

	public String updateTeamName(char teamX, String teamName){
		findTeam(teamX).setName(teamName);

		return "   Nombre del equipo actualizado";
	}	

	public String addLineup(char teamX, String dateLineup, String tactic, int defenders, int midfielders, int fordwards){
		return "";
	}

}
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
	private Coach[][] office;

	public Club(String name, String nit, String foundationDate){
		this.name=name;
		this.nit=nit;
		this.foundationDate=foundationDate;

		teamA=new Team('A');
		teamB=new Team('B');
		employees=new ArrayList<Employee>();
		office= new Coach[MAX_OFFICE_ROWS][MAX_OFFICE_COLS];

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

	public String hireTeamPlayer(Team team, String name, String id, double salary, int number, String position ){
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

	public String hireEmployee(char teamName, String name, String id, double salary, int number, String position){
		//player
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			if(teamName=='A'){
				message=hireTeamPlayer( teamA,  name,  id,  salary,  number,  position);
			}
			else{
				message=hireTeamPlayer( teamB,  name,  id,  salary,  number,  position);
			}

		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
		return message;
	}

	public String hireTeamHeadCoach(Team team, String name, String id, double salary, int yearsExperience, int numberTeams, int numberChampionships ){
		String message="";
		if(team.canHireHeadCoach()){
				employees.add(team.hireHeadCoach(name,  id,  salary,  yearsExperience,  numberTeams,  numberChampionships));
				message="Nuevo entrenador principal contratado exitosamente.";

		}
		else{
			message="No se pudo agregar el nuevo entrenador. Ya existe uno en el equipo.";
		}
		return message;
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int yearsExperience, int numberTeams, int numberChampionships){
		//headCoach
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			if(teamName=='A'){
				message=hireTeamHeadCoach( teamA,  name,  id,  salary,  yearsExperience,  numberTeams,  numberChampionships);
			}
			else{
				message=hireTeamHeadCoach( teamB,  name,  id,  salary,  yearsExperience,  numberTeams,  numberChampionships);
			}

		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
		return message;
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int yearsExperience, boolean wasPlayer, String skill){
		//assistantCoach
		return "";
	}

}
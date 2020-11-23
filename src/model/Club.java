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
	private Arraylist<Employee> employees;
	private Coach[][] office;

	public Club(String name, String nit, String foundationDate){
		this.name=name;
		this.nit=nit;
		this.foundationDate=foundationDate;

		teamA=new Team('A');
		teamB=new Team('B');
		employees=new Arraylist<Employee>();
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
		
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int number, String position){
		//player
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			if(teamName=='A'){
				if(teamA.canHirePlayer()){
					if(teamA.numberPlayerAvailable(number)){
						objEmployee=teamA.hirePlayer(name, id, salary, number, position);
						message="Nuevo jugador contratado exitosamente.";
						employees.add(objEmployee);
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
				message=teamB.hireEmployee(name, id, salary, number, position);
			}

		}
		else{
			message="No se agrego el nuevo empleado. Ya existe un empleado con el mismo identificador";
		}
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int yearsExperience, int numberTeams, int numberChampionships){
		//headCoach
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int yearsExperience, boolean wasPlayer, String skill){
		//assistantCoach
	}

}
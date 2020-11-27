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

	public String hireEmployee(char teamName, String name, String id, double salary, int number, String position){
		//player
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			if(teamName==teamA.getName()){
				message=hireTeamEmployee( teamA,  name,  id,  salary,  number,  position);
			}
			else{
				message=hireTeamEmployee( teamB,  name,  id,  salary,  number,  position);
			}

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
				message="Nuevo entrenador principal contratado exitosamente.";

		}
		else{
			message="No se pudo agregar el nuevo entrenador. Ya existe uno en el equipo.";
		}
		return message;
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int yearsExperience, int numberTeams, ArrayList<String> championships){
		//headCoach
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			if(teamName=='A'){
				message=hireTeamEmployee( teamA,  name,  id,  salary,  yearsExperience,  numberTeams,  championships);
			}
			else{
				message=hireTeamEmployee( teamB,  name,  id,  salary,  yearsExperience,  numberTeams,  championships);
			}

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
				message="Nuevo entrenador principal contratado exitosamente.";

		}
		else{
			message="No se pudo agregar el nuevo entrenador. Ya estan completos los cupos de asistentes tecnicos en el equipo.";
		}
		return message;
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int yearsExperience, boolean wasPlayer, String[] skills){
		//assistantCoach
		String message="";
		Employee objEmployee=findEmployee(id);
		boolean hire;
		if(objEmployee==null){
			if(teamName=='A'){
				message=hireTeamEmployee( teamA,  name,  id,  salary,  yearsExperience,  wasPlayer,  skills);
			}
			else{
				message=hireTeamEmployee( teamB,  name,  id,  salary,  yearsExperience,  wasPlayer,  skills);
			}

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
			if(objEmployee.getActiveStatus()==true){
				objEmployee.setActiveStatus(false);
				teamA.fireEmployee(objEmployee);
				teamB.fireEmployee(objEmployee);
				
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
		String message="";
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setGoals(goals);

		return "  Goles actualizados";
	}

	public String updateAverageRatingPlayer(String id, double averageRating){
		String message="";
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setAverageRating(averageRating);

		return "  Calificacion promedio actualizada";
	}

	public String updatePosition(String id, String position){
		String message="";
		Employee objEmployee=findEmployee(id);
		
		((Player)objEmployee).setPosition(position);

		return "  Posicion actualizada";
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

}
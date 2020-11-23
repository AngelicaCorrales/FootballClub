package ui;
import java.util.*;
import model.Club;
public class Main{
	private Club club;
	private Scanner sc;

	public Main(){
		sc= new Scanner(System.in);
		createClub();
	}

	public static void main(String [] args){
		Main objMain= new Main();
		int option;
		do{
			option=objMain.showMenu();
			objMain.chosenOption(option);
		}while(option!=8);
		
	}

	public int showMenu(){
		System.out.println("Seleccione una opcion:\n"+
				"(1) Contratar empleado\n"+
				"(2) Despedir empleado \n"+
				"(5) Mostrar informacion de empleados  \n"+
				"(6) Mostrar informacion de equipos \n"+
				"(6) Agregar alineacion a equipo \n"+
				"(7) Ubicar entrenadores en oficinas \n"+
				"(7) Ubicar jugadores en camerinos \n"+
				"(7) Mostrar informacion de todo el club\n"+
				"(8) Salir");
		int option= sc.nextInt();
		return option;
	}

	public void chosenOption(int op) {
		
		switch(op) {
		case 1:
			hireEmployee();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			 
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
				
		case 8:
			System.out.println("\nHasta la proxima!");
			break;
			
		default:
			System.out.println("\n Error, opcion no valida \n");
		
		}
	}

	public void createClub(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("	FOOTBALL CLUB \n");

		System.out.println("Ingrese el nombre del club");
		String name=sc.nextLine();

		System.out.println("\nIngrese el NIT que identifica el club");
		String nit=sc.nextLine();

		int day,month, year;
		System.out.println("\nFECHA DE FUNDACION (primero el dia, luego mes, por ultimo anio");
		do{
			System.out.println("\nIngrese el dia");
			day=sc.nextInt();
			if(day<1 ||day>31){
				System.out.println("\n No valido");
			}
		}while(day<1 ||day>31);

		
		do{
			System.out.println("\nIngrese el mes (en formato numerico)");
			month=sc.nextInt();
			if(month<1 ||month>12){
				System.out.println("\n No valido");
			}
		}while(month<1 ||month>12);

		
		do{
			System.out.println("\nIngrese el anio");
			year=sc.nextInt();
			if(year<1900 ||year>2020){
				System.out.println("\n No valido");
			}
		}while(year<1900 ||year>2020);

		String foundationDate=day+"/"+month+"/"+year;
		
		club= new Club(name, nit, foundationDate);
		System.out.println("-----------------------------------------------------------");
	}

	public void hireEmployee(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("CONTRATAR EMPLEADO \n");
		boolean error;
		int option;
		String message;
		do{
			error=false;
			System.out.println("Seleccione el tipo de empleado:\n"+
				"(1) Jugador\n"+
				"(2) Entrenador principal \n"+
				"(3) Entrenador asistente");
			option= sc.nextInt();
			if(option!=1 && option!=2 && option!=3){
				error=true;
			}
		}while(error);
		sc.nextLine();
		
		String team;
		do{
			error= false;
			System.out.println("\nIngrese el nombre del equipo al que va a pertenecer el nuevo empleado (A o B)");
			team=sc.nextLine().toUpperCase();
			if(!team.equals("A") && !team.equals("B")){
				error=true;
			}

		}while(error);
		char teamName=team.charAt(0);


		System.out.println("\nIngrese el nombre del nuevo empleado");
		String name=sc.nextLine();

		System.out.println("\nIngrese el identificador del nuevo empleado");
		String id=sc.nextLine();

		System.out.println("\nIngrese el salario del nuevo empleado");
		double salary=sc.nextDouble();

		switch(option){
			case 1:
				System.out.println("\nIngrese el numero de camiseta");
				int number=sc.nextInt();
				sc.nextLine();
				boolean control;
				String position;
				do{
					
					System.out.println("\nIngrese la posicion dentro del terreno de juego del nuevo empleado (portero, defensor, volante o delantero)");
					position=sc.nextLine().toUpperCase();
					if(position.equals("PORTERO") || position.equals("DEFENSOR") || position.equals("VOLANTE") || position.equals("DELANTERO")){
						
						if(position.equals("PORTERO"){
							position= "GOALKEEPER";
						}

						if(position.equals("DEFENSOR")){
							position="DEFENDER";
						}

						if(position.equals("VOLANTE")){
							position="MIDFIELDER";
						}

						if(position.equals("DELANTERO")){
							position="FORDWARD";
						}
						control=false;

					}
					else{
						control=true;
						System.out.println("Posicion no valida. Ingrese nuevamente");
					}

				}while(control);

				message=club.hireEmployee(teamName, name, id, salary, number, position);

				break;

			case 2:
			case 3:
				System.out.println("\nIngrese los anios de experiencia del nuevo empleado");
				int yearsExperience=sc.nextInt();

				if(option==2){
					System.out.println("\nIngrese el numero de equipos a cargo en la carrera como manager del nuevo empleado");
					int numberTeams=sc.nextInt();

					System.out.println("\nIngrese los campeonatos conseguidos del nuevo empleado");
					int numberChampionships=sc.nextInt();

					message=club.hireEmployee(teamName, name, id, salary, yearsExperience, numberTeams, numberChampionships);
				}
				else{
					System.out.println("\nIngrese (1) si ha sido jugador profesional en algun momento de su vida, cualquier otro numero si no");
					int playerOp=sc.nextInt();
					boolean wasPlayer=false;
					if(playerOp==1){
						wasPlayer=true;
					}
					sc.nextLine();
					String skill;
					do{
						System.out.println("\nIngrese la experticia del nuevo empleado (ofensivo, defensivo, posesion, jugadas de laboratorio)");
						skill=sc.nextLine().toUpperCase();

						if(skill.equals("OFENSIVO") || skill.equals("DEFENSIVO") || skill.equals("POSESION")|| skill.equals("JUGADAS DE LABORATORIO")){
							if(skill.equals("OFENSIVO")){
								skill="OFFENSIVE";
							}

							if(skill.equals("DEFENSIVO")){
								skill="DEFENSIVE";
							}

							if(skill.equals("POSESION")){
								skill="POSSESSION";
							}

							if(skill.equals("JUGADAS DE LABORATORIO")){
								skill="LABORATORY_PLAYS";
							}
							control=false;
						}

						else{
							control=true;
							System.out.println("Experticia no valida. Ingrese nuevamente");

						}

					}while(control);

					message=club.hireEmployee(teamName, name, id, salary, yearsExperience, wasPlayer, skill);
				}

				break;
		}

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

}
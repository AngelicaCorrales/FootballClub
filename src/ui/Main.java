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
				"(3) Actualizar informacion de empleado \n"+
				"(4) Actualizar informacion de equipo\n"+
				"(5) Ubicar entrenadores en oficinas \n"+
				"(6) Ubicar jugadores en camerinos \n"+
				"(7) Mostrar informacion de todo el club\n"+
				"(5) Mostrar informacion de empleados  \n"+
				"(6) Mostrar informacion de equipos \n"+
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
			fireEmployee();
			break;
		case 3:
			updateEmployee();
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

		sc.nextLine();
		System.out.println("\nIngrese el nombre del equipo A del club");
		String nameTA=sc.nextLine();

		System.out.println("\nIngrese el nombre del equipo B del club");
		String nameTB=sc.nextLine();

		
		club= new Club(name, nit, foundationDate, nameTA, nameTB);
		System.out.println("-----------------------------------------------------------");
	}

	public void hireEmployee(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("CONTRATAR EMPLEADO \n");
		boolean error;
		int option;
		String message="";
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
						
						if(position.equals("PORTERO")){
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
				boolean exit=false;
				System.out.println("\nIngrese los anios de experiencia del nuevo empleado");
				int yearsExperience=sc.nextInt();
				sc.nextLine();
				if(option==2){
					System.out.println("\nIngrese el numero de equipos a cargo en la carrera como manager del nuevo empleado");
					int numberTeams=sc.nextInt();
					sc.nextLine();


					ArrayList<String> championships= new ArrayList<String>();
					String championshipName, championshipYear, championship;
					
					System.out.println("\nHa conseguido algun campeonato? (1) Si,(Cualquier numero) No");
					int optionch=sc.nextInt();
					do{

						if(optionch==1){
							sc.nextLine();
							System.out.println("\nIngrese el nombre de un campeonato conseguido del nuevo empleado");
							championshipName=sc.nextLine();

							System.out.println("\nIngrese el anio del campeonato anterior");
							championshipYear=sc.nextLine();

							championship= championshipName+" ("+championshipYear+")";
							championships.add(championship);


							int same=0;
							for(int i=0; i<championships.size();i++){
								if(championship.equals(championships.get(i))){
									same++;
								}
							}

							if(same==2){
								championships.remove(championships.indexOf(championship));
								System.out.println("\nYa se habia ingresado ese campeonato");
							}

							System.out.println("Agregar otro campeonato? (1) Si, (Cualquier numero) No");
							int other=sc.nextInt();
							if(other!=1){
								exit=true;
							}

						}
						else{
							exit=true;
						}
					}while(!exit);


					message=club.hireEmployee(teamName, name, id, salary, yearsExperience, numberTeams, championships);
				}
				else{
					System.out.println("\nIngrese (1) si ha sido jugador profesional en algun momento de su vida, cualquier otro numero si no");
					int playerOp=sc.nextInt();
					boolean wasPlayer=false;
					if(playerOp==1){
						wasPlayer=true;
					}
					sc.nextLine();
					String[] skills= new String[club.getMAX_SKILLS()];
					
					int counter=0;
					exit=false;
					for(int i=0; i<skills.length && !exit;i++){

						do{
							System.out.println("\nIngrese la experticia del nuevo empleado (ofensivo, defensivo, posesion, jugadas de laboratorio, otra1, otra2)");
							skills[i]=sc.nextLine().toUpperCase();

							if(skills[i].equals("OFENSIVO") || skills[i].equals("DEFENSIVO") || skills[i].equals("POSESION")|| skills[i].equals("JUGADAS DE LABORATORIO") || skills[i].equals("OTRA1") || skills[i].equals("OTRA2")){
								if(skills[i].equals("OFENSIVO")){
									skills[i]="OFFENSIVE";
								}

								if(skills[i].equals("DEFENSIVO")){
									skills[i]="DEFENSIVE";
								}

								if(skills[i].equals("POSESION")){
									skills[i]="POSSESSION";
								}

								if(skills[i].equals("JUGADAS DE LABORATORIO")){
									skills[i]="LABORATORY_PLAYS";
								}

								if(skills[i].equals("OTRA1")){
									skills[i]="OTRA1";
								}

								if(skills[i].equals("OTRA2")){
									skills[i]="OTRA2";
								}
								control=false;
								counter++;

								for(int j=0; j<skills.length; j++){
									if(j!=i && skills[i]==skills[j]){
										System.out.println("\nYa se habia ingresado esa experticia");
										skills[i]=null;
										i--;
										counter--;
									}
								}
							}

							else{
								control=true;
								System.out.println("Experticia no valida. Ingrese nuevamente");

							}
							


						}while(control);
						if(counter!=club.getMAX_SKILLS()){
							System.out.println("Agregar otra experticia? (1) Si, (Cualquier numero) No");
							int other=sc.nextInt();
							if(other!=1){
								exit=true;
							}
							sc.nextLine();
						}

					}


					message=club.hireEmployee(teamName, name, id, salary, yearsExperience, wasPlayer, skills);
				}

				break;
		}

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}// end hire employee





	public void fireEmployee(){
		String message="";
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("DESPEDIR EMPLEADO \n");

		System.out.println("Ingrese el identificador del empleado a despedir");
		String id=sc.nextLine();
		message=club.fireEmployee(id);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	public void updateEmployee(){
		String message="";
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("ACTUALIZAR INFORMACION DE EMPLEADO \n");

		System.out.println("Ingrese el identificador del empleado a actualizar");
		String id=sc.nextLine();
		if(club.searchEmployee(id)==0){
			message="  Error. El identificador del empleado no se encuentra vinculado al club";
			System.out.println(message);
		}
		else{

			message="\n"+club.showEmployeeInfo(id);
			System.out.println(message);
			if(club.searchEmployee(id)==1){
				updatePlayer(id);
			}

			if(club.searchEmployee(id)==2){
				updateHeadCoach(id);
			}

			if(club.searchEmployee(id)==3){
				updateAssistantCoach(id);
			}
			
		}

		
		System.out.println("-----------------------------------------------------------");
	}

	public void updatePlayer(String id){
		int opt;
		String message="";
		do{
			System.out.println("Seleccione la opcion que desea actualizar \n"+
								"(1) Salario \n"+
								"(2) Numero de camiseta \n"+
								"(3) Cantidad de goles que ha marcado en el club \n"+
								"(4) Calificacion promedio \n"+
								"(5) Posicion dentro del terreno de juego \n"+
								"(6) Salir");
			opt=sc.nextInt();

			switch(opt){
				case 1:
					System.out.println("\nIngrese el nuevo salario");
					double salary=sc.nextDouble();
					message=club.updateSalary(id, salary)+"\n";
					break;

				case 2:
					System.out.println("\nIngrese el nuevo numero de camiseta");
					int number=sc.nextInt();
					message=club.updateNumberPlayer(id, number)+"\n";
					break;

				case 3:
					System.out.println("\nIngrese la nueva cantidad de goles que ha marcado en el club");
					int goals=sc.nextInt();
					message=club.updateGoalsPlayer(id, goals)+"\n";
					break;

				case 4:
					System.out.println("\nIngrese la nueva calificacion promedio");
					double averageRating=sc.nextDouble();
					message=club.updateAverageRatingPlayer(id, averageRating)+"\n";
					break;

				case 5:
					System.out.println("\nIngrese la nueva posicion dentro del terreno de juego");
					String position=sc.nextLine().toUpperCase();

					if(position.equals("PORTERO") || position.equals("DEFENSOR") || position.equals("VOLANTE") || position.equals("DELANTERO")){
						
						if(position.equals("PORTERO")){
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
						message=club.updatePosition(id, position)+"\n";

					}
					else{
						message="   Posicion no valida.";
					}

					
					break;

				case 6:
					message="";
					break;

				default:
					message=" Opcion no valida \n";
			}

		System.out.println(message);

		}while(opt!=6);

	}

	public void updateHeadCoach(String id){
		int opt;
		String message="";
		do{
			System.out.println("Seleccione la opcion que desea actualizar \n"+
								"(1) Salario \n"+
								"(2) Anios de experiencia \n"+
								"(3) Numero de equipos a cargo en la carrera como manager \n"+
								"(4) Agregar campeonato conseguido\n"+
								"(5) Salir");
			opt=sc.nextInt();

			switch(opt){
				case 1:
					System.out.println("\nIngrese el nuevo salario");
					double salary=sc.nextDouble();
					message=club.updateSalary(id, salary)+"\n";
					break;

				case 2:
					System.out.println("\nIngrese los anios de experiencia actualizados");
					int yearsExperience=sc.nextInt();
					message=club.updateYearsExperience(id, yearsExperience)+"\n";
					break;

				case 3:
					System.out.println("\nIngrese el numero de equipos a cargo en la carrera como manager actualizados");
					int numberTeams=sc.nextInt();
					message=club.updateNumberTeams(id, numberTeams)+"\n";
					break;

				case 4:
					
					String championshipName, championshipYear, championship;

					sc.nextLine();
					System.out.println("\nIngrese el nombre del campeonato conseguido");
					championshipName=sc.nextLine();

					System.out.println("\nIngrese el anio del campeonato");
					championshipYear=sc.nextLine();

					championship= championshipName+" ("+championshipYear+")";

					message=club.updateChampionships(id, championship)+"\n";					
					
					break;

				case 5:
					message="";
					break;


				default:
					message=" Opcion no valida \n";
			}

			System.out.println(message);

		}while(opt!=5);
	}

	public void updateAssistantCoach(String id){
		int opt;
		String message="";
		do{
			System.out.println("Seleccione la opcion que desea actualizar \n"+
						"(1) Salario \n"+
						"(2) Anios de experiencia \n"+
						"(3) Cambiar: Ha sido jugador profesional \n"+
						"(4) Agregar experticia\n"+
						"(5) Salir");
			opt=sc.nextInt();

			switch(opt){
				case 1:
					System.out.println("\nIngrese el nuevo salario");
					double salary=sc.nextDouble();
					message=club.updateSalary(id, salary)+"\n";
					break;

				case 2:
					System.out.println("\nIngrese los anios de experiencia actualizados");
					int yearsExperience=sc.nextInt();
					message=club.updateYearsExperience(id, yearsExperience)+"\n";
					break;

				case 3:
					
					message=club.updateWasPlayer(id)+"\n";
					break;

				case 4:

					sc.nextLine();
					System.out.println("\nIngrese la nueva experticia (ofensivo, defensivo, posesion, jugadas de laboratorio, otra1, otra2)");
					String skill=sc.nextLine().toUpperCase();
					
					if(skill.equals("OFENSIVO") || skill.equals("DEFENSIVO") || skill.equals("POSESION")|| skill.equals("JUGADAS DE LABORATORIO") || skill.equals("OTRA1") || skill.equals("OTRA2")){
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

						if(skill.equals("OTRA1")){
							skill="OTRA1";
						}

						if(skill.equals("OTRA2")){
							skill="OTRA2";
						}

						message=club.updateSkill(id, skill)+"\n";	
					}
					else{
						message="  Experticia no valida";
					}
					
					break;

				case 5:
					message="";
					break;


				default:
					message=" Opcion no valida \n";
			}

			System.out.println(message);

		}while(opt!=5);

	}



}
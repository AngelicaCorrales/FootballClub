package ui;
import java.util.*;
import model.Club;
public class Main{
	private Club club;
	private Scanner sc;

	/**
	*<b>name:</b> Main <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the relationships of the class have been initialized <br>
	*/
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
		}while(option!=9);
		
	}

	/**
	*<b>name:</b> showMenu <br>
	*This method shows the menu with the options that the user can choose <br>
	*<b>post:</b> the menu has been shown and the option chosen<br>
	*@return an <code>integer</code>  specifying option, the option chosen
	*/
	public int showMenu(){
		System.out.println("\n	MENU PRINCIPAL \n");
		System.out.println("Seleccione una opcion:\n"+
				"(1) Contratar empleado\n"+
				"(2) Despedir empleado \n"+
				"(3) Actualizar informacion de empleado \n"+
				"(4) Actualizar informacion de equipo\n"+
				"    Mostrar informacion de:\n"+
				"(5) todo el club\n"+
				"(6) equipos \n"+
				"(7) empleados \n"+
				"(8) instalaciones \n"+
				"(9) Salir");
		int option= sc.nextInt();
		return option;
	}

	/**
	*<b>name:</b> chosenOption <br>
	*This method does an action depending on the option chosen<br>
	*<b>post:</b> the action has been done<br>
	*@param op Is the option chosen.<br>
	*/
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
			updateTeam();
			break;
		case 5:
			showClub();
			break;
		case 6:
			showTeams();
			break;
		case 7:
			showEmployees();
			break;

		case 8:
			showFacilities();
			break;
				
		case 9:
			System.out.println("\nHasta la proxima!");
			break;
			
		default:
			System.out.println("\n Error, opcion no valida \n");
		
		}
	}

	/**
	*<b>name:</b> createClub <br>
	*This method initializes a Club object<br>
	*<b>post:</b> the Club object has been initialized <br>
	*/
	public void createClub(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("	FOOTBALL CLUB \n");

		String name;
		do{
			System.out.println("Ingrese el nombre del club");
			name=sc.nextLine();
		}while(name.equals(""));

		String nit;
		do{
			System.out.println("\nIngrese el NIT que identifica el club");
			nit=sc.nextLine();
		}while(nit.equals(""));

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

		String teamNameA;
		do{
			System.out.println("\nIngrese el nombre del equipo A del club");
			teamNameA=sc.nextLine();
		}while(teamNameA.equals(""));

		String teamNameB;
		do{
			System.out.println("\nIngrese el nombre del equipo B del club");
			teamNameB=sc.nextLine();
		}while(teamNameB.equals(""));

		
		club= new Club(name, nit, foundationDate, teamNameA, teamNameB);
		System.out.println("-----------------------------------------------------------");
	}

	/**
	*<b>name:</b> hireEmployee <br>
	*This method hires an employee<br>
	*<b>post:</b> the employee has been hired<br>
	*/
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
			System.out.println("\nIngrese el equipo al que va a pertenecer el nuevo empleado (A o B)");
			team=sc.nextLine().toUpperCase();
			if(!team.equals("A") && !team.equals("B")){
				error=true;
			}

		}while(error);
		char teamX=team.charAt(0);

		String name;
		do{
			System.out.println("\nIngrese el nombre del nuevo empleado");
			name=sc.nextLine();
		}while(name.equals(""));

		String id;
		do{
			System.out.println("\nIngrese el identificador del nuevo empleado");
			id=sc.nextLine();
		}while(id.equals(""));

		double salary;
		do{
			System.out.println("\nIngrese el salario del nuevo empleado");
			salary=sc.nextDouble();
		}while(salary<0);

		switch(option){
			case 1:
				int number;
				do{
					System.out.println("\nIngrese el numero de camiseta");
					number=sc.nextInt();
				}while(number<1 || number>99);

				boolean control;
				double averageRating;
				do{
					control=false;
					System.out.println("\nIngrese la calificacion promedio del jugador (1 a 10)");
					averageRating=sc.nextDouble();
					if(averageRating<1 || averageRating>10){
						control=true;
					}
				}while(control);

				sc.nextLine();
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

				message=club.hireEmployee(teamX, name, id, salary, number, averageRating, position);

				break;

			case 2:
			case 3:
				boolean exit=false;
				int yearsExperience;
				do{
					System.out.println("\nIngrese los anios de experiencia del nuevo empleado");
					yearsExperience=sc.nextInt();
				}while(yearsExperience<0 || yearsExperience>80);

				sc.nextLine();
				if(option==2){
					int numberTeams;
					do{
						System.out.println("\nIngrese el numero de equipos a cargo en la carrera como manager del nuevo empleado");
						numberTeams=sc.nextInt();
					}while(numberTeams<0);
					sc.nextLine();


					ArrayList<String> championships= new ArrayList<String>();
					String championshipName, championshipYear, championship;
					
					System.out.println("\nHa conseguido algun campeonato? (1) Si,(Cualquier numero) No");
					int optionch=sc.nextInt();
					do{

						if(optionch==1){
							sc.nextLine();
							do{
								System.out.println("\nIngrese el nombre de un campeonato conseguido del nuevo empleado");
								championshipName=sc.nextLine();
							}while(championshipName.equals(""));

							do{
								System.out.println("\nIngrese el anio del campeonato anterior");
								championshipYear=sc.nextLine();
							}while(championshipYear.equals(""));

							championship= championshipName+" ("+championshipYear+")";
							championships.add(championship);


							int same=0;
							for(int i=0; i<championships.size();i++){
								if(championship.equalsIgnoreCase(championships.get(i))){
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


					message=club.hireEmployee(teamX, name, id, salary, yearsExperience, numberTeams, championships);
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
							System.out.println("\nIngrese la experticia del nuevo empleado (ofensivo, defensivo, posesion, jugadas de laboratorio, psicologo, fisioterapeuta)");
							skills[i]=sc.nextLine().toUpperCase();

							if(skills[i].equals("OFENSIVO") || skills[i].equals("DEFENSIVO") || skills[i].equals("POSESION")|| skills[i].equals("JUGADAS DE LABORATORIO") || skills[i].equals("PSICOLOGO") || skills[i].equals("FISIOTERAPEUTA")){
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

								if(skills[i].equals("PSICOLOGO")){
									skills[i]="PSYCHOLOGIST";
								}

								if(skills[i].equals("FISIOTERAPEUTA")){
									skills[i]="PHYSIOTHERAPIST";
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


					message=club.hireEmployee(teamX, name, id, salary, yearsExperience, wasPlayer, skills);
				}

				break;
		}

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}// end hire employee




	/**
	*<b>name:</b> fireEmployee <br>
	*This method fires an employee<br>
	*<b>post:</b> the employee has been fired<br>
	*/
	public void fireEmployee(){
		String message="";
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("DESPEDIR EMPLEADO \n");

		String id;
		do{
			System.out.println("Ingrese el identificador del empleado a despedir");
			id=sc.nextLine();
		}while(id.equals(""));
		message=club.fireEmployee(id);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}


	/**
	*<b>name:</b> updateEmployee <br>
	*This method updates an employee's information<br>
	*<b>post:</b> the employee' information has been updated<br>
	*/
	public void updateEmployee(){
		String message="";
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("ACTUALIZAR INFORMACION DE EMPLEADO \n");
		String id;
		do{
			System.out.println("Ingrese el identificador del empleado a actualizar");
			id=sc.nextLine();
		}while(id.equals(""));

		if(club.searchEmployee(id)==0){
			message="  Error. El identificador del empleado no se encuentra vinculado al club";
			System.out.println(message);
		}
		else{

			message="\n"+club.showEmployee(id);
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

	/**
	*<b>name:</b> updatePlayer <br>
	*This method updates a player's information<br>
	*<b>post:</b> the player's information has been updated<br>
	*@param id Is the identifier of the player. id!=null <br>
	*/
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
					double salary;
					do{
						System.out.println("\nIngrese el nuevo salario");
						salary=sc.nextDouble();
					}while(salary<0);
					message=club.updateSalary(id, salary)+"\n";
					break;

				case 2:
					int number;
					do{
						System.out.println("\nIngrese el nuevo numero de camiseta");
						number=sc.nextInt();
					}while(number<1 || number>99);
					message=club.updateNumberPlayer(id, number)+"\n";
					break;

				case 3:
					int goals;
					do{
						System.out.println("\nIngrese la nueva cantidad de goles que ha marcado en el club");
						goals=sc.nextInt();
					}while(goals<0);
					message=club.updateGoalsPlayer(id, goals)+"\n";
					break;

				case 4:
					double averageRating;
					do{
						System.out.println("\nIngrese la nueva calificacion promedio (1 a 10)");
						averageRating=sc.nextDouble();
						
					}while(averageRating<1 || averageRating>10);
					message=club.updateAverageRatingPlayer(id, averageRating)+"\n";
					break;

				case 5:
					sc.nextLine();
					System.out.println("\nIngrese la nueva posicion dentro del terreno de juego (portero, defensor, volante o delantero)");
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

	/**
	*<b>name:</b> updateHeadCoach <br>
	*This method updates a head coach's information<br>
	*<b>post:</b> the head coach's information has been updated<br>
	*@param id Is the identifier of the player. id!=null <br>
	*/
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
					double salary;
					do{
						System.out.println("\nIngrese el nuevo salario");
						salary=sc.nextDouble();
					}while(salary<0);
					message=club.updateSalary(id, salary)+"\n";
					break;

				case 2:
					int yearsExperience;
					do{
						System.out.println("\nIngrese los anios de experiencia actualizados");
						yearsExperience=sc.nextInt();
					}while(yearsExperience<0 || yearsExperience>80);
					message=club.updateYearsExperience(id, yearsExperience)+"\n";
					break;

				case 3:
					int numberTeams;
					do{
						System.out.println("\nIngrese el numero de equipos a cargo en la carrera como manager actualizados");
						numberTeams=sc.nextInt();
					}while(numberTeams<0);
					message=club.updateNumberTeams(id, numberTeams)+"\n";
					break;

				case 4:
					
					String championshipName, championshipYear, championship;

					sc.nextLine();
					do{
						System.out.println("\nIngrese el nombre del campeonato conseguido");
						championshipName=sc.nextLine();
					}while(championshipName.equals(""));

					do{
						System.out.println("\nIngrese el anio del campeonato");
						championshipYear=sc.nextLine();
					}while(championshipYear.equals(""));


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

	/**
	*<b>name:</b> updateAssistantCoach <br>
	*This method updates a assistant coach's information<br>
	*<b>post:</b> the assistant coach's information has been updated<br>
	*@param id Is the identifier of the player. id!=null <br>
	*/
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
					double salary;
					do{
						System.out.println("\nIngrese el nuevo salario");
						salary=sc.nextDouble();
					}while(salary<0);
					message=club.updateSalary(id, salary)+"\n";
					break;

				case 2:
					int yearsExperience;
					do{
						System.out.println("\nIngrese los anios de experiencia actualizados");
						yearsExperience=sc.nextInt();
					}while(yearsExperience<0 || yearsExperience>80);
					message=club.updateYearsExperience(id, yearsExperience)+"\n";
					break;

				case 3:
					
					message=club.updateWasPlayer(id)+"\n";
					break;

				case 4:

					sc.nextLine();
					System.out.println("\nIngrese la nueva experticia (ofensivo, defensivo, posesion, jugadas de laboratorio, psicologo, fisioterapeuta)");
					String skill=sc.nextLine().toUpperCase();
					
					if(skill.equals("OFENSIVO") || skill.equals("DEFENSIVO") || skill.equals("POSESION")|| skill.equals("JUGADAS DE LABORATORIO") || skill.equals("PSICOLOGO") || skill.equals("FISIOTERAPEUTA")){
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

						if(skill.equals("PSICOLOGO")){
							skill="PSYCHOLOGIST";
						}

						if(skill.equals("FISIOTERAPEUTA")){
							skill="PHYSIOTHERAPIST";
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

	/**
	*<b>name:</b> updateTeam <br>
	*This method updates a team's information<br>
	*<b>post:</b> the team's information has been updated<br>
	*/
	public void updateTeam(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("ACTUALIZAR INFORMACION DE EQUIPO\n");
		boolean error;
		int opt;
		String message="";

		String team;
		sc.nextLine();
		do{
			error= false;
			System.out.println("\nIngrese el equipo a actualizar (A o B)");
			team=sc.nextLine().toUpperCase();
			if(!team.equals("A") && !team.equals("B")){
				error=true;
			}

		}while(error);
		char teamX=team.charAt(0);

		do{
			System.out.println("\nSeleccione la opcion que desea actualizar \n"+
						"(1) Nombre del equipo \n"+
						"(2) Agregar alineacion\n"+
						"(3) Salir");
			opt=sc.nextInt();

			
			switch(opt){
				case 1:
					sc.nextLine();
					String teamName;
					do{
						System.out.println("\nIngrese el nuevo nombre del equipo");
						teamName=sc.nextLine();
					}while(teamName.equals(""));
					message=club.updateTeamName(teamX, teamName);
					break;

				case 2:
					int day,month, year;
					System.out.println("\nFECHA DE ALINEACION (primero el dia, luego mes, por ultimo anio");
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

					String dateLineup=day+"/"+month+"/"+year;

					sc.nextLine();
					boolean control;
					String tactic;
					do{
						System.out.println("\nIngrese la tactica (posesion, contraataque, presion alta, o por defecto)");
						tactic=sc.nextLine().toUpperCase();
							if(tactic.equals("POSESION") || tactic.equals("CONTRAATAQUE") || tactic.equals("PRESION ALTA") || tactic.equals("POR DEFECTO")){
						
								if(tactic.equals("POSESION")){
									tactic= "POSSESSION";
								}

								if(tactic.equals("CONTRAATAQUE")){
									tactic="COUNTERATTACK";
								}

								if(tactic.equals("PRESION ALTA")){
									tactic="HIGH_PRESSURE";
								}

								if(tactic.equals("POR DEFECTO")){
									tactic="DEFAULT";
								}
								control=false;

							}
							else{
								control=true;
								System.out.println("Tactica no valida. Ingrese nuevamente");
							}
					}while(control);

					System.out.println("\nFORMACION EN EL CAMPO");
					int defenders, midfielders, fordwards;
					do{
						do{
							System.out.println("\nIngrese el numero de defensores");
							defenders=sc.nextInt();
							if(defenders<1 || defenders>8){
								System.out.println("\n   No valido");
								control=true;
							}
							else{
								control=false;
							}

						}while(control);

						do{
							System.out.println("\nIngrese el numero de volantes");
							midfielders=sc.nextInt();
							if(midfielders<1 || midfielders>8){
								System.out.println("\n   No valido");
								control=true;
							}
							else{
								control=false;
							}
						}while(control);

						do{
							System.out.println("\nIngrese el numero de delanteros");
							fordwards=sc.nextInt();
							if(fordwards<1 || fordwards>8){
								System.out.println("\n   No valido");
								control=true;
							}
							else{
								control=false;
							}
						}while(control);

						int total=defenders+midfielders+fordwards;

						if(total!=10){
							System.out.println("Error. No hay diez jugadores en el campo. Ingrese nuevamente");
							control=true;
						}
					}while(control);

					message=club.addLineup(teamX, dateLineup, tactic, defenders, midfielders, fordwards);

					break;

				case 3:
					message="";
					break;


				default:
					message=" Opcion no valida \n";
			}

			System.out.println(message);



		}while(opt!=3);
		System.out.println("-----------------------------------------------------------");

	}

	/**
	*<b>name:</b> showFacilities <br>
	*This method shows the club's facilities<br>
	*<b>post:</b> the club's facilities have been shown<br>
	*/
	public void showFacilities(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR INFORMACION DE INSTALACIONES\n");

		System.out.println(club.showFacilities());

		System.out.println("-----------------------------------------------------------");
	}

	/**
	*<b>name:</b> showEmployees <br>
	*This method shows the employees<br>
	*<b>post:</b> the employees have been shown<br>
	*/
	public void showEmployees(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR INFORMACION DE EMPLEADOS\n");
		int opt;
		String message="";
		do{
			System.out.println("Seleccione una opcion\n"+
							"(1) Todos los empleados \n"+
							"(2) Un empleado particular");

			opt=sc.nextInt();
		}while(opt!=1 && opt!=2);

		switch(opt){
			case 1:
				message=club.showAllEmployees();
				break;

			case 2: 
				sc.nextLine();
				String id;
				do{
					System.out.println("\nIngrese el identificador del empleado");
					id=sc.nextLine();
				}while(id.equals(""));
				message=club.showEmployee(id);
				break;

		}

		System.out.println(message);

		System.out.println("-----------------------------------------------------------");
	}

	/**
	*<b>name:</b> showTeams <br>
	*This method shows the club's teams<br>
	*<b>post:</b> the club's teams have been shown<br>
	*/
	public void showTeams(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR INFORMACION DE EQUIPOS\n");
		int opt;
		String message="";
		do{
			System.out.println("Seleccione una opcion\n"+
							"(1) Ambos los equipos \n"+
							"(2) Un equipo particular");

			opt=sc.nextInt();
		}while(opt!=1 && opt!=2);

		switch(opt){
			case 1:
				message=club.showAllTeams();
				break;

			case 2:
				String team;
				sc.nextLine();
				do{
					
					System.out.println("\nIngrese el equipo (A o B)");
					team=sc.nextLine().toUpperCase();
					
				}while(!team.equals("A") && !team.equals("B"));
				char teamX=team.charAt(0);
				message=club.showTeam(teamX);
				break;
		}

		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	/**
	*<b>name:</b> showClub<br>
	*This method shows the club's information<br>
	*<b>post:</b> the club's information has been shown<br>
	*/
	public void showClub(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR INFORMACION DE TODO EL CLUB\n");

		System.out.println(club.showClub());

		System.out.println("-----------------------------------------------------------");
	}

}
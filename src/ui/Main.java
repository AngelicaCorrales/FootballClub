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
				"(3) Agregar jugador a equipo\n"+
				"(4) Agregar entrenador a equipo \n"+
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

}
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

	public String hireEmployee(char teamName, String name, String id, double salary, int number, String position){
		//player
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int yearsExperience, int numberTeams, int numberChampionships){
		//headCoach
	}

	public String hireEmployee(char teamName, String name, String id, double salary, int yearsExperience, boolean wasPlayer, String skill){
		//assistantCoach
	}

}
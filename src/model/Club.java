package model;
import java.util.*;

public class Club{
	//constants
	public final static int MAX_TEAMS= 2;
	public final static int MAX_OFFICE_ROWS= 6;
	public final static int MAX_OFFICE_COLS= 6;


	//attributes
	private String name;
	private String nit;
	private String foundationDate;

	//relationships
	private Team[] teams;
	private Arraylist<Employee> employees;
	private Coach[][] office;//[6][6]

	public Club(String name, String nit, String foundationDate){
		this.name=name;
		this.nit=nit;
		this.foundationDate=foundationDate;

		teams=new Team[MAX_TEAMS];
		employees=new Arraylist<Employee>();
		office= new Coach[MAX_OFFICE_ROWS][MAX_OFFICE_COLS];

	}

}
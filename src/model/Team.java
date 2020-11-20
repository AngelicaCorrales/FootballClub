package model;
import java.util.*;
public class Team{
	//constants
	public final static int MAX_PLAYERS=25;

	public final static int MAX_CR1_ROWS=7;
	public final static int MAX_CR1_COLS=6;

	public final static int MAX_CR2_ROWS=7;
	public final static int MAX_CR2_COLS=7;

	public final static int MAX_AS_COACHES=3;
	

	//attributes
	private char name;
	private Player[] players;
	private Player[][] changingRoom1;
	private Player[][] changingRoom2;

	private AssistantCoach[] assistantCoaches;
	private HeadCoach headCoach;

	private ArrayList<Lineup> lineups;

	public Team(){
		name='';
		players=new Player[MAX_PLAYERS];
		changingRoom1=new Player[MAX_CR1_ROWS][MAX_CR1_COLS];
		changingRoom2=new Player[MAX_CR2_ROWS][MAX_CR2_COLS];
		assistantCoaches=new AssistantCoach[MAX_AS_COACHES];
		lineups=new ArrayList<Lineup>();
		headCoach=null;


	}

}
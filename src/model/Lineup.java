package model;
public class Lineup{
	
	//constants
	public final static int MAX_FORMATION_ROWS=10;
	public final static int MAX_FORMATION_COLS=7;

	//attributes
	private String date;
	private int[][] formation;
	private Tactic tactic;

	public Lineup(String date, String tactic){
		this.date=date;
		this.formation=new int[MAX_FORMATION_ROWS][MAX_FORMATION_COLS];
		this.tactic=Tactic.valueOf(tactic);
	}

}
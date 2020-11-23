package model;
public class Player extends Employee implements Price, Level{
	//attributes
	private int number;
	private int goals;
	private double averageRating;
	private Position position; 

	public Player(String name, String id, double salary,  int number, String position){
		super( name,  id,  salary);
		this.number=number;
		this.goals=0;
		this.averageRating=0;
		this.position=Position.valueOf(position);
	}

	public int getNumber(){
		return number;
	}

}
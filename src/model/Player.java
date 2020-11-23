package model;
public class Player extends Employee implements Price, Level{
	//attributes
	private int number;
	private int goals;
	private double averageRating;
	private Position position; 

	public Player(String name, String id, double salary,  int number,  double averageRating, String position){
		super( name,  id,  salary);
		this.number=number;
		this.goals=0;
		this.averageRating=averageRating;
		this.position=Position.valueOf(position);
	}

}
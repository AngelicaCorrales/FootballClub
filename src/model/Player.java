package model;
public class Player extends Employee implements Price, Level{
	//attributes
	private int number;
	private int goals;
	private double averageRating;
	private Position position; 

	public Player(String name, String id, double salary, boolean activeStatus, int number, int goals, double averageRating, String position){
		super( name,  id,  salary,  activeStatus);
		this.number=number;
		this.goals=goals;
		this.averageRating=averageRating;
		this.position=Position.valueOf(position);
	}

}
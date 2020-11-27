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

	public void setNumber(int number){
		this.number=number;
	}
	public int getNumber(){
		return number;
	}

	public void setGoals(int goals){
		this.goals=goals;
	}

	public void setAverageRating(double averageRating){
		this.averageRating=averageRating;
	}

	public void setPosition(String position){
		this.position=Position.valueOf(position);
	}

	public double calculatePrice(){
		return 1;
	}

	public double calculateLevel(){
		return 1;
	}

	public String toString(){
		return super.toString()+"*Numero de camiseta: "+number+"\n"+
								"*Cantidad de goles que ha marcado en el club: "+goals+"\n"+
								"*Calificacion promedio: "+averageRating+"\n"+
								"*Posicion: "+position.name()+"\n"+
								"*Precio del mercado: "+calculatePrice()+"\n"+
								"*Nivel: "+calculateLevel()+"\n";
	}

}
package model;
public class Player extends Employee implements Price, Level{
	//attributes
	private int number;
	private int goals;
	private double averageRating;
	private Position position; 

	public Player(String name, String id, double salary,  int number, double averageRating, String position){
		super( name,  id,  salary);
		this.number=number;
		this.goals=0;
		this.averageRating=averageRating;
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
		double price=0;
		if(position==Position.GOALKEEPER){
			price=(getSalary()*12)+(averageRating*150);
		}

		if(position==Position.DEFENDER){
			price=(getSalary()*13)+(averageRating*125)+(goals*100);
		}

		if(position==Position.MIDFIELDER){
			price=(getSalary()*14)+(averageRating*135)+(goals*125);
		}

		if(position==Position.FORDWARD){
			price=(getSalary()*15)+(averageRating*145)+(goals*150);
		}

		return price;
	}
	

	public int calculateLevel(){
		int level=0;
		if(position==Position.GOALKEEPER){
			level=(int)(averageRating*0.9);
		}

		if(position==Position.DEFENDER){
			level=(int)((averageRating*0.9)+(goals/100));
		}

		if(position==Position.MIDFIELDER){
			level=((int)(averageRating*0.9)+(goals/90));
		}

		if(position==Position.FORDWARD){
			level=(int)((averageRating*0.9)+(goals/80));
		}

		return level;
	}
	

	public String toString(){
		return super.toString()+"*Numero de camiseta: "+number+"\n"+
								"*Cantidad de goles que ha marcado en el club: "+goals+"\n"+
								"*Calificacion promedio: "+averageRating+"\n"+
								"*Posicion: "+position.name()+"\n"+
								"*Precio del mercado: $"+calculatePrice()+"\n"+
								"*Nivel: "+calculateLevel()+"\n";
	}

}
package model;
public class Player extends Employee implements Price, Level{
	//attributes
	private int number;
	private int goals;
	private double averageRating;

	//relationship
	private Position position; 

	/**
	*<b>name:</b> Player <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the attributes and relationships of the class have been initialized<br>
	*@param name Is the name of the player. name!=null and name!=""<br>
	*@param id Is the identifier of the player. id!=null, id!=""<br>
	*@param salary Is the salary of the player. salary greater than 0<br>
	*@param number Is the T-shirt number of the player. number from 1 to 99<br>
	*@param averageRating Is the average rating of the player. averageRating from 1 to 10<br>
	*@param position Is the position of the player on the field. position!=null and position!=""<br>
	*/
	public Player(String name, String id, double salary,  int number, double averageRating, String position){
		super( name,  id,  salary);
		this.number=number;
		this.goals=0;
		this.averageRating=averageRating;
		this.position=Position.valueOf(position);
	}

	/**
	*<b>name:</b> getNumber<br>
	*This method gets the T-shirt number of the player <br>
	*<b>post:</b> the T-shirt number of the player has been gotten <br>
	*@return an <code>integer</code> specifying number, the T-shirt number of the player
	*/
	public int getNumber(){
		return number;
	}

	/**
	*<b>name:</b> setNumber<br>
	*This method sets the T-shirt number of the player <br>
	*<b>post:</b> the T-shirt number of the player has been set <br>
	*@param number Is the T-shirt number of the player. number from 1 to 99<br>
	*/
	public void setNumber(int number){
		this.number=number;
	}
	
	/**
	*<b>name:</b> getGoals<br>
	*This method gets the number of goals the player has scored <br>
	*<b>post:</b> the number of goals the player has scored has been gotten <br>
	*@return an <code>integer</code> specifying goals, the number of goals the player has scored
	*/
	public int getGoals(){
		return goals;
	}

	/**
	*<b>name:</b> setGoals<br>
	*This method sets the number of goals the player has scored <br>
	*<b>post:</b> the number of goals the player has scored has been set <br>
	*@param goals Is the number of goals the player has scored. goals greater than 0<br>
	*/
	public void setGoals(int goals){
		this.goals=goals;
	}

	/**
	*<b>name:</b> getAverageRating<br>
	*This method gets the average rating of the player <br>
	*<b>post:</b> the average rating of the player has been gotten <br>
	*@return a <code>double</code> specifying averageRating, the average rating of the player
	*/
	public double getAverageRating(){
		return averageRating;
	}

	/**
	*<b>name:</b> setAverageRating<br>
	*This method sets the average rating of the player <br>
	*<b>post:</b> the average rating of the player has been set <br>
	*@param averageRating Is the average rating of the player. averageRating from 1 to 10<br>
	*/
	public void setAverageRating(double averageRating){
		this.averageRating=averageRating;
	}

	/**
	*<b>name:</b> getPosition<br>
	*This method gets the position of the player on the field <br>
	*<b>post:</b> the position of the player on the field has been gotten <br>
	*@return a <code>Position</code> specifying position, the position of the player on the field
	*/
	public Position getPosition(){
		return position;
	}

	/**
	*<b>name:</b> setPosition<br>
	*This method sets the position of the player on the field <br>
	*<b>post:</b> the position of the player on the field has been set <br>
	*@param position Is the position of the player on the field. position!=null and position!=""<br>
	*/
	public void setPosition(String position){
		this.position=Position.valueOf(position);
	}

	/**
	*<b>name:</b> calculatePrice <br>
	*This method calculates the market price of the player<br>
	*<b>post:</b> the market price of the player has been calculated <br>
	*@return a <code>double</code> specifying the market price of the player
	*/
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
	
	/**
	*<b>name:</b> calculateLevel <br>
	*This method calculates the level of the player<br>
	*<b>post:</b> the level of the player has been calculated <br>
	*@return an <code>integer</code> specifying the level of the player
	*/
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
	
	/**
	*<b>name:</b> toString <br>
	*This method return the name, id, salary, status, t-shirt number, goals, average rating, position, market price and level  of the player on a string<br>
	*<b>post:</b> the name, id, salary, status, t-shirt number, goals, average rating, position, market price and level  of the player have been returned<br>
	*@return a <code>string</code> specifying the name, id, salary, status, t-shirt number, goals, average rating, position, market price and level  of the player
	*/
	@Override
	public String toString(){
		return super.toString()+"*Numero de camiseta: "+number+"\n"+
								"*Cantidad de goles que ha marcado en el club: "+goals+"\n"+
								"*Calificacion promedio: "+averageRating+"\n"+
								"*Posicion: "+position.name()+"\n"+
								"*Precio del mercado: $"+calculatePrice()+"\n"+
								"*Nivel: "+calculateLevel()+"\n";
	}

}
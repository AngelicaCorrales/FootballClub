package model;

public abstract class Coach extends Employee{
	//attributes
	private int yearsExperience;

	/**
	*<b>name:</b> Coach <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the attributes of the class have been initialized<br>
	*@param name Is the name of the coach. name!=null and name!=""<br>
	*@param id Is the identifier of the coach. id!=null, id!=""<br>
	*@param salary Is the salary of the coach. salary greater than 0<br>
	*@param yearsExperience Is the years of experience of the coach. yearsEmperience greater than 0 and less than 80<br>
	*/
	public Coach(String name, String id, double salary, int yearsExperience){
		super( name,  id,  salary);
		this.yearsExperience=yearsExperience;
	}


	/**
	*<b>name:</b> getYearsExperience <br>
	*This method gets the years of experience of the coach <br>
	*<b>post:</b> the years of experience of the coach has been gotten <br>
	*@return a <code>integer</code> specifying yearsExperience, the years of experience of the coach 
	*/
	public int getYearsExperience(){
		return yearsExperience;
	}

	/**
	*<b>name:</b> setYearsExperience<br>
	*This method sets the years experience of the coach <br>
	*<b>post:</b> the years experience of the coach has been set <br>
	*@param yearsExperience Is the years of experience of the coach. yearsEmperience greater than 0 and less than 80<br>
	*/
	public void setYearsExperience(int yearsExperience){
		this.yearsExperience=yearsExperience;
	}
	
	/**
	*<b>name:</b> toString <br>
	*This method return the name, id, salary, status and years of experience of the coach on a string<br>
	*<b>post:</b> the name, id, salary, status and years of experience of the coach have been returned<br>
	*@return a <code>string</code> specifying the name, id, salary, status and years of experience of the coach
	*/
	@Override
	public String toString(){
		return super.toString()+"*Anios de experiencia: "+yearsExperience+"\n";
	}
}
package model;
public class Lineup{
	
	//constants
	public final static int MAX_FORMATION_ROWS=10;
	public final static int MAX_FORMATION_COLS=7;

	//attributes
	private String date;
	private int[][] formation;

	//relationship
	private Tactic tactic;

	/**
	*<b>name:</b> Lineup <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the attributes and relationships of the class have been initialized<br>
	*@param date Is the date of the lineup. date!=null and date!=""<br>
	*@param tactic Is the tactic of the lineup. tactic!=null and tactic!=""<br>
	*/
	public Lineup(String date, String tactic){
		this.date=date;
		this.formation=new int[MAX_FORMATION_ROWS][MAX_FORMATION_COLS];
		this.tactic=Tactic.valueOf(tactic);
	}

	/**
	*<b>name:</b> getDate <br>
	*This method gets the date of the lineup <br>
	*<b>post:</b> the date of the lineup has been gotten <br>
	*@return a <code>string</code> specifying date, the date of the lineup 
	*/
	public String getDate(){
		return date;
	}

	/**
	*<b>name:</b> setDate<br>
	*This method sets the date of the lineup <br>
	*<b>post:</b> the date of the lineup has been set <br>
	*@param date Is the date of the lineup. date!=null and date!=""<br>
	*/
	public void setDate(String date){
		this.date=date;
	}

	/**
	*<b>name:</b> getFormation <br>
	*This method gets the formation of the lineup <br>
	*<b>post:</b> the formation of the lineup have been gotten <br>
	*@return a matrix of <code>integer</code> specifying formation, the formation of the lineup 
	*/
	public int[][] getFormation(){
		return formation;
	}

	/**
	*<b>name:</b> setFormation<br>
	*This method sets the formation of the lineup <br>
	*<b>post:</b> the formationof the lineup have been set <br>
	*@param formation Is a matrix of the formation of the lineup. formation!=null<br>
	*/
	public void setFormation(int[][] formation){
		this.formation=formation;
	}

	/**
	*<b>name:</b> getTactic <br>
	*This method gets the tactic of the lineup <br>
	*<b>post:</b> the tactic of the lineup has been gotten <br>
	*@return a <code>Tactic</code> specifying tactic, the tactic of the lineup 
	*/
	public Tactic getTactic(){
		return tactic;
	}

	/**
	*<b>name:</b> setTactic<br>
	*This method sets the tactic of the lineup <br>
	*<b>post:</b> the tactic of the lineup has been set <br>
	*@param tactic Is the tactic of the lineup. tactic!=null and tactic!=""<br>
	*/
	public void setTactic(Tactic tactic){
		this.tactic=tactic;
	}

	/**
	*<b>name:</b> formationMatrix <br>
	*This method fills the formation matrix<br>
	*<b>post:</b> the formation matrix has been filled<br>
	*@param defenders Is the number of defenders of the formation. defenders greater than or equal to 1, defenders less than or equal to 8<br>
	*@param midfielders Is the number of midfielders of the formation. midfielders greater than or equal to 1, midfieldders less than or equal to 8<br>
	*@param fordwards Is the number of fordwards of the formation. fordwars greater than or equal to 1, fordwards less than or equal to 8<br>
	*/
	public void formationMatrix(int defenders, int midfielders, int fordwards){
		int aux=0;
		int aux2=0;
		for(int i=MAX_FORMATION_ROWS-2; i>0; i--){
			aux=0;
			if(i==MAX_FORMATION_ROWS-2){
				aux=defenders;
			}

			if(i==MAX_FORMATION_ROWS-5){
				aux=midfielders;
				aux2=0;
			}

			if(i==MAX_FORMATION_ROWS-8){
				aux=fordwards;
				aux2=0;
			}


			if(aux2!=0){
				aux=aux2;
				aux2=0;
			}

			if(aux>4){
				aux2=aux-4;
				aux=4;

			}


			for(int j=0; j<MAX_FORMATION_COLS;j++){
			

				if(aux==4){
					if(j!=0 && j!=3 && j!=MAX_FORMATION_COLS-1){
						formation[i][j]=1;
					}
				}

				if(aux==3){
					if(j==2 || j==3 || j==4){
						formation[i][j]=1;
					}
				}

				if(aux==2){
					if(j==2 || j==4){
						formation[i][j]=1;
					}
				}

				if(aux==1){
					if(j==3){
						formation[i][j]=1;
					}
				}
			}
		}

	}

	/**
	*<b>name:</b> formationMatrixToString <br>
	*This method returns the formation matrix in a string<br>
	*<b>post:</b> the formation matrix has been returned as a string<br>
	*@return a <code>string</code> specifying message, the message  of the formation matrix in a string
	*/
	public String formationMatrixToString(){
		String message="\n     ";
		for(int i=0; i<MAX_FORMATION_ROWS; i++){
			for(int j=0; j<MAX_FORMATION_COLS;j++){
				message+=formation[i][j];
			
			}
			message+="\n     ";
		}
		return message;
	}


	/**
	*<b>name:</b> formationForMedia <br>
	*This method returns the formation for media<br>
	*<b>post:</b> the formation for media has been returned<br>
	*@return a <code>string</code> specifying message, the message  of the formation for media
	*/
	public String formationForMedia(){
		String message="";
		int defenders=0;
		int midfielders=0;
		int fordwards=0;
		for(int i=MAX_FORMATION_ROWS-2; i>0; i--){
			for(int j=1; j<MAX_FORMATION_COLS-1;j++){
				if(i==MAX_FORMATION_ROWS-2 || i== MAX_FORMATION_ROWS-3){
					defenders+=formation[i][j];
				}

				if(i==MAX_FORMATION_ROWS-5 || i== MAX_FORMATION_ROWS-6){
					midfielders+=formation[i][j];
				}

				if(i==MAX_FORMATION_ROWS-8 || i== MAX_FORMATION_ROWS-9){
					fordwards+=formation[i][j];
				}
			
			}
		}
		message=defenders+"-"+midfielders+"-"+fordwards;
		return message;
	}

	/**
	*<b>name:</b> toString <br>
	*This method return the date, formation and tactic of the lineup on a string<br>
	*<b>post:</b> the date, formation and tactic of the lineup have been returned<br>
	*@return a <code>string</code> specifying the date, formation and tactic of the lineup
	*/
	public String toString(){
		return "**ALINEACION**\n"+
				"*Fecha: "+date+"\n"+
				"*Formacion: "+formationForMedia()+"\n"+
				"*Tactica: "+tactic.name()+"\n";
	}

	

}
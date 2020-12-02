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

	public String getDate(){
		return date;
	}

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

	public String toString(){
		return "**ALINEACION**\n"+
				"*Fecha: "+date+"\n"+
				"*Formacion: "+formationForMedia()+"\n"+
				"*Tactica: "+tactic.name()+"\n";
	}

	

}
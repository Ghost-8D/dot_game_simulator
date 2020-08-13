/**
*  Author:        Panayiotis Leontiou
*  Written:       06/11/2016
*  Last updated:  13/8/2020
*
*  Compilation:   javac -cp ./stdlib.jar DotGameSimulator.java
*  Execution:     java -cp .:./stdlib.jar DotGameSimulator
*  
*  To programma lamvanei apo ti grammi entolis ena fisiko akeraio arithmo N, pou antiprosopevei
*  ena tetragoniko plegma NxN apo koukkides, kai ilopoiei mia aftomatopoiimeni ekdoxi tou gnostou 
*  pexnidiou ton koukkidon. 
*  
*  Kanones Pexnidiou:
*  To pexnidi koukkidon pezetai apo dio pextes, ton Mple kai ton Kokkino, pou pezoun enallaks
*  arxizontas panta apo ton Mple. O pextis pou einai i seira tou na peksei, afou prota kleisei
*  to kathe tetragono pou mporei na kleisei travontas tin enapominasa, tetarti, plevra tou
*  (orizontios i kathetos), teleionei tin trexousa seira tou epilegontas tixea tin keni orizontia 
*  i katheti grammi pou tha traviksei. 
*  
*  Oi 2 pextes pezoun aftomata (xoris kapia epemvasi tou xristi) apo tin arxi os to telos. O
*  kathe pextis, otan einai i seira tou na peksei, diadoxika prota entopizei kai meta kleinei 
*  kathe tetragono pou mporei na kleisei (kleinontas ena tetragono mporei sti sinexeia na kleisei 
*  kai allo/a gitoniko/a tetragono/a pou pithanon na thelei/oun mono mia grammi). Arxika fisika 
*  den tha iparxoun tetragona pros kleisimo. Afou o pextis kleisei ola ta tetragona pou dinantai
*  na kleistoun, tote oloklironei tin seira tou, epilegontas tixea tin teleftea grammi pou tha
*  traviksei.
*  
*  I poreia ekseliksis tou pexnidiou diagrafetai me tin optiki parousiasi tou kathe tetragonou pou
*  kleinei, sto xroma tou pexti pou to ekleise. Oi grammes pou travoun oi pextes den parousiazontai
*  optika (afto ilopoieitai mono esoterika sto programma). Stin othoni tha parousiazontai mono ta
*  kleista tetragona. To pexnidi stamata otan kleisoun kai xromatistoun ola ta tetragona, eite se
*  mple, eite se kokkino.
*
*/

public class DotGameSimulator {

	public static boolean isGameOver(int N, int[] pl){
		if (pl[0] == (N * N)){  //  I sinartisi elegxei an o pinakas grid (pou periexei ta mple kai
			return true;        //  kokkina koutakia) einai gematos. An nai epistrefei true, allios
		}else{                  //  epistrefei false.
			return false;
		}
	}

	public static boolean isHorLinesFull(int N, int[] pl){
		if (pl[1] == (N * (N+1))){  //  I sinartisi elegxei an o pinakas horLines einai gematos. An
			return true;            //  nai epistrefei true, allios epistrefei false.
		}else{
			return false;
		}
	}
	
	public static boolean isVerLinesFull(int N, int[] pl){
		if (pl[2] == (N * (N+1))){  //  I sinartisi elegxei an o pinakas verLines einai gematos. An
			return true;            //  nai epistrefei true, allios epistrefei false.
		}else{
			return false;
		}
	}
	
	public static boolean randomLineSelection(char[][] horLines, char[][] verLines,char player, 
											  int N, int[] pl){
		int horORver;  //  I sinartisi epilegei mia tixea grammi kai epistrefei true an i grammi
		               //  pou epelekse itan adia, allios epistrefei false. 
		if (isGameOver(N, pl)){  //  An einai gematos o pinakas grid tote i sinartisi epistrefei
			return true;         //  true (mias kai exei teleiosei to pexnidi) gia na ekselthei
		}                        //  to programma apo to Loop.
		if (isHorLinesFull(N, pl)){  //  Elegxei an o pinakas horLines einai gematos, an nai tote
			horORver = 1;            //  dialeigei katakorifi grammi.
		}else if (isVerLinesFull(N, pl)){  //  Allios elegxei an o pinakas verLines einai gematos,
			horORver = 0;                  //  an nai tote dialeigei orizontia grammi.
		}else{                                   //  Allios epilegei tixea orizontia i katakorifi
			horORver = (int) (Math.random() * 2.0);  //  0: horizontal line, 1: vertical line
		}
		int rX, rY; //  rX: seira/ rY: sili tixeas grammis ston pinaka horLines i verLines analoga.
		if (horORver==0){  //  An i metavliti horORver einai 0 tote tha epileksei orizontia grammi.
			rX = (int) (Math.random() * (N+1));  //  Gia ton pinaka horLines, epilegei tixea to rX
			rY = (int) (Math.random() * N);      //  metaksi 0 kai N, eno to rY metaksi 0 kai N-1.
			if (horLines[rX][rY]=='E'){        //  An i thesi tis grammis pou epelekse einai keni
				horLines[rX][rY] = player;     //  tote vazei stin thesi afti to onoma tou pexti,
				pl[1]++;                       //  afksanei to plithos ton orizontion grammon kai
				return true;                   //  i sinartisi epistrefei tin timi true.
			}else return false;                //  Allios i sinartisi epistrefei false.
		}
		else{          //  An i metavliti horORver den einai 0 tote tha epileksei katheti grammi.
			rX = (int) (Math.random() * N);      //  Gia ton pinaka verLines, epilegei tixea to rX
			rY = (int) (Math.random() * (N+1));  //  metaksi 0 kai N-1, eno to rY metaksi 0 kai N.
			if (verLines[rX][rY]=='E'){        //  An i thesi tis grammis pou epelekse einai keni
				verLines[rX][rY] = player;     //  tote vazei stin thesi afti to onoma tou pexti,
				pl[2]++;                       //  afksanei to plithos ton orizontion grammon kai
				return true;                   //  i sinartisi epistrefei tin timi true.
			}else return false;                //  Allios i sinartisi epistrefei false.
		}
	}
	
	public static boolean canCloseSquare(char[][] grid, char[][] horLines, char[][] verLines,
										 char player, int N, int[] pl, double radious){
		//  I sinartisi elegxei an iparxei kouti pou xriazete mono mia grammi gia na klisei,
		//  an iparxei tote vazei tin grammi pou lipei, klinei to kouti kai epistrefei true,
		//  an den iparxei tote epistrefei false.
		
		for (int rX=0; rX<=N; rX++){          //  Elegxei gia oles tis kenes grammes tou
			for (int rY=0; rY<N; rY++){       //  pinaka horLines, an mporei na klisei 
				boolean isClosed = true;      //  kouti epilegontas tin siggekrimeni 
		  		if (horLines[rX][rY]=='E'){   //  grammi kathe fora.
		  			if (rX==0){                          //  An i grammi einai stin proti 
		  				if (horLines[rX+1][rY]=='E'){    //  seira tou pinaka tote elegxei
		  					isClosed = false;            //  mono gia to kato kouti.
		  				}
		  				if (verLines[rX][rY]=='E'){          //  An vrethei esto kai mia
		  					isClosed = false;                //  keni grammi tote to kouti
		  				}                                    //  den mporei na klisei.
		  				if (verLines[rX][rY+1]=='E'){  
		  					isClosed = false;  //  An to isClosed einai true tote mporei
		  				}                      //  na kleisei kouti, allios den mporei.
		  				if (isClosed){                  //  An den vrei keni grammi tote 
		  					horLines[rX][rY] = player;  //  epilegei tin grammi kai klinei
		  					grid[rX][rY] = player;      //  to kouti me to xroma tou pexti
		  					StdDraw.filledSquare(rY + radious, rX + radious, radious);							
		  					pl[0]++;                    //  pou epelekse tin enapominanta
		  					pl[1]++;                    //  grammi, afksanei to plithos 
		  					return true;                //  tou pinaka grid kai horLines
		  				}                     //  kai epistrefei i sinartisi tin timi true.
		  				
		  			}else if (rX==N){                  //  An i grammi einai stin teleftea
		  				if (horLines[N-1][rY]=='E'){   //  seira tou pinaka tote elegxei
		  					isClosed = false;          //  mono gia to pano kouti.
		  				}
		  				if (verLines[N-1][rY]=='E'){          //  An vrethei esto kai mia
		  					isClosed = false;                 //  keni grammi tote to kouti
		  				}                                     //  den mporei na klisei.
		  				if (verLines[N-1][rY+1]=='E'){  
		  					isClosed = false;
		  				}
		  				if (isClosed){                   //  An den vrei keni grammi tote 
		  					horLines[rX][rY] = player;   //  epilegei tin grammi kai klinei
		  					grid[rX-1][rY] = player;     //  to kouti me to xroma tou pexti
		  					StdDraw.filledSquare(rY + radious, (rX-1) + radious, radious);
		  					pl[0]++;                     //  pou epelekse tin enapominanta
		  					pl[1]++;                     //  grammi, afksanei to plithos 
		  					return true;                 //  tou pinaka grid kai horLines
		  				}                      //  kai epistrefei i sinartisi tin timi true.
		  				
		  			}else{          //  Allios elegxei kai apo tis dio plevres tis grammis.
		  				if (horLines[rX-1][rY]=='E'){         //  Gia tis orizonties diladi
		  					isClosed = false;                 //  elegxei kai to pano kai 
		  				}                                     //  to kato kouti.
		  				if (verLines[rX-1][rY]=='E'){   
		  					isClosed = false;                 //  An vrethei esto kai mia
		  				}                                     //  keni grammi tote to kouti
		  				if (verLines[rX-1][rY+1]=='E'){       //  den mporei na klisei.
		  					isClosed = false;                 
		  				}
		  				if (isClosed){                  //  An den vrei keni grammi tote 
		  					horLines[rX][rY] = player;  //  epilegei tin grammi kai klinei
		  					grid[rX-1][rY] = player;    //  to kouti me to xroma tou pexti
		  					StdDraw.filledSquare(rY + radious, (rX-1) + radious, radious);
		  					pl[0]++;                    //  pou epelekse tin enapominanta
		  				}              //  grammi kai afksanei to plithos tou pinaka grid.
		  				
		  				isClosed=true;
		  				if (horLines[rX+1][rY]=='E'){      //  Elegxos gia to kato kouti.
		  					isClosed = false;              //  An vrethei esto kai mia
		  				}                                  //  keni grammi tote to kouti
		  				if (verLines[rX][rY]=='E'){        //  den mporei na klisei.
		  					isClosed = false;              
		  				}
		  				if (verLines[rX][rY+1]=='E'){
		  					isClosed = false;
		  				}
		  				if (isClosed){                  //  An den vrei keni grammi tote 
		  					horLines[rX][rY] = player;  //  epilegei tin grammi kai klinei
		  					grid[rX][rY] = player;      //  to kouti me to xroma tou pexti
		  					StdDraw.filledSquare(rY + radious, rX + radious, radious);
		  					pl[0]++;                    //  pou epelekse tin enapominanta
		  				}             //  grammi kai afksanei to plithos tou pinaka grid.
		  				
		  				if (horLines[rX][rY]==player){  //  An epelekse tin grammi tote
		  					pl[1]++;                    //  afksanei to plithos tou 
		  					return true;                //  pinaka horLines kai i
		  				}                               //  sinartisi epistrefei true.
		  			}
		  		}
			}
		}	
		for (int rX=0; rX<N; rX++){          //  Elegxei gia oles tis kenes grammes tou
			for (int rY=0; rY<=N; rY++){     //  pinaka verLines, an mporei na klisei 
				boolean isClosed = true;     //  kouti epilegontas tin siggekrimeni 
				if (verLines[rX][rY]=='E'){  //  grammi kathe fora.
					if (rY==0){                        //  An i grammi einai stin proti 
						if (verLines[rX][rY+1]=='E'){  //  stili tou pinaka tote elegxei
							isClosed = false;          //  mono gia to deksia kouti.
						}
						if (horLines[rX][0]=='E'){
							isClosed = false;
						}
						if (horLines[rX+1][0]=='E'){
							isClosed = false;
						}
						if (isClosed){                  //  An den vrei keni grammi tote 
							verLines[rX][rY] = player;  //  epilegei tin grammi kai klinei
							grid[rX][rY] = player;      //  to kouti me to xroma tou pexti
							StdDraw.filledSquare(rY + radious, rX + radious, radious);
							pl[0]++;                    //  pou epelekse tin enapominanta
		  					pl[2]++;       //  grammi, afksanei to plithos tou pinaka grid
							return true;   //  kai verLines kai i sinartisi epistrefei true.
						}
					}else if (rY==N){                  //  An i grammi einai stin teleftea
						if (verLines[rX][N-1]=='E'){   //  stili tou pinaka tote elegxei
							isClosed = false;          //  mono gia to aristera kouti.
						}
						if (horLines[rX][N-1]=='E'){
							isClosed = false;
						}
						if (horLines[rX+1][N-1]=='E'){
							isClosed = false;
						}
						if (isClosed){                  //  An den vrei keni grammi tote 
							verLines[rX][rY] = player;  //  epilegei tin grammi kai klinei
							grid[rX][rY-1] = player;    //  to kouti me to xroma tou pexti
							StdDraw.filledSquare((rY-1) + radious, rX + radious, radious);
							pl[0]++;                    //  pou epelekse tin enapominanta
		  					pl[2]++;       //  grammi, afksanei to plithos tou pinaka grid
							return true;   //  kai verLines kai i sinartisi epistrefei true.
						}
					}else{           //  Allios elegxei kai apo tis dio plevres tis grammis.
						if (verLines[rX][rY-1]=='E'){           //  Gia tis kathetes diladi
							isClosed = false;                   //  elegxei kai to aristera
						}                                       //  kai to deksia kouti.
						if (horLines[rX][rY-1]=='E'){     
							isClosed = false;                  //  An vrethei esto kai mia
						}                                      //  keni grammi tote to kouti
						if (horLines[rX+1][rY-1]=='E'){        //  den mporei na klisei.
							isClosed = false;                  
						}
						if (isClosed){                   //  An den vrei keni grammi tote 
							verLines[rX][rY] = player;   //  epilegei tin grammi kai klinei
							grid[rX][rY-1] = player;     //  to kouti me to xroma tou pexti
							StdDraw.filledSquare((rY-1) + radious, rX + radious, radious);
							pl[0]++;                     //  pou epelekse tin enapominanta
						}                //  grammi kai afksanei to plithos tou pinaka grid.
						
						isClosed=true;
						if (verLines[rX][rY+1]=='E'){      //  Elegxos gia to deksia kouti.
							isClosed = false;              //  An vrethei esto kai mia
						}
						if (horLines[rX][rY]=='E'){  //  keni grammi tote to kouti
							isClosed = false;              //  den mporei na klisei.
						}
						if (horLines[rX+1][rY]=='E'){
							isClosed = false;
						}
						if (isClosed){                   //  An den vrei keni grammi tote 
							verLines[rX][rY] = player;   //  epilegei tin grammi kai klinei
							grid[rX][rY] = player;       //  to kouti me to xroma tou pexti
							StdDraw.filledSquare(rY + radious, rX + radious, radious);
							pl[0]++;                     //  pou epelekse tin enapominanta
						}               //  grammi kai afksanei to plithos tou pinaka grid.
						
						if (verLines[rX][rY]==player){   //  An epelekse tin grammi tote
							pl[2]++;                     //  afksanei to plithos tou 
							return true;                 //  pinaka verLines kai i
						}                                //  sinartisi epistrefei true.
					}
				}
			}
		}
		return false;    //  An den iparxei kouti gia klisimo tote i sinartisi epistrefei 
	}                    //  tin timi false.
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length!=1){ 
			StdOut.println("Invalid number! You must give 1 positive integer number!");
			return;           //  An stin grammi entolis dothoun perissoteroi apo 1 arithmoi
		}	                  //  tote to programma termatizei me antistixo minima lathous.
		
		double num = Double.parseDouble(args[0]);
		if ((num%1!=0) || (num<=0)){
			StdOut.println("Invalid number! You must give 1 positive integer number!");
			return;       //  An stin grammi entolis dothei enas pragmatikos i enas arithmos
		}   //  mikroteros apo to 1, tote to programma tiponei minima lathous kai termatizei. 
		
		int N = (int) num;         //  Metatrepoume ton arithmo pou pirame se akeraio.
		final double X1 = 0.0;     //  Ta X1, X2, Y1, Y2 einai statheres pou antiprosopevoun
		final double X2 = N;       //  tin klimaka tou kamva ston opio tha zografisoume.
		final double Y1 = N;
		final double Y2 = 0.0;
		StdDraw.setXscale(X1, X2);     //  Dilonoume tin klimaka tou kamva gia ton X aksona.
		StdDraw.setYscale(Y1, Y2);     //  Dilonoume tin klimaka tou kamva gia ton Y aksona.
		
		final double CENTERX= (X1+X2)/2.0;  //  To CENTERX kai CENTERY antiprosopevoun tis
		final double CENTERY= (Y1+Y2)/2.0;  //  sintetagmenes tou kentrou tou kamva.
		StdDraw.setPenColor(StdDraw.GRAY);  //  Zografizoume sto kentro tou kamva ena grizo
        StdDraw.filledSquare(CENTERX, CENTERY, 2*(X1+X2));  //  tetragono gia background.
        
		final char player1 = 'B';  //  O protos pextis einai o mple (B: Blue)
		final char player2 = 'R';  //  kai o defteros pextis o kokkinos (R: Red)
		
		
        double squareRadious=(X1+X2)/(2.0 * N);
        //  To squareRadious einai i misi timi tis plevras tou kathe tetragonou.
		
		char[][] grid = new char[N][N];  //  Dimiourgoume ena pinaka gia ta koutakia
		for (int i=0; i<N; i++){         //  kai ton gemizoume me ton xaraktira 'E'
			for (int j=0; j<N; j++){     //  (diladi E: Empty).
				grid[i][j] = 'E';
			}
		}
		char[][] horLines = new char[N+1][N];  //  Dimiourgoume ena pinaka gia tis orizonties
		for (int i=0; i<N+1; i++){             //  grammes kai ton gemizoume me ton xaraktira
			for (int j=0; j<N; j++){           //  'E' (diladi E: Empty).
				horLines[i][j] = 'E';
			}
		}
		char[][] verLines = new char[N][N+1];  //  Dimiourgoume ena pinaka gia tis kathetes
		for (int i=0; i<N; i++){               //  grammes kai ton gemizoume me ton xaraktira
			for (int j=0; j<N+1; j++){         //  'E' (diladi E: Empty).
				verLines[i][j] = 'E';
			}
		}
		int[] arrayCounter = {0, 0, 0};  //  Dimiourgoume pinaka me ta plithoi ton 3 pinakon
		//  arrayCounter[a]: a=0-> plithos grid, a=1-> plithos horLines, a=2-> plithos verLines
		
		char player = player1;  //  player einai o pextis pou exei sira na peksei.
		
		while (!isGameOver(N, arrayCounter)){  //  Enoso o pinakas grid den einai gematos to
			                                   //  pexnidi den exei teleiosei.
			if (player=='B'){                       //  An einai i seira tou mple na peksei
    			StdDraw.setPenColor(StdDraw.CYAN);  //  to xroma tis pennas ginete mple eno
    		}                                       //  an pezei o kokkinos tote to xroma 
    		else{                                   //  tis penna ginete kokkino.
    			StdDraw.setPenColor(StdDraw.MAGENTA);  
    		}
			while (canCloseSquare(grid, horLines, verLines, player, N, arrayCounter, squareRadious)){
			}  //  Oso mporei na klinei koutakia sinexizei na pezei o idios pextis. 
			
			boolean isRandomEmpty = false;  //  An einai false tote simenei oti i tixea grammi
			                                //  pou epilegike den einai keni.
			while (!isRandomEmpty){    //  Enoso i tixea grammi den einai keni epilegei mia alli.
				isRandomEmpty = randomLineSelection(horLines, verLines, player, N, arrayCounter);
			}                     //  Mexri i sinartisi na vrei mia tixea grammi pou einai keni.
			
			if (player==player1){  //  An o pextis pou molis epekse itan o protos (player1) tote  
				player=player2;    //  einai i seira tou defterou pexti (player2) na peksei.
			}else{                 //  Allios einai i seira tou protou pexti (player1).
				player=player1;
			}
		}
	}  
	
}

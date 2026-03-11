package org.dacracot;
//---------------------------------------------------
public class Solitaire {
	//-----------------------------------------------
	public Solitaire(){}
	//-----------------------------------------------
	public static void main(String[] args){
		int won = 0;
		int cards = 0;
		int tries = 0;
		if (args.length == 2){
			cards = Integer.parseInt(args[0]);  // how many cards to flip
			tries = Integer.parseInt(args[1]); 	// number of games to play
			}
		else{
			System.out.println();
			System.out.println("parameters: cards games");
			System.out.println();
			}
		for(int i=0; i<tries; i++){
 			Player player = new Player(cards);
 			player.run();
 			}
		Score.result();
		}
	//-----------------------------------------------
}
//---------------------------------------------------
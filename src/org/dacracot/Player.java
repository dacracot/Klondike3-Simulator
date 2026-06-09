package org.dacracot;
//---------------------------------------------------
import org.dacracot.move.FromStack;
import org.dacracot.move.FromBoard;
import org.dacracot.move.FromFoundation;
//---------------------------------------------------
public class Player {
	//-----------------------------------------------
	private int cards;
	private StringBuilder activeGame = new StringBuilder();
	//-----------------------------------------------
	public Player(int cards){
		this.cards = cards;
		}
	//-----------------------------------------------
	public void play() {
		Global.play();
		Klondike game = new Klondike(cards);
		FromStack fromStack = new FromStack(game);
		FromBoard fromBoard = new FromBoard(game);
		FromFoundation fromFoundation = new FromFoundation(game);
		if (Global.debug){activeGame.append(game.showAll("Ready to Play"));}
		//-------------------------------------------
		boolean won = false;
		int loops = 0;
		int flops = 0;
		// Play until there are no moves for three loops.
		while(flops < 3) {
			// Play only one (or none) from stack to foundation
			if (fromStack.toFoundation()) {
				// Played a card
				flops = 0;
				}
			if (Global.debug){activeGame.append(game.showAll("s2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
			// Play board to board until no more moves available
			while(fromBoard.toBoard()) {
				if (Global.debug){activeGame.append(game.showAll("b2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
				}
			// Play only one (or none) from board to foundation
			if (fromBoard.toFoundation()) {
				// Played a card
				flops = 0;
				}
			if (Global.debug){activeGame.append(game.showAll("b2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
			// Play stack to board until no more moves available
			while(fromStack.toBoard()) {
				if (Global.debug){activeGame.append(game.showAll("s2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
				}
			// Turn over the stack
			if (game.stack.flip()) {
				flops++;
				}
			if (Global.debug){activeGame.append(game.showAll("s.flip >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
			// Did we win by putting all cards in the foundation?
			if (game.foundation.winner()) {
 				if (Global.debug) {
 					activeGame.append(game.showAll("winner >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));
					System.out.println("================== WINNER ==================");
					System.out.println(activeGame);
					System.out.println("================== WINNER ==================");
					}
				won = true;
				Global.win();
				break;
				}
			}
		//-------------------------------------------
		if ((Global.debug) && (!won)) {
			activeGame.append(game.showAll("loser >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));
			System.out.println("================== LOSER ==================");
			System.out.println(activeGame);
			System.out.println("================== LOSER ==================");
			}
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
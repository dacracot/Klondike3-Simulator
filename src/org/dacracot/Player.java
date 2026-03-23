package org.dacracot;
//---------------------------------------------------
import org.dacracot.move.FromStack;
import org.dacracot.move.FromBoard;
import org.dacracot.move.FromGoal;
//---------------------------------------------------
public class Player {
	//-----------------------------------------------
	private int cards;
	//-----------------------------------------------
	public Player(int cards){
		this.cards = cards;
		}
	//-----------------------------------------------
	public boolean run() {
		Klondike game = new Klondike(cards);
		FromStack fromStack = new FromStack(game);
		FromBoard fromBoard = new FromBoard(game);
		FromGoal fromGoal = new FromGoal(game);
		game.showAll("Ready to Play");
		//-------------------------------------------
		int loops = 0;
		int flops = 0;
		// Play until there are no moves for three loops.
		while(flops < 3) {
			// Play only one (or none) from stack to goal
			if (fromStack.toGoal()) {
				// Played a card
				flops = 0;
				}
			game.showAll("s2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			// Play board to board until no more moves available
			while(fromBoard.toBoard()) {
				game.showAll("b2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				}
			// Play only one (or none) from board to goal
			if (fromBoard.toGoal()) {
				// Played a card
				flops = 0;
				}
			game.showAll("b2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			// Play stack to board until no more moves available
			while(fromStack.toBoard()) {
				game.showAll("s2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				}
			// Turn over the stack
			if (game.stack.flip()) {
				flops++;
				}
			game.showAll("s.flip >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			// Did we win by putting all cards in the goal?
			if (game.goal.winner()) {
				game.showAll("winner >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				return(true);
				}
			}
		// Game is lost.
		return(false);
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
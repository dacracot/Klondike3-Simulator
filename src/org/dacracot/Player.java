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
			if (fromStack.toGoal()) { // s2g
				flops = 0;
				}
			game.showAll("s2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			while(fromBoard.toBoard()) { // b2b
				game.showAll("b2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				}
			if (fromBoard.toGoal()) { // b2g
				flops = 0;
				}
			game.showAll("b2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			while(fromStack.toBoard()) { // s2b
				game.showAll("s2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				}
			if (game.stack.flip()) {
				flops++;
				}
			game.showAll("s.flip >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			if (game.goal.winner()) {
				game.showAll("winner >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				return(true);
				}
			}
		return(false);
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
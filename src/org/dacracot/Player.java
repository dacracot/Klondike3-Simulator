package org.dacracot;
//---------------------------------------------------
import java.lang.Thread;
import org.dacracot.move.FromStack;
import org.dacracot.move.FromBoard;
import org.dacracot.move.FromGoal;
// import org.dacracot.util.Throttle;
//---------------------------------------------------
public class Player extends Thread {
	//-----------------------------------------------
	private int cards;
	private StringBuffer activeGame = new StringBuffer();
	//-----------------------------------------------
	public Player(int cards){
		this.cards = cards;
		}
	//-----------------------------------------------
	public void run() {
		Klondike game = new Klondike(cards);
		FromStack fromStack = new FromStack(game);
		FromBoard fromBoard = new FromBoard(game);
		FromGoal fromGoal = new FromGoal(game);
		if (Global.debug){activeGame.append(game.showAll("Ready to Play"));}
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
			if (Global.debug){activeGame.append(game.showAll("s2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
			// Play board to board until no more moves available
			while(fromBoard.toBoard()) {
				if (Global.debug){activeGame.append(game.showAll("b2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
				}
			// Play only one (or none) from board to goal
			if (fromBoard.toGoal()) {
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
			// Did we win by putting all cards in the goal?
			if (game.goal.winner()) {
				if (Global.debug){activeGame.append(game.showAll("winner >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
 				if (Global.debug) {
					System.out.println("================== WINNER ==================");
					System.out.println(activeGame);
					System.out.println("================== WINNER ==================");
					activeGame.delete(0, activeGame.length());
					}
				Global.win();
				}
			}
		// Game is lost.
		Global.gameOver();
//		Throttle.less();
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
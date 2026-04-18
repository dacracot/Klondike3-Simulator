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
		// Prioritized greedy action selection following Bjarnason, Fern,
		// Tadepalli 2009 ("Lower Bounding Klondike Solitaire with
		// Monte-Carlo Planning", ICAPS-09, pg. 3):
		//   1. tableau -> foundation that reveals a face-down card
		//   2. any other move to a foundation stack
		//   3. tableau -> tableau that reveals a face-down card
		//   4. deck -> tableau
		//   5. foundation -> tableau (not implemented)
		//   6. tableau -> tableau that does not reveal
		// After each move, re-evaluate from priority 1.
		while(flops < 3) {
			boolean moved = true;
			while(moved) {
				moved = false;
				if (fromBoard.toGoalReveal()) {
					flops = 0;
					moved = true;
					game.showAll("b2g+  >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
					continue;
					}
				if (fromBoard.toGoal()) {
					flops = 0;
					moved = true;
					game.showAll("b2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
					continue;
					}
				if (fromStack.toGoal()) {
					flops = 0;
					moved = true;
					game.showAll("s2g   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
					continue;
					}
				if (fromBoard.toBoardReveal()) {
					moved = true;
					game.showAll("b2b+  >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
					continue;
					}
				if (fromStack.toBoard()) {
					moved = true;
					game.showAll("s2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
					continue;
					}
				if (fromBoard.toBoardNoReveal()) {
					moved = true;
					game.showAll("b2b   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
					continue;
					}
				}
			// Turn over the stack.
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
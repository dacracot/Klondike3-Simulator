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
		while(flops < 3) {
			if (fromStack.toGoal()) {
				flops = 0;
				}
			game.showAll("loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			if (fromBoard.toGoal()) {
				flops = 0;
				}
			game.showAll("loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			while(fromBoard.toBoard()) {
				game.showAll("loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				}
			while(fromStack.toBoard()) {
				game.showAll("loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				}
			if (game.stack.flip()) {
				flops++;
				}
			game.showAll("loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			if (game.goal.winner()) {
				game.showAll("loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
				return(true);
				}
			game.showAll("loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			}
		return(false);
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
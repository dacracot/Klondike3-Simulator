package org.dacracot;
//---------------------------------------------------
import org.dacracot.move.FromStack;
import org.dacracot.move.FromBoard;
import org.dacracot.move.FromGoal;
//---------------------------------------------------
public class Player implements Runnable {
	//-----------------------------------------------
	private int cards;
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
		//-------------------------------------------
		int loops = 0;
		int flops = 0;
		while(flops < 3) {
			if (fromStack.toGoal()) {
				flops = 0;
				}
			if (game.stack.flip()) {
				flops++;
				}
			if (game.goal.winner()) {
				System.out.println("winner");
				break;
				}
			game.showAll("loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops));
			}
		System.out.println("loser");
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
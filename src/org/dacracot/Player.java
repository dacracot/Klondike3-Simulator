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
		while(fromStack.toGoal()) {
			if (game.goal.winner()) {
				System.out.println("winner");
				break;
				}
			}
		System.out.println("loser");
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
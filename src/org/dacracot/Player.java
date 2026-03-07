package org.dacracot;
//---------------------------------------------------
public class Player implements Runnable {
	//-----------------------------------------------
	private int cards;
	//-----------------------------------------------
	public Player(int c){
		cards = c;
		}
	//-----------------------------------------------
	public void run() {
		Klondike game = new Klondike(cards);
		Score.winner(game.play());
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
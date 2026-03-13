package org.dacracot;
//---------------------------------------------------
import org.dacracot.card.Card;
import org.dacracot.card.Deck;
import org.dacracot.table.Goal;
import org.dacracot.table.Board;
import org.dacracot.table.Stack;
//---------------------------------------------------
public class Klondike{
	//-----------------------------------------------
	private int flips;
	private Deck deck;
	public Goal goal;
	public Board board;
	public Stack stack;
	//-----------------------------------------------
	public Klondike(int f) {
		flips = f;
		deck = new Deck();
		goal = new Goal();
		board = new Board(deck);
		stack = new Stack(deck.getStack(),flips);
		}
	//-----------------------------------------------
	public void showAll(String title) {
		if (Global.debug){
			System.err.println("~~~~~~~~~~~~~~~~~~");
			System.err.println("~~~ "+title+" ~~~~~~~~~");
			goal.show();
			board.show();
			stack.show();
			System.err.println("~~~~~~~~~~~~~~~~~~");
			}
		}
	//-----------------------------------------------
}
//---------------------------------------------------
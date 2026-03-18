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
		StringBuffer sb = new StringBuffer();
		sb.append("~~~~~~~~~~~~~~~~~~\n");
		sb.append("~~~ "+title+" ~~~~~~~~~\n");
		sb.append(goal.show());
		sb.append(board.show());
		sb.append(stack.show());
		sb.append("~~~~~~~~~~~~~~~~~~\n");
		Global.activeGame.append(sb);
		if (Global.debug){
			System.err.println(sb.toString());
			}
		}
	//-----------------------------------------------
}
//---------------------------------------------------
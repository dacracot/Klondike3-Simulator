package org.dacracot;
//---------------------------------------------------
import org.dacracot.card.Card;
import org.dacracot.card.Deck;
import org.dacracot.table.Foundation;
import org.dacracot.table.Board;
import org.dacracot.table.Stack;
//---------------------------------------------------
public class Klondike{
	//-----------------------------------------------
	private int flips;
	private Deck deck;
	public Foundation foundation;
	public Board board;
	public Stack stack;
	//-----------------------------------------------
	public Klondike(int f) {
		flips = f;
		deck = new Deck();
		foundation = new Foundation();
		board = new Board(deck);
		stack = new Stack(deck.getStack(),flips);
		}
	//-----------------------------------------------
	public String showAll(String title) {
		StringBuilder sb = new StringBuilder();
		sb.append("~~~~~~~~~~~~~~~~~~\n");
		sb.append("~~~ "+title+" ~~~~~~~~~\n");
		sb.append(foundation.show());
		sb.append(board.show());
		sb.append(stack.show());
		sb.append("~~~~~~~~~~~~~~~~~~\n");
		return(sb.toString());
		}
	//-----------------------------------------------
}
//---------------------------------------------------
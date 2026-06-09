package org.dacracot;
//---------------------------------------------------
import org.dacracot.card.Card;
import org.dacracot.card.Deck;
import org.dacracot.table.Foundation;
import org.dacracot.table.Tableau;
import org.dacracot.table.Stack;
//---------------------------------------------------
public class Klondike{
	//-----------------------------------------------
	private int flips;
	private Deck deck;
	public Foundation foundation;
	public Tableau tableau;
	public Stack stack;
	//-----------------------------------------------
	public Klondike(int f) {
		flips = f;
		deck = new Deck();
		foundation = new Foundation();
		tableau = new Tableau(deck);
		stack = new Stack(deck.getStack(),flips);
		}
	//-----------------------------------------------
	public String showAll(String title) {
		StringBuilder sb = new StringBuilder();
		sb.append("~~~~~~~~~~~~~~~~~~\n");
		sb.append("~~~ "+title+" ~~~~~~~~~\n");
		sb.append(foundation.show());
		sb.append(tableau.show());
		sb.append(stack.show());
		sb.append("~~~~~~~~~~~~~~~~~~\n");
		return(sb.toString());
		}
	//-----------------------------------------------
}
//---------------------------------------------------
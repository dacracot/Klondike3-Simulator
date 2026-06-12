package org.dacracot;
//---------------------------------------------------
import org.dacracot.card.Card;
// fully qualified below
// import org.dacracot.card.Deck;
import org.dacracot.table.Deck;
import org.dacracot.table.Foundation;
import org.dacracot.table.Tableau;
//---------------------------------------------------
public class Klondike{
	//-----------------------------------------------
	private int flips;
	private org.dacracot.card.Deck deckOfCards;
	public Foundation foundation;
	public Tableau tableau;
	public Deck deck;
	//-----------------------------------------------
	public Klondike(int f) {
		flips = f;
		deckOfCards = new org.dacracot.card.Deck();
		foundation = new Foundation();
		tableau = new Tableau(deckOfCards);
		deck = new Deck(deckOfCards.getDeck(),flips);
		}
	//-----------------------------------------------
	public String showAll(String title) {
		StringBuilder sb = new StringBuilder();
		sb.append("~~~~~~~~~~~~~~~~~~\n");
		sb.append("~~~ "+title+" ~~~~~~~~~\n");
		sb.append(foundation.show());
		sb.append(tableau.show());
		sb.append(deck.show());
		sb.append("~~~~~~~~~~~~~~~~~~\n");
		return(sb.toString());
		}
	//-----------------------------------------------
}
//---------------------------------------------------
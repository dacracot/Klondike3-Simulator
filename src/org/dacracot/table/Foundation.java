package org.dacracot.table;
//---------------------------------------------------
import java.util.ArrayList;
import org.dacracot.card.Card;
//---------------------------------------------------
public class Foundation {
	//-----------------------------------------------
	ArrayList<Card> spades;
	ArrayList<Card> hearts;
	ArrayList<Card> clubs;
	ArrayList<Card> diamonds;
	//-----------------------------------------------
	public Foundation(){
		spades = new ArrayList<Card>();
		hearts = new ArrayList<Card>();
		clubs = new ArrayList<Card>();
		diamonds = new ArrayList<Card>();
		}
	//-----------------------------------------------
	public ArrayList<Card> getUpCardsFromBottom() {
		ArrayList<Card> bottom = new ArrayList<Card>();
		// Spades
		Card spade = spades.get(spades.size()-1);
		spade.setWeight(spades.size());
		bottom.add(spade);
		// hearts
		Card heart = hearts.get(hearts.size()-1);
		heart.setWeight(hearts.size());
		bottom.add(heart);
		// clubs
		Card club = clubs.get(clubs.size()-1);
		club.setWeight(clubs.size());
		bottom.add(club);
		// diamonds
		Card diamond = diamonds.get(diamonds.size()-1);
		diamond.setWeight(diamonds.size());
		bottom.add(diamond);
		//-------------------------------------------		
		return(bottom);
		}
	//-----------------------------------------------
	public boolean playCard(Card c){
		try{
			switch(c.getSuit()){
				case SPADES:
					if (spades.size() == (c.getValue() - 1)){
						spades.add(c);
						return(true);
						}
					break;
				case HEARTS:
					if (hearts.size() == (c.getValue() - 1)){
						hearts.add(c);
						return(true);
						}
					break;
				case CLUBS:
					if (clubs.size() == (c.getValue() - 1)){
						clubs.add(c);
						return(true);
						}
					break;
				case DIAMONDS:
					if (diamonds.size() == (c.getValue() - 1)){
						diamonds.add(c);
						return(true);
						}
					break;
				}
			}
		catch(Exception e){
			System.err.println(e);
			System.exit(1);
			}
		return(false);
		}
	//-----------------------------------------------
	private void showFoundation(ArrayList<Card> g, StringBuilder sb){
		for(int i=0; i<g.size(); i++){
			sb.append(g.get(i).draw());
			}
 		sb.append("\n");
		}
	//-----------------------------------------------
	public String show(){
		StringBuilder sb = new StringBuilder();
		sb.append("======================\n");
		sb.append("=== Foundation =============\n");
		showFoundation(spades,sb);
		showFoundation(diamonds,sb);
		showFoundation(clubs,sb);
		showFoundation(hearts,sb);
		return(sb.toString());
		}
	//-----------------------------------------------
	public boolean winner(){
		return((spades.size() == 13) && (hearts.size() == 13) && (clubs.size() == 13) && (diamonds.size() == 13));
		}
	//-----------------------------------------------
}
//---------------------------------------------------
package org.dacracot.play;
//---------------------------------------------------
import org.dacracot.card.Card;
//---------------------------------------------------
import java.util.ArrayList;
//---------------------------------------------------
public class Goal {
	//-----------------------------------------------
	ArrayList<Card> spades;
	ArrayList<Card> hearts;
	ArrayList<Card> clubs;
	ArrayList<Card> diamonds;
	//-----------------------------------------------
	public Goal(){
		spades = new ArrayList<Card>();
		hearts = new ArrayList<Card>();
		clubs = new ArrayList<Card>();
		diamonds = new ArrayList<Card>();
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
	private void showGoal(ArrayList<Card> g){
		for(int i=0; i<g.size(); i++){
			g.get(i).draw();
			}
		System.err.println();
		}
	//-----------------------------------------------
	public void showGoals(){
		showGoal(spades);
		System.err.println("----------------------");
		showGoal(diamonds);
		System.err.println("----------------------");
		showGoal(clubs);
		System.err.println("----------------------");
		showGoal(hearts);
		System.err.println("======================");
		}
	//-----------------------------------------------
	public boolean winner(){
		return((spades.size() == 13) && (hearts.size() == 13) && (clubs.size() == 13) && (diamonds.size() == 13));
		}
	//-----------------------------------------------
}
//---------------------------------------------------
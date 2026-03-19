package org.dacracot.card;
//---------------------------------------------------
import java.util.Random;
import java.util.ArrayList;
//---------------------------------------------------
public class Deck {
	//-----------------------------------------------
	ArrayList<Card> deck;
	//-----------------------------------------------
	public Deck(long seed){
		deck = new ArrayList<Card>();
		int ndx = 0;
		for(Suit suit : Suit.values()){
			for(int i = 1; i < 14; i++){
				deck.add(new Card(suit, i, false));
				}
			}
		shuffle(seed);
		}
	//-----------------------------------------------
	private void shuffle(long seed){
		ArrayList<Card> tmp = new ArrayList<Card>();
		Random r = new Random(seed);
		int max = 52;
		while(deck.size() > 0){
			tmp.add(deck.remove(r.nextInt(max--)));
			}
		deck = tmp;
		}
	//-----------------------------------------------
	public ArrayList<Card> getStack(){
		return(deck);
		}
	//-----------------------------------------------
	public Card getCard(int ndx){
		return(deck.get(ndx));
		}
	//-----------------------------------------------
	public void removeCard(int ndx){
		deck.remove(ndx);
		}
	//-----------------------------------------------
	public int size(){
		return(deck.size());
		}
	//-----------------------------------------------
	public void show(){
		for(int i=0; i<deck.size(); i++){
			deck.get(i).draw();
			}
		System.err.println();
		System.err.println("----------------------");
		}
	//-----------------------------------------------
}
//---------------------------------------------------
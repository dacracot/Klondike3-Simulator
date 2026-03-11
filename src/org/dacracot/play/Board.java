package org.dacracot.play;
//---------------------------------------------------
import org.dacracot.card.Card;
import org.dacracot.card.Deck;
//---------------------------------------------------
import java.util.ArrayList;
//---------------------------------------------------
public class Board {
	//-----------------------------------------------
	ArrayList<Card> column_1;
	ArrayList<Card> column_2;
	ArrayList<Card> column_3;
	ArrayList<Card> column_4;
	ArrayList<Card> column_5;
	ArrayList<Card> column_6;
	ArrayList<Card> column_7;
	//-----------------------------------------------
	public Board(Deck d){
		column_1 = new ArrayList<Card>();
		column_2 = new ArrayList<Card>();
		column_3 = new ArrayList<Card>();
		column_4 = new ArrayList<Card>();
		column_5 = new ArrayList<Card>();
		column_6 = new ArrayList<Card>();
		column_7 = new ArrayList<Card>();
		sevenXseven(d);
		}
	//-----------------------------------------------
	private void sevenXseven(Deck deck){
		column_1.add(deck.getCard(0));
		deck.removeCard(0);
		for (int i = 0; i < 2; i++){
			column_2.add(deck.getCard(0));
			deck.removeCard(0);
			}
		for (int i = 0; i < 3; i++){
			column_3.add(deck.getCard(0));
			deck.removeCard(0);
			}
		for (int i = 0; i < 4; i++){
			column_4.add(deck.getCard(0));
			deck.removeCard(0);
			}
		for (int i = 0; i < 5; i++){
			column_5.add(deck.getCard(0));
			deck.removeCard(0);
			}
		for (int i = 0; i < 6; i++){
			column_6.add(deck.getCard(0));
			deck.removeCard(0);
			}
		for (int i = 0; i < 7; i++){
			column_7.add(deck.getCard(0));
			deck.removeCard(0);
			}
		}
	//-----------------------------------------------
	public boolean playCard(Card c){
		try{
			return(true);
			}
		catch(Exception e){
			System.err.println(e);
			System.exit(1);
			}
		return(false);
		}
	//-----------------------------------------------
	private void showColumn(ArrayList<Card> g){
		for(int i=0; i<g.size(); i++){
			g.get(i).draw();
			}
		System.err.println();
		}
	//-----------------------------------------------
	public void show(){
		System.err.println("======================");
		System.err.println("=== Board ============");
		showColumn(column_1);
		System.err.println("----------------------");
		showColumn(column_2);
		System.err.println("----------------------");
		showColumn(column_3);
		System.err.println("----------------------");
		showColumn(column_4);
		System.err.println("----------------------");
		showColumn(column_5);
		System.err.println("----------------------");
		showColumn(column_6);
		System.err.println("----------------------");
		showColumn(column_7);
		System.err.println("======================");
		}
	//-----------------------------------------------
}
//---------------------------------------------------
package org.dacracot.table;
//---------------------------------------------------
import java.lang.IndexOutOfBoundsException;
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
	private void initColumn(Deck deck, ArrayList<Card> column, int size){
		Card temp;
		for (int i = 0; i < size; i++){
			temp = deck.getCard(0);
			temp.setHidden(true);
			column.add(temp);
			deck.removeCard(0);
			}
		column.get(column.size() - 1).flip();
		}
	//-----------------------------------------------
	private void sevenXseven(Deck deck){
		initColumn(deck,column_1,1);
		initColumn(deck,column_2,2);
		initColumn(deck,column_3,3);
		initColumn(deck,column_4,4);
		initColumn(deck,column_5,5);
		initColumn(deck,column_6,6);
		initColumn(deck,column_7,7);
		}
	//-----------------------------------------------
	public void removeCard(Card card) {
		Card bottomUpCard;
		try {
			bottomUpCard = column_1.get(column_1.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_1.remove(column_1.size()-1);
				column_1.get(column_1.size()-1).setHidden(false);
				}
			}
		catch(IndexOutOfBoundsException e) {} // empty columns have no up card
		try {
			bottomUpCard = column_2.get(column_2.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_2.remove(column_2.size()-1);
				column_2.get(column_2.size()-1).setHidden(false);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_3.get(column_3.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_3.remove(column_3.size()-1);
				column_3.get(column_3.size()-1).setHidden(false);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_4.get(column_4.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_4.remove(column_4.size()-1);
				column_4.get(column_4.size()-1).setHidden(false);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_5.get(column_5.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_5.remove(column_5.size()-1);
				column_5.get(column_5.size()-1).setHidden(false);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_6.get(column_6.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_6.remove(column_6.size()-1);
				column_6.get(column_6.size()-1).setHidden(false);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_7.get(column_7.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_7.remove(column_7.size()-1);
				column_7.get(column_7.size()-1).setHidden(false);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		}
	//-----------------------------------------------
	public ArrayList<Card> getUpCardsFromBottom() {
		ArrayList<Card> up = new ArrayList<Card>();
		try {
			up.add(column_1.get(column_1.size()-1));
			}
		catch(IndexOutOfBoundsException e) {} // empty columns have no up card
		try {
			up.add(column_2.get(column_2.size()-1));
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			up.add(column_3.get(column_3.size()-1));
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			up.add(column_4.get(column_4.size()-1));
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			up.add(column_5.get(column_5.size()-1));
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			up.add(column_6.get(column_6.size()-1));
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			up.add(column_7.get(column_7.size()-1));
			}
		catch(IndexOutOfBoundsException e) {}
		return(up);
		}
	//-----------------------------------------------
	public boolean playCard(Card bottom, Card top){
		try{

// bottom & top in same column > ignore

// opposite colors
// sequential values

// split ArrayList
// join ArrayList

// flip

			}
		catch(Exception e){
			System.err.println(e);
			System.exit(1);
			}
		return(false);
		}
	//-----------------------------------------------
	private void showColumn(ArrayList<Card> g, StringBuffer sb){
		for(int i=0; i<g.size(); i++){
			sb.append(g.get(i).draw());
			}
		}
	//-----------------------------------------------
	public String show(){
		StringBuffer sb = new StringBuffer();
		sb.append("======================\n");
		sb.append("=== Board ============\n");
		showColumn(column_1,sb);
		sb.append("\n----------------------\n");
		showColumn(column_2,sb);
		sb.append("\n----------------------\n");
		showColumn(column_3,sb);
		sb.append("\n----------------------\n");
		showColumn(column_4,sb);
		sb.append("\n----------------------\n");
		showColumn(column_5,sb);
		sb.append("\n----------------------\n");
		showColumn(column_6,sb);
		sb.append("\n----------------------\n");
		showColumn(column_7,sb);
		sb.append("\n======================\n");
		return(sb.toString());
		}
	//-----------------------------------------------
}
//---------------------------------------------------
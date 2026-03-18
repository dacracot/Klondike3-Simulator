package org.dacracot.table;
//---------------------------------------------------
import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;
import org.dacracot.card.Card;
import org.dacracot.card.Deck;
import org.dacracot.util.TypedArray;
//---------------------------------------------------
public class Board {
	//-----------------------------------------------
	private final int SEVEN = 7;
	private TypedArray<ArrayList<Card>> columns = new TypedArray(SEVEN);
	//-----------------------------------------------
	public Board(Deck d){
		for(int i=0; i<SEVEN; i++) {
			columns.add(i, new ArrayList<Card>());
			}
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
		for(int i=0; i<SEVEN; i++) {
			initColumn(deck,columns.get(i),(i+1));
			}
		}
	//-----------------------------------------------
	public boolean bottomsUp(ArrayList<Card> c){
		if (c.isEmpty()) {
			return(false);
			}
		else {
			c.get(c.size()-1).setHidden(false);
			return(true);
			}
		}
	//-----------------------------------------------
	public void removeCard(Card card) {
		Card bottomUpCard;
		for(int i=0; i<SEVEN; i++) {
			try {
				bottomUpCard = columns.get(i).get(columns.get(i).size()-1);
				if (card.stringEquals(bottomUpCard)) {
					columns.get(i).remove(columns.get(i).size()-1);
					bottomsUp(columns.get(i));
					}
				}
			catch(IndexOutOfBoundsException e) {} // empty columns have no up card
			}
		}
	//-----------------------------------------------
	public ArrayList<Card> getUpCardsFromTop() {
		ArrayList<Card> up = new ArrayList<Card>();
		for(int i=0; i<SEVEN; i++) {
			for(Card card : columns.get(i)) {
				if (!card.isHidden()) {
					up.add(card);
					break;
					}
				}
			}
		return(up);
		}
	//-----------------------------------------------
	public ArrayList<Card> getUpCardsFromBottom() {
		ArrayList<Card> up = new ArrayList<Card>();
		for(int i=0; i<SEVEN; i++) {
			try {
				up.add(columns.get(i).get(columns.get(i).size()-1));
				}
			catch(IndexOutOfBoundsException e) {} // empty columns have no up card
			}
		return(up);
		}
	//-----------------------------------------------
	public boolean playCard(Card source) {
		boolean playable = false;
		int index = -1;
		for(int i=0; i<SEVEN; i++) {
			index = columns.get(i).size()-1;
			if (index < 0) return(false);
			Card destination = columns.get(i).get(index);
			playable = (
				(destination.getColor() != source.getColor())
				&&
				(source.getValue() == (destination.getValue() - 1))
				);
			if (playable) {
				columns.get(i).add(source);
				break;
				}
			}
		return(playable);
		}
	//-----------------------------------------------
	public boolean playKingFromStack(Card source) {
		if (source.getValue() == 13) {
			for(int i=0; i<SEVEN; i++) {
				if (columns.get(i).isEmpty()) {
					columns.get(i).add(source);
					return(true);
					}
				}
			}
		return(false);
		}
	//-----------------------------------------------
	public boolean playKingFromBoard(Card source) {
		ArrayList<Card> sourceColumn = null;
		if (source.getValue() == 13) {
			for(int i=0; i<SEVEN; i++) {
				if (columns.get(i).contains(source)) {
					sourceColumn = columns.get(i);
					if (sourceColumn.indexOf(source) == 0) { // ignore if already on top of column
						return(false);
						}
					break;
					}
				}
			for(int i=0; i<SEVEN; i++) {
				if (columns.get(i).isEmpty()) {
					columns.get(i).add(source);
					sourceColumn.remove(source);
					bottomsUp(sourceColumn);
					return(true);
					}
				}
			}
		return(false);
		}
	//-----------------------------------------------
	public boolean playCard(Card destination, Card source) {
		ArrayList<Card> destinationColumn = null;
		ArrayList<Card> sourceColumn = null;
		boolean playable = (
			(destination.getColor() != source.getColor())
			&&
			(source.getValue() == (destination.getValue() - 1))
			);
		if (playable) {
			for(int i=0; i<SEVEN; i++) {
				if (columns.get(i).contains(destination)) {
					destinationColumn = columns.get(i);
					break; // it can only be one
					}
				}
			for(int i=0; i<SEVEN; i++) {
				if (columns.get(i).contains(source)) {
					sourceColumn = columns.get(i);
					break; // it can only be one
					}
				}
			ArrayList<Card> deletion = new ArrayList<Card>();
			for (Card c : sourceColumn) {
				if (!c.isHidden()) {
					destinationColumn.add(c);
					deletion.add(c);
					}
				}
			sourceColumn.removeAll(deletion);
			bottomsUp(sourceColumn);
			}
		return(playable);
		}
	//-----------------------------------------------
	private void showColumn(ArrayList<Card> g, StringBuffer sb) {
		for(int i=0; i<g.size(); i++){
			sb.append(g.get(i).draw());
			}
		}
	//-----------------------------------------------
	public String show(){
		StringBuffer sb = new StringBuffer();
		sb.append("======================\n");
		sb.append("=== Board ============\n");
		for(int i=0; i<SEVEN; i++) {
			showColumn(columns.get(i),sb);
			if (i != (SEVEN-1)) sb.append("\n----------------------\n");
			}
		sb.append("\n======================\n");
		return(sb.toString());
		}
	//-----------------------------------------------
}
//---------------------------------------------------
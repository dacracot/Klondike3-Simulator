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
		try {
			bottomUpCard = column_1.get(column_1.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_1.remove(column_1.size()-1);
				bottomsUp(column_1);
				}
			}
		catch(IndexOutOfBoundsException e) {} // empty columns have no up card
		try {
			bottomUpCard = column_2.get(column_2.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_2.remove(column_2.size()-1);
				bottomsUp(column_2);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_3.get(column_3.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_3.remove(column_3.size()-1);
				bottomsUp(column_3);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_4.get(column_4.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_4.remove(column_4.size()-1);
				bottomsUp(column_4);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_5.get(column_5.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_5.remove(column_5.size()-1);
				bottomsUp(column_5);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_6.get(column_6.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_6.remove(column_6.size()-1);
				bottomsUp(column_6);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		try {
			bottomUpCard = column_7.get(column_7.size()-1);
			if (card.stringEquals(bottomUpCard)) {
				column_7.remove(column_7.size()-1);
				bottomsUp(column_7);
				}
			}
		catch(IndexOutOfBoundsException e) {}
		}
	//-----------------------------------------------
	public ArrayList<Card> getUpCardsFromTop() {
		ArrayList<Card> up = new ArrayList<Card>();
		for(Card card : column_1) {
			if (!card.isHidden()) {
				up.add(card);
				break;
				}
			}
		for(Card card : column_2) {
			if (!card.isHidden()) {
				up.add(card);
				break;
				}
			}
		for(Card card : column_3) {
			if (!card.isHidden()) {
				up.add(card);
				break;
				}
			}
		for(Card card : column_4) {
			if (!card.isHidden()) {
				up.add(card);
				break;
				}
			}
		for(Card card : column_5) {
			if (!card.isHidden()) {
				up.add(card);
				break;
				}
			}
		for(Card card : column_6) {
			if (!card.isHidden()) {
				up.add(card);
				break;
				}
			}
		for(Card card : column_7) {
			if (!card.isHidden()) {
				up.add(card);
				break;
				}
			}
		return(up);
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
	public boolean canPlayCard(Card destination, Card source) {
		return(false);
		}
	//-----------------------------------------------
	public boolean playCard(Card source) {
return(false);
// 		ArrayList<Card> destinationColumn = null;
// 		Card destination = destinationColumn.get(destinationColumn.size()-1);
// 		boolean playable = (
// 			(destination.getColor() != source.getColor())
// 			&&
// 			(source.getValue() == (destination.getValue() - 1))
// 			);
// 		if (playable) {
// 			destinationColumn.add(source);
// 			}
//		return(playable);
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
			// it can only be in one
			if (column_1.contains(destination)) destinationColumn = column_1;
			if (column_2.contains(destination)) destinationColumn = column_2;
			if (column_3.contains(destination)) destinationColumn = column_3;
			if (column_4.contains(destination)) destinationColumn = column_4;
			if (column_5.contains(destination)) destinationColumn = column_5;
			if (column_6.contains(destination)) destinationColumn = column_6;
			if (column_7.contains(destination)) destinationColumn = column_7;
			// it can only be in one
			if (column_1.contains(source)) sourceColumn = column_1;
			if (column_2.contains(source)) sourceColumn = column_2;
			if (column_3.contains(source)) sourceColumn = column_3;
			if (column_4.contains(source)) sourceColumn = column_4;
			if (column_5.contains(source)) sourceColumn = column_5;
			if (column_6.contains(source)) sourceColumn = column_6;
			if (column_7.contains(source)) sourceColumn = column_7;
			// --
			ArrayList<Card> deletion = new ArrayList<Card>();
			for (Card c : sourceColumn) {
				if (!c.isHidden()) {
					destinationColumn.add(c);
					deletion.add(c);
					}
				}
			sourceColumn.removeAll(deletion);
			if (!bottomsUp(sourceColumn)) {
//
// king's exception for empty column
//
				}
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
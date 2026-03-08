package org.dacracot.card;
//---------------------------------------------------
//---------------------------------------------------
public class Card implements Comparable<Card> {
	//-----------------------------------------------
	private final Suit SUIT;
	//-----------------------------------------------
	private final int VALUE;
	//-----------------------------------------------
	private boolean hidden;
	//-----------------------------------------------
	public Card(Suit suit, int value, boolean hidden){
		if(value < 1 || value > 13){
			throw new IllegalArgumentException("Value out of range.");
			}
		this.SUIT = suit;
		this.VALUE = value;
		this.hidden = hidden;
		}
	//-----------------------------------------------
	public Suit getSuit(){
		return SUIT;
		}
	//-----------------------------------------------
	public int getValue(){
		return VALUE;
		}
	//-----------------------------------------------
	public void flip(){
		hidden = !hidden;
		}
	//-----------------------------------------------
	public boolean isHidden(){
		return hidden;
		}
	//-----------------------------------------------
	public void setHidden(boolean hidden){
		this.hidden = hidden;
		}
	//-----------------------------------------------
	private void drawBack(){
		System.err.format("|•%1s%1s•|",valueToString(),SUIT.getChar());
		}
	//-----------------------------------------------
	private void drawFront(){
		System.err.format("| %1s%1s |",valueToString(),SUIT.getChar());
		}
	//-----------------------------------------------
	public void draw(){
		if(hidden){
			drawBack();
		} else { 
			drawFront();
		}
	}
	//-----------------------------------------------
	private String valueToString(){
		switch(VALUE){
		case 1: return "A";	 //Ace
		case 11: return "J"; //Jack
		case 12: return "Q"; //Queen
		case 13: return "K"; //King
		default: return Integer.toString(VALUE);//Number card.
		}
	}
	//-----------------------------------------------
	/**
	 * Compares this card with some other card. Per the specifications, a negative
	 * integer, zero, or a positive integer will be returned if this card is less
	 * than, equal to, or greater than the given card respectively. Specifically,
	 * the number returned is this card's value minus the given card's value. 
	 */
	@Override
	public int compareTo(Card card) {
		return VALUE - card.getValue();
	}
	//-----------------------------------------------
	/**
	 * Compares the color of this card with some other card.
	 * @param card The card to be compared with.
	 * @return <code>true</code> if this card and the other card have the same
	 * color, otherwise <code>false</code>.
	 */
	public boolean colorEquals(Card card){
		return SUIT.getColor() == card.getSuit().getColor();
	}
	//-----------------------------------------------
}
//---------------------------------------------------
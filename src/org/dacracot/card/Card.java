package org.dacracot.card;
//---------------------------------------------------
//---------------------------------------------------
public class Card {
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
	public Suit.Color getColor(){
		return SUIT.getColor();
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
	private String drawBack(){
		return(String.format("|•%1s%1s•|",valueToString(),SUIT.getChar()));
		}
	//-----------------------------------------------
	private String drawFront(){
		return(String.format("| %1s%1s |",valueToString(),SUIT.getChar()));
		}
	//-----------------------------------------------
	public String draw(){
		if(hidden){
			return(drawBack());
		} else { 
			return(drawFront());
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
	public String toString() {
		return(String.format("| %1s%1s |",this.valueToString(),this.getSuit().getChar()));
		}
	//-----------------------------------------------
	public boolean stringEquals(Card card){
		String inquery = card.toString();
		String self = this.toString();
		return (self.equals(inquery));
		}
	//-----------------------------------------------
}
//---------------------------------------------------
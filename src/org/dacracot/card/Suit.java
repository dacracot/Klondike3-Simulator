package org.dacracot.card;
//---------------------------------------------------
public enum Suit {
	//-----------------------------------------------
	SPADES, HEARTS, DIAMONDS, CLUBS;
	//-----------------------------------------------
	public enum Color {RED, BLACK}
	//-----------------------------------------------
	public Color getColor(){
		switch(this){
			case HEARTS:
			case DIAMONDS:
				return(Color.RED);
			case SPADES:
			case CLUBS:
				return(Color.BLACK);
			}
		return(null);
		}
	//-----------------------------------------------
	public String getChar(){
		switch(this){
			case SPADES:
				return("♠︎");
			case HEARTS:
				return("♥︎");
			case CLUBS:
				return("♣︎");
			case DIAMONDS:
				return("♦︎");
			}
		return("How did we get here?");
		}
	//-----------------------------------------------
}
//---------------------------------------------------

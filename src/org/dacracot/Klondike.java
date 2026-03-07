package org.dacracot;
//---------------------------------------------------
import org.dacracot.card.Card;
import org.dacracot.card.Deck;
import org.dacracot.play.Goal;
import org.dacracot.play.Stack;
//---------------------------------------------------
public class Klondike{
	//-----------------------------------------------
	private int flips;
	private Deck deck;
	private Goal goal;
	private Stack stack;
	//-----------------------------------------------
	public Klondike(int f){
		flips = f;
		deck = new Deck();
		goal = new Goal();
		stack = new Stack(deck.getStack(),flips);
		}
	//-----------------------------------------------
	public boolean play(){
		stack.showStacks();
		stack.flip();
		stack.showStacks();
		int moves = 0;
		int anyMoves = 0;
		int noMoves = 0;
		while((stack.sizeDown() + stack.sizeUp()) > 0){
			if (goal.playCard(stack.getUpCard())){
				stack.removeUpCard();
				moves++;
				}
			else{
			
			// if (board.moveCards()){moves++;}
			
			// if (board.playCard(stack.getUpCard())){
			//    stack.removeUpCard();
			//    moves++;
			//    }
			
				if(stack.flip()){ //flopped
					if (anyMoves == moves)
						noMoves++;
					else{
						anyMoves = moves;
						noMoves = 0;
						}
					}
				}
//			stack.showStacks();
//			goal.showGoals();
			if (goal.winner()){
				System.err.println();
				System.err.println("WINNER");
				System.err.println();
				stack.showStacks();
				goal.showGoals();
				return(true);
				}
			else if(noMoves > 3){
				System.err.println();
				System.err.println("LOSER");
				System.err.println();
				stack.showStacks();
				goal.showGoals();
				return(false);
				}
// try{System.in.read();}catch(Exception e){}
			}
		System.err.println("Huh?");
		return(false);
		}
	//-----------------------------------------------
}
//---------------------------------------------------
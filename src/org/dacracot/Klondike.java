package org.dacracot;
//---------------------------------------------------
import org.dacracot.card.Card;
import org.dacracot.card.Deck;
import org.dacracot.table.Goal;
import org.dacracot.table.Board;
import org.dacracot.table.Stack;
//---------------------------------------------------
public class Klondike{
	//-----------------------------------------------
	private int flips;
	private Deck deck;
	private Goal goal;
	private Board board;
	private Stack stack;
	//-----------------------------------------------
	public Klondike(int f){
		flips = f;
		deck = new Deck();
		goal = new Goal();
		board = new Board(deck);
		stack = new Stack(deck.getStack(),flips);
		}
	//-----------------------------------------------
	private void showAll(String title){
		System.err.println("~~~~~~~~~~~~~~~~~~");
		System.err.println("~~~ "+title+" ~~~~~~~~~");
		goal.show();
		board.show();
		stack.show();
		System.err.println("~~~~~~~~~~~~~~~~~~");
		}
	//-----------------------------------------------
	public boolean play(){
		stack.flip();
		showAll("begin");
		int moves = 0;
		int anyMoves = 0;
		int noMoves = 0;
		while((stack.sizeDown() + stack.sizeUp()) > 0){
			if (goal.playCard(stack.getUpCard())){
				stack.removeUpCard();
				moves++;
				showAll("move stack to goal");
				}
			else{
			
			// if (board.moveCards()){moves++;}
			
			// if (board.playCard(stack.getUpCard())){
			//    stack.removeUpCard();
			//    moves++;
			//    }
			
				if(stack.flip()){ //flopped
					if (anyMoves == moves) {
						noMoves++;
						}
					else{
						anyMoves = moves;
						noMoves = 0;
						}
					}
				showAll("flip");
				}
//			stack.showStacks();
//			goal.showGoals();
			if (goal.winner()){
				System.err.println();
				System.err.println("WINNER");
				System.err.println();
				showAll("WINNER");
				return(true);
				}
			else if(noMoves > 3){
				System.err.println();
				System.err.println("LOSER");
				System.err.println();
				showAll("LOSER");
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
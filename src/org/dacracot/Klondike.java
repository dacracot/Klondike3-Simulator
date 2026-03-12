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
		if (Global.debug){
			System.err.println("~~~~~~~~~~~~~~~~~~");
			System.err.println("~~~ "+title+" ~~~~~~~~~");
			goal.show();
			board.show();
			stack.show();
			System.err.println("~~~~~~~~~~~~~~~~~~");
			}
		}
	//-----------------------------------------------
	@Deprecated(forRemoval = true)
	public boolean play(){
System.err.println("play begin");
// System.out.println("xxx > "+xxx);
		stack.flip();
		showAll("begin");
		int moves = 0;
		int anyMoves = 0;
		int noMoves = 0;
System.err.println("play ~~1~~");
		while((stack.sizeDown() + stack.sizeUp()) > 0){
System.err.println("play ~~2~~");
			if (goal.playCard(stack.getUpCard())){
System.err.println("play ~~3~~");
				stack.removeUpCard();
				moves++;
				showAll("move stack to goal");
System.err.println("play ~~4~~");
				}
			else{
System.err.println("play ~~5~~");
			
			// if (board.playCard(stack.getUpCard())){
			//    stack.removeUpCard();
			//    moves++;
			//    }
System.err.println("play ~~6~~");
			
				if(stack.flip()){ //flopped
System.err.println("play ~~7~~");
					if (anyMoves == moves) {
System.err.println("play ~~8~~");
						noMoves++;
						}
					else{
System.err.println("play ~~9~~");
						anyMoves = moves;
						noMoves = 0;
System.err.println("play ~~10~~");
						}
					}
System.err.println("play ~~11~~");
				showAll("flip");
				}
System.err.println("play ~~12~~");
			if (goal.winner()){
System.err.println("play ~~13~~");
				showAll("WINNER");
				return(true);
				}
			else if(noMoves > 3){
System.err.println("play ~~14~~");
				showAll("LOSER");
				return(false);
				}
System.err.println("play ~~15~~");
			}
System.err.println("play end");
		return(false);
		}
	//-----------------------------------------------
}
//---------------------------------------------------
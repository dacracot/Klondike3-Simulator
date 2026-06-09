package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.card.Card;
import org.dacracot.Klondike;
//---------------------------------------------------
public class FromStack {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	public FromStack (Klondike game) {
		this.game = game;
		}
	//-----------------------------------------------
	//
	// Move a card from the stack to the board.
	//
	public boolean toBoard() {
		// Get upper most card from stack.
		Card upCard = game.stack.getUpCard();
		// Stack is empty.
		if (upCard == null) return(false);
		// Play any kings to any empty colum.
		if (game.board.playKingFromStack(upCard)){
			// Remove played card from stack.
			game.stack.removeUpCard();
			return(true);
			}
		// Play card to first available column.
		if (game.board.playCard(upCard)){
			// Remove played card from stack.
			game.stack.removeUpCard();
			return(true);
			}
		// Return false if no play as available.
		return(false);
		}
	//-----------------------------------------------
	//
	// Move a card from the stack to the foundation.
	//
	public boolean toFoundation() {
		// Get upper most card from stack.
		Card upCard = game.stack.getUpCard();
		// Stack is empty.
		if (upCard == null) return(false);
		// Play card to foundation.
		if (game.foundation.playCard(upCard)){
			// Remove played card from stack.
			game.stack.removeUpCard();
			return(true);
			}
		// Return false if no play as available.
		return(false);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
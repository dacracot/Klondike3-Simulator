package org.dacracot.move;
//---------------------------------------------------
import java.util.ArrayList;
import org.dacracot.Klondike;
import org.dacracot.card.Card;
//---------------------------------------------------
public class FromBoard implements From {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	public FromBoard (Klondike game) {
		this.game = game;
		}
	//-----------------------------------------------
	//
	// Move a card from the board to the board.
	//
	@Override
	public boolean toBoard() {
		// Get a list of the face-up bottom most cards starting with originally shortest column.
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		// Get a list of the face-up top most cards starting with originally shortest column.
		ArrayList<Card> topUpCards = game.board.getUpCardsFromTop();
		// Loop thru bottom up cards.
		for(Card bottomUpCard : bottomUpCards) {
			// Loop thru top up cards.
			for(Card topUpCard : topUpCards) {
				// Play any kings to any empty colum.
				if (game.board.playKingFromBoard(topUpCard)) {
					return(true);
					}
				// Play any top card to any matching bottom card.
				if (game.board.playCard(bottomUpCard,topUpCard)) {
					return(true);
					}
				}
			// Return true for the successful first play.
			}
		// Return false if no play as available.
		return(false);
		}
	//-----------------------------------------------
	//
	// Move a card from the board to the goal.
	//
	@Override
	public boolean toGoal() {
		boolean played = false;
		// Get a list of the face-up bottom most cards starting with originally shortest column.
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		// Loop thru bottom up cards.
		for(Card bottomUpCard : bottomUpCards) {
			// Play card on goal.
			if (game.goal.playCard(bottomUpCard)) {
				// Remove played card from board.
				game.board.removeCard(bottomUpCard);
				played = true;
				}
			// Play all playable cards, return true.
			}
		// Return false if no play as available.
		return(played);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
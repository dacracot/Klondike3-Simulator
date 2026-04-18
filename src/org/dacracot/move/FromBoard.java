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
	// Move a card from the board to the board, but only if the source's
	// column has face-down cards (so that the move reveals a new card).
	//
	public boolean toBoardReveal() {
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		ArrayList<Card> topUpCards = game.board.getUpCardsFromTop();
		for(Card bottomUpCard : bottomUpCards) {
			for(Card topUpCard : topUpCards) {
				if (topUpCard.getValue() == 13) {
					// playKingFromBoard moves only the king; it reveals iff
					// the king is the bottom-most face-up card (i.e. hidden
					// card directly beneath it).
					if (!game.board.removeCardWouldReveal(topUpCard)) continue;
					if (game.board.playKingFromBoard(topUpCard)) {
						return(true);
						}
					}
				else {
					// playCard moves the whole face-up run; it reveals iff
					// the column has any hidden card (bottomsUp flips the
					// new bottom after the run is stripped).
					if (!game.board.columnHasHidden(topUpCard)) continue;
					if (game.board.playCard(bottomUpCard,topUpCard)) {
						return(true);
						}
					}
				}
			}
		return(false);
		}
	//-----------------------------------------------
	//
	// Move a card from the board to the board, only when the source's
	// column has no face-down cards (no reveal happens).
	//
	public boolean toBoardNoReveal() {
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		ArrayList<Card> topUpCards = game.board.getUpCardsFromTop();
		for(Card bottomUpCard : bottomUpCards) {
			for(Card topUpCard : topUpCards) {
				if (topUpCard.getValue() == 13) {
					if (game.board.removeCardWouldReveal(topUpCard)) continue;
					if (game.board.playKingFromBoard(topUpCard)) {
						return(true);
						}
					}
				else {
					if (game.board.columnHasHidden(topUpCard)) continue;
					if (game.board.playCard(bottomUpCard,topUpCard)) {
						return(true);
						}
					}
				}
			}
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
	//
	// Move a card from the board to the goal, but only when removing
	// the card would reveal a face-down card underneath it.
	//
	public boolean toGoalReveal() {
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		for(Card bottomUpCard : bottomUpCards) {
			if (!game.board.removeCardWouldReveal(bottomUpCard)) continue;
			if (game.goal.playCard(bottomUpCard)) {
				game.board.removeCard(bottomUpCard);
				return(true);
				}
			}
		return(false);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
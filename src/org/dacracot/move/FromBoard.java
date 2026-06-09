package org.dacracot.move;
//---------------------------------------------------
import java.util.ArrayList;
import java.util.Collections;
import org.dacracot.Klondike;
import org.dacracot.card.Card;
import org.dacracot.move.criteria.CardColumnLengthAscending;
import org.dacracot.move.criteria.CardColumnLengthDescending;
//---------------------------------------------------
public class FromBoard {
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
	public boolean toBoard() {
		// Get a list of the face-up bottom most cards starting with originally shortest column.
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		// Get a list of the face-up top most cards starting with originally shortest column.
		ArrayList<Card> topUpCards = game.board.getUpCardsFromTop();
		//-------------------------------------------
		// 
		// Primary new strategy implements sorting the choice of two playable cards.
		// For instance, two red Jacks at the top the face up cards in two separate
		// columns can both be played on an exposed face up black Queen. So which do
		// you choose? From the column with the most or least face down cards?  Some
		// would say least, to make room for Kings, others would say most to expose
		// face down cards as quickly as possible.  Trialed both scenarios with one
		// million games:
		//
		// Left to right, no variance 					baseline =	 8.54274%
		// Least face down (shortest column) first 		least = 	 8.89590%
		// Most face down (longest column) first 		most = 		11.74316%
		//
		// While least is better than the baseline, most is the clear winner.
		//
		CardColumnLengthDescending ccld = new CardColumnLengthDescending();
		Collections.sort(topUpCards,ccld);
		//-------------------------------------------
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
	// Move a card from the board to the foundation.
	//
	public boolean toFoundation() {
		boolean played = false;
		// Get a list of the face-up bottom most cards starting with originally shortest column.
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		//-------------------------------------------
		// 
		// Primary new strategy implements sorting the choice of two playable cards.
		//
		CardColumnLengthAscending ccla = new CardColumnLengthAscending();
		Collections.sort(bottomUpCards,ccla);
		//-------------------------------------------
		// Loop thru bottom up cards.
		for(Card bottomUpCard : bottomUpCards) {
			// Play card on foundation.
			if (game.foundation.playCard(bottomUpCard)) {
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
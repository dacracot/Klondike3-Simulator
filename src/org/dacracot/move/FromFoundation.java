package org.dacracot.move;
//---------------------------------------------------
import java.util.ArrayList;
import java.util.Collections;
import org.dacracot.card.Card;
import org.dacracot.Klondike;
import org.dacracot.move.criteria.CardColumnLengthAscending;
import org.dacracot.move.criteria.CardColumnLengthDescending;
//---------------------------------------------------
public class FromFoundation {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	public FromFoundation (Klondike game) {
		this.game = game;
		}
	//-----------------------------------------------
	//
	// Move a card from the foundation to the tableau.
	//
	public boolean toTableau() {
		// Get a list of the face-up bottom most cards starting with originally shortest column.
		ArrayList<Card> bottomUpCards = game.tableau.getUpCardsFromBottom();
		// Get a list of the face-up top most cards starting with originally shortest column.
		ArrayList<Card> returnCards = game.foundation.getUpCardsFromBottom();
		//-------------------------------------------
		// Sort the longest foundation column first
		CardColumnLengthDescending ccld = new CardColumnLengthDescending();
		Collections.sort(returnCards,ccld);
System.out.println("-- 1 --");
		//-------------------------------------------
		// Loop thru bottom up cards.
		for(Card bottomUpCard : bottomUpCards) {
			// Loop thru top up cards.
System.out.println("-- 2 -- bottomUpCard: "+bottomUpCard.toString());
			for(Card returningCard : returnCards) {
				// Play any top card to any matching bottom card.
System.out.println("-- 3 -- returningCard: "+returningCard.toString());
				if (game.tableau.returnCard(bottomUpCard,returningCard)) {
System.out.println("-- 4 --");
					game.foundation.removeCard(returningCard);
System.out.println(game.showAll("returned"));
System.out.println("-- 5 --");
					return(true);
					}
System.out.println("-- 6 --");
				}
			// Return true for the successful first play.
System.out.println("-- 7 --");
			}
		// Return false if no play as available.
System.out.println("-- 8 --");
		return(false);
		}
	//-----------------------------------------------
	//
	// Move a card from the foundation to the foundation.
	//
	public boolean toFoundation() {
		// This makes no sense from a game perspective
		// and should not be implemented.
		return(false);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
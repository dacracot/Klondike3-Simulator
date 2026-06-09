package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.card.Card;
import org.dacracot.Klondike;
//---------------------------------------------------
public class FromDeck {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	public FromDeck (Klondike game) {
		this.game = game;
		}
	//-----------------------------------------------
	//
	// Move a card from the deck to the tableau.
	//
	public boolean toTableau() {
		// Get upper most card from deck.
		Card upCard = game.deck.getUpCard();
		// Deck is empty.
		if (upCard == null) return(false);
		// Play any kings to any empty colum.
		if (game.tableau.playKingFromDeck(upCard)){
			// Remove played card from deck.
			game.deck.removeUpCard();
			return(true);
			}
		// Play card to first available column.
		if (game.tableau.playCard(upCard)){
			// Remove played card from deck.
			game.deck.removeUpCard();
			return(true);
			}
		// Return false if no play as available.
		return(false);
		}
	//-----------------------------------------------
	//
	// Move a card from the deck to the foundation.
	//
	public boolean toFoundation() {
		// Get upper most card from deck.
		Card upCard = game.deck.getUpCard();
		// Deck is empty.
		if (upCard == null) return(false);
		// Play card to foundation.
		if (game.foundation.playCard(upCard)){
			// Remove played card from deck.
			game.deck.removeUpCard();
			return(true);
			}
		// Return false if no play as available.
		return(false);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
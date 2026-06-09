package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.Klondike;
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
	// Move a card from the foundation to the board.
	//
	public boolean toBoard() {
		// This is yet to be implemented.
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
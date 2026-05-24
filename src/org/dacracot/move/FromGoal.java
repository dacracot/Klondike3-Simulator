package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.Klondike;
//---------------------------------------------------
public class FromGoal {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	public FromGoal (Klondike game) {
		this.game = game;
		}
	//-----------------------------------------------
	//
	// Move a card from the goal to the board.
	//
	public boolean toBoard() {
		// This is yet to be implemented.
		return(false);
		}
	//-----------------------------------------------
	//
	// Move a card from the goal to the goal.
	//
	public boolean toGoal() {
		// This makes no sense from a game perspective
		// and should not be implemented.
		return(false);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
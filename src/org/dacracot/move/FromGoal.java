package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.Klondike;
//---------------------------------------------------
public class FromGoal implements From {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	public FromGoal (Klondike game) {
		this.game = game;
		}
	//-----------------------------------------------
	@Override
	public boolean toBoard() {
		return(false);
		}
	//-----------------------------------------------
	@Override
	public boolean toGoal() {
		return(false);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
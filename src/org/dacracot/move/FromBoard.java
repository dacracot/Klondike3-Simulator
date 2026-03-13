package org.dacracot.move;
//---------------------------------------------------
import java.util.ArrayList;
import org.dacracot.Klondike;
import org.dacracot.move.tests.MoreFaceDown;
import org.dacracot.move.tests.TieBreaker;
import org.dacracot.move.tests.WillFreeColumn;
//---------------------------------------------------
public class FromBoard implements From {
	//-----------------------------------------------
	private Klondike game;
	private ArrayList<TieBreaker> tests;
	//-----------------------------------------------
	public FromBoard (Klondike game) {
		game = this.game;
		tests = new ArrayList<TieBreaker>();
		tests.add(new WillFreeColumn());
		tests.add(new MoreFaceDown());
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
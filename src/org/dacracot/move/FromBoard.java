package org.dacracot.move;
//---------------------------------------------------
import java.util.ArrayList;
import org.dacracot.move.tests.TieBreaker;
import org.dacracot.move.tests.MoreFaceDown;
import org.dacracot.move.tests.WillFreeColumn;
//---------------------------------------------------
public class FromBoard implements From {
	//-----------------------------------------------
	private ArrayList<TieBreaker> tests;
	//-----------------------------------------------
	public FromBoard () {
		tests = new ArrayList<TieBreaker>();
		tests.add(new WillFreeColumn());
		tests.add(new MoreFaceDown());
		}
	//-----------------------------------------------
	@Override
	public int toBoard() {
		return(0);
		}
	//-----------------------------------------------
	@Override
	public int toGoal() {
		return(0);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
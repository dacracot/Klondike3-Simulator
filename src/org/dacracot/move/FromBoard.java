package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.move.tests.moreFaceDown;
//---------------------------------------------------
public class FromBoard implements From {
	//-----------------------------------------------
	private TieBreaker[] tests;
	//-----------------------------------------------
	public FromBoard () {
		tests.add(new WillFreeColumn());
		tests.add(new MoreFaceDown());
		}
	//-----------------------------------------------
	public int toBoard() {
		return(0);
		}
	//-----------------------------------------------
	public int toGoal() {
		return(0);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
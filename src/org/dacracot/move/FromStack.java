package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.Klondike;
//---------------------------------------------------
public class FromStack implements From {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	public FromStack (Klondike game) {
		game = this.game;
		}
	//-----------------------------------------------
	@Override
	public boolean toBoard() {
		return(false);
		}
	//-----------------------------------------------
	@Override
	public boolean toGoal() {
		if (game.goal.playCard(game.stack.getUpCard())){
			game.stack.removeUpCard();
			return(true);
			}
		return(false);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
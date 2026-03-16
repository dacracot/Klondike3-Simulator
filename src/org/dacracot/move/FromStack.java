package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.Klondike;
//---------------------------------------------------
public class FromStack implements From {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	public FromStack (Klondike game) {
		this.game = game;
		}
	//-----------------------------------------------
	@Override
	public boolean toBoard() {
		if (game.board.playCard(game.stack.getUpCard())){
			game.stack.removeUpCard();
			return(true);
			}
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
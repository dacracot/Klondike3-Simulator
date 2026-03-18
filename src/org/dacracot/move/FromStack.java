package org.dacracot.move;
//---------------------------------------------------
import org.dacracot.card.Card;
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
		Card upCard = game.stack.getUpCard();
		if (upCard == null) return(false);
		if (game.board.playKingFromStack(upCard)){
			game.stack.removeUpCard();
			return(true);
			}
		if (game.board.playCard(upCard)){
			game.stack.removeUpCard();
			return(true);
			}
		return(false);
		}
	//-----------------------------------------------
	@Override
	public boolean toGoal() {
		Card upCard = game.stack.getUpCard();
		if (upCard == null) return(false);
		if (game.goal.playCard(upCard)){
			game.stack.removeUpCard();
			return(true);
			}
		return(false);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
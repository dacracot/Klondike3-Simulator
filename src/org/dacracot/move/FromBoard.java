package org.dacracot.move;
//---------------------------------------------------
import java.util.ArrayList;
import org.dacracot.Klondike;
import org.dacracot.card.Card;
//---------------------------------------------------
public class FromBoard implements From {
	//-----------------------------------------------
	private Klondike game;
	//-----------------------------------------------
	@Override
	public boolean toBoard() {
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		ArrayList<Card> topUpCards = game.board.getUpCardsFromTop();
		for(Card bottomUpCard : bottomUpCards) {
			for(Card topUpCard : topUpCards) {
				if (game.board.playKingFromBoard(topUpCard)) {
					return(true);
					}
				if (game.board.playCard(bottomUpCard,topUpCard)) {
					return(true);
					}
				}
			}
		return(false);
		}
	//-----------------------------------------------
	@Override
	public boolean toGoal() {
		boolean played = false;
		ArrayList<Card> upCards = game.board.getUpCardsFromBottom();
		for(Card upCard : upCards) {
			if (game.goal.playCard(upCard)) {
				game.board.removeCard(upCard);
				played = true;
				}
			}
		return(played);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
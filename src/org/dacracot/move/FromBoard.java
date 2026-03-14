package org.dacracot.move;
//---------------------------------------------------
import java.util.ArrayList;
import org.dacracot.Klondike;
import org.dacracot.card.Card;
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
		this.game = game;
		tests = new ArrayList<TieBreaker>();
		tests.add(new WillFreeColumn());
		tests.add(new MoreFaceDown());
		}
	//-----------------------------------------------
	@Override
	public boolean toBoard() {
		boolean played = false;
		ArrayList<Card> bottomUpCards = game.board.getUpCardsFromBottom();
		ArrayList<Card> topUpCards = game.board.getUpCardsFromTop();
		for(Card bottomUpCard : bottomUpCards) {
			for(Card topUpCard : topUpCards) {
				if (game.board.playCard(bottomUpCard,topUpCard)) {
					played = true;
					}
				}
			}
		return(played);
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
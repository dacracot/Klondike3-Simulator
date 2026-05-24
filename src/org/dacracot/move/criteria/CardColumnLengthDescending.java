package org.dacracot.move.criteria;
//---------------------------------------------------
import java.util.Comparator;
import org.dacracot.card.Card;
//---------------------------------------------------
public class CardColumnLengthDescending implements Comparator<Card> {
	//-----------------------------------------------
	@Override
	public int compare(Card left, Card right) {
		return (Integer.compare(right.getWeight(),left.getWeight()));
		}
	//-----------------------------------------------
}
//---------------------------------------------------

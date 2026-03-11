package org.dacracot.play;
//---------------------------------------------------
import org.dacracot.card.Card;
//---------------------------------------------------
import java.util.ArrayList;
//---------------------------------------------------
public class Stack {
	//-----------------------------------------------
	private ArrayList<Card> up = new ArrayList<Card>();
	private ArrayList<Card> down = new ArrayList<Card>();
	private int cardsToFlip;
	//-----------------------------------------------
	public Stack(ArrayList<Card> d, int f){
		flop(d);
		cardsToFlip = f;
		}
	//-----------------------------------------------
	private void upToDown(){
		flop(up);
		up.clear();
		}
	//-----------------------------------------------
	private void flop(ArrayList<Card> d){
		down = new ArrayList<Card>(d);
		for(int i=0; i<down.size(); i++){
			down.get(i).setHidden(true);
			}
		}
	//-----------------------------------------------
	public boolean flip(){
		boolean flopped = false;
		if (down.size() == 0){
			upToDown();
			flopped = true;
			}
		int limit = 0;
		if (down.size() >= cardsToFlip) limit = cardsToFlip;
		if ((down.size() < cardsToFlip) && (down.size() > 0)) limit = down.size();
 		for(int i=0; i<limit; i++){
			Card m = down.get(down.size()-1);
			m.setHidden(false);
			up.add(m);
			down.remove(down.size()-1);
			}
		return(flopped);
		}
	//-----------------------------------------------
	private void showStack(ArrayList<Card> g){
		for(int i=0; i<g.size(); i++){
			g.get(i).draw();
			}
		System.err.println();
		}
	//-----------------------------------------------
	public Card getUpCard(){
		if (up.size() == 0) flip();
		return(up.get((up.size()-1)));
		}
	//-----------------------------------------------
	public void removeUpCard(){
		up.remove((up.size()-1));
		}
	//-----------------------------------------------
	public int sizeUp(){
		return(up.size());
		}
	//-----------------------------------------------
	public int sizeDown(){
		return(down.size());
		}
	//-----------------------------------------------
	public void show(){
		System.err.println("======================");
		System.err.println("=== Stack ============");
		showStack(down);
		System.err.println("----------------------");
		showStack(up);
		System.err.println("======================");
		}
	//-----------------------------------------------
}
//---------------------------------------------------
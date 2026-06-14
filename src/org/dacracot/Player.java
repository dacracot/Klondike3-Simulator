package org.dacracot;
//---------------------------------------------------
import org.dacracot.move.FromDeck;
import org.dacracot.move.FromTableau;
import org.dacracot.move.FromFoundation;
//---------------------------------------------------
public class Player {
	//-----------------------------------------------
	private final int FLOPLIMIT = 3;
	private Klondike game;
	private FromDeck fromDeck;
	private FromTableau fromTableau;
	private FromFoundation fromFoundation;
	private StringBuilder activeGame;
	//-----------------------------------------------
	public Player(int cards){
		game = new Klondike(cards);
		fromDeck = new FromDeck(game);
		fromTableau = new FromTableau(game);
		fromFoundation = new FromFoundation(game);
		activeGame = new StringBuilder();
		}
	//-----------------------------------------------
	private void watcher() {
		try {
			Thread.sleep(1000); // wait 1 seconds
			System.out.print("\033[H\033[2J"); // clear screen
			System.out.flush();
			}
		catch (Exception e) {
			System.err.println(e);
			System.exit(1);
			}
		}
	//-----------------------------------------------
	private boolean playRescue() {
		boolean moved = false;
		// Return cards from foundation to tableau one at a time
		while (fromFoundation.toTableau()) {
			if (Global.debug){activeGame.append(game.showAll("f2t"));}
			if (Global.watch){System.out.println(game.showAll("f2t"));watcher();}
			// Play tableau to tableau until no more moves available
			while(fromTableau.toTableau()) {
				moved = true;
				if (Global.debug){activeGame.append(game.showAll("t2t rescue"));}
				if (Global.watch){System.out.println(game.showAll("t2t rescue"));watcher();}
				}
			// Play deck to tableau until no more moves available
			while(fromDeck.toTableau()) {
				moved = true;
				if (Global.debug){activeGame.append(game.showAll("d2t rescue"));}
				if (Global.watch){System.out.println(game.showAll("d2t rescue"));watcher();}
				}
			}
		return(moved);
		}
	//-----------------------------------------------
	private boolean playNormal() {
		int loops = 0;
		int flops = 0;
		// Play until there are no moves for three loops.
		while(flops < FLOPLIMIT) {
			// Play only one (or none) from deck to foundation
			if (fromDeck.toFoundation()) {
				// Played a card
				flops = 0;
				}
			if (Global.debug){activeGame.append(game.showAll("d2f   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
			if (Global.watch){System.out.println(game.showAll("d2f   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));watcher();}
			// Play tableau to tableau until no more moves available
			while(fromTableau.toTableau()) {
				flops = 0;
				if (Global.debug){activeGame.append(game.showAll("t2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
				if (Global.watch){System.out.println(game.showAll("t2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));watcher();}
				}
			// Play only one (or none) from tableau to foundation
			if (fromTableau.toFoundation()) {
				// Played a card
				flops = 0;
				}
			if (Global.debug){activeGame.append(game.showAll("t2f   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
			if (Global.watch){System.out.println(game.showAll("t2f   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));watcher();}
			// Play deck to tableau until no more moves available
			while(fromDeck.toTableau()) {
				flops = 0;
				if (Global.debug){activeGame.append(game.showAll("d2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
				if (Global.watch){System.out.println(game.showAll("d2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));watcher();}
				}
			// Turn over the deck
			if (game.deck.flip()) {
				flops++;
				}
			if (Global.debug){activeGame.append(game.showAll("s.flip >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));}
			if (Global.watch){System.out.println(game.showAll("s.flip >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));watcher();}
			// Did we win by putting all cards in the foundation?
			if (game.foundation.winner()) {
 				if (Global.debug) {
 					activeGame.append(game.showAll("winner >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)));
					System.out.println("================== WINNER ==================");
					System.out.println(activeGame);
					System.out.println("================== WINNER ==================");
					}
				Global.win();
				return(true);
				}
			}
		return(false);
		}
	//-----------------------------------------------
	public void play() {
		Global.play();
		if (Global.debug){activeGame.append(game.showAll("Ready to Play"));}
		if (Global.watch){System.out.print("\033[H\033[2J");System.out.flush();System.out.println(game.showAll("Ready to Play"));watcher();}
		//-------------------------------------------
		boolean won;
		won = playNormal();
		if (!won) {
			if (playRescue()) {
				won = playNormal();
				}
			}
		//-------------------------------------------
		if ((Global.debug) && (!won)) {
			activeGame.append(game.showAll(" Lost Game "));
			System.out.println("================== LOSER ==================");
			System.out.println(activeGame);
			System.out.println("================== LOSER ==================");
			}
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
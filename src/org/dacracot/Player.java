package org.dacracot;
//---------------------------------------------------
import org.dacracot.move.FromDeck;
import org.dacracot.move.FromFoundation;
import org.dacracot.move.FromTableau;
//---------------------------------------------------
public class Player {
	//-----------------------------------------------
	private int cards;
	private StringBuilder activeGame = new StringBuilder();
	//-----------------------------------------------
	public Player(int cards){
		this.cards = cards;
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
	public void play() {
		Global.play();
		Klondike game = new Klondike(cards);
		FromDeck fromDeck = new FromDeck(game);
		FromTableau fromTableau = new FromTableau(game);
		FromFoundation fromFoundation = new FromFoundation(game);
		if (Global.debug){activeGame.append(game.showAll("Ready to Play"));}
		if (Global.watch){System.out.print("\033[H\033[2J");System.out.flush();System.out.println(game.showAll("Ready to Play"));watcher();}
		//-------------------------------------------
		boolean won = false;
		int loops = 0;
		int flops = 0;
		int saves = 0;
		// Play until there are no moves for three loops.
		while(flops < 3) {
			// Play only one (or none) from deck to foundation
			if (fromDeck.toFoundation()) {
				// Played a card
				flops = 0;
				}
			if (Global.debug){activeGame.append(game.showAll("d2f   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));}
			if (Global.watch){System.out.println(game.showAll("d2f   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));watcher();}
			// Play tableau to tableau until no more moves available
			while(fromTableau.toTableau()) {
				if (Global.debug){activeGame.append(game.showAll("t2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));}
				if (Global.watch){System.out.println(game.showAll("t2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));watcher();}
				}
			// Play only one (or none) from tableau to foundation
			if (fromTableau.toFoundation()) {
				// Played a card
				flops = 0;
				}
			if (Global.debug){activeGame.append(game.showAll("t2f   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));}
			if (Global.watch){System.out.println(game.showAll("t2f   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));watcher();}
			// Play deck to tableau until no more moves available
			while(fromDeck.toTableau()) {
				if (Global.debug){activeGame.append(game.showAll("d2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));}
				if (Global.watch){System.out.println(game.showAll("d2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));watcher();}
				}
			// Turn over the deck
			if (game.deck.flip()) {
				flops++;
				}
			if (Global.debug){activeGame.append(game.showAll("s.flip >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));}
			if (Global.watch){System.out.println(game.showAll("s.flip >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));watcher();}
			// Did we win by putting all cards in the foundation?
			if (game.foundation.winner()) {
 				if (Global.debug) {
 					activeGame.append(game.showAll("winner >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));
					System.out.println("================== WINNER ==================");
					System.out.println(activeGame);
					System.out.println("================== WINNER ==================");
					}
				won = true;
				Global.win();
				break;
				}
			// Saved by the foundation
			if ((flops >= 3) && (saves > 3)) {
				// Play tableau to tableau until no more moves available
				while(fromFoundation.toTableau()) {
					if (Global.debug){activeGame.append(game.showAll("f2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));}
					if (Global.watch){System.out.println(game.showAll("f2t   >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));watcher();}
					}
				saves++;
				}
			}
		//-------------------------------------------
		if ((Global.debug) && (!won)) {
			activeGame.append(game.showAll("loser >> loops: "+Integer.toString(loops++)+" | flops:"+Integer.toString(flops)+" | saves:"+Integer.toString(saves)));
			System.out.println("================== LOSER ==================");
			System.out.println(activeGame);
			System.out.println("================== LOSER ==================");
			}
		//-------------------------------------------
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
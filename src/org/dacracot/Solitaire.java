package org.dacracot;
//---------------------------------------------------
import java.util.Scanner;
//---------------------------------------------------
public class Solitaire {
	//-----------------------------------------------
	public Solitaire(){}
	//-----------------------------------------------
	public static void main(String[] args){
		String params = String.join(" ",args);
		if (!params.isEmpty()){
			if (params.indexOf("--one") != -1){
				Global.cards = 1;
				}
			if (params.indexOf("--three") != -1){
				Global.cards = 3;
				}
			if (params.indexOf("--attempts") != -1){
				Scanner cli = new Scanner(params);
				if ("--attempts".equals(cli.findInLine("--attempts"))){
					Global.tries = cli.nextInt();
					}
				cli.close();
				}
			Global.debug = (params.indexOf("--debug") != -1);
			}
		else{
			System.out.println("usage: [--one|--three] [--attempts #] [--debug] ");
			System.out.println("    --one: Turn only one card each play.");
			System.out.println("    --three: Turn three cards each play.");
			System.out.println("    --attempts: Number of games to attempt.");
			System.out.println("    --debug: Verbose output about each game.");
			System.out.println("");
			}
		System.out.println("");
		System.out.println("running: turn "+Global.cards+" cards and "+Global.tries+" attempts "+(Global.debug?"with":"without")+" debug");
		System.out.println("");
		//-------------------------------------------
		for(int i=0; i<Global.tries; i++){
 			Player player = new Player(Global.cards);
 			player.run();
 			}
		}
	//-----------------------------------------------
}
//---------------------------------------------------
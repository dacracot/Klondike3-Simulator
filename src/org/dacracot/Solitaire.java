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
		int cards = 3;
		int tries = 10;
		boolean debug = false;
System.out.println("params> "+params);
		if (!params.isEmpty()){
System.out.println("params.indexOf(--one)> "+params.indexOf("--one"));
			if (params.indexOf("--one") != -1){
				cards = 1;
				}
System.out.println("params.indexOf(--three)> "+params.indexOf("--three"));
			if (params.indexOf("--three") != -1){
				cards = 3;
				}
System.out.println("params.indexOf(--attempts)> "+params.indexOf("--attempts"));
			if (params.indexOf("--attempts") != -1){
				Scanner cli = new Scanner(params);
				if ("--attempts".equals(cli.findInLine("--attempts"))){
					tries = cli.nextInt();
					}
				}
			debug = (params.indexOf("--debug") != -1);
			}
		else{
			System.out.println("usage: [--one | --three] [--attempts #] [--debug] ");
			System.out.println("    --one: Turn only one card each play.");
			System.out.println("    --three: Turn three cards each play.");
			System.out.println("    --attempts: Number of games to attempt.");
			System.out.println("    --debug: Verbose output about each game.");
			System.out.println("");
			}
		System.out.println("");
		System.out.println("running: turn "+cards+" cards and "+tries+" attempts "+(debug?"with":"without")+" debug");
		System.out.println("");
		//-------------------------------------------
		for(int i=0; i<tries; i++){
 			Player player = new Player(cards);
 			player.run();
 			}
		Score.result();
		}
	//-----------------------------------------------
}
//---------------------------------------------------
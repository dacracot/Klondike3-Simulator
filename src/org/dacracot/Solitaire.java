package org.dacracot;
//---------------------------------------------------
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;
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
			if (params.indexOf("--seed") != -1){
				Scanner cli = new Scanner(params);
				if ("--seed".equals(cli.findInLine("--seed"))){
					Global.seed = cli.nextLong();
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
			System.out.println("    --seed: Random seed for repeatable play.");
			System.out.println("");
			}
		System.out.println("");
		System.out.println("running: turn "+Global.cards+" cards and "+Global.tries+" attempts "+(Global.debug?"with":"without")+" debug");
		//-------------------------------------------
		int winner = 0;
		Instant start = Instant.now();
		//-------------------------------------------
		for(int i=0; i<Global.tries; i++){
 			Player player = new Player(Global.cards, Global.seed);
 			if (player.run()) {
 				winner++;
 				System.out.println("================== WINNER ==================");
 				System.out.println(Global.activeGame);
 				System.out.println("================== WINNER ==================");
 				}
  			Global.activeGame.delete(0, Global.activeGame.length());
			System.out.println("Game "+i+" of "+Global.tries);
			}
		//-------------------------------------------
 		Instant end = Instant.now();
		System.out.println("");
		System.out.println("success: won "+winner+" of "+Global.tries+" for "+String.format("%3.3f",(((1.0*winner)/Global.tries)*100))+"%");
 		Duration between = Duration.between(start, end);
		System.out.println("");
 		System.out.format(
 			"duration: %dD, %02d:%02d:%02d",
 			between.toDays(),
 			between.toHoursPart(),
 			between.toMinutesPart(),
 			between.toSecondsPart()
 			);
		System.out.println("");
		}
	//-----------------------------------------------
}
//---------------------------------------------------
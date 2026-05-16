package org.dacracot;
//---------------------------------------------------
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import org.dacracot.util.Statistics;
//---------------------------------------------------
public class Solitaire {
	//-----------------------------------------------
	public Solitaire(){}
	//-----------------------------------------------
	public static void main(String[] args){
		Statistics stats = new Statistics();
		//-------------------------------------------
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			Instant end = Instant.now();
			System.out.println("");
			System.out.println("success: won "+Global.winner+" of "+Global.tried+" for "+String.format("%3.5f",stats.getPercentage())+"%");
			Duration between = Duration.between(Global.start, end);
			System.out.println("");
			System.out.format(
				"duration: %dD, %02d:%02d:%02d",
				between.toDays(),
				between.toHoursPart(),
				between.toMinutesPart(),
				between.toSecondsPart()
				);
			System.out.println("");
			}));
		//-------------------------------------------		
		boolean seeded = false;
		long seed = -1L;
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
			if (params.indexOf("--continuous") != -1){
				Global.tries = Integer.MAX_VALUE;
				}
			if (params.indexOf("--seed") != -1){
				Scanner cli = new Scanner(params);
				if ("--seed".equals(cli.findInLine("--seed"))){
					seeded = true;
					seed = cli.nextLong();
					Global.random = new Random(seed); // seeded Random
					}
				cli.close();
				}
			else {
				Global.random = new Random(); // truly Random
				}
			Global.debug = (params.indexOf("--debug") != -1);
			Global.quiet = (params.indexOf("--quiet") != -1);
			if (Global.quiet) {
				Global.debug = false;
				}
			}
		else{
			System.out.println("usage: [--one|--three] [--attempts #|--continuous] [--debug|--quiet]  [--seed #]");
			System.out.println("    --one: Turn only one card each play.");
			System.out.println("    --three: Turn three cards each play.");
			System.out.println("    --attempts: Number of games to attempt.");
			System.out.println("    --continuous: Attempt games until killed.");
			System.out.println("    --debug: Verbose output about each game.");
			System.out.println("    --quiet: Minimal output about each game.");
			System.out.println("    --seed: Random seed for repeatable play.");
			System.out.println("");
			Global.random = new Random(); // truly Random for no parameters
			}
		System.out.println("");
		System.out.println(
			"running: turn "+Global.cards+" cards"+
			((Global.tries==Integer.MAX_VALUE)?" until killed":" for "+Global.tries+" attempts")+
			(Global.quiet?" quietly ":" ")+
			(Global.debug?"with":"without")+" debug "+
			(seeded?("with "+seed+" seed"):"without a seed")
			);
		System.out.println("");
System.err.println("percent\tcount\tsum\tmean\tmin\tmax");
		//-------------------------------------------
		Global.tried=0;
		while(Global.tried<Global.tries){
 			Player player = new Player(Global.cards);
 			if (player.run()) {
 				Global.winner++;
 				if (!Global.quiet) {
					System.out.println("================== WINNER ==================");
					System.out.println(Global.activeGame);
					System.out.println("================== WINNER ==================");
					}
 				}
  			Global.activeGame.delete(0, Global.activeGame.length());
			if (!Global.quiet) System.out.println("Game "+Global.tried+((Global.tries==Integer.MAX_VALUE)?" until killed":" of "+Global.tries));
			Global.tried++;
			if (Global.tried >= Global.waitForSteadyState) stats.setValue();
			if ((Global.tried % Global.reportInterval) == 0) System.out.println(stats.show());
			}
		//-------------------------------------------
		}
	//-----------------------------------------------
}
//---------------------------------------------------
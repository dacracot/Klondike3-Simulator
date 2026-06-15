package org.dacracot;
//---------------------------------------------------
import java.util.Random;
import java.time.Instant;
//---------------------------------------------------
public class Global {
	//-----------------------------------------------
	private static int tried = 0;
	private static int winner = 0;
	//-----------------------------------------------
	public static Instant start = Instant.now();
	public static int cards = 3;
	public static int tries = 10;
	public static Random random = null;
	public static boolean debug = false;
	public static boolean watch = false;
	public static boolean quiet = false;
	//-----------------------------------------------
	public static double valueSum = 0;
	public static double varianceSum = 0;
	public static int count = 0;
	public static double valueHigh = 0.0;
	public static double valueLow = 100.0;
	public static int reportInterval = 1000000;
	public static int waitForSteadyState = reportInterval-100;
	//-----------------------------------------------
	public static void win() {
		winner++;
		}
	//-----------------------------------------------
	public static void play() {
		tried++;
		}
	//-----------------------------------------------
	public static int getWins() {
		return(winner);
		}
	//-----------------------------------------------
	public static int getTried() {
		return(tried);
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
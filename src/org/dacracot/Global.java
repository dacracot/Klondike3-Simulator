package org.dacracot;
//---------------------------------------------------
import java.util.Random;
import java.time.Instant;
//---------------------------------------------------
public class Global {
	//-----------------------------------------------
	public static Instant start = Instant.now();
	public static int cards = 3;
	public static int tries = 10;
	public static int tried = 0;
	public static int winner = 0;
	public static Random random = null;
	public static boolean debug = false;
	public static boolean quiet = false;
	public static StringBuffer activeGame = new StringBuffer();
	//-----------------------------------------------
	}
//---------------------------------------------------
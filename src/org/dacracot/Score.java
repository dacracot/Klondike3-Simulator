package org.dacracot;
//---------------------------------------------------
import java.text.NumberFormat;
import java.util.Locale;
//---------------------------------------------------
public class Score{
	//-----------------------------------------------
	private static int won = 0;
	private static int loss = 0;
	//-----------------------------------------------
	public static void winner(boolean played) {
		if (played)
			won++;
		else
			loss++;
		}
	//-----------------------------------------------
	public static void result() {
		System.out.println();
		int tries = won + loss;
		System.out.println(" won "+won+" out of "+tries+" for "+NumberFormat.getPercentInstance(Locale.US).format((float)won/tries));
		System.out.println();
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
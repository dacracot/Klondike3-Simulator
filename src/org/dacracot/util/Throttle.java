package org.dacracot.util;
//---------------------------------------------------
public class Throttle
	{
	//-----------------------------------------------
	private static int max = 1;
	private static int count = 0;
	//-----------------------------------------------
	public static void setLimit(int m) {
		max = m;
		}
	//-----------------------------------------------
	public static int getLimit() {
		return(max);
		}
	//-----------------------------------------------
	public static int getCount() {
		return(count);
		}
	//-----------------------------------------------
	public static synchronized boolean more() {
		boolean result = (count < max);
		if (result) count++;
		return(result);
		}
	//-----------------------------------------------
	public static synchronized void less() {
		count--;
		}
	//-----------------------------------------------
	}
//---------------------------------------------------
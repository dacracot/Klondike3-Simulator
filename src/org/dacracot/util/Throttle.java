package org.dacracot.util;
//---------------------------------------------------
public class Throttle
	{
	//-----------------------------------------------
	private static int max = 1;
	private static int count = 0;
	//-----------------------------------------------
	public static synchronized void setLimit(int m) {
		max = m;
		}
	//-----------------------------------------------
	public static synchronized int getLimit() {
		return(max);
		}
	//-----------------------------------------------
	public static synchronized int getCount() {
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
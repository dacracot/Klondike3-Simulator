package org.dacracot.util;
//---------------------------------------------------
import org.dacracot.Global;
//---------------------------------------------------
public class Statistics {
	//-----------------------------------------------
	public void setValue(double value) {
		Global.valueSum+= value;
		Global.varianceSum+= Math.pow(value - getMean(), 2);
		}
	//-----------------------------------------------
	public double getMean() {
		return(Global.valueSum/Global.tried);
		}
	//-----------------------------------------------
	public double getStdDev() {
		return(Math.sqrt(Global.varianceSum/Global.tried));
		}
	//-----------------------------------------------
}
//-----------------------------------------------

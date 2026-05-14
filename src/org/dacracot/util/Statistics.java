package org.dacracot.util;
//---------------------------------------------------
import java.time.Duration;
import java.time.Instant;
import org.dacracot.Global;
//---------------------------------------------------
public class Statistics {
	//-----------------------------------------------
	public void setValue(double value) {
		Global.valueSum+= value;
		if (value > Global.valueHigh) Global.valueHigh = value;
		if (value < Global.valueLow) Global.valueLow = value;
		Global.varianceSum+= Math.pow((value - getMean()),2);
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
	public String show() {
		Duration between = Duration.between(Global.start, Instant.now());
		return(String.format(
			"stats: won "+Global.winner+
			" of "+Global.tried+
			" for "+String.format("%3.5f",(((1.0*Global.winner)/Global.tried)*100))+"%,"+
			" with a standard deviation of "+String.format("%3.7f",getStdDev())+
			" across the mean of "+String.format("%3.5f",getMean())+"%"+
			" with max of "+String.format("%3.5f",Global.valueHigh)+"%"+
			" with min of "+String.format("%3.5f",Global.valueLow)+"%"+
			" after a duration of "+String.format("%dD, %02d:%02d:%02d",between.toDays(),between.toHoursPart(),between.toMinutesPart(),between.toSecondsPart())
			));
		}
	//-----------------------------------------------
}
//-----------------------------------------------

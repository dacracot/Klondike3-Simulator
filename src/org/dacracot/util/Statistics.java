package org.dacracot.util;
//---------------------------------------------------
import java.time.Duration;
import java.time.Instant;
import org.dacracot.Global;
//---------------------------------------------------
public class Statistics {
	//-----------------------------------------------
	public void setValue() {
		double percent = getPercentage();
		Global.valueSum+= percent;
		if (Global.tried >= (Global.reportInterval-1)) {
			if (percent > Global.valueHigh) Global.valueHigh = percent;
			if (percent < Global.valueLow) Global.valueLow = percent;
			}
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
	public double getPercentage() {
		return(((1.0*Global.winner)/Global.tried)*100);
		}
	//-----------------------------------------------
	public String show() {
		Duration between = Duration.between(Global.start, Instant.now());
		return(
			"stats: won "+Global.winner+
			" of "+Global.tried+
			" for "+String.format("%3.5f",getPercentage())+"%,"+
			" with a standard deviation of "+String.format("%3.7f",getStdDev())+
			" across the mean of "+String.format("%3.5f",getMean())+"%"+
			" with max of "+String.format("%3.5f",Global.valueHigh)+"%"+
			" with min of "+String.format("%3.5f",Global.valueLow)+"%"+
			" after a duration of "+String.format("%dD, %02d:%02d:%02d",between.toDays(),between.toHoursPart(),between.toMinutesPart(),between.toSecondsPart())
			);
		}
	//-----------------------------------------------
}
//-----------------------------------------------

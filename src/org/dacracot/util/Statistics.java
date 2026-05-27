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
		Global.count++;
		Global.valueSum+= percent;
		Global.varianceSum+= Math.pow((percent - getMean()),2);
		if (percent > Global.valueHigh) Global.valueHigh = percent;
		if (percent < Global.valueLow) Global.valueLow = percent;
		}
	//-----------------------------------------------
	public double getMean() {
		return(Global.valueSum/Global.count);
		}
	//-----------------------------------------------
	public double getStdDev() {
		return(Math.sqrt(Global.varianceSum/Global.count));
		}
	//-----------------------------------------------
	public double getPercentage() {
		return(((1.0*Global.getWins())/Global.getTried())*100);
		}
	//-----------------------------------------------
	public String show() {
		Duration between = Duration.between(Global.start, Instant.now());
		return(
			"stats: won "+String.format("%,10d",Global.getWins())+
			" of "+String.format("%,11d",Global.getTried())+
			" for "+String.format("%7.5f",getPercentage())+"%,"+
			" with a standard deviation of "+String.format("%9.7f",getStdDev())+
			" from the mean of "+String.format("%7.5f",getMean())+"%"+
			" with max of "+String.format("%7.5f",Global.valueHigh)+"%"+
			" with min of "+String.format("%7.5f",Global.valueLow)+"%"+
			" after a duration of "+String.format("%dD, %02d:%02d:%02d",between.toDays(),between.toHoursPart(),between.toMinutesPart(),between.toSecondsPart())
			);
		}
	//-----------------------------------------------
}
//---------------------------------------------------

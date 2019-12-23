package p3.model;

public class TimePoint{

	private boolean isA;
	private boolean isStartPoint;
	private long timeMilliSec;
	public boolean isA() {
		return isA;
	}
	public void setA(boolean isA) {
		this.isA = isA;
	}
	public boolean isStartPoint() {
		return isStartPoint;
	}
	public void setStartPoint(boolean isStartPoint) {
		this.isStartPoint = isStartPoint;
	}
	public long getTimeMilliSec() {
		return timeMilliSec;
	}
	public void setTimeMilliSec(long timeMilliSec) {
		this.timeMilliSec = timeMilliSec;
	}
	
}

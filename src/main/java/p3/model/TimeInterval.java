package p3.model;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeInterval {
	
	private static DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	private Date startTime;
	private Date endTime;
	
	public long getStartTime() {
		return startTime.getTime();
	}
	public void setStartTime(long startTime) {
		this.startTime = new Date(startTime);
	}
	public long getEndTime() {
		return endTime.getTime();
	}
	public void setEndTime(long endTime) {
		this.endTime = new Date(endTime);
	}
	
	public TimeInterval() {};
	public TimeInterval (long startTime, long endTime) {
		this.startTime = new Date(startTime);
		this.endTime = new Date(endTime);
	}

	public TimeInterval (Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return dateFormat.format(startTime) + "-" + dateFormat.format(endTime);
	}
}

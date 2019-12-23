package p3.main;

import java.util.ArrayList;
import java.util.List;

import p3.model.TimeInterval;
import p3.model.TimePoint;

public class TimeIntervalDifferenceHelper {

	public List<TimeInterval> processTimeIntervalDifference(List<TimePoint> timePointList) {
		int depthIndexA = 0;
		int depthIndexB = 0;
		boolean previous_status = false;	// record down whether the interval is open
		TimeInterval resultTimeInterval = new TimeInterval();
		List<TimeInterval> resultTimeIntervalList = new ArrayList<>();
		for ( TimePoint timePoint : timePointList ) {
			if ( timePoint.isA() ) {
				if ( timePoint.isStartPoint() )
					depthIndexA ++;
				if ( !timePoint.isStartPoint() ) {
					depthIndexA --;
				}
			}
			if ( !timePoint.isA() ) {
				if ( timePoint.isStartPoint() ) {
					depthIndexB ++;
				}
				if ( !timePoint.isStartPoint() ) {
					depthIndexB --;
				}
			}
			if ( depthIndexA > 0 && depthIndexB == 0 ) {
				if ( !previous_status ) {
					resultTimeInterval.setStartTime(timePoint.getTimeMilliSec());
					previous_status = true;
				}
			} else {
				if ( previous_status ) {
					resultTimeInterval.setEndTime(timePoint.getTimeMilliSec());
					previous_status = false;
					if ( resultTimeInterval.getStartTime() != resultTimeInterval.getEndTime() ) {
						resultTimeIntervalList.add(resultTimeInterval);
						resultTimeInterval = new TimeInterval();
					}
				}
			}
		}
		return resultTimeIntervalList;
		
	}
	
	public List<TimePoint> processInputs (List<TimeInterval> listA, List<TimeInterval> listB ){
		List<TimePoint> timePointList = new ArrayList<>();
		timePointList.addAll(processInput(listA, true));
		timePointList.addAll(processInput(listB, false));
		return timePointList;
	}
	
	public List<TimePoint> processInput(List<TimeInterval> list, boolean isA) {
		List<TimePoint> timePointList = new ArrayList<>();
		for (TimeInterval ti : list ) {
			timePointList.add(inputTimePoint(isA, true, ti.getStartTime()));
			timePointList.add(inputTimePoint(isA, false, ti.getEndTime()));
		}
		return timePointList;
	}
	
	private TimePoint inputTimePoint(boolean isA, boolean isStartTime, long timePoint) {
		TimePoint tp = new TimePoint();
		tp.setA(isA);
		tp.setStartPoint(isStartTime);
		tp.setTimeMilliSec(timePoint);
		return tp;
	}
}

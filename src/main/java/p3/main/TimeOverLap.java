package p3.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import p3.inputExamples.InputExamples;
import p3.model.TimeInterval;
import p3.model.TimePoint;

public class TimeOverLap {
	
	private static DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	private static TimeIntervalDifferenceHelper timeDifference = new TimeIntervalDifferenceHelper();
	
	public static void main(String[] args) throws ParseException {
		Scanner reader = new Scanner(System.in);
		List<TimeInterval> listA = new ArrayList<>();
		List<TimeInterval> listB = new ArrayList<>();
		getInputForList(listA, listB, reader);
		reader.close();
	}
	
	private static void getInputFromExamples(List<TimeInterval> listA, List<TimeInterval> listB, Scanner reader) throws ParseException {
		System.out.println("Please select the following examples: ");
		System.out.println("1: " + InputExamples.example1);
		System.out.println("2: " + InputExamples.example2);
		System.out.println("3: " + InputExamples.example3);
		System.out.println("4: " + InputExamples.example4);
		System.out.println("5: " + InputExamples.example5);
		int i = Integer.parseInt(reader.next());
		InputExamples.inputExample(i, listA, listB);
	}
	
	private static void getInputManually(List<TimeInterval> list, String string, Scanner reader) throws ParseException {
		boolean hasMore = true;
		System.out.printf("Please enter start date for List %s: ", string);
		while(hasMore) {
			TimeInterval input = new TimeInterval();
			System.out.printf("Please enter start date for List %s: ", string);
			input.setStartTime(dateFormat.parse(reader.next()).getTime());
			System.out.printf("Please enter end date for List %s: ", string);
			input.setEndTime(dateFormat.parse(reader.next()).getTime());
			list.add(input);
			System.out.printf("Do you have more for List %s (Y/N): ", string);
			hasMore = reader.next().equalsIgnoreCase("Y") ? true : false ;
		}
	}
	
	private static void getInputForList(List<TimeInterval> listA, List<TimeInterval> listB, Scanner reader) throws ParseException {
		
		while(true) {
			clearData(listA, listB);
			System.out.println("Please select the way you input time intervals: ");
			System.out.println("1: import from examples");
			System.out.println("2: mannually input time intervals");
			System.out.println("3: Exit...");
			String i = reader.next();
			if(i.equals("1")) {
				getInputFromExamples(listA, listB, reader);
			}else if (i.equals("2")) {
				getInputManually(listA, "A", reader);
				getInputManually(listB, "B", reader);
			}else if( i.equals("3")) {
				break;
			}
			processTimeIntervalDifference(listA, listB);
		}
	}
	
	private static void processTimeIntervalDifference(List<TimeInterval> listA, List<TimeInterval> listB) {
		List<TimePoint> timePointList = new ArrayList<>();
		List<TimeInterval> results = new ArrayList<>();
		timePointList = timeDifference.processInputs(listA, listB);
		timePointList = timePointList.stream()
				.sorted(Comparator.comparing(TimePoint::getTimeMilliSec))
				.collect(Collectors.toList());
		results = timeDifference.processTimeIntervalDifference(timePointList);
		printAnswer(listA, listB, results);
	}
	
	private static void printAnswer(List<TimeInterval> listA, List<TimeInterval> listB, List<TimeInterval> results) {
		printQuestion(listA);
		System.out.printf(" \"minus\" ");
		printQuestion(listB);
		System.out.printf(" = ");
		printTimeIntervalLists(results);
		System.out.println("");
	}
	
	private static void printQuestion(List<TimeInterval> listA) {
		printTimeIntervalLists(listA);
	}
	
	private static void printTimeIntervalLists(List<?> results) {
		String resultString = "(";
		for ( int i = 0; i < results.size(); i ++ ) {
			resultString = resultString + results.get(i).toString() + ", ";
		}
		if ( results.size() > 0 ) {
			resultString = resultString.substring(0, resultString.length() - 2 );
		}
		resultString = resultString + ")";
		System.out.printf(resultString);
	}
	
	private static void clearData(List<TimeInterval> listA, List<TimeInterval> listB) {
		listA.clear();
		listB.clear();
	}
}

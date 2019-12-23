package p3.inputExamples;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import p3.model.TimeInterval;

public class InputExamples {
	
	private static DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	public static String example1 = "(9:00-10:00) \"minus\" (9:00-9:30)";
	public static String example2 = "(9:00-10:00) \"minus\" (9:00-10:00)";
	public static String example3 = "(9:00-9:30) \"minus\" (9:30-15:00)";
	public static String example4 = "(9:00-9:30, 10:00-10:30) \"minus\" (9:15-10:15)";
	public static String example5 = "(9:00-11:00, 13:00-15:00) \"minus\" (9:00-9:15, 10:00-10:15, 12:30-16:00)";
	
	public static void inputExample(int i, List<TimeInterval> listA, List<TimeInterval> listB ) throws ParseException {
		switch(i){
			case 1:
				inputExample1(listA, listB);
				break;
			case 2:
				inputExample2(listA, listB);
				break;
			case 3:
				inputExample3(listA, listB);
				break;
			case 4:
				inputExample4(listA, listB);
				break;
			case 5:
				inputExample5(listA, listB);
				break;
			default:
				inputExample11(listA, listB);
				break;
		}
	}
	
	private static void inputExample11(List<TimeInterval> listA, List<TimeInterval> listB) throws ParseException {
		listA.add(new TimeInterval ( dateFormat.parse("9:00"), dateFormat.parse("10:00")) );
		listA.add(new TimeInterval ( dateFormat.parse("9:20"), dateFormat.parse("10:20")) );
		listB.add(new TimeInterval ( dateFormat.parse("9:10"), dateFormat.parse("9:30")) );
	}
	
	private static void inputExample1(List<TimeInterval> listA, List<TimeInterval> listB) throws ParseException {
		listA.add(new TimeInterval ( dateFormat.parse("9:00"), dateFormat.parse("10:00")) );
		listB.add(new TimeInterval ( dateFormat.parse("9:00"), dateFormat.parse("9:30")) );
	}
	
	private static void inputExample2(List<TimeInterval> listA, List<TimeInterval> listB) throws ParseException {
		listA.add(new TimeInterval(dateFormat.parse("9:00"), dateFormat.parse("10:00")) );
		listB.add(new TimeInterval(dateFormat.parse("9:00"), dateFormat.parse("10:00")) );
	}
	
	private static void inputExample3(List<TimeInterval> listA, List<TimeInterval> listB) throws ParseException {
		listA.add(new TimeInterval(dateFormat.parse("9:00"), dateFormat.parse("09:30")) );
		listB.add(new TimeInterval(dateFormat.parse("9:30"), dateFormat.parse("15:00")) );
	}
	
	private static void inputExample4(List<TimeInterval> listA, List<TimeInterval> listB) throws ParseException {
		listA.add(new TimeInterval(dateFormat.parse("9:00"), dateFormat.parse("09:30")) );
		listA.add(new TimeInterval(dateFormat.parse("10:00"), dateFormat.parse("10:30")) );
		listB.add(new TimeInterval(dateFormat.parse("9:15"), dateFormat.parse("10:15")) );
	}
	
	private static void inputExample5(List<TimeInterval> listA, List<TimeInterval> listB) throws ParseException {
		listA.add(new TimeInterval(dateFormat.parse("09:00"), dateFormat.parse("11:00")) );
		listA.add(new TimeInterval(dateFormat.parse("13:00"), dateFormat.parse("15:00")) );
		listB.add(new TimeInterval(dateFormat.parse("09:00"), dateFormat.parse("09:15")) );
		listB.add(new TimeInterval(dateFormat.parse("10:00"), dateFormat.parse("10:15")) );
		listB.add(new TimeInterval(dateFormat.parse("12:30"), dateFormat.parse("16:00")) );
	}
}

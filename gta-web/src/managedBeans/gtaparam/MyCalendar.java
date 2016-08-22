package managedBeans.gtaparam;

import java.util.Calendar;
import java.util.Date;

public class MyCalendar {

	public static Date addDays(Date date, int n) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, n);
		return calendar.getTime();
	}

	public static Date addMonths(Date date, int n) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();

	}

	public static Date addYears(Date date, int n) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, n);
		return calendar.getTime();

	}

	public static Date subDays(Date date, int n) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -n);
		return calendar.getTime();

	}

	public static Date subMonths(Date date, int n) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -n);
		return calendar.getTime();

	}

	public static Date subYears(Date date, int n) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -n);
		return calendar.getTime();

	}

}

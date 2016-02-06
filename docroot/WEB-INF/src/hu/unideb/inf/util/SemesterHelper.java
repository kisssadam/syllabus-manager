package hu.unideb.inf.util;

import java.util.Calendar;

public abstract class SemesterHelper {

	private static final int FIRST_MONTH_OF_ODD_SEMESTER = Calendar.SEPTEMBER;
	private static final int LAST_MONTH_OF_ODD_SEMESTER = Calendar.FEBRUARY;

	public static int currentMonth() {
		return Calendar.getInstance().get(Calendar.MONTH);
	}

	public static int currentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static int nextDivision() {
		int currentMonth = currentMonth();
		return currentMonth > LAST_MONTH_OF_ODD_SEMESTER && currentMonth <= FIRST_MONTH_OF_ODD_SEMESTER ? 1 : 2;
	}

}

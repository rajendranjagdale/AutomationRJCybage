package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateUtils {

	private DateUtils() {
	}

	/**
	 * The method to return the current date
	 *
	 * @return the current date
	 */
	public static LocalDate getCurrentDate() {
		return LocalDate.now();
	}

	/**
	 * The method to return the date in the format provided in as input type
	 *
	 * @param date   the date to convert to
	 * @param format the format to convert date to
	 * @return the date as formatted date
	 */
	public static String getFormattedDate(LocalDate date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return date.format(formatter);
	}

	/**
	 * The method to return the current date in format 'dd-MMM-yyyy'
	 *
	 * @return the formatted current date
	 */
	public static String getSimpleFormatCurrentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		return dateFormat.format(new Date());
	}
}

package thirty.days.of.code;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DayOfProgrammer {

	static String dayOfProgrammer(int year) {

		GregorianCalendar gc = new GregorianCalendar();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

		if (year >= 1700 && year <= 2700) {
			if (year == 1918) {
				gc.setGregorianChange(new Date(Long.MAX_VALUE));
				gc.set(GregorianCalendar.DAY_OF_YEAR, 256);
				gc.set(GregorianCalendar.YEAR, year);
				return dateFormat.format(gc.getTime());
			} else if (year < 1918) {

				gc.setGregorianChange(new Date(Long.MAX_VALUE));
				gc.set(GregorianCalendar.DAY_OF_YEAR, 256);
				gc.set(GregorianCalendar.YEAR, year);

				gc.setGregorianChange(new Date(Long.MIN_VALUE));
				gc.set(GregorianCalendar.YEAR, year);

				return dateFormat.format(gc.getTime());
			} else {
				gc.set(GregorianCalendar.DAY_OF_YEAR, 256);
				gc.set(GregorianCalendar.YEAR, year);
				gc.setGregorianChange(new Date(Long.MAX_VALUE));
				return dateFormat.format(gc.getTime());
			}
		}
		return null;

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("year=");
		int year = input.nextInt();

		String result = dayOfProgrammer(year);
		System.out.println(result);
		input.close();

	}
}

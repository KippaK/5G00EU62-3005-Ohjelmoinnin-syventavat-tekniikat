import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class timestamp {
	private time_only time;
	private date_only date;

	private timestamp(int year, int month, int day, int hour, int minute, int second)
	{
		time = new time_only(hour, minute, second);
		date = new date_only(year, month, day);
	}

	private timestamp(String str)
	{
		date.set_year(str.substring(0,4));
		date.set_month(5, 7);
		date.set_day(8, 10);
		time.set_hour(11, 13);
		time.set_minute(14, 16);
		time.set_second(17, 19);
	}

	public static timestamp parse(String str_time)
	{
		if (str_time.matches("\\d{4}-\\d{2})-\\d{2}T\\d{2}:d{2}:\\d{2}") {
			return new timestamp(str_time);			
		}
		throw IllegalArgumentException
	}

	@Override String toString()
	{
		return String.format(date.toString() + 'T' + time.toString);
	}
}

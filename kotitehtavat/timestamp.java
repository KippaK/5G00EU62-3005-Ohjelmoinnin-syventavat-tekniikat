public class timestamp {
	private time_only time;
	private date_only date;

	public timestamp(int year, int month, int day, int hour, int minute, int second)
	{
		time = new time_only(hour, minute, second);
		date = new date_only(year, month, day);
	}

	public static timestamp parse(String )

	@Override String toString()
	{
		return String.format(
			"%04d-%02d-%02d %02d:%02d:%02d",
			date.get_year(),
			date.get_month(),
			date.get_day(),
			time.get_hour(),
			time.get_minute(),
			time.get_second()
		);
	}
}

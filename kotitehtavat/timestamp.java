import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class timestamp {
	private time_only time;
	private date_only date;

	private timestamp(int year, int month, int day, int hour, int minute, int second)
	{
		this.time = new time_only(hour, minute, second);
		this.date = new date_only(year, month, day);
	}

	private timestamp(String str)
	{
		this.date = new date_only(
			Integer.parseInt(str.substring(0, 4)),
			Integer.parseInt(str.substring(5, 7)),
			Integer.parseInt(str.substring(8, 10)),
		);
		this.time = new time_only(
			Integer.parseInt(str.substring(11, 13)),
			Integer.parseInt(str.substring(14, 16)),
			Integer.parseInt(str.substring(17, 19)),
		);
	}

	public static timestamp parse(String str_time)
	{
		if (str_time.matches("\\d{4}-\\d{2})-\\d{2}T\\d{2}:d{2}:\\d{2}") {
			return new timestamp(str_time);			
		}
		throw IllegalArgumentException
	}

	public int get_year() {
		return this.date.get_year();
	}

	public void set_year(int year) {
		this.date.set_year(year);
	}
	public int get_month() {
		return this.date.get_month();
	}

	public void set_month(int month) {
		this.date.set_month(month);
	}
	public int get_day() {
		return this.date.get_day();
	}

	public void set_day(int day) {
		this.date.set_day(day);
	}
	public int get_hour() {
		return this.time.get_hour();
	}

	public void set_hour(int hour) {
		this.time.set_hour(hour);
	}
	public int get_minute() {
		return this.time.get_minute();
	}

	public void set_minute(int minute) {
		this.time.set_minute(minute);
	}
	public int get_second() {
		return this.time.get_second();
	}

	public void set_second(int second) {
		this.time.set_second(second);
	}

	public time_only get_time() {
        return time;
    }

    public void set_time(time_only time) {
        this.time = time;
    }

    public date_only get_date() {
        return date;
    }

    public void set_date(date_only date) {
        this.date = date;
	}

	@Override String toString()
	{
		return String.format(date.toString() + 'T' + time.toString);
	}
}

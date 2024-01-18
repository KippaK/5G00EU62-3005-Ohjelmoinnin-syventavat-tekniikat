public class time_only {
	private int h;
	private int m;
	private int s;

	public time_only(int hour, int minute, int second)
	{
		set_hour(hour);
		set_minute(minute);
		set_second(second);
	}

	public void get_hour() 
	{
		return hour;
	}

	public void set_hour(int hour) 
	{
		if (hour < 0 || > 23) {
			throw new IllegalArgumentException("Hour must be 0...23");
		}
		this.h = hour;
	}

	public void get_minute(int )
	{
		return minute;
	}

	public void set_minute(int minute)
	{
		if (minute < 0 || minute > 59) {
			throw new IllegalArgumentException("Minute must be 0...59")
		}
		this.m = minute;
	}

	public void get_second() {
		return second;
	}

	public void set_second(int second)
	{
		if (second < 0 || second > 59) {
			throw new IllegalArgumentException("Second must be 0...59");
		}
		this.s = second;
	}

	@Override
	public String toString()
	{
		return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
	}
}

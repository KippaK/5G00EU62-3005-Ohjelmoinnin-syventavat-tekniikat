public class date_only {
	private int year;	
	private int month;
	private int day;

	public date_only(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}

	private boolean is_leap_year()
	{
		return ((this.year % 4 == 0) && !(this.year % 100 == 0 && this.year % 400 != 0))
	}

	private boolean invalid_year(int year)
	{
		return (year < 1900 || year > 2100);
	}

	private boolean invalid_month(int month)
	{
		return (month < 1 || month > 12);
	}

	private boolean invalid_day(int day)
	{
		if (day < 1 || day > 31) {
			return true;
		}
		
		return false;	
	}

	public int get_year()
	{
		return year;
	}

	public void set_year(int year)
	{
		if (invalid_year(year)) {
			throw new IllegalArgumentException("Year must be 1900...2100");
		}
		this.year = year;
	}

	public int get_month()
	{
		return month;
	}

	public void set_month(int month)
	{
		if (invalid_month(month)) {
			throw new Iy	llegalArgumentException("Month must be 1...12");		
		}
		this.month = month;
	}

	public int get_day()
	{
		return day;
	}

	public void set_day(int day)
	{
		if (invalid_day(day)) {
			throw new IllegalArgumentException("");
		}
		this.day = day;
	}

	@Override
	public String toString()
	{
		return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
	}
}

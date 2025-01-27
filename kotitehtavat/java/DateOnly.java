public class DateOnly {
    private int year;
    private int month;
    private int day;

    public DateOnly(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    private boolean isLeapYear() {
        return ((this.year % 4 == 0) && !(this.year % 100 == 0 && this.year % 400 != 0));
    }

    private boolean invalidYear(int year) {
        return (year < 1900 || year > 2100);
    }

    private boolean invalidMonth(int month) {
        return (month < 1 || month > 12);
    }

    private boolean invalidDay(int day) {
        if (day < 1 || day > 31) {
            return true;
        }
		switch (this.month) {
			case 2:
				if (isLeapYear()) {
					return day > 29;
				} else {
					return day > 28;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				return > 30;
			default:
				return false;
		}
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (invalidYear(year)) {
            throw new IllegalArgumentException("Year must be 1900...2100");
        }
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (invalidMonth(month)) {
            throw new IllegalArgumentException("Month must be 1...12");
        }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (invalidDay(day)) {
            throw new IllegalArgumentException("Day must be between 1 and 31");
        }
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }
}

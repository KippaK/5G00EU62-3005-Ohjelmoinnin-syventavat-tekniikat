import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamp {
    private TimeOnly time;
    private DateOnly date;

    private Timestamp(int year, int month, int day, int hour, int minute, int second) {
        this.time = new TimeOnly(hour, minute, second);
        this.date = new DateOnly(year, month, day);
    }

    private Timestamp(String str) {
        this.date = new DateOnly(
                Integer.parseInt(str.substring(0, 4)),
                Integer.parseInt(str.substring(5, 7)),
                Integer.parseInt(str.substring(8, 10))
        );
        this.time = new TimeOnly(
                Integer.parseInt(str.substring(11, 13)),
                Integer.parseInt(str.substring(14, 16)),
                Integer.parseInt(str.substring(17, 19))
        );
    }

    public static Timestamp parse(String strTime) {
        if (strTime.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}")) {
            return new Timestamp(strTime);
        }
        throw new IllegalArgumentException("Invalid timestamp format");
    }

    public int getYear() {
        return this.date.getYear();
    }

    public void setYear(int year) {
        this.date.setYear(year);
    }

    public int getMonth() {
        return this.date.getMonth();
    }

    public void setMonth(int month) {
        this.date.setMonth(month);
    }

    public int getDay() {
        return this.date.getDay();
    }

    public void setDay(int day) {
        this.date.setDay(day);
    }

    public int getHour() {
        return this.time.getHour();
    }

    public void setHour(int hour) {
        this.time.setHour(hour);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public void setMinute(int minute) {
        this.time.setMinute(minute);
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public void setSecond(int second) {
        this.time.setSecond(second);
    }

    public TimeOnly getTime() {
        return time;
    }

    public void setTime(TimeOnly time) {
        this.time = time;
    }

    public DateOnly getDate() {
        return date;
    }

    public void setDate(DateOnly date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%sT%s", date.toString(), time.toString());
    }
}


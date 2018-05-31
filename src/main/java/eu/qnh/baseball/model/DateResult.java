package eu.qnh.baseball.model;

import java.io.Serializable;
import java.time.DayOfWeek;

public class DateResult implements Serializable {

    private int weekDay;

    public DateResult() {

    }

    public DateResult(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public DayOfWeek getDayOfWeek() {
        return this.weekDay == 0 ? DayOfWeek.SUNDAY : DayOfWeek.of(this.weekDay);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar.hourlyevents.domain;

import calendar.DaysOfTheWeek;
import java.time.Month;
import java.time.Year;

/**
 *
 * @author harrison
 */
public abstract class HourlyEvent {
    Year year;
    Month month;
    DaysOfTheWeek day;
    EveryFifteenMinuteId startTime;
    EveryFifteenMinuteId endTime;

    protected HourlyEvent(Year year, Month month, DaysOfTheWeek day, EveryFifteenMinuteId startTime, EveryFifteenMinuteId endTime) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    

    
}

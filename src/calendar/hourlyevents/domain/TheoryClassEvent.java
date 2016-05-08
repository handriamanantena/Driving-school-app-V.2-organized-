/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar.hourlyevents.domain;

import calendar.DaysOfTheWeek;
import classes.drivingClasses.domain.TheoryClassId;
import java.time.Month;
import java.time.Year;

/**
 *
 * @author harrison
 */
public class TheoryClassEvent extends HourlyEvent{
    
    TheoryClassId theoryClass;

    public TheoryClassEvent(TheoryClassId theoryClass, Year year, Month month, 
            DaysOfTheWeek day, EveryFifteenMinuteId startTime, EveryFifteenMinuteId endTime) {
        super(year, month, day, startTime, endTime);
        this.theoryClass = theoryClass;
    }
}

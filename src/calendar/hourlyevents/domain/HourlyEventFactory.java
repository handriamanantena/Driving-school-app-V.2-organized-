/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar.hourlyevents.domain;

import calendar.DaysOfTheWeek;
import classes.drivingClasses.domain.DrivingClassId;
import classes.drivingClasses.domain.TheoryClassId;
import java.time.Month;
import java.time.Year;

/**
 *
 * @author harrison
 */
public class HourlyEventFactory {
    
    public static DrivingClassEvent createHourlyEvent(DrivingClassId drivingclass,
            Year year, Month month, DaysOfTheWeek day,
            EveryFifteenMinuteId startTime, EveryFifteenMinuteId endTime) {
        
        return new DrivingClassEvent(drivingclass,  year,  month, 
                day,  startTime, endTime);
    }
    
     public static TheoryClassEvent createHourlyEvent(TheoryClassId theoryclass,
            Year year, Month month, DaysOfTheWeek day,
            EveryFifteenMinuteId startTime, EveryFifteenMinuteId endTime) {
        
        return new TheoryClassEvent(theoryclass,  year,  month, 
                day,  startTime, endTime);
    }
}

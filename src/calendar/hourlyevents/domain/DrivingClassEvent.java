/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar.hourlyevents.domain;

import calendar.DaysOfTheWeek;
import classes.drivingClasses.domain.DrivingClassId;
import java.time.Month;
import java.time.Year;

/**
 *
 * @author harrison
 */
public class DrivingClassEvent extends HourlyEvent{
    
    DrivingClassId drivingclass;

    protected DrivingClassEvent(DrivingClassId drivingclass, Year year, Month month, DaysOfTheWeek day, EveryFifteenMinuteId startTime, EveryFifteenMinuteId endTime) {
        super(year, month, day, startTime, endTime);
        this.drivingclass = drivingclass;
    }
    
    
    
}

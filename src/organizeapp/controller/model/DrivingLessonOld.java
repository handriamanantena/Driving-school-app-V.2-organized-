/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizeapp.controller.model;

import java.text.SimpleDateFormat;

/**
 *
 * @author harrison
 */


public class DrivingLessonOld extends Lesson{

    public DrivingLessonOld(boolean payDay, boolean payed, double amountToPay) {
        super(payDay, payed, amountToPay);
    }

    public DrivingLessonOld(DrivingLessonOld oldDrivngLesson) {
        super(oldDrivngLesson);
    }
    
    public DrivingLessonOld clone(){
        return new DrivingLessonOld(this);
    }
    

}

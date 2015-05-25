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
public class DrivingLessonTheory extends DrivingLessonOld{

    private String language;
    private int moduleNumber;

    public DrivingLessonTheory(String language, int moduleNumber, boolean payDay, boolean payed, double amountToPay) {
        super(payDay, payed, amountToPay);
        this.language = language;
        this.moduleNumber = moduleNumber;
    }
    
    public DrivingLessonTheory(DrivingLessonTheory drivingLessonTheory){
         super(drivingLessonTheory);
         this.language = drivingLessonTheory.language;
         this.moduleNumber = drivingLessonTheory.moduleNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getModuleNuber() {
        return moduleNumber;
    }

    public void setModuleNuber(int moduleNumber) {
        this.moduleNumber = moduleNumber;
    }
    
    public DrivingLessonTheory copy(){
        return new DrivingLessonTheory(this);
    }
    

}

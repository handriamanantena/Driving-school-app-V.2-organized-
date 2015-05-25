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
public class Lesson {
    
    private boolean payDay;
    private boolean payed;
    private double amountToPay;
    SimpleDateFormat dateOfLesson = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //year, month, day, hour, min

    public Lesson(boolean payDay, boolean payed, double amountToPay) {
        this.payDay = payDay;
        this.payed = payed;
        this.amountToPay = amountToPay;
    }
    
    public Lesson(Lesson lesson){
        this.payDay = lesson.payDay;
        this.payed = lesson.payed;
        this.amountToPay = lesson.amountToPay;
    }

    
   
    public boolean isPayDay() {
        return payDay;
    }

    public void setPayDay(boolean payDay) {
        this.payDay = payDay;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
    
    public SimpleDateFormat getDateOfLesson() {
        return dateOfLesson;
    }
    public String getYearOfLesson(){
        return null;
    }
    public String getMonthOfLesson(){
        return null;
    }
    public String getDayOfLesson(){
        return null;
    }
    public String getHourOfLesson(){
        return null;
    }
    public String getMinOfLesson(){
        return null;
    }
    
    public void setDateOfLesson(SimpleDateFormat dateOfLesson) {
        this.dateOfLesson = dateOfLesson;
    }  

    public double isAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    @Override
    protected Lesson clone()  {
        return new Lesson(this);
    }
    
    
    

    
    
    
}

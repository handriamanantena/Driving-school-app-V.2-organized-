/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.domain;

import organizeapp.controller.model.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author harrison
 */
public class NewProgramStudent extends Student {

    private int currentTheoryNumber;
    private int practiceNumber;
    private boolean passedExam;
 

    public NewProgramStudent() {

    }

    public NewProgramStudent(int currentTheoryNumber, int practiceNumber, boolean passedExam, int id, String firstName, String lastName, String address, String phoneNumber1, String phoneNumber2, String program, String language, LocalDate registrationDate, LocalDate lastTimeViewed, ArrayList<Payments> paymentArray, double totalPrice, String email) {
        super(id, firstName, lastName, address, phoneNumber1, phoneNumber2, program, language, registrationDate, lastTimeViewed, paymentArray, totalPrice, email);
        this.currentTheoryNumber = currentTheoryNumber;
        this.practiceNumber = practiceNumber;
        this.passedExam = passedExam;
    }
    public NewProgramStudent(Student student){
        super(student);       
    }

  

    public int getCurrentTheoryNumber() {
        return currentTheoryNumber;
    }

    public void setCurrentTheoryNumber(int currentTheoryNumber) {
        this.currentTheoryNumber = currentTheoryNumber;
    }

    public int getPracticeNumber() {
        return practiceNumber;
    }

    public void setPracticeNumber(int practiceNumber) {
        this.practiceNumber = practiceNumber;
    }



    public boolean isPassedExam() {
        return passedExam;
    }

    public void setPassedExam(boolean passedExam) {
        this.passedExam = passedExam;
    }

}

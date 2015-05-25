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
public class DrivingLessonRoadNew extends DrivingLessonOld {

    int drivingLessonNumber;
    boolean evaluationLesson;
    boolean driveWithAnotherStudent;

    public DrivingLessonRoadNew(int drivingLessonNumber, boolean evaluationLesson, boolean driveWithAnotherStudent, boolean payDay, boolean payed, double amountToPay) {
        super(payDay, payed, amountToPay);
        this.drivingLessonNumber = drivingLessonNumber;
        this.evaluationLesson = evaluationLesson;
        this.driveWithAnotherStudent = driveWithAnotherStudent;
    }

    public DrivingLessonRoadNew(DrivingLessonRoadNew drivingLessonRoadNew) {
        super(drivingLessonRoadNew);
        this.drivingLessonNumber = drivingLessonRoadNew.drivingLessonNumber;
        this.evaluationLesson = drivingLessonRoadNew.evaluationLesson;
        this.driveWithAnotherStudent = drivingLessonRoadNew.driveWithAnotherStudent;
    }

    public int getDrivingLessonNumber() {
        return drivingLessonNumber;
    }

    public void setDrivingLessonNumber(int drivingLessonNumber) {
        this.drivingLessonNumber = drivingLessonNumber;
    }

    public boolean isEvaluationLesson() {
        return evaluationLesson;
    }

    public void setEvaluationLesson(boolean evaluationLesson) {
        this.evaluationLesson = evaluationLesson;
    }

    public boolean isDriveWithAnotherStudent() {
        return driveWithAnotherStudent;
    }

    public void setDriveWithAnotherStudent(boolean driveWithAnotherStudent) {
        this.driveWithAnotherStudent = driveWithAnotherStudent;
    }
    
    public DrivingLessonRoadNew copy(){
        return new DrivingLessonRoadNew(this);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizeapp.controller.model;

import java.time.LocalDate;
import java.util.ArrayList;
//import javax.persistence.Entity;
//import javax.persistence.Id;

/**
 *
 * @author andrians
 *
 */
//@Entity
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber1;
    private String phoneNumber2;
    private String program;
    private String language;
    private LocalDate registrationDate;
    private LocalDate lastTimeViewed;
    private ArrayList<Payments> paymentArray = new ArrayList<>();
    private ArrayList<Lesson> drivingLessonsArray = new ArrayList<>();
    private double totalPrice = 0; //total price of everything, including past payments  
    private String email;

    public Student() {

    }

    public Student(int id, String firstName, String lastName, String address, String phoneNumber1,
            String phoneNumber2, String program, String language, LocalDate registrationDate,
            LocalDate lastTimeViewed, ArrayList<Payments> paymentArray, double totalPrice, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.program = program;
        this.language = language;
        this.registrationDate = registrationDate;
        this.lastTimeViewed = lastTimeViewed;
        this.paymentArray = paymentArray;
        this.totalPrice = totalPrice;
        this.email = email;
    }

    public Student(Student student) {
        this.id = student.id;
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.address = student.address;
        this.phoneNumber1 = student.phoneNumber1;
        this.phoneNumber2 = student.phoneNumber2;
        this.program = student.program;
        this.language = student.language;
        this.registrationDate = student.registrationDate;
        this.lastTimeViewed = student.lastTimeViewed;
        this.paymentArray = student.paymentArray;
        this.totalPrice = student.totalPrice;
        this.email = student.email;

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getLastTimeViewed() {
        return lastTimeViewed;
    }

    public void setLastTimeViewed(LocalDate lastTimeViewed) {
        this.lastTimeViewed = lastTimeViewed;
    }

    public ArrayList<Payments> getPaymentArray() {
        ArrayList<Payments> temp = new ArrayList<>();
        for (int index = 0; index < paymentArray.size(); index++) {
            temp.add(paymentArray.get(index));
        }
        return temp;
    }

    public void setPaymentArray(ArrayList<Payments> paymentArray) {
        ArrayList<Payments> temp = new ArrayList<>();
        for (int index = 0; index < paymentArray.size(); index++) {
            temp.add(paymentArray.get(index));
        }
        this.paymentArray = temp;
    }

    public ArrayList<Lesson> getDrivingLessonsArray() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int index = 0; index < drivingLessonsArray.size(); index++) {
            temp.add(drivingLessonsArray.get(index).clone());
        }
        return temp;
    }

    public void setDrivingLessonsArray(ArrayList<Lesson> drivingLessonsArray) {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int index = 0; index < drivingLessonsArray.size(); index++) {
            temp.add(drivingLessonsArray.get(index).clone());
        }
        this.drivingLessonsArray = temp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int numberOfPayments(){
        return paymentArray.size();
    }

    @Override
    public Student clone() {
        return new Student(this); //To change body of generated methods, choose Tools | Templates.
    }

}

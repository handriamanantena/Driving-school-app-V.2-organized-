/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package organizeapp.controller.model;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author harrison
 */
public class OldProgramStudent extends Student{

    public OldProgramStudent() {
    }

    public OldProgramStudent(int id, String firstName, String lastName, String address, String phoneNumber1, String phoneNumber2, String program, String language, LocalDate registrationDate, LocalDate lastTimeViewed, ArrayList<Payments> paymentArray, double totalPrice, String email) {
        super(id, firstName, lastName, address, phoneNumber1, phoneNumber2, program, language, registrationDate, lastTimeViewed, paymentArray, totalPrice, email);
    }
    
    public OldProgramStudent(Student student){
        super(student);
    }
    public void derp(){
        
    }



    

 

    
}

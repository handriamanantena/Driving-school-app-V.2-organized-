/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.domain;

/**
 *
 * @author harrison
 */
public class StudentFactory {
    
    public Student createNewStudent(String student){
        return new NewProgramStudent();
        
    }
}

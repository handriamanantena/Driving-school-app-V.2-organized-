/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package organizeapp.controller;

import javafx.collections.ObservableList;
import organizeapp.controller.model.Student;

/**
 *
 * @author harrison
 */
public class FirstMiddleLastNameThread implements Runnable{
    ObservableList<Student> studentNameList;
    
    String name;
    public FirstMiddleLastNameThread(ObservableList<Student> studentNameList, String name){
        this.studentNameList = studentNameList;
        this.name=name;
    }

    @Override
    public void run() {
          for(int index =0;index<studentNameList.size();index++){
          
          }
    }

    
    
    
    
    
}

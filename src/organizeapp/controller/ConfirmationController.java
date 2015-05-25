/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizeapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import organizeapp.controller.model.NewProgramStudent;
import organizeapp.controller.model.OldProgramStudent;
import organizeapp.controller.model.Student;
import static organizeapp.interfaces.DefaultPricesInterface.CURRENCY_FORMATER;

/**
 *
 * @author harrison
 */
public class ConfirmationController {

    @FXML
    private Label nameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label phone1Label;
    @FXML
    private Label phone2Label;
    @FXML
    private Label emailLabel;
    @FXML
    private Label programLabel;
    @FXML
    private Label languageLabel;
    @FXML
    private Label amountPayedLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Button confirmOkButton;
    private Student student;
    private MainApp mainApp;
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    
    @FXML
    public void initialize() throws Exception {
    }

    public void setLabels(Student student, double totalPrice) {

        nameLabel.setText(student.getFirstName() + " " + student.getLastName());
        addressLabel.setText(student.getAddress());
        phone1Label.setText(student.getPhoneNumber1());
        phone2Label.setText(student.getPhoneNumber2());
        emailLabel.setText(student.getEmail());
        if (student instanceof OldProgramStudent) {
            this.student = (OldProgramStudent) student;
        }
        programLabel.setText(student.getProgram());
        languageLabel.setText(student.getLanguage());
        amountPayedLabel.setText("$" + CURRENCY_FORMATER.format(student.getPaymentArray().get(student.numberOfPayments() - 1).getAmountPayed()));
        totalPriceLabel.setText("$" + CURRENCY_FORMATER.format(totalPrice));
        if (student instanceof OldProgramStudent) {
            this.student = (OldProgramStudent) student;
        } else {
            this.student = (NewProgramStudent) student;
        }

    }

    /* public void setLabels(String name, String address, String phoneNumer1, String phoneNumber2,
     String email, String program, String language, String payed, String totalPrice, Student student) {
        
     nameLabel.setText(name);
     addressLabel.setText(address);
     phone1Label.setText(phoneNumer1);
     phone2Label.setText(phoneNumber2);
     emailLabel.setText(email);
     if(student instanceof OldProgramStudent)
     this.student = (OldProgramStudent) student;
     programLabel.setText(program);
     languageLabel.setText(language);
     amountPayedLabel.setText(payed);
     totalPriceLabel.setText(totalPrice);
     if(student instanceof OldProgramStudent)
     this.student = (OldProgramStudent) student;
     else
     this.student = (NewProgramStudent) student;
  
     }*/
    public ConfirmationController() {

    }

    @FXML
    private void onOKButtonAction() {
        PersonOverviewController.addStudent(student);

    }

}

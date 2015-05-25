/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizeapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;
import organizeapp.controller.model.Database;
import organizeapp.controller.model.DrivingLessonOld;
import organizeapp.controller.model.NewProgramStudent;
import organizeapp.controller.model.OldProgramStudent;
import organizeapp.controller.model.Payments;
import organizeapp.controller.model.Student;
import organizeapp.interfaces.DefaultPricesInterface;
import static organizeapp.interfaces.DefaultPricesInterface.DEFAULT_COST_PER_DRIVING_CLASS;
import static organizeapp.interfaces.DefaultPricesInterface.DEFAULT_COST_PER_THEORY_CLASS;

/**
 *
 * @author harrison
 */
public class PersonOverviewController implements DefaultPricesInterface {

    private static ObservableList<Student> studentDataController = FXCollections.observableArrayList();
    /*@FXML
     private TableView<Student> studentTable;
     @FXML
     private TableColumn<Student, String> firstNameColumn;
     @FXML
     private TableColumn<Student, String> lastNameColumn;*/

    @FXML
    private Accordion programPaymentLayout;

    private CheckBox[] checkBoxPaymentArray = new CheckBox[28];
    @FXML
    private CheckBox checkBoxPaymentRegistrationDay = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment0 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment1 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment2 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment3 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment4 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment5 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment6 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment7 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment8 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment9 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment10 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment11 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment12 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment13 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment14 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment15 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment16 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment17 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment18 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment19 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment20 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment21 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment22 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment23 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment24 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment25 = new CheckBox();
    @FXML
    private CheckBox checkBoxPayment26 = new CheckBox();
    @FXML
    private Label[] errorPaymentLabelArray = new Label[28];
    @FXML
    private Label errorPaymentLabelRegistrationDay = new Label();
    @FXML
    private Label errorPaymentLabel0 = new Label();
    @FXML
    private Label errorPaymentLabel1 = new Label();
    @FXML
    private Label errorPaymentLabel2 = new Label();
    @FXML
    private Label errorPaymentLabel3 = new Label();
    @FXML
    private Label errorPaymentLabel4 = new Label();
    @FXML
    private Label errorPaymentLabel5 = new Label();
    @FXML
    private Label errorPaymentLabel6 = new Label();
    @FXML
    private Label errorPaymentLabel7 = new Label();
    @FXML
    private Label errorPaymentLabel8 = new Label();
    @FXML
    private Label errorPaymentLabel9 = new Label();
    @FXML
    private Label errorPaymentLabel10 = new Label();
    @FXML
    private Label errorPaymentLabel11 = new Label();
    @FXML
    private Label errorPaymentLabel12 = new Label();
    @FXML
    private Label errorPaymentLabel13 = new Label();
    @FXML
    private Label errorPaymentLabel14 = new Label();
    @FXML
    private Label errorPaymentLabel15 = new Label();
    @FXML
    private Label errorPaymentLabel16 = new Label();
    @FXML
    private Label errorPaymentLabel17 = new Label();
    @FXML
    private Label errorPaymentLabel18 = new Label();
    @FXML
    private Label errorPaymentLabel19 = new Label();
    @FXML
    private Label errorPaymentLabel20 = new Label();
    @FXML
    private Label errorPaymentLabel21 = new Label();
    @FXML
    private Label errorPaymentLabel22 = new Label();
    @FXML
    private Label errorPaymentLabel23 = new Label();
    @FXML
    private Label errorPaymentLabel24 = new Label();
    @FXML
    private Label errorPaymentLabel25 = new Label();
    @FXML
    private Label errorPaymentLabel26 = new Label();
    @FXML
    private TextField[] paymentAmountTextFieldArray = new TextField[28];
    @FXML
    private TextField paymentAmountTextRegistrationDay = new TextField();
    @FXML
    private TextField paymentAmountTextField0 = new TextField();
    @FXML
    private TextField paymentAmountTextField1 = new TextField();
    @FXML
    private TextField paymentAmountTextField2 = new TextField();
    @FXML
    private TextField paymentAmountTextField3 = new TextField();
    @FXML
    private TextField paymentAmountTextField4 = new TextField();
    @FXML
    private TextField paymentAmountTextField5 = new TextField();
    @FXML
    private TextField paymentAmountTextField6 = new TextField();
    @FXML
    private TextField paymentAmountTextField7 = new TextField();
    @FXML
    private TextField paymentAmountTextField8 = new TextField();
    @FXML
    private TextField paymentAmountTextField9 = new TextField();
    @FXML
    private TextField paymentAmountTextField10 = new TextField();
    @FXML
    private TextField paymentAmountTextField11 = new TextField();
    @FXML
    private TextField paymentAmountTextField12 = new TextField();
    @FXML
    private TextField paymentAmountTextField13 = new TextField();
    @FXML
    private TextField paymentAmountTextField14 = new TextField();
    @FXML
    private TextField paymentAmountTextField15 = new TextField();
    @FXML
    private TextField paymentAmountTextField16 = new TextField();
    @FXML
    private TextField paymentAmountTextField17 = new TextField();
    @FXML
    private TextField paymentAmountTextField18 = new TextField();
    @FXML
    private TextField paymentAmountTextField19 = new TextField();
    @FXML
    private TextField paymentAmountTextField20 = new TextField();
    @FXML
    private TextField paymentAmountTextField21 = new TextField();
    @FXML
    private TextField paymentAmountTextField22 = new TextField();
    @FXML
    private TextField paymentAmountTextField23 = new TextField();
    @FXML
    private TextField paymentAmountTextField24 = new TextField();
    @FXML
    private TextField paymentAmountTextField25 = new TextField();
    @FXML
    private TextField paymentAmountTextField26 = new TextField();
    //reference to main app
    private MainApp mainApp;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public PersonOverviewController() {
    }

    @FXML
    public void initialize() throws Exception {
        //initializes objects

        ObservableList<String> programOptions
                = FXCollections.observableArrayList(
                        "Old Program",
                        "New Program"
                );
        ObservableList<String> theoryOptions
                = FXCollections.observableArrayList(
                        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "Completed"
                );
        ObservableList<String> practiceNumberOptions
                = FXCollections.observableArrayList(
                        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "Completed"
                );
        ObservableList<String> languageOptions
                = FXCollections.observableArrayList(
                        "French", "English"
                );
        programTypeCombo.setItems(programOptions);

        currentTheoryNumberCombo.setItems(theoryOptions);
        practiceNumberCombo.setItems(practiceNumberOptions);
        languageCombo.setItems(languageOptions);
        //initializes the checkboxes to the array to make checking wheather or not the checkbox is checked easier
        checkBoxPaymentArray[0] = checkBoxPayment0;
        checkBoxPaymentArray[1] = checkBoxPayment1;
        checkBoxPaymentArray[2] = checkBoxPayment2;
        checkBoxPaymentArray[3] = checkBoxPayment3;
        checkBoxPaymentArray[4] = checkBoxPayment4;
        checkBoxPaymentArray[5] = checkBoxPayment5;
        checkBoxPaymentArray[6] = checkBoxPayment6;
        checkBoxPaymentArray[7] = checkBoxPayment7;
        checkBoxPaymentArray[8] = checkBoxPayment8;
        checkBoxPaymentArray[9] = checkBoxPayment9;
        checkBoxPaymentArray[10] = checkBoxPayment10;
        checkBoxPaymentArray[11] = checkBoxPayment11;
        checkBoxPaymentArray[12] = checkBoxPayment12;
        checkBoxPaymentArray[13] = checkBoxPayment13;
        checkBoxPaymentArray[14] = checkBoxPayment14;
        checkBoxPaymentArray[15] = checkBoxPayment15;
        checkBoxPaymentArray[16] = checkBoxPayment16;
        checkBoxPaymentArray[17] = checkBoxPayment17;
        checkBoxPaymentArray[18] = checkBoxPayment18;
        checkBoxPaymentArray[19] = checkBoxPayment19;
        checkBoxPaymentArray[20] = checkBoxPayment20;
        checkBoxPaymentArray[21] = checkBoxPayment21;
        checkBoxPaymentArray[22] = checkBoxPayment22;
        checkBoxPaymentArray[23] = checkBoxPayment23;
        checkBoxPaymentArray[24] = checkBoxPayment24;
        checkBoxPaymentArray[25] = checkBoxPayment25;
        checkBoxPaymentArray[26] = checkBoxPayment26;
        checkBoxPaymentArray[27] = checkBoxPaymentRegistrationDay;
        //initializes pamentLabels to array to make it easier to check labels in a loop
        errorPaymentLabelArray[0] = errorPaymentLabel0;
        errorPaymentLabelArray[1] = errorPaymentLabel1;
        errorPaymentLabelArray[2] = errorPaymentLabel2;
        errorPaymentLabelArray[3] = errorPaymentLabel3;
        errorPaymentLabelArray[4] = errorPaymentLabel4;
        errorPaymentLabelArray[5] = errorPaymentLabel5;
        errorPaymentLabelArray[6] = errorPaymentLabel6;
        errorPaymentLabelArray[7] = errorPaymentLabel7;
        errorPaymentLabelArray[8] = errorPaymentLabel8;
        errorPaymentLabelArray[9] = errorPaymentLabel9;
        errorPaymentLabelArray[10] = errorPaymentLabel10;
        errorPaymentLabelArray[11] = errorPaymentLabel11;
        errorPaymentLabelArray[12] = errorPaymentLabel12;
        errorPaymentLabelArray[13] = errorPaymentLabel13;
        errorPaymentLabelArray[14] = errorPaymentLabel14;
        errorPaymentLabelArray[15] = errorPaymentLabel15;
        errorPaymentLabelArray[16] = errorPaymentLabel16;
        errorPaymentLabelArray[17] = errorPaymentLabel17;
        errorPaymentLabelArray[18] = errorPaymentLabel18;
        errorPaymentLabelArray[19] = errorPaymentLabel19;
        errorPaymentLabelArray[20] = errorPaymentLabel20;
        errorPaymentLabelArray[21] = errorPaymentLabel21;
        errorPaymentLabelArray[22] = errorPaymentLabel22;
        errorPaymentLabelArray[23] = errorPaymentLabel23;
        errorPaymentLabelArray[24] = errorPaymentLabel24;
        errorPaymentLabelArray[25] = errorPaymentLabel25;
        errorPaymentLabelArray[26] = errorPaymentLabel26;
        errorPaymentLabelArray[27] = errorPaymentLabelRegistrationDay;
        //initializes the payment textfield to the array so it is easier to obtain payment value
        paymentAmountTextFieldArray[0] = paymentAmountTextField0;
        paymentAmountTextFieldArray[1] = paymentAmountTextField1;
        paymentAmountTextFieldArray[2] = paymentAmountTextField2;
        paymentAmountTextFieldArray[3] = paymentAmountTextField3;
        paymentAmountTextFieldArray[4] = paymentAmountTextField4;
        paymentAmountTextFieldArray[5] = paymentAmountTextField5;
        paymentAmountTextFieldArray[6] = paymentAmountTextField6;
        paymentAmountTextFieldArray[7] = paymentAmountTextField7;
        paymentAmountTextFieldArray[8] = paymentAmountTextField8;
        paymentAmountTextFieldArray[9] = paymentAmountTextField9;
        paymentAmountTextFieldArray[10] = paymentAmountTextField10;
        paymentAmountTextFieldArray[11] = paymentAmountTextField11;
        paymentAmountTextFieldArray[12] = paymentAmountTextField12;
        paymentAmountTextFieldArray[13] = paymentAmountTextField13;
        paymentAmountTextFieldArray[14] = paymentAmountTextField14;
        paymentAmountTextFieldArray[15] = paymentAmountTextField15;
        paymentAmountTextFieldArray[16] = paymentAmountTextField16;
        paymentAmountTextFieldArray[17] = paymentAmountTextField17;
        paymentAmountTextFieldArray[18] = paymentAmountTextField18;
        paymentAmountTextFieldArray[19] = paymentAmountTextField19;
        paymentAmountTextFieldArray[20] = paymentAmountTextField20;
        paymentAmountTextFieldArray[21] = paymentAmountTextField21;
        paymentAmountTextFieldArray[22] = paymentAmountTextField22;
        paymentAmountTextFieldArray[23] = paymentAmountTextField23;
        paymentAmountTextFieldArray[24] = paymentAmountTextField24;
        paymentAmountTextFieldArray[25] = paymentAmountTextField25;
        paymentAmountTextFieldArray[26] = paymentAmountTextField26;
        paymentAmountTextFieldArray[27] = paymentAmountTextRegistrationDay;
        drivingClassRateTextField.setText(String.valueOf(DEFAULT_COST_PER_DRIVING_CLASS));
        theoryClassRateTextField.setText(String.valueOf(DEFAULT_COST_PER_THEORY_CLASS));
        // Initialize the person table
        //firstNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        // lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName")); 
        //  connectToDatabase();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        //  studentTable.setItems(mainApp.getStudentData());
    }

    private void connectToDatabase() throws Exception { //when the application starts, the app connects to the database
        Database.getInstance().connect();
    }

    private void disconnectfromDatabase() { //when the application ends, the app disonnects to the database
        mainApp.getPrimaryStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

                try {
                    Database.getInstance().disconnect();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonOverviewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    @FXML
    private void programTypeComboAction() { //called in PersonOverView
        //disables other ComboBoxes if Old Prgram 
        if (programTypeCombo.getValue() == "Old Program") {
            numberOfDrivingClassesTextField.setDisable(false);
            theoryClassRateTextField.setDisable(true);
            //checkBoxDefaultPaymentSchema.setDisable(true);
            programPaymentLayout.setVisible(false); //disables accordian
            currentTheoryNumberCombo.setDisable(true);
            checkBoxDefaultTheoryClassRate.setDisable(true);
            practiceNumberCombo.setDisable(true);
            errorTheoryLabel.setText("");
            errorPracticeLabel.setText("");
            errorTheoryCostRate.setText("");

        } else {
            //.setDisable(false);
            numberOfDrivingClassesTextField.setDisable(true);
            theoryClassRateTextField.setDisable(false);
            programPaymentLayout.setVisible(true); //disables accordian
            currentTheoryNumberCombo.setDisable(false);
            practiceNumberCombo.setDisable(false);
            checkBoxDefaultTheoryClassRate.setDisable(false);
            errorPracticeLabel.setText("Select 1 if student is still in phase 1"); //autimatically label if new student is selected
            // errorTheoryLabel.setText("* Select 0 for students starting the first module class"); //informs user that if 
            errorNumberOfDrivingClases.setText("");
        }
    }

    @FXML
    private void onDefaultTheoryClassRateAction() {
        if (checkBoxDefaultTheoryClassRate.isSelected()) {
            theoryClassRateTextField.setText(String.valueOf(DEFAULT_COST_PER_THEORY_CLASS));
        }

    }

    @FXML
    private void onDefaultDrivingClassRateAction() {
        if (checkBoxDefaultDrivingClassRate.isSelected()) {
            drivingClassRateTextField.setText(String.valueOf(DEFAULT_COST_PER_DRIVING_CLASS));
        }

    }

    @FXML
    private void dateHandler() {

        final String pattern = "dd-MM-yyyy";
        final String pattern2 = "dd/MM/yyyy";
        StringConverter converter = new StringConverter<LocalDate>() { //converts the users inputs

            DateTimeFormatter dateFormatter
                    = DateTimeFormatter.ofPattern(pattern);
            DateTimeFormatter dateFormatter2
                    = DateTimeFormatter.ofPattern(pattern2);

            @Override
            public String toString(LocalDate date) { //the pattern to convert to
                if (date != null) {
                    return dateFormatter2.format(date); //converts to desired pattern for date
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) { //the undesired string pattern for date
                if (string != null && !string.isEmpty() && string.contains("/")) {
                    return LocalDate.parse(string, dateFormatter2);
                } else if (string.contains("-")) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        datePicker.setConverter(converter);
    }

    @FXML
    private void addStudentButtonClicked() throws IOException {
        //when addStudentButton is clicked, it adds the students
        this.errorAddressLabel.setText("");
        this.errorClientPayed.setText("");
        this.errorDateLabel.setText("");
        this.errorFirstNameLabel.setText("");
        this.errorLanguageLabel.setText("");
        this.errorLastNameLabel.setText("");
        errorNumberOfDrivingClases.setText("");
        errorDrivingCostRate.setText("");
        errorDrivingCostRate.setText("");
        //if(programTypeCombo.getValue().equals("New Program"))        
        //this.errorPracticeLabel.setText("Set as 0 if student is just starting");
        errorPracticeLabel.setText("");
        this.errorProgramLabel.setText("");
        this.errorTheoryLabel.setText("");
        this.errorTotalPrice.setText("");
        this.errorphoneNumber1Label.setText("");
        this.errorphoneNumber2Label.setText("");
        addStudentValidation();

    }
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneNumber1AreaCodeTextField;
    @FXML
    private TextField phoneNumber1firstThreeDigitsTextField;
    @FXML
    private TextField phoneNumber1lastFourDigitsTextField;
    @FXML
    private TextField phoneNumber1ExtensionTextField;
    @FXML
    private TextField phoneNumber2AreaCodeTextField;
    @FXML
    private TextField phoneNumber2firstThreeDigitsTextField;
    @FXML
    private TextField phoneNumber2lastFourDigitsTextField;
    @FXML
    private TextField phoneNumber2ExtensionTextField;
    @FXML
    private ComboBox programTypeCombo;
    @FXML
    private TextField numberOfDrivingClassesTextField;
    @FXML
    private ComboBox currentTheoryNumberCombo;
    @FXML
    private ComboBox practiceNumberCombo;
    @FXML
    private ComboBox languageCombo;
    @FXML
    private TextField amountPayedDollarsTextField;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private CheckBox checkBoxDefaultTheoryClassRate;
    @FXML
    private CheckBox checkBoxDefaultDrivingClassRate;
    @FXML
    private TextField drivingClassRateTextField;
    @FXML
    private TextField theoryClassRateTextField;
    @FXML
    private Button addStudentButton;
    @FXML
    private DatePicker datePicker; //get rid of date picker. select class dates in calandar
    @FXML
    private ComboBox studentComboSearch;
    @FXML
    private Label errorDateLabel;
    @FXML
    private Label errorFirstNameLabel;
    @FXML
    private Label errorLastNameLabel;
    @FXML
    private Label errorAddressLabel;
    @FXML
    private Label errorphoneNumber1Label;
    @FXML
    private Label errorphoneNumber2Label;
    @FXML
    private Label errorProgramLabel;
    @FXML
    private Label errorTheoryLabel;
    @FXML
    private Label errorPracticeLabel;
    @FXML
    private Label errorLanguageLabel;
    @FXML
    private Label errorTotalPrice;
    @FXML
    private Label errorClientPayed;
    @FXML
    private Label errorTheoryCostRate;
    @FXML
    private Label errorDrivingCostRate;
    @FXML
    private Label errorNumberOfDrivingClases;
    @FXML
    private CheckBox includeBookPriceCheckBox;
    @FXML
    private TextField setBookPriceTextField;
    @FXML
    private TextField setDefaultTotalPriceCheckBox;
    @FXML
    private TextField emailTextField;

    public void addStudentValidation() throws IOException {
        boolean validInput = true;

        Student student = new Student();
        student.setId(1); //to be changed. need to research how to deal with id key
        String capitalizeFist;
        if (firstNameTextField.getText().trim().equals("")) {
            errorFirstNameLabel.setText("* invalid First Name.");
            validInput = false;
        } else {
            String name = firstNameTextField.getText().trim().replaceAll("\\s+", " ");
            capitalizeFist = name.substring(0, 1).toUpperCase() + name.substring(1);
            firstNameTextField.setText(capitalizeFist);
            student.setFirstName(capitalizeFist);
        }
        if (lastNameTextField.getText().trim().equals("")) {
            errorLastNameLabel.setText("* invalid Last Name.");
            validInput = false;
        } else {
            String name = lastNameTextField.getText().trim().replaceAll("\\s+", " ");
            capitalizeFist = name.substring(0, 1).toUpperCase() + name.substring(1);
            lastNameTextField.setText(capitalizeFist);
            student.setFirstName(capitalizeFist);
            student.setLastName(lastNameTextField.getText().trim().replaceAll("\\s+", " "));
        }

        if (addressTextField.getText().trim().equals("")) {
            errorAddressLabel.setText("* invalid Address.");
            validInput = false;
        } else {
            student.setAddress(addressTextField.getText().trim().replaceAll("\\s+", " "));
        }

        String phoneNumber1 = phoneNumber1AreaCodeTextField.getText() + phoneNumber1firstThreeDigitsTextField.getText() + phoneNumber1lastFourDigitsTextField.getText() + phoneNumber1ExtensionTextField.getText();
        if (phoneNumber1AreaCodeTextField.getText().trim().equals("") && phoneNumber1firstThreeDigitsTextField.getText().trim().equals("") && phoneNumber1lastFourDigitsTextField.getText().trim().equals("") && phoneNumber1ExtensionTextField.getText().trim().equals("")) {
            //does nothing since the user has no phone number
        } else if (phoneNumber1AreaCodeTextField.getText().length() == 3 && phoneNumber1firstThreeDigitsTextField.getText().length() == 3 && phoneNumber1lastFourDigitsTextField.getText().length() == 4) {
            //does code if not blank
            student.setPhoneNumber1(phoneNumber1);
        } else {
            //invalid number of digits inputed in each phone number textfield
            errorphoneNumber1Label.setText("* invalid phone number");
            validInput = false;
        }
        //check if else statments
        String phoneNumber2 = phoneNumber2AreaCodeTextField.getText() + phoneNumber2firstThreeDigitsTextField.getText() + phoneNumber2lastFourDigitsTextField.getText() + phoneNumber2ExtensionTextField.getText();
        if (phoneNumber2AreaCodeTextField.getText().trim().equals("") && phoneNumber2firstThreeDigitsTextField.getText().trim().equals("") && phoneNumber2lastFourDigitsTextField.getText().trim().equals("") && phoneNumber2ExtensionTextField.getText().trim().equals("")) {
            //does nothing since the user has no phone number
        } else if (phoneNumber2AreaCodeTextField.getText().length() == 3 && phoneNumber2firstThreeDigitsTextField.getText().length() == 3 && phoneNumber2lastFourDigitsTextField.getText().length() == 4) {
            //does code if not blank
            student.setPhoneNumber2(phoneNumber2);
        } else {
            //invalid number of digits inputed in each phone number textfield
            errorphoneNumber2Label.setText("* invalid phone number");
            validInput = false;
        }
        String email = emailTextField.getText();
        if (!email.trim().equals(BLANK)) {
            student.setEmail(email);
        }
        try { //checks if a language was selected
            student.setLanguage(languageCombo.getValue().toString());
        } catch (java.lang.NullPointerException e) {
            errorLanguageLabel.setText("* Select a language");
            validInput = false;
        }

        student.setRegistrationDate(LocalDate.now()); //user has no effect over this variable. based on the current date
        student.setLastTimeViewed(LocalDate.now()); //user has no effect over this variable. based on the current date
        boolean validprices = true; //only true if all variable used to calculate total price are not blank

        if (drivingClassRateTextField.getText().trim().equals("")) { //checks driving class rate input
            errorDrivingCostRate.setText("* Enter the driving class rate");
            validprices = false;
            validInput = false;
        }

        if (programTypeCombo.getValue() == "Old Program") { //if old program is selected
            theoryClassRateTextField.setDisable(true);
            checkBoxDefaultTheoryClassRate.setDisable(true);
            OldProgramStudent oldstudent = new OldProgramStudent(student);
            oldstudent.setProgram("Old Program");
            student = null; //deletes information passed onto oldstudent
            if (amountPayedDollarsTextField.getText().trim().equals("")) {
                errorClientPayed.setText("* Enter the amount the client payed");
                validprices = false;
                validInput = false;
            }
            if (numberOfDrivingClassesTextField.getText().trim().equals("")) {
                errorNumberOfDrivingClases.setText("* Enter the number of driving classes");
                validprices = false;
                validInput = false;
            }
            double totalPrice = 0;
            //you have to fix the total price for the old program. right now the program does not display the total price  
            //checks if the amount the client payed is more than the total price. if it is this is an error and the user will be warned
            if (validprices && Double.valueOf(numberOfDrivingClassesTextField.getText()) * Double.valueOf(drivingClassRateTextField.getText()) < Double.parseDouble(amountPayedDollarsTextField.getText())) { //checks if payment is less than total price
                errorTotalPrice.setText("* invalid price. Total price must be greater than or equal to amount payed");
            } else if (validprices) { //if everything is valid then adds total price and amount student payed
                totalPrice = calculateTotalPriceOldProgram(Integer.valueOf(numberOfDrivingClassesTextField.getText()), Double.valueOf(drivingClassRateTextField.getText()));
                ArrayList<Payments> tempArray = oldstudent.getPaymentArray();
                tempArray.add(new Payments(LocalDate.now(), Double.parseDouble(amountPayedDollarsTextField.getText()))); //updates payment array for temp array
                oldstudent.setPaymentArray(tempArray);
                oldstudent.setTotalPrice(oldstudent.getTotalPrice() + totalPrice);
            }
            if (validInput) { //if all the inputs are corect then the program will add the student

                try {
                   /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/ConfirmationWindow.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.show();
                    ConfirmationController confirmationController = (ConfirmationController) fxmlLoader.getController();
                    confirmationController.setLabels(oldstudent.getFirstName() + " " + oldstudent.getLastName(),
                            oldstudent.getAddress(), oldstudent.getPhoneNumber1(), oldstudent.getPhoneNumber2(),
                            oldstudent.getEmail(), oldstudent.getProgram(), oldstudent.getLanguage(),
                            error when user enters more money for amount payed then the actual cost
                            "$" + CURRENCY_FORMATER.format(oldstudent.getPaymentArray().get(oldstudent.numberOfPayments() - 1).getAmountPayed()),
                            "$" + CURRENCY_FORMATER.format(totalPrice), oldstudent);*/
                    mainApp.showCustomerDialog(oldstudent,totalPrice);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (programTypeCombo.getValue() == "New Program") {
            NewProgramStudent newstudent = new NewProgramStudent();
            student = newstudent; // no cast needed for upward use
            newstudent.setProgram("New Program");
            newstudent = (NewProgramStudent) student; // must cast explicitly (turns student into new program student)          
            try {
                //  newstudent.setDrivingLessonsArray(new ArrayList<DrivingLessonNew>()); // need to fix driving lesson array in student class

            } catch (NumberFormatException e) {
                //you need to create a panel which allows the user to chose date of next class
                validInput = false;
            }
            try {
                newstudent.setCurrentTheoryNumber(Integer.parseInt(currentTheoryNumberCombo.getValue().toString()));
                // errorTheoryLabel.setText("* Select 0 for students starting the first module class");
            } catch (NumberFormatException e1) {
                if (!currentTheoryNumberCombo.getValue().toString().equals("Completed")) //because the string "Completed" throws an exception, the if statments ignores this case
                {
                    this.errorTheoryLabel.setText("* Select next uncompleted theory class.");
                }
                validInput = false;
                validprices = false;// a price can't be calculated because a thoery number has not been selected
            } catch (NullPointerException e2) {
                if (!currentTheoryNumberCombo.getValue().toString().equals("Completed")) //because the string "Completed" throws an exception, the if statments ignores this case
                {
                    this.errorTheoryLabel.setText("* Select next uncompleted theory class.");
                }
                validInput = false;
            }
            try {
                newstudent.setPracticeNumber(Integer.parseInt(practiceNumberCombo.getValue().toString()));
                errorPracticeLabel.setText("Select 1 if student is still in phase 1");
            } catch (NumberFormatException e) {
                if (!practiceNumberCombo.getValue().toString().equals("Completed")) //because the string "Completed" throws an exception, the if statments ignores this case
                {
                    this.errorPracticeLabel.setText("* Select current road class. Select 1 if student is still in phase 1");
                }
                validInput = false;
                validprices = false;// a price can't be calculated because a practice number has not been selected
            } catch (NullPointerException e) {
                if (!practiceNumberCombo.getValue().toString().equals("Completed")) //because the string "Completed" throws an exception, the if statments ignores this case
                {
                    this.errorPracticeLabel.setText("* Select current road class. Select 1 if student is still in phase 1");
                }
                validInput = false;
            }
            /*try {
             newstudent.setArrayOfPaymentClasses(new ArrayList<Integer>());
             } catch (NumberFormatException e) {
             //you need to put in the interface an onption where the user selects the modules of payment
             validInput = false;
             }*/
            // student.setPaymentArray(new ArrayList<Payments>()); //creates a new payment array, because student has mad therefirst payment  
            // you have to fix prices for the new program and you have to fix the total price. right now the program does not display the total price
            if (theoryClassRateTextField.getText().trim().equals("")) {
                errorTheoryCostRate.setText("* Enter the theory class rate");
                validprices = false;
                validInput = false;
            }
            if (amountPayedDollarsTextField.getText().trim().equals("")) {
                errorClientPayed.setText("* Enter the amount the client payed");
                validprices = false;
                validInput = false;
            }
            //   fix total price again. total price when they make it a default selection  and close button           
            //checks if the amount the client payed is more than the total price. if it is this is an error and the user will be warned
            if (validprices && Double.valueOf(numberOfDrivingClassesTextField.getText()) * Double.valueOf(drivingClassRateTextField.getText()) < Double.parseDouble(amountPayedDollarsTextField.getText())) { //checks if payment is less than total price
                errorTotalPrice.setText("* invalid price. Total price must be greater than or equal to amount payed");
            } else if (validprices) { //if everything is valid then adds total price and amount student payed
                student.getPaymentArray().add(new Payments(LocalDate.now(), Double.parseDouble(amountPayedDollarsTextField.getText()))); //payment student made
                int numberOfThoeryClassesToPay;
                if (currentTheoryNumberCombo.getValue().toString().equals("Completed")) {
                    numberOfThoeryClassesToPay = 0;
                } else {
                    numberOfThoeryClassesToPay = 13 - Integer.valueOf(currentTheoryNumberCombo.getValue().toString());
                }
                int numberOfDrivingClassesToPay;
                if (practiceNumberCombo.getValue().toString().equals("Completed")) {
                    numberOfDrivingClassesToPay = 0;
                } else {
                    numberOfDrivingClassesToPay = 16 - Integer.valueOf(practiceNumberCombo.getValue().toString());
                }
                if (includeBookPriceCheckBox.isSelected()) {
                    student.setTotalPrice(Double.parseDouble(drivingClassRateTextField.getText()) * numberOfDrivingClassesToPay
                            + Double.parseDouble(theoryClassRateTextField.getText()) * numberOfThoeryClassesToPay + Double.parseDouble(setBookPriceTextField.getText()));
                } else // does not add book price if setTotalPriceCheckBox is selected      
                {
                    student.setTotalPrice(student.getTotalPrice() + Double.parseDouble(drivingClassRateTextField.getText()) * numberOfDrivingClassesToPay
                            + Double.parseDouble(theoryClassRateTextField.getText()) * numberOfThoeryClassesToPay); //total price to be payed in the future            
                }
            }
            if (validInput) {
                AnchorPane rootLayout = FXMLLoader.load(getClass().getResource("view/ConfirmationWindow.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(rootLayout);
                primaryStage.setScene(scene);
                primaryStage.show();
                studentDataController.add(newstudent);
            }

        } else { // if no program is selected
            errorProgramLabel.setText("* Select a program");
        }

    }

    public static void addStudent(Student student) {
        studentDataController.add(student);
    }
    
   

    public double calculateTotalPriceOldProgram(int NumberOfClassesTaken, double costPerDrivingClass) {

        return NumberOfClassesTaken * costPerDrivingClass;
    }

    public double calculateTotalPriceNewProgram(int numberOfTheoryClasses, int numberofDrivingClasses, double costPerTheoryclass, double costPerDrivingClass) {
        return numberOfTheoryClasses * costPerTheoryclass + numberofDrivingClasses * costPerDrivingClass;
    }

    @FXML
    private void onPaymentCheckboxSelected(ActionEvent event) {
        for (int index = 0; index < 27; index++) {
            if (event.getSource().equals(checkBoxPaymentArray[index])) { //checks which checkbox was selected
                paymentAmountTextFieldArray[index].setDisable(!checkBoxPaymentArray[index].isSelected());//disables textbox if there is no payment
                break;
            }
        }

    }

    @FXML
    private void onNameChangeAction(KeyEvent event) { //prevents characters which are not common in a name to be typed on textfield
        TextField text = (TextField) event.getSource();

        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("^[\\p{L} .'-]+$")) {
                } else {
                    if (!newValue.equals("")) //if there is only one letter left and the user backspaces then the "blank" will always remain one letter
                    {
                        text.setText(oldValue);
                    }
                }
            }
        });
    }

    @FXML
    private void onextentionPhoneNumberChangeAction(KeyEvent event) { //prevents characters which are not common in a name to be typed on textfield
        TextField text = (TextField) event.getSource();

        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("^\\d+$")) { //no length restriction
                } else {
                    if (!newValue.equals("")) //if there is only one letter left and the user backspaces then the "blank" will always remain one letter
                    {
                        text.setText(oldValue);
                    }
                }
            }
        });
    }

    @FXML
    private void onThreeDigitCodePhoneNumberChangeAction(KeyEvent event) { //prevents characters which are not common in a name to be typed on textfield
        TextField text = (TextField) event.getSource();

        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("^\\d+$") && newValue.length() < 4) {
                } else {
                    if (!newValue.equals("")) //if there is only one letter left and the user backspaces then the "blank" will always remain one letter
                    {
                        text.setText(oldValue);
                    }
                }
            }
        });
    }

    @FXML
    private void onFourDigitCodePhoneNumberChangeAction(KeyEvent event) { //prevents characters which are not common in a name to be typed on textfield
        TextField text = (TextField) event.getSource();

        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("^\\d+$") && newValue.length() < 5) {
                } else {
                    if (!newValue.equals("")) //if there is only one letter left and the user backspaces then the "blank" will always remain one letter
                    {
                        text.setText(oldValue);
                    }
                }
            }
        });
    }

    @FXML
    private void onPriceChangeAction(KeyEvent event) { ///used for textfields which only require a restriction on two decimal places
        TextField text = (TextField) event.getSource();
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("^[0-9]+(\\.([0-9]{1,2})?)?$")) {
                } else {
                    if (!newValue.equals("")) {
                        text.setText(oldValue);
                    }
                }
            }
        });
    }

    @FXML
    private void onDrivingRateChange(KeyEvent event) { ///used for textfields which only require a restriction on two decimal places
        TextField text = (TextField) event.getSource();
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("^[0-9]+(\\.([0-9]{1,2})?)?$")) { //checks if inputed value makes a double with only 2 decimal places
                    if (Double.valueOf(drivingClassRateTextField.getText()) != DEFAULT_COST_PER_DRIVING_CLASS) { //checks if rate is not equal to default rate
                        checkBoxDefaultDrivingClassRate.setSelected(false); //if rate is not equal to default rate then the checkbox will be deselected
                    }
                } else {
                    if (!newValue.equals("")) {
                        text.setText(oldValue);
                    }
                }
            }
        });
    }

    @FXML
    private void onTheoryRateChange(KeyEvent event) { ///used for textfields which only require a restriction on two decimal places
        TextField text = (TextField) event.getSource();
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("^[0-9]+(\\.([0-9]{1,2})?)?$")) { //checks if inputed value makes a double with only 2 decimal places
                    if (Double.valueOf(theoryClassRateTextField.getText()) != DEFAULT_COST_PER_THEORY_CLASS) { //checks if rate is not equal to default rate
                        checkBoxDefaultTheoryClassRate.setSelected(false); //if rate is not equal to default rate then the checkbox will be deselected
                    }
                } else {
                    if (!newValue.equals("")) {
                        text.setText(oldValue);
                    }
                }
            }
        });
    }

    @FXML
    private void onIntegerChange(KeyEvent event) { ///used for textfields which only require integers
        TextField text = (TextField) event.getSource();
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("\\d+")) { //checks if inputed value makes a double with only 2 decimal places

                } else {
                    if (!newValue.equals("")) {
                        text.setText(oldValue);
                    }
                }
            }
        });
    }

    private boolean onlyDigits(String inputString) { //checks if textfield only contains digits
        String string = inputString.toUpperCase();
        for (int ch = 32; ch <= 47; ch++) {
            if (string.contains(String.valueOf((char) ch))) {
                return false;
            }
        }
        for (int ch = 58; ch <= 127; ch++) {
            if (string.contains(String.valueOf((char) ch))) {
                return false;
            }
        }
        return true;
    }

    private boolean onlyDigitsExceptslash(String inputString) { //checks if textfield only contains digits and /
        String string = inputString.toUpperCase();
        for (int ch = 32; ch <= 46; ch++) { //from [space] to .
            if (string.contains(String.valueOf((char) ch))) {
                return false;
            }
        }
        for (int ch = 58; ch <= 127; ch++) { //after 9 to end
            if (string.contains(String.valueOf((char) ch))) {
                return false;
            }
        }
        return true;
    }

    @FXML
    private void autoFillComboBox() {
        ObservableList<String> studentListOptions = FXCollections.observableArrayList();
        String entered = studentComboSearch.getEditor().getText();
        FirstMiddleLastNameThread firstMiddleName = new FirstMiddleLastNameThread(studentDataController, entered);
        FirstMiddleLastNameThread LastName = new FirstMiddleLastNameThread(studentDataController, entered);
        Thread thread1 = new Thread(firstMiddleName);
        Thread thread2 = new Thread(LastName);
        thread1.start();
        thread2.start();
        for (int index = 0; index < studentDataController.size(); index++) {

        }
        thread1.start();
        thread2.start();

    }

    public static ObservableList<Student> getStudentDataController() {
        return studentDataController;
    }

    public static void addStudenttoDataController(NewProgramStudent student) {
        studentDataController.add(student);
    }

    public static void addStudenttoDataController(OldProgramStudent student) {
        studentDataController.add(student);
    }

}

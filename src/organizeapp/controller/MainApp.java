/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizeapp.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import organizeapp.controller.model.Database;
import organizeapp.controller.model.Student;
import static organizeapp.interfaces.DefaultPricesInterface.CURRENCY_FORMATER;

/**
 *
 * @author harrison
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Student> studentData = FXCollections.observableArrayList();

    public MainApp() {
        // Add some sample data
      /*  studentData.add(new Student("Hans", "Muster"));
         studentData.add(new Student("Ruth", "Mueller"));
         studentData.add(new Student("Heinz", "Kurz"));
         studentData.add(new Student("Cornelia", "Meier"));
         studentData.add(new Student("Werner", "Meyer"));
         studentData.add(new Student("Lydia", "Kunz"));
         studentData.add(new Student("Anna", "Best"));
         studentData.add(new Student("Stefan", "Meier"));
         studentData.add(new Student("Martin", "Mueller"));*/
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        try {

            // FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("OrganizeApp/src/organizeapp/controller/view/RootLayout.fxml"));
            rootLayout = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));
            //  rootLayout = (BorderPane) loader.load();
            //  rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    try {
                        Database.getInstance().connect();
                    } catch (Exception ex) {
                        Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (IOException e) {
            //Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

        showPersonOverview();
    }

    /**
     * Shows the person overview scene.
     */
    public void showPersonOverview() {
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane overviewPage = (AnchorPane) loader.load();
            rootLayout.setCenter(overviewPage);

            // Give the controller access to the main app
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }

    public void showCustomerDialog(Student student, double totalPrice) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "view/ConfirmationWindow.fxml"
                )
        );
        Parent root1 = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        ConfirmationController controller
                = loader.getController();
        controller.setMainApp(this);
        controller.setLabels(student, totalPrice);
    }

    public ObservableList<Student> getStudentData() {
        return studentData;
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

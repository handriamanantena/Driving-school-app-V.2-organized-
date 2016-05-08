/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import organizeapp.controller.MainApp;
import organizeapp.controller.model.Database;

/**
 *
 * @author harrison
 */
public class TestFXMain extends Application {
    private Stage primaryStage;
  /*  @Override
    public void start(Stage primaryStage) {
        this.primaryStage =primaryStage;
        
         try {
            primaryStage.setTitle("AddressApp");
            BorderPane rootLayout;

            //FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("OrganizeApp/src/organizeapp/controller/view/RootLayout.fxml"));
            rootLayout = FXMLLoader.load(getClass().getResource("Agenda.fxml"));
            //  rootLayout = (BorderPane) loader.load();
            //  rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        
        } catch (IOException e) {
            //Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }*/
    
    private BorderPane rootLayout;
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        try {

            // FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("OrganizeApp/src/organizeapp/controller/view/RootLayout.fxml"));
            rootLayout = FXMLLoader.load(getClass().getResource("WarningUserPayedMoreThanTotalPrice.fxml"));
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

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

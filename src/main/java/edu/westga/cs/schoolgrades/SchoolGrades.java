package edu.westga.cs.schoolgrades;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class for the SchoolGrades application
 * 
 * @author James Luke Johnson
 * @version 2018.10.30
 */
public class SchoolGrades extends Application {
	//TODO Move the view back and fix this line
	private static final String GUI_RESOURCE = "edu/westga/cs/schoolgrades/controllers/SchoolGrades.fxml";
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(SchoolGrades.GUI_RESOURCE);
        FXMLLoader loader = new FXMLLoader(resource);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grades Worksheet");
        primaryStage.setMaxWidth(600);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(200);
        primaryStage.show();
    }

    /**
     * Start point for the application.
     * @param args not used
     */
    public static void main(String[] args) {
        launch(args);
    }
}

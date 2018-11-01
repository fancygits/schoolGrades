package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.AverageGradingStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestGradeStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumGradingStrategy;
import edu.westga.cs.schoolgrades.views.GradeCellFactory;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

/**
 * Defines the controller for the SchoolGrades GUI
 * 
 * @author James Luke Johnson
 * @version 2018.10.31
 */
public class SchoolGradesController {

	@FXML
	private TextField quizSubtotalField;
	@FXML
	private TextField homeworkSubtotalField;
	@FXML
	private TextField examSubtotalField;
	@FXML
	private TextField finalGradeField;
	@FXML
	private ListView<Grade> quizzes;
	@FXML
	private ListView<Grade> homeworks;
	@FXML
	private ListView<Grade> exams;
	@FXML
	private Menu dataMenu;
	
	private DoubleProperty quizProperty;
	private DoubleProperty homeworkProperty;
	private DoubleProperty examProperty;
	private DoubleProperty finalGradeProperty;
	private CompositeGrade quizGrades;
	private CompositeGrade homeworkGrades;
	private CompositeGrade examGrades;
	
	/**
	 * Constructs the GUI controller
	 */
	public SchoolGradesController() {
		this.quizGrades = new CompositeGrade();
		this.quizGrades.setGradingStrategy(new SumGradingStrategy());
		this.homeworkGrades = new CompositeGrade();
		this.homeworkGrades.setGradingStrategy(new DropLowestGradeStrategy(new AverageGradingStrategy()));
		this.examGrades = new CompositeGrade();
		this.examGrades.setGradingStrategy(new AverageGradingStrategy());
		this.quizProperty = new SimpleDoubleProperty(0);
		this.homeworkProperty = new SimpleDoubleProperty(0);
		this.examProperty = new SimpleDoubleProperty(0);
		this.finalGradeProperty = new SimpleDoubleProperty(0);
		this.addDummyGrades();
	}
	
	/**
	 * Initializes the GUI FXML
	 */
	@FXML
	private void initialize() {
		this.quizSubtotalField.textProperty().bind(this.quizProperty.asString());
		this.homeworkSubtotalField.textProperty().bind(this.homeworkProperty.asString());
		this.examSubtotalField.textProperty().bind(this.examProperty.asString());
		this.finalGradeField.textProperty().bind(this.finalGradeProperty.asString());
		this.quizzes.setCellFactory(new GradeCellFactory());
		this.homeworks.setCellFactory(new GradeCellFactory());
		this.exams.setCellFactory(new GradeCellFactory());
		this.quizzes.setItems(this.quizGrades.getGrades());
		this.homeworks.setItems(this.homeworkGrades.getGrades());
		this.exams.setItems(this.examGrades.getGrades());
		this.recalculate();
	}
	
	@FXML
	private void addDummyGrades() {
		this.quizGrades.addGrade(new SimpleGrade(0));
		this.quizGrades.addGrade(new SimpleGrade(10));
		this.homeworkGrades.addGrade(new SimpleGrade(50));
		this.examGrades.addGrade(new SimpleGrade(30));
	}
	
	@FXML
	private void recalculate() {
		this.quizProperty.set(this.quizGrades.getValue());
		this.homeworkProperty.set(this.homeworkGrades.getValue());
		this.examProperty.set(this.examGrades.getValue());
	}
	
}

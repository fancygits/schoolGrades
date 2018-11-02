package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.AverageGradingStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestGradeStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumGradingStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
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
	
	private CompositeGrade quizGrades;
	private CompositeGrade homeworkGrades;
	private CompositeGrade examGrades;
	private CompositeGrade finalGrade;
	private DoubleProperty quizProperty;
	private DoubleProperty homeworkProperty;
	private DoubleProperty examProperty;
	private DoubleProperty finalGradeProperty;
	
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
		this.finalGrade = new CompositeGrade();
		this.finalGrade.addGrade(new WeightedGrade(this.quizGrades, 0.2));
		this.finalGrade.addGrade(new WeightedGrade(this.homeworkGrades, 0.3));
		this.finalGrade.addGrade(new WeightedGrade(this.examGrades, 0.5));
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
		this.quizzes.setEditable(true);
		this.homeworks.setEditable(true);
		this.exams.setEditable(true);
		this.recalculate();
	}
	
	private void addDummyGrades() {
		this.quizGrades.addGrade(new SimpleGrade(0));
		this.quizGrades.addGrade(new SimpleGrade(10));
		this.homeworkGrades.addGrade(new SimpleGrade(100));
		this.homeworkGrades.addGrade(new SimpleGrade(80));
		this.homeworkGrades.addGrade(new SimpleGrade(60));
		this.homeworkGrades.addGrade(new SimpleGrade(40));
		this.homeworkGrades.addGrade(new SimpleGrade(20));
		this.examGrades.addGrade(new SimpleGrade(99));
		this.examGrades.addGrade(new SimpleGrade(67));
		this.examGrades.addGrade(new SimpleGrade(73));
		this.examGrades.addGrade(new SimpleGrade(88));
	}
	
	@FXML
	private void recalculate() {
		this.quizProperty.set(this.quizGrades.getValue());
		this.homeworkProperty.set(this.homeworkGrades.getValue());
		this.examProperty.set(this.examGrades.getValue());
		this.finalGradeProperty.set(this.finalGrade.getValue());
	}
	
}

package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Defines the CompositeGrade class, allowing SimpleGrades and other CompositeGrades
 * 
 * @author James Luke Johnson
 * @version 2018.10.23
 */
public class CompositeGrade implements Grade {

	private ArrayList<Grade> gradeList;
	private CompositeGradingStrategy gradingStrategy;
	
	/**
	 * Constructs a CompositeGrade object and adds another Grade object to it.
	 * @param grade	The grade to add at construction
	 */
	public CompositeGrade(Grade grade) {
		this();
		if (grade == null) {
			throw new IllegalArgumentException("Grades cannot be null");
		}
		this.gradeList.add(grade);
	}
	
	/**
	 * Constructs an empty CompositeGrade object
	 * Assigns the default CompositeGradingStrategy
	 */
	public CompositeGrade() {
		this.gradeList = new ArrayList<Grade>();
		this.gradingStrategy = new SumGradingStrategy();
	}
	
	/**
	 * Adds a Grade to the CompositeGrade
	 * @param grade	The Grade to add
	 */
	public void addGrade(Grade grade) {
		if (grade == null) {
			throw new IllegalArgumentException("Grades cannot be null");
		}
		if (this.gradeList.contains(grade)) {
			throw new IllegalArgumentException("Cannot add the same grade twice");
		}
		this.gradeList.add(grade);
	}
	
	/**
	 * Getter for a Grade object at the given index
	 * @param gradeIndex	Index of the Grade
	 * @return				The Grade at that index
	 */
	public Grade getGrade(int gradeIndex) {
		return (Grade) this.gradeList.get(gradeIndex);
	}
	
	/**
	 * Gets the {@link Grade}s contained in this CompositeGrade
	 * 
	 * @return all contained grades
	 */
	public ObservableList<Grade> getGrades() {
		return FXCollections.observableArrayList(this.gradeList);
	}
	
	/**
	 * Sets a new CompositeGradingStrategy
	 * @param strategy	The strategy to set
	 */
	public void setGradingStrategy(CompositeGradingStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("Strategy cannot be null");
		}
		this.gradingStrategy = strategy;
	}
	
	@Override
	public double getValue() {
		return this.gradingStrategy.calculateGrade(this.gradeList);
	}

}

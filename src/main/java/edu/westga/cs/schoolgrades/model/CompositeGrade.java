package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Defines the CompositeGrade class, allowing SimpleGrades and other CompositeGrades
 * 
 * @author James Luke Johnson
 * @version 2018.10.23
 */
public class CompositeGrade implements Grade {

	private ArrayList<Grade> gradeList;
	private CompositeGradingStrategy gradingStrategy;
	
	public CompositeGrade(Grade grade) {
		this();
		if (grade == null) {
			throw new IllegalArgumentException("Grades cannot be null");
		}
		this.gradeList.add(grade);
	}
	
	public CompositeGrade() {
		this.gradeList = new ArrayList<Grade>();
		this.gradingStrategy = new SumGradingStrategy();
	}
	
	public void addGrade(Grade grade) {
		if (grade == null) {
			throw new IllegalArgumentException("Grades cannot be null");
		}
		this.gradeList.add(grade);
	}
	
	public Grade getGrade(int gradeIndex) {
		return (Grade) this.gradeList.get(gradeIndex);
	}
	
	public void setGradingStrategy(CompositeGradingStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("Strategy cannot be null");
		}
		this.gradingStrategy = strategy;
	}
	
	@Override
	public double getValue() {
		return gradingStrategy.calculateGrade(this.gradeList);
	}

}

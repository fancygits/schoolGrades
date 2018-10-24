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
	
	public CompositeGrade(Grade grade) {
		this.gradeList = new ArrayList<Grade>();
		this.gradeList.add(grade);
	}
	
	public void addGrade(Grade grade) {
		this.gradeList.add(grade);
	}
	
	public void removeGrade(Grade grade) {
		this.gradeList.remove(grade);
	}
	
	public Grade getGrade(int gradeIndex) {
		return (Grade) this.gradeList.get(gradeIndex);
	}
	
	@Override
	public double getValue() {
		double value = 0;
		for (Grade grade : this.gradeList) {
			value += grade.getValue();
		}
		return value;
	}

}

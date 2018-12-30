package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Defines the CompositeGradingStrategy interface and classes
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
public interface CompositeGradingStrategy {
	
	/**
	 * Calculates the Value of the CompositeGrade based on the
	 * concrete CompositeGradingStrategy object
	 * 
	 * @param grades	The gradeList of the CompositeGrade
	 * @return			The total value of all Grades contained
	 */
	double calculateGrade(ArrayList<Grade> grades);
	
}




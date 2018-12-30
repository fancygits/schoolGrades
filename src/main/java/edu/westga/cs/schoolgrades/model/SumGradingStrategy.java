package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Uses the Strategy design pattern to calculate a sum value
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
public class SumGradingStrategy implements CompositeGradingStrategy {
	
	@Override
	public double calculateGrade(ArrayList<Grade> grades) {
		if (grades.size() == 0 || grades == null) {
			throw new IllegalArgumentException("There are no grades to calculate.");
		}
		double value = 0;
		for (Grade grade : grades) {
			value += grade.getValue();
		}
		return value;
	}

}

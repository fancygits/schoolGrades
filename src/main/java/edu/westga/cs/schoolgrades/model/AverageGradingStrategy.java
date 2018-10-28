package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Uses the Strategy design pattern to calculate an average value
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
public class AverageGradingStrategy implements CompositeGradingStrategy {

	@Override
	public double calculateGrade(ArrayList<Grade> grades) {
		if (grades.size() == 0 || grades == null) {
			throw new IllegalArgumentException("There are no grades to calculate.");
		}
		return new SumGradingStrategy().calculateGrade(grades) / grades.size();
	}

}

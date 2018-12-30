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
		if (grades == null) {
			throw new IllegalArgumentException("Grade cannot be null");
		} else if (grades.size() == 0) {
			return 0;
		} else {
			return new SumGradingStrategy().calculateGrade(grades) / grades.size();
		}
	}

}

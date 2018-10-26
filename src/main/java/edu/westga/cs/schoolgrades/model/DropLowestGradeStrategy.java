package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * CompositeGradingStrategy decorator
 * Removes the lowest grade
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
public class DropLowestGradeStrategy extends StrategyDecorator {
	
	/**
	 * Constructs a DropLowestGradeStrategy
	 * @param strategy	A CompositeGradingStrategy
	 */
	public DropLowestGradeStrategy(CompositeGradingStrategy strategy) {
		super(strategy);
	}

	/** 
	 * Calculates the grade value without the lowest grade value.
	 * 
	 * I chose to clone the ArrayList so the original grades are preserved in case the strategy
	 * changes. This is more logical to the way a teacher would prefer. 
	 */
	@Override
	public double calculateGrade(ArrayList<Grade> grades) {
		@SuppressWarnings("unchecked")
		ArrayList<Grade> tempGrades = (ArrayList<Grade>) grades.clone();
		if (grades.size() > 1) {
			tempGrades.remove(Collections.min(tempGrades, Comparator.comparing(g -> g.getValue())));
		} else {
			throw new UnsupportedOperationException("CompositeGrade must contain more than 1 grade to drop the lowest grade.");
		}
		return getBaseStrategy().calculateGrade(tempGrades);
	}

}

package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
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

	@Override
	public double calculateGrade(ArrayList<Grade> grades) {
		if (grades.size() > 1) {
			grades.remove(Collections.min(grades, Comparator.comparing(g -> g.getValue())));
		} else {
			throw new UnsupportedOperationException("CompositeGrade must contain more than 1 grade to drop the lowest grade.");
		}
		return baseStrategy.calculateGrade(grades);
	}

}

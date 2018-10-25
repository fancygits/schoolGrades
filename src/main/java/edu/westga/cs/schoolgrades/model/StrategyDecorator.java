package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * 
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
public abstract class StrategyDecorator implements CompositeGradingStrategy {

	protected CompositeGradingStrategy baseStrategy;
	
	public StrategyDecorator(CompositeGradingStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("CompositeGradingStrategy cannot be null");
		}
		this.baseStrategy = strategy;
	}
	
	@Override
	public abstract double calculateGrade(ArrayList<Grade> grades);

}

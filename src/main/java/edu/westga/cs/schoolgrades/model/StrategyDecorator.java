package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Decorator class for CompositeGradingStrategy
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
public abstract class StrategyDecorator implements CompositeGradingStrategy {

	private CompositeGradingStrategy baseStrategy;
	
	/**
	 * Constructs a new decorator for CompositeGradingStrategy
	 * @param strategy	The strategy to decorate
	 */
	public StrategyDecorator(CompositeGradingStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("CompositeGradingStrategy cannot be null");
		}
		this.baseStrategy = strategy;
	}
	
	/**
	 * Getter for the baseStrategy. Created instead of making it protected.
	 * @return	The CompositeGradingStrategy to decorate
	 */
	public CompositeGradingStrategy getBaseStrategy() {
		return this.baseStrategy;
	}
	
	@Override
	public abstract double calculateGrade(ArrayList<Grade> grades);

}

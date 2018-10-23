package edu.westga.cs.schoolgrades.model;

/**
 * Defines the WeightedGrade class, a decorator class
 * 
 * @author James Luke Johnson
 * @version 2018.10.22
 */
public class WeightedGrade extends GradeDecorator {

	private double weight;
	
	/**
	 * @param newGrade
	 */
	public WeightedGrade(Grade newGrade, double weight) {
		super(newGrade);
		if (weight < 0) {
			throw new IllegalArgumentException("Weights cannot be negative.");
		}
		this.weight = weight;
	}
	
	@Override
	public double getValue() {
		return baseGrade.getValue() * this.weight;
	}

}

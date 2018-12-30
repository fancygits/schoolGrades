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
	 * Constructs a new WeightedGrade object
	 * @param newGrade	The grade to apply weight to
	 * @param weight	The weight to apply to the grade
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
		return getBaseGrade().getValue() * this.weight;
	}

}

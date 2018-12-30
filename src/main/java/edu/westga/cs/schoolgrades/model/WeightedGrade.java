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
	 * @param weight	The weight to apply to the grade (0.0 - 1.0)
	 */
	public WeightedGrade(Grade newGrade, double weight) {
		super(newGrade);
		if (weight < 0 || weight > 1) {
			throw new IllegalArgumentException("Weight must be between 0.0 - 1.0");
		}
		this.weight = weight;
	}
	
	@Override
	public double getValue() {
		return getBaseGrade().getValue() * this.weight;
	}

}

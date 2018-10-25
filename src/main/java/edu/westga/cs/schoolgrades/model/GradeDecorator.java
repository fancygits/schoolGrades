package edu.westga.cs.schoolgrades.model;

/**
 * Defines the GradeDecorator class for WeightedGrade decorators
 * 
 * @author James Luke Johnson
 * @version 2018.10.22
 */
public abstract class GradeDecorator implements Grade {

	protected Grade baseGrade;
	
	public GradeDecorator(Grade newGrade) {
		if (newGrade == null) {
			throw new IllegalArgumentException("Grades cannot be null");
		}
		this.baseGrade = newGrade;
	}
	
	@Override
	public abstract double getValue();

}

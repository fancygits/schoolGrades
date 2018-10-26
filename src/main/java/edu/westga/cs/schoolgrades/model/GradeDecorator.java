package edu.westga.cs.schoolgrades.model;

/**
 * Defines the GradeDecorator class for WeightedGrade decorators
 * 
 * @author James Luke Johnson
 * @version 2018.10.22
 */
public abstract class GradeDecorator implements Grade {

	private Grade baseGrade;
	
	/**
	 * Constructs a new Decorator for a Grade object
	 * @param newGrade	The Grade to decorate
	 */
	public GradeDecorator(Grade newGrade) {
		if (newGrade == null) {
			throw new IllegalArgumentException("Grades cannot be null");
		}
		this.baseGrade = newGrade;
	}
	
	/**
	 * Getter for the baseGrade
	 * @return	The baseGrade to decorate
	 */
	public Grade getBaseGrade() {
		return this.baseGrade;
	}
	
	@Override
	public abstract double getValue();

}

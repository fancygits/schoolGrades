package edu.westga.cs.schoolgrades.model;

/**
 * Defines the SimpleGrade class
 * 
 * @author James Luke Johnson
 * @version 2018.10.22
 */
public class SimpleGrade implements Grade {
	private double value;

	
	/**
	 * Constructs a new SimpleGrade object set to a value
	 * @param value		The Grade value
	 * Precondition:	value >= 0
	 */
	public SimpleGrade(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("SimpleGrade value must be greater than zero.");
		}
		this.value = value;
	}
	
	/**
	 * Constructs a new SimpleGrade with a value of 0
	 */
	public SimpleGrade() {
		this(0);
	}
	
	/**
	 * Returns the value of the SimpleGrade
	 * @see edu.westga.cs.schoolgrades.model.Grade#getValue()
	 */
	@Override
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Modifies the value of the SimpleGrade
	 * 
	 * @param newValue	The new Double value of the SimpleGrade	
	 */
	public void setValue(double newValue) {
		if (newValue < 0) {
			throw new IllegalArgumentException("SimpleGrade value must be greater than zero.");
		}
		this.value = newValue;
	}
}

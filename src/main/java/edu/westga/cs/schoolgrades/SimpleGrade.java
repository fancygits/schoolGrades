package edu.westga.cs.schoolgrades;

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
	 * @param value	The Grade value
	 */
	public SimpleGrade(double value) {
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
	 * @see edu.westga.cs.schoolgrades.Grade#getValue()
	 */
	public double getValue() {
		return this.value;
	}

}

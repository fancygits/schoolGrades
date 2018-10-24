package edu.westga.cs.schoolgrades.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * Tests the WeightedGrade constructor and getValue method
 * 
 * @author James Luke Johnson
 * @version 2018.10.22
 */
public class TestWeightedGradeConstructor {

	@Test
	public void shouldReturnValueOf50() {
		Grade halfGrade = new WeightedGrade(new SimpleGrade(100), .5);
		assertEquals(50, halfGrade.getValue());
	}

	@Test
	public void shouldReturnValueOf200() {
		Grade doubleGrade = new WeightedGrade(new SimpleGrade(100), 2);
		assertEquals(200, doubleGrade.getValue());
	}
	
	@Test
	public void shouldReturnValuesOf0WhenGradeIsZero() {
		Grade zeroGrade = new WeightedGrade(new SimpleGrade(), 7);
		assertEquals(0, zeroGrade.getValue());
	}
	
	@Test
	public void shouldReturnValuesOf0WhenWeightIsZero() {
		Grade zeroWeight = new WeightedGrade(new SimpleGrade(78), 0);
		assertEquals(0, zeroWeight.getValue());
	}
	
	@Test
	public void shouldNotAllowNullGrades() {
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(null, 1));
	}
	
	@Test
	public void shouldNotAllowNegativeGrades() {
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(-43), 7));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(-0.5), 4));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(-100), 1));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(-1), 0));
	}
	
	@Test
	public void shouldNotAllowNegativeWeights() {
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(43), -7));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(0.5), -4));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(100), -1));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(1), -0.2));
	}
}

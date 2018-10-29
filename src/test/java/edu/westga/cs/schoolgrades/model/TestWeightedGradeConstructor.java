package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the WeightedGrade constructor and getValue method
 * 
 * @author James Luke Johnson
 * @version 2018.10.22
 */
class TestWeightedGradeConstructor {

	@Test
	void shouldReturnValueOf50() {
		Grade halfGrade = new WeightedGrade(new SimpleGrade(100), .5);
		assertEquals(50, halfGrade.getValue());
	}

	@Test
	void shouldReturnValueOf200() {
		Grade doubleGrade = new WeightedGrade(new SimpleGrade(100), .4);
		assertEquals(40, doubleGrade.getValue());
	}
	
	@Test
	void shouldReturnValuesOf0WhenGradeIsZero() {
		Grade zeroGrade = new WeightedGrade(new SimpleGrade(), .7);
		assertEquals(0, zeroGrade.getValue());
	}
	
	@Test
	void shouldReturnValuesOf0WhenWeightIsZero() {
		Grade zeroWeight = new WeightedGrade(new SimpleGrade(78), 0);
		assertEquals(0, zeroWeight.getValue());
	}
	
	@Test
	void shouldAddWeightToCompositeGrade() {
		CompositeGrade project = new CompositeGrade();
		SimpleGrade part1 = new SimpleGrade(90);
		project.addGrade(part1);
		CompositeGrade part2 = new CompositeGrade(new SimpleGrade(100));
		project.addGrade(part2);
		part2.addGrade(new SimpleGrade(75));
		part2.addGrade(new SimpleGrade(35));
		WeightedGrade modifiedProject = new WeightedGrade(project, 0.5);
		assertEquals(150, modifiedProject.getValue());
	}
	
	@Test
	void shouldNotAllowNullGrades() {
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(null, 1));
	}
	
	@Test
	void shouldNotAllowNegativeGrades() {
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(-43), .7));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(-0.5), .4));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(-100), .1));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(-1), 0));
	}
	
	@Test
	void shouldNotAllowNegativeWeights() {
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(43), -.7));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(0.5), -.4));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(100), -.1));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(1), -0.2));
	}
	
	@Test
	void shouldNotAllowWeightsGreaterThan1() {
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(43), 7));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(0.5), 4));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(100), 1.1));
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(new SimpleGrade(1), 2));
	}
}

package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the constructor and getValue of SimpleGrade
 * 
 * @author James Luke Johnson
 * @version 2018.10.22
 */
class TestSimpleGradeConstructor {

	@Test
	void shouldSetValueTo100() {
		SimpleGrade perfectScore = new SimpleGrade(100);
		assertEquals(100, perfectScore.getValue());
	}
	
	@Test
	void shouldSetValueTo87() {
		SimpleGrade bScore = new SimpleGrade(87.12);
		assertEquals(87.12, bScore.getValue());
	}
	
	@Test
	void shouldSetValueTo32() {
		SimpleGrade failingScore = new SimpleGrade(32.6);
		assertEquals(32.6, failingScore.getValue());
	}

	@Test
	void shouldSetValueTo0() {
		SimpleGrade missingScore = new SimpleGrade();
		assertEquals(0, missingScore.getValue());
	}
	
	@Test
	void shouldNotAllowNegativeValues() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleGrade(-34));
		assertThrows(IllegalArgumentException.class, () -> new SimpleGrade(-1.9));
		assertThrows(IllegalArgumentException.class, () -> new SimpleGrade(-0.1));
		assertThrows(IllegalArgumentException.class, () -> new SimpleGrade(-100));
	}
}

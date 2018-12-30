package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the setValue method of SimpleGrade
 * 
 * @author James Luke Johnson
 * @version 2018.11.07
 */
class TestSimpleGradeSetValue {

	@Test
	void shouldSetValueTo100() {
		SimpleGrade perfectScore = new SimpleGrade(0);
		perfectScore.setValue(100);
		assertEquals(100, perfectScore.getValue());
	}
	
	@Test
	void shouldSetValueTo87() {
		SimpleGrade bScore = new SimpleGrade();
		bScore.setValue(87.12);
		assertEquals(87.12, bScore.getValue());
	}
	
	@Test
	void shouldSetValueTo32() {
		SimpleGrade failingScore = new SimpleGrade(100);
		failingScore.setValue(32.6);
		assertEquals(32.6, failingScore.getValue());
	}

	@Test
	void shouldSetValueTo0() {
		SimpleGrade missingScore = new SimpleGrade();
		missingScore.setValue(0);
		assertEquals(0, missingScore.getValue());
	}
	
	@Test
	void shouldNotAllowNegativeValues() {
		SimpleGrade negativeGrade = new SimpleGrade();
		assertThrows(IllegalArgumentException.class, () -> negativeGrade.setValue(-34));
		assertThrows(IllegalArgumentException.class, () -> negativeGrade.setValue(-1.9));
		assertThrows(IllegalArgumentException.class, () -> negativeGrade.setValue(-0.1));
		assertThrows(IllegalArgumentException.class, () -> negativeGrade.setValue(-100));
	}

}

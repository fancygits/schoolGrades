package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the getGrade method of CompositeGrade
 * 
 * @author James Luke Johnson
 * @version 2018.10.25
 */
class TestCompositeGradeGetGrade {

	@Test
	void shouldReturnTheOnlyGrade() {
		CompositeGrade oneGrade = new CompositeGrade(new SimpleGrade(99));
		assertEquals(99, oneGrade.getGrade(0).getValue());
	}
	
	@Test
	void shouldReturnAllGradesInOrder() {
		CompositeGrade fourGrades = new CompositeGrade(new SimpleGrade(0));
		fourGrades.addGrade(new SimpleGrade(10));
		fourGrades.addGrade(new SimpleGrade(20));
		fourGrades.addGrade(new SimpleGrade(30));
		assertEquals(0, fourGrades.getGrade(0).getValue());
		assertEquals(10, fourGrades.getGrade(1).getValue());
		assertEquals(20, fourGrades.getGrade(2).getValue());
		assertEquals(30, fourGrades.getGrade(3).getValue());
	}
	
	@Test
	void shouldThrowExceptionForIndexWithNoGrade() {
		CompositeGrade noGrades = new CompositeGrade();
		assertThrows(IndexOutOfBoundsException.class, () -> noGrades.getGrade(0));
		noGrades.addGrade(new SimpleGrade(100));
		assertThrows(IndexOutOfBoundsException.class, () -> noGrades.getGrade(1));
	}

}

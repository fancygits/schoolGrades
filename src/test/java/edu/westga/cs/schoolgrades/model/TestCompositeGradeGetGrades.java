package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author James Luke Johnson
 * @version 2018.11.07
 */
class TestCompositeGradeGetGrades {

	@Test
	void shouldReturnObservableArrayWithNoGrades() {
		CompositeGrade emptyGrade = new CompositeGrade();
		assertEquals(0, emptyGrade.getGrades().size());
	}
	
	@Test
	void shouldReturnObservableArrayWith1Grade() {
		CompositeGrade oneGrade = new CompositeGrade();
		SimpleGrade newGrade = new SimpleGrade(78);
		oneGrade.addGrade(newGrade);
		assertEquals(1, oneGrade.getGrades().size());
		assertTrue(oneGrade.getGrades().contains(newGrade));
	}
	
	@Test
	void shouldReturnObservableArrayWith3Grade() {
		CompositeGrade oneGrade = new CompositeGrade();
		SimpleGrade newGrade1 = new SimpleGrade(78);
		SimpleGrade newGrade2 = new SimpleGrade(89);
		SimpleGrade newGrade3 = new SimpleGrade(100);
		oneGrade.addGrade(newGrade1);
		oneGrade.addGrade(newGrade2);
		oneGrade.addGrade(newGrade3);
		assertEquals(3, oneGrade.getGrades().size());
		assertTrue(oneGrade.getGrades().contains(newGrade1));
		assertTrue(oneGrade.getGrades().contains(newGrade2));
		assertTrue(oneGrade.getGrades().contains(newGrade3));
	}

}

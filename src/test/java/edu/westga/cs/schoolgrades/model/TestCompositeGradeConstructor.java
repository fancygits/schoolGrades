package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the constructor of CompositeGrade
 * 
 * @author James Luke Johnson
 * @version 2018.10.23
 */
class TestCompositeGradeConstructor {

	@Test
	void shouldAdd1SimpleGradeAtConstruction() {
		CompositeGrade project1 = new CompositeGrade(new SimpleGrade(80));
		assertEquals(80, project1.getGrade(0).getValue());
		assertThrows(IndexOutOfBoundsException.class, () -> project1.getGrade(1));
	}
	
	@Test
	void shouldAddACompositeGradeContainingASimpleGradeAtConstruction() {
		CompositeGrade project2 = new CompositeGrade(new CompositeGrade(new SimpleGrade(79)));
		assertEquals(79, project2.getGrade(0).getValue());
	}
	
	@Test
	void shouldNotAllowNullGrades() {
		assertThrows(IllegalArgumentException.class, () -> new CompositeGrade(null));
		
	}

}

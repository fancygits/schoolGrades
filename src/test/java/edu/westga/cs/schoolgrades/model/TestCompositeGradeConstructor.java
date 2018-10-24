package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests the add method of CompositeGrade
 * 
 * @author James Luke Johnson
 * @version 2018.10.23
 */
class TestCompositeGradeConstructor {

	@Test
	void shouldAdd1SimpleGradeAtConstruction() {
		CompositeGrade project1 = new CompositeGrade(new SimpleGrade(80));
		assertEquals(80, project1.getGrade(0).getValue());
	}

}

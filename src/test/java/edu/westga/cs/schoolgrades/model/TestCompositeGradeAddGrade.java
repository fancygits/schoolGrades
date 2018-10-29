package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the addGrade method of CompositeGrade
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
class TestCompositeGradeAddGrade {

	@Test
	void shouldAddASimpleGrade() {
		CompositeGrade containsTwo = new CompositeGrade(new SimpleGrade(50.1));
		containsTwo.addGrade(new SimpleGrade(60.2));
		assertEquals(50.1, containsTwo.getGrade(0).getValue());
		assertEquals(60.2, containsTwo.getGrade(1).getValue());
		assertThrows(IndexOutOfBoundsException.class, () -> containsTwo.getGrade(2));
	}
	
	@Test
	void shouldAdd3SimpleGrades() {
		CompositeGrade containsFour = new CompositeGrade(new SimpleGrade(1));
		containsFour.addGrade(new SimpleGrade(2));
		containsFour.addGrade(new SimpleGrade(3));
		containsFour.addGrade(new SimpleGrade(4));
		assertEquals(1, containsFour.getGrade(0).getValue());
		assertEquals(2, containsFour.getGrade(1).getValue());
		assertEquals(3, containsFour.getGrade(2).getValue());
		assertEquals(4, containsFour.getGrade(3).getValue());
		assertThrows(IndexOutOfBoundsException.class, () -> containsFour.getGrade(4));
	}
	
	@Test
	void shouldAdd1CompositeGradeWith1SimpleGrade() {
		CompositeGrade containsTwo = new CompositeGrade(new SimpleGrade(0.1));
		containsTwo.addGrade(new CompositeGrade(new SimpleGrade(0.2)));
		assertEquals(0.1, containsTwo.getGrade(0).getValue());
		assertEquals(0.2, containsTwo.getGrade(1).getValue());
		assertThrows(IndexOutOfBoundsException.class, () -> containsTwo.getGrade(2));
	}
	
	@Test
	void shouldAdd5CompositeGradesInsideEachOther() {
		CompositeGrade containsTwo = new CompositeGrade(new SimpleGrade(100));
		containsTwo.addGrade(
				new CompositeGrade(
						new CompositeGrade(
								new CompositeGrade(
										new CompositeGrade(
												new CompositeGrade(
														new SimpleGrade(200)))))));
		assertEquals(100, containsTwo.getGrade(0).getValue());
		assertEquals(200, containsTwo.getGrade(1).getValue());
		assertThrows(IndexOutOfBoundsException.class, () -> containsTwo.getGrade(2));
	}
	
	@Test
	void shouldAddAWeightedGrade() {
		CompositeGrade project = new CompositeGrade();
		WeightedGrade part1 = new WeightedGrade(new SimpleGrade(90), .5);
		SimpleGrade part2 = new SimpleGrade(100);
		project.addGrade(part1);
		project.addGrade(part2);
		assertEquals(145, project.getValue());
		assertEquals(45, project.getGrade(0).getValue());
		assertEquals(100, project.getGrade(1).getValue());
		assertThrows(IndexOutOfBoundsException.class, () -> project.getGrade(2));
	}
	
	@Test
	void shouldNotAddNullGrade() {
		CompositeGrade containsOne = new CompositeGrade(new SimpleGrade(10));
		assertThrows(IllegalArgumentException.class, () -> containsOne.addGrade(null));
	}
	
	@Test
	void shouldNotAddSameGradeTwice() {
		SimpleGrade grade1 = new SimpleGrade(10);
		CompositeGrade containsOne = new CompositeGrade(grade1);
		assertThrows(IllegalArgumentException.class, () -> containsOne.addGrade(grade1));
	}

}

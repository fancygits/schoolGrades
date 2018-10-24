package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests the GradeDecorator abstract class with the GradeDecoratorTester concrete class
 * 
 * @author James Luke Johnson
 * @version 2018.10.23
 */
class TestGradeDecoratorGetValue {

	@Test
	void shouldReturn100() {
		GradeDecorator newGDTester = new GradeDecoratorTester(new SimpleGrade(100));
		assertEquals(100, newGDTester.getValue());
	}
	
	@Test
	void shouldReturn567() {
		GradeDecorator newGDTester = new GradeDecoratorTester(new SimpleGrade(567));
		assertEquals(567, newGDTester.getValue());
	}

	@Test
	void shouldReturn4() {
		GradeDecorator newGDTester = new GradeDecoratorTester(new SimpleGrade(4));
		assertEquals(4, newGDTester.getValue());
	}
	
	@Test
	void shouldReturn0() {
		GradeDecoratorTester newGDTester = new GradeDecoratorTester(new SimpleGrade());
		assertEquals(0, newGDTester.getValue());
	}
}

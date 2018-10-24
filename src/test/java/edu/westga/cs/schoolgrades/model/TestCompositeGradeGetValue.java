package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests the getValue method of CompositeGrade
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
class TestCompositeGradeGetValue {

	@Test
	void shouldReturn100WhenContainingOneGradeOf100() {
		CompositeGrade oneGrade = new CompositeGrade(new SimpleGrade(100));
		assertEquals(100, oneGrade.getValue());
	}
	
	@Test
	void shouldContain2SimpleGradesTotalling150() {
		CompositeGrade twoGrades = new CompositeGrade(new SimpleGrade(100));
		twoGrades.addGrade(new SimpleGrade(50));
		assertEquals(150, twoGrades.getValue());
	}

	@Test
	void shouldContain4SimpleGradesTotalling300() {
		CompositeGrade fourGrades = new CompositeGrade(new SimpleGrade(75));
		fourGrades.addGrade(new SimpleGrade(75));
		fourGrades.addGrade(new SimpleGrade(75));
		fourGrades.addGrade(new SimpleGrade(75));
		assertEquals(300, fourGrades.getValue());
	}
	
	@Test
	void shouldContainManyGradesTotalling709() {
		CompositeGrade projectGrade = new CompositeGrade();
		SimpleGrade titlePage = new SimpleGrade(98);
		SimpleGrade bibliography = new SimpleGrade(87);
		CompositeGrade content = new CompositeGrade();
		SimpleGrade grammar = new SimpleGrade(95);
		SimpleGrade spelling = new SimpleGrade(100);
		SimpleGrade thesisStatement = new SimpleGrade(74);
		CompositeGrade supportingStatements = new CompositeGrade();
		SimpleGrade firstStatement = new SimpleGrade(99);
		SimpleGrade secondStatement = new SimpleGrade(89);
		SimpleGrade thirdStatement = new SimpleGrade(67);
		supportingStatements.addGrade(firstStatement);
		supportingStatements.addGrade(secondStatement);
		supportingStatements.addGrade(thirdStatement);
		content.addGrade(grammar);
		content.addGrade(spelling);
		content.addGrade(thesisStatement);
		content.addGrade(supportingStatements);
		projectGrade.addGrade(titlePage);
		projectGrade.addGrade(content);
		projectGrade.addGrade(bibliography);
		assertEquals(709, projectGrade.getValue());
	}
}

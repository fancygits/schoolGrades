package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Tests the constructor for the DropLowestGradeStrategy
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
class TestDropLowestGradeStrategyConstructor {

	@Test
	void shouldDropTheLowestScoreFrom4ScoresAndReturn270() {
		ArrayList<Grade> fourGrades = new ArrayList<Grade>();
		fourGrades.add(new SimpleGrade(100));
		fourGrades.add(new SimpleGrade(90));
		fourGrades.add(new SimpleGrade(80));
		fourGrades.add(new SimpleGrade(70));
		DropLowestGradeStrategy sumDropStrategy = new DropLowestGradeStrategy(new SumGradingStrategy());
		assertEquals(100 + 90 + 80 + 70 - 70, sumDropStrategy.calculateGrade(fourGrades));
	}
	
	
	/**
	 * The lowest grade in projectGrade is 87, the bibliography. It isn't 67, thirdStatement,
	 * because the supportingStatements Grade uses the SumGradingStrategy with no decorator.
	 */
	@Test
	void shouldDropGradeOf87ReturningTotalOf622() {
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
		projectGrade.setGradingStrategy(new DropLowestGradeStrategy(new SumGradingStrategy()));
		assertEquals(622, projectGrade.getValue());
	}

	@Test
	void shouldDropLowestDoubleGrade() {
		CompositeGrade doubles = new CompositeGrade();
		doubles.addGrade(new SimpleGrade(56.54));
		doubles.addGrade(new SimpleGrade(78.33));
		doubles.addGrade(new SimpleGrade(24.123));
		doubles.addGrade(new SimpleGrade(45.1));
		doubles.addGrade(new SimpleGrade(99.99));
		doubles.setGradingStrategy(new DropLowestGradeStrategy(new AverageGradingStrategy()));
		assertEquals(69.99, doubles.getValue(), 0.01);
	}
	
	@Test
	void shouldDropLowestGradeBeforeSum() {
		CompositeGrade summedGradeMinusOne = new CompositeGrade();
		summedGradeMinusOne.addGrade(new SimpleGrade(66.6));
		summedGradeMinusOne.addGrade(new SimpleGrade(33.3));
		summedGradeMinusOne.addGrade(new SimpleGrade(99.9));
		summedGradeMinusOne.addGrade(new SimpleGrade(11.1));
		summedGradeMinusOne.setGradingStrategy(new DropLowestGradeStrategy(new SumGradingStrategy()));
		assertEquals(199.8, summedGradeMinusOne.getValue());
	}
	
	@Test
	void shouldDropLowestGradeBeforeAverage() {
		CompositeGrade averagedGradeMinusOne = new CompositeGrade();
		averagedGradeMinusOne.addGrade(new SimpleGrade(66.6));
		averagedGradeMinusOne.addGrade(new SimpleGrade(33.3));
		averagedGradeMinusOne.addGrade(new SimpleGrade(99.9));
		averagedGradeMinusOne.addGrade(new SimpleGrade(11.1));
		averagedGradeMinusOne.setGradingStrategy(new DropLowestGradeStrategy(new AverageGradingStrategy()));
		assertEquals(66.6, averagedGradeMinusOne.getValue(), 0.01);
	}
	
	@Test
	void cannotDropGradeWhenOnlyOneGradeInCompositeGradeReturnsChildStrategyInstead() {
		CompositeGrade oneGrade = new CompositeGrade(new SimpleGrade(99));
		oneGrade.setGradingStrategy(new DropLowestGradeStrategy(new AverageGradingStrategy()));
		assertEquals(99, oneGrade.getValue());
	}
	
	@Test
	void cannotDropGradeWhenNoGradesInCompositeGrade() {
		CompositeGrade noGrade = new CompositeGrade();
		noGrade.setGradingStrategy(new DropLowestGradeStrategy(new AverageGradingStrategy()));
		assertThrows(IllegalArgumentException.class, () -> noGrade.getValue());
	}
	
	@Test
	void cannotDecorateWithNull() {
		CompositeGrade oneGrade = new CompositeGrade(new SimpleGrade(99));
		assertThrows(IllegalArgumentException.class, () -> oneGrade.setGradingStrategy(new DropLowestGradeStrategy(null)));
	}
}

package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the setGradingStrategy method of CompositeGrade
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
class TestCompositeGradeSetGradingStrategy {

	@Test
	void shouldReturn100ForSumStrategyAnd50ForAverageStrategy() {
		CompositeGrade twoGrades = new CompositeGrade(new SimpleGrade(50));
		twoGrades.addGrade(new SimpleGrade(50));
		assertEquals(100, twoGrades.getValue());
		twoGrades.setGradingStrategy(new AverageGradingStrategy());
		assertEquals(50, twoGrades.getValue());
		twoGrades.setGradingStrategy(new SumGradingStrategy());
		assertEquals(100, twoGrades.getValue());
	}
	
	@Test
	void shouldReturn100ForSumStrategyAnd33ForAverageStrategy() {
		CompositeGrade threeGrades = new CompositeGrade(new SimpleGrade(20));
		threeGrades.addGrade(new SimpleGrade(50));
		threeGrades.addGrade(new SimpleGrade(30));
		assertEquals(100, threeGrades.getValue());
		threeGrades.setGradingStrategy(new AverageGradingStrategy());
		assertEquals(33.333, threeGrades.getValue(), 0.001);
		threeGrades.setGradingStrategy(new SumGradingStrategy());
		assertEquals(100, threeGrades.getValue());
	}
	
	@Test
	void shouldNotCalculateEmptyCompositeGrades() {
		CompositeGrade emptyGrade = new CompositeGrade();
		assertThrows(IllegalArgumentException.class, () -> emptyGrade.getValue());
		emptyGrade.setGradingStrategy(new AverageGradingStrategy());
		assertThrows(IllegalArgumentException.class, () -> emptyGrade.getValue());
		emptyGrade.setGradingStrategy(new SumGradingStrategy());
		assertThrows(IllegalArgumentException.class, () -> emptyGrade.getValue());
	}
	
	@Test
	void cannotUseNullStrategy() {
		CompositeGrade threeGrades = new CompositeGrade(new SimpleGrade(20));
		threeGrades.addGrade(new SimpleGrade(50));
		threeGrades.addGrade(new SimpleGrade(30));
		assertThrows(IllegalArgumentException.class, () -> threeGrades.setGradingStrategy(null));
	}

}

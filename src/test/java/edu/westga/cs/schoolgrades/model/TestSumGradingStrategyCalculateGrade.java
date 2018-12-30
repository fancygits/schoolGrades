package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Tests calculateGrade() from SumGradingStrategy
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
class TestSumGradingStrategyCalculateGrade {

	@Test
	void shouldSumAListOf1GradeTotalling100() {
		ArrayList<Grade> oneGrade = new ArrayList<Grade>();
		oneGrade.add(new SimpleGrade(100));
		SumGradingStrategy sumStrategy = new SumGradingStrategy();
		assertEquals(100, sumStrategy.calculateGrade(oneGrade));
	}
	
	@Test
	void shouldSumAListOf2GradesTotalling150() {
		ArrayList<Grade> twoGrades = new ArrayList<Grade>();
		twoGrades.add(new SimpleGrade(100));
		twoGrades.add(new SimpleGrade(50));
		SumGradingStrategy sumStrategy = new SumGradingStrategy();
		assertEquals(150, sumStrategy.calculateGrade(twoGrades));
	}

	@Test
	void shouldSumAListOf4GradesTotalling300() {
		ArrayList<Grade> fourGrades = new ArrayList<Grade>();
		fourGrades.add(new SimpleGrade(100));
		fourGrades.add(new SimpleGrade(50));
		fourGrades.add(new SimpleGrade(75));
		fourGrades.add(new SimpleGrade(75));
		SumGradingStrategy sumStrategy = new SumGradingStrategy();
		assertEquals(300, sumStrategy.calculateGrade(fourGrades));
	}
	
	@Test
	void shouldNotCalculateEmptyGrades() {
		ArrayList<Grade> zeroGrade = new ArrayList<Grade>();
		AverageGradingStrategy averageStrategy = new AverageGradingStrategy();
		assertThrows(IllegalArgumentException.class, () -> averageStrategy.calculateGrade(zeroGrade));
	}

}

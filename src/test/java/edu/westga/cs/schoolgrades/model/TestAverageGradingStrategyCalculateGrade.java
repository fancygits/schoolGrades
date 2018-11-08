package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Tests calculateGrade() from AverageGradingStrategy
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
class TestAverageGradingStrategyCalculateGrade {

	@Test
	void shouldSumAListOf1GradeTotalling100() {
		ArrayList<Grade> oneGrade = new ArrayList<Grade>();
		oneGrade.add(new SimpleGrade(100));
		AverageGradingStrategy averageStrategy = new AverageGradingStrategy();
		assertEquals(100, averageStrategy.calculateGrade(oneGrade));
	}
	
	@Test
	void shouldSumAListOf2GradesTotalling150() {
		ArrayList<Grade> twoGrades = new ArrayList<Grade>();
		twoGrades.add(new SimpleGrade(100));
		twoGrades.add(new SimpleGrade(50));
		AverageGradingStrategy averageStrategy = new AverageGradingStrategy();
		assertEquals(75, averageStrategy.calculateGrade(twoGrades));
	}

	@Test
	void shouldSumAListOf4GradesTotalling300() {
		ArrayList<Grade> fourGrades = new ArrayList<Grade>();
		fourGrades.add(new SimpleGrade(100));
		fourGrades.add(new SimpleGrade(50));
		fourGrades.add(new SimpleGrade(75));
		fourGrades.add(new SimpleGrade(75));
		AverageGradingStrategy averageStrategy = new AverageGradingStrategy();
		assertEquals(75, averageStrategy.calculateGrade(fourGrades));
	}
	
	@Test
	void shouldCalculateEmptyGradesAs0() {
		ArrayList<Grade> zeroGrade = new ArrayList<Grade>();
		AverageGradingStrategy averageStrategy = new AverageGradingStrategy();
		assertEquals(0, averageStrategy.calculateGrade(zeroGrade));
	}

}

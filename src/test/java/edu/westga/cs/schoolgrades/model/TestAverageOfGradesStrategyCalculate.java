package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAverageOfGradesStrategyCalculate {

	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	private List<Grade> grades;
	
	private AverageOfGradesStrategy strategy;
	
	@BeforeEach
	public void setup() {
		this.mockGrade0 = mock(Grade.class);
		when(this.mockGrade0.getValue()).thenReturn(10.0);
		this.mockGrade1 = mock(Grade.class);
		when(this.mockGrade1.getValue()).thenReturn(20.0);
		this.mockGrade2 = mock(Grade.class);
		when(this.mockGrade2.getValue()).thenReturn(30.0);
		
		this.grades = new ArrayList<Grade>();
		
		this.strategy = new AverageOfGradesStrategy();
	}
	
	@Test
	public  void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> { 
			this.strategy.calculate(null);
		});
	}
	
	@Test
	public void shouldGiveZeroIfNoGrades() {
		assertEquals(0, this.strategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void shouldCalculateAverageOfOneGrades() {
		this.grades.add(this.mockGrade0);
		assertEquals(this.mockGrade0.getValue(), this.strategy.calculate(this.grades), DELTA);
	}

	@Test
	public void shouldCalculateSumOManyGrades() {
		this.grades.add(this.mockGrade0);
		this.grades.add(this.mockGrade1);
		this.grades.add(this.mockGrade2);
		assertEquals(20, this.strategy.calculate(this.grades), DELTA);
	}

}

package edu.westga.cs.schoolgrades.model;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSumOfGradesStrategyCalculate {

	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	private List<Grade> grades;
	
	private SumOfGradesStrategy strategy;
	
	@BeforeEach
	public void setup() {
		mockGrade0 = mock(Grade.class);
		when(mockGrade0.getValue()).thenReturn(10.0);
		mockGrade1 = mock(Grade.class);
		when(mockGrade1.getValue()).thenReturn(20.0);
		mockGrade2 = mock(Grade.class);
		when(mockGrade2.getValue()).thenReturn(30.0);
		
		grades = new ArrayList<Grade>();
		
		strategy = new SumOfGradesStrategy();
	}
	
	@Test
	public  void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			strategy.calculate(null);
		});
	}
	
	@Test
	public void shouldGiveZeroIfNoGrades() {
		assertEquals(0, strategy.calculate(grades), DELTA);
	}
	
	@Test
	public void shouldCalculateSumOfOneGrades() {
		grades.add(mockGrade0);
		assertEquals(mockGrade0.getValue(), strategy.calculate(grades), DELTA);
	}

	@Test
	public void shouldCalculateSumOManyGrades() {
		grades.add(mockGrade0);
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		assertEquals(60, strategy.calculate(grades), DELTA);
	}
}

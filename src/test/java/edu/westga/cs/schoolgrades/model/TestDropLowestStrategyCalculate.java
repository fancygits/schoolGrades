package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private static final double DELTA = 0.001;
	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy mockStrategy;
	
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	private List<Grade> grades;
	private List<Grade> mockList;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.mockGrade0 = mock(Grade.class);
		when(this.mockGrade0.getValue()).thenReturn(10.0);
		this.mockGrade1 = mock(Grade.class);
		when(this.mockGrade1.getValue()).thenReturn(20.0);
		this.mockGrade2 = mock(Grade.class);
		when(this.mockGrade2.getValue()).thenReturn(30.0);
		
		this.grades = new ArrayList<Grade>();
		this.mockList = new ArrayList<Grade>();
		
		this.mockStrategy = mock(GradeCalculationStrategy.class); 
		this.dropLowestStrategy = new DropLowestStrategy(this.mockStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> { 
			this.dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		assertEquals(0, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		this.grades.add(this.mockGrade0);
		assertEquals(this.mockGrade0.getValue(), this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		this.grades.add(this.mockGrade0);
		this.grades.add(this.mockGrade1);
		this.grades.add(this.mockGrade2);
		this.mockList.add(this.mockGrade1);
		this.mockList.add(this.mockGrade2);
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.mockStrategy).calculate(this.mockList);
	}
	
	@Test
	public void canDropWhenLowestIsLast() {
		this.grades.add(this.mockGrade1);
		this.grades.add(this.mockGrade2);
		this.grades.add(this.mockGrade0);
		this.mockList.add(this.mockGrade1);
		this.mockList.add(this.mockGrade2);
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.mockStrategy).calculate(this.mockList);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		this.grades.add(this.mockGrade1);
		this.grades.add(this.mockGrade0);
		this.grades.add(this.mockGrade2);
		this.mockList.add(this.mockGrade1);
		this.mockList.add(this.mockGrade2);
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.mockStrategy).calculate(this.mockList);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		this.grades.add(this.mockGrade1);
		this.grades.add(this.mockGrade0);
		this.grades.add(this.mockGrade2);
		this.grades.add(this.mockGrade0);
		this.mockList.add(this.mockGrade1);
		this.mockList.add(this.mockGrade2);
		this.mockList.add(this.mockGrade0);
		this.dropLowestStrategy.calculate(this.grades);
		verify(this.mockStrategy).calculate(this.mockList);
	}
}

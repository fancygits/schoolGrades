package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestCompositeGradeGetValue {

	@Test
	void shouldGetValue() {
		Grade mockGrade0 = mock(Grade.class);
		when(mockGrade0.getValue()).thenReturn(10.0);
		Grade mockGrade1 = mock(Grade.class);
		when(mockGrade1.getValue()).thenReturn(20.0);
		Grade mockGrade2 = mock(Grade.class);
		when(mockGrade2.getValue()).thenReturn(30.0);
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(mockGrade0);
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		GradeCalculationStrategy mockStrategy = mock(GradeCalculationStrategy.class);
		when(mockStrategy.calculate(grades)).thenReturn(60.0);
		
		CompositeGrade composite = new CompositeGrade(mockStrategy);
		composite.add(mockGrade0);
		composite.add(mockGrade1);
		composite.add(mockGrade2);
		assertEquals(60, composite.getValue(), 0.01);
	}

}

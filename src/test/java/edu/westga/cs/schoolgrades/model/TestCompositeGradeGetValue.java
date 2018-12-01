package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class TestCompositeGradeGetValue {

	@Test
	void shouldGetValue() {
		CompositeGrade composite = new CompositeGrade(new SumOfGradesStrategy());
		Grade mockGrade0 = mock(Grade.class);
		when(mockGrade0.getValue()).thenReturn(10.0);
		Grade mockGrade1 = mock(Grade.class);
		when(mockGrade1.getValue()).thenReturn(20.0);
		Grade mockGrade2 = mock(Grade.class);
		when(mockGrade2.getValue()).thenReturn(30.0);
		composite.add(mockGrade0);
		composite.add(mockGrade1);
		composite.add(mockGrade2);
		assertEquals(60, composite.getValue(), 0.01);
	}

}

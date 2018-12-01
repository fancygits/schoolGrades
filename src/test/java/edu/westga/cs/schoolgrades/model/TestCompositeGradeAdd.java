package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCompositeGradeAdd {

	private CompositeGrade composite;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	@BeforeEach
	public void setup() {
		composite = new CompositeGrade(mock(GradeCalculationStrategy.class));
		mockGrade0 = mock(Grade.class);
		mockGrade1 = mock(Grade.class);
		mockGrade2 = mock(Grade.class);
	}
	
	@Test
	public void canAddOneGrade() {
		composite.add(mockGrade0);
		List<Grade> grades = composite.getGrades();
		assertEquals(1, grades.size());
		assertEquals(mockGrade0, grades.get(0));
	}

	@Test
	public void canAddManyGrades() {
		composite.add(mockGrade0);
		composite.add(mockGrade1);
		composite.add(mockGrade2);
		List<Grade> grades = composite.getGrades();
		assertEquals(3, grades.size());
		assertEquals(mockGrade0, grades.get(0));
		assertEquals(mockGrade1, grades.get(1));
		assertEquals(mockGrade2, grades.get(2));
	}
	
	@Test
	public void shouldNotAddSameGradeTwice() {
		composite.add(mockGrade0);
		
		assertThrows(IllegalArgumentException.class, () ->{ 
			composite.add(mockGrade0);
		});
	}
	
	@Test
	public void shouldNotAddNullGrade() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			composite.add(null);
		});
	}
}

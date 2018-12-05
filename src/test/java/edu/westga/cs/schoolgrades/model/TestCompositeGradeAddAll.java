package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCompositeGradeAddAll {

	private CompositeGrade composite;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	private List<Grade> list;
	
	@BeforeEach
	public void setup() {
		this.composite = new CompositeGrade(mock(GradeCalculationStrategy.class));
		this.mockGrade0 = mock(Grade.class);
		this.mockGrade1 = mock(Grade.class);
		this.mockGrade2 = mock(Grade.class);
		this.list = new ArrayList<Grade>();
	}

	@Test
	public void shouldNotAddNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> { 
			this.composite.addAll(null);
		});
	}
	
	@Test
	public void shouldAddEmptyList() {
		this.composite.addAll(new ArrayList<Grade>());
		assertTrue(this.composite.getGrades().isEmpty());
	}
	
	@Test
	public void shouldAddOneElementList() {
		this.list.add(this.mockGrade0);
		this.composite.addAll(this.list);
		List<Grade> actual = this.composite.getGrades();
		assertEquals(1, actual.size());
		assertEquals(this.mockGrade0, actual.get(0));
	}
	
	@Test
	public void shouldAddManyElementsList() {
		this.list.add(this.mockGrade0);
		this.list.add(this.mockGrade1);
		this.list.add(this.mockGrade2);
		this.composite.addAll(this.list);
		List<Grade> actual = this.composite.getGrades();
		assertEquals(3, actual.size());
		assertEquals(this.mockGrade0, actual.get(0));
		assertEquals(this.mockGrade1, actual.get(1));
		assertEquals(this.mockGrade2, actual.get(2));
	}

	@Test
	public void shouldNotAddListWithDuplicates() {
		this.list.add(this.mockGrade0);
		this.list.add(this.mockGrade1);
		this.list.add(this.mockGrade0);
		this.list.add(this.mockGrade2);
		
		assertThrows(IllegalArgumentException.class, () -> { 
			this.composite.addAll(this.list);
		});
	}
	
	@Test
	public void shouldNotAddListThatDuplicatesExistingGrades() {
		this.composite.add(this.mockGrade1);
		this.list.add(this.mockGrade1);
		this.list.add(this.mockGrade0);
		this.list.add(this.mockGrade2);
		
		assertThrows(IllegalArgumentException.class, () -> { 
			this.composite.addAll(this.list);
		});
	}
}

package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWeightedGradeGetValue {

	private static final double DELTA = 0.001;
	private WeightedGrade weightedGrade;
	private Grade mockGrade;
	
	@BeforeEach
	public void setup() {
		this.mockGrade = mock(Grade.class);
		when(this.mockGrade.getValue()).thenReturn(100.00);
	}
	
	@Test
	public void shouldApplyZeroWeight() {
		this.weightedGrade = new WeightedGrade(this.mockGrade, 0);
		assertEquals(0, this.weightedGrade.getValue(), DELTA);
	}
	
	@Test
	public void shouldApplyWeightOfOne() {
		this.weightedGrade = new WeightedGrade(this.mockGrade, 1);
		assertEquals(100, this.weightedGrade.getValue(), DELTA);
	}
	
	@Test
	public void shouldApplyWeightBetweenZeroAndOne() {
		this.weightedGrade = new WeightedGrade(this.mockGrade, 0.5);
		assertEquals(50, this.weightedGrade.getValue(), DELTA);
	}

}

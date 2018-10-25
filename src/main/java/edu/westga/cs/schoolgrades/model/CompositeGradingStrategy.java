package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Defines the CompositeGradingStrategy interface and classes
 * 
 * @author James Luke Johnson
 * @version 2018.10.24
 */
public interface CompositeGradingStrategy {
	
	public double calculateGrade(ArrayList<Grade> grades);
	
}




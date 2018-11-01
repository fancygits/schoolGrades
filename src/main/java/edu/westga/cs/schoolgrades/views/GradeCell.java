package edu.westga.cs.schoolgrades.views;

import edu.westga.cs.schoolgrades.model.Grade;
import javafx.scene.control.ListCell;

/**
 * Defines the GradeCell object to format the ListView objects
 * 
 * @author James Luke Johnson
 * @version 2018.10.31
 */
public class GradeCell extends ListCell<Grade> {

	@Override
	public void updateItem(Grade item, boolean empty) {
		super.updateItem(item, empty);
		
		String name = "";
		if (item != null || !empty) 	{
			name = item.getValue() + "";
		}
		this.setAccessibleText(name);
		this.setText(name);
	}
}

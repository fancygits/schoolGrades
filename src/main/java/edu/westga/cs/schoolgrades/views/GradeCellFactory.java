package edu.westga.cs.schoolgrades.views;

import edu.westga.cs.schoolgrades.model.Grade;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Defines the GradeCellFactory to add GradeCell objects to the ListView
 * 
 * @author James Luke Johnson
 * @version 2018.10.31
 */
public class GradeCellFactory implements Callback<ListView<Grade>, ListCell<Grade>> {

	@Override
	public ListCell<Grade> call(ListView<Grade> listview) {
		return new GradeCell();
	}
}

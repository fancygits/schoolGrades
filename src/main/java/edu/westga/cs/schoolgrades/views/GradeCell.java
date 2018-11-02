package edu.westga.cs.schoolgrades.views;

import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Defines the GradeCell object to format the ListView objects
 * 
 * @author James Luke Johnson
 * @version 2018.10.31
 */
public class GradeCell extends ListCell<Grade> {

	private final TextField textField = new TextField();
	
	/**
	 * Constructs a GradeCell, an editable TextField in the ListCell
	 */
	public GradeCell() {
        this.textField.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                this.cancelEdit();
            }
        });
        this.textField.setOnAction(e -> {
        	try {
        		((SimpleGrade) getItem()).setValue(Double.parseDouble(this.textField.getText()));
        		setText(this.textField.getText());
        		setContentDisplay(ContentDisplay.TEXT_ONLY);
        	} catch (NumberFormatException nfe) {
        		this.cancelEdit();
        	}
        });
        setGraphic(this.textField);
    }
	
	@Override
    protected void updateItem(Grade grade, boolean empty) {
        super.updateItem(grade, empty);
        if (empty || grade == null) {
            setText(null);
        } else {
            setText(grade.getValue() + "");
        }
        if (isEditing()) {
            this.textField.setText(grade.getValue() + "");
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        } else {
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        this.textField.setText(getItem().getValue() + "");
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        this.textField.requestFocus();
        this.textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem().getValue() + "");
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }
}

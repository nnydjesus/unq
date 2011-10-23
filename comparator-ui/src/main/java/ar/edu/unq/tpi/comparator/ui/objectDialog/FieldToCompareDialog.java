package ar.edu.unq.tpi.comparator.ui.objectDialog;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Color;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import ar.edu.unq.tpi.comparator.ui.utils.FakeFalseObservable;
import ar.unq.tpi.comparatorObject.comparator.FieldToCompare;

public class FieldToCompareDialog extends AbstractFieldObjectDialog<FieldToCompare> {
	private static final long serialVersionUID = 1L;

	public FieldToCompareDialog(WindowOwner parent, FieldToCompare model) {
		super(parent, model);
	}


	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Field Name");
		TextBox fieldTextBox = new TextBox(form);
		fieldTextBox.setForeground(Color.BLUE);
		fieldTextBox.bindEnabled(new FakeFalseObservable("fieldName"));
		fieldTextBox.bindValueToProperty("fieldName");

		new Label(form).setText("Object 1 value");
		TextBox value1TextBox = new TextBox(form);
		value1TextBox.setForeground(Color.BLUE);
		value1TextBox.bindEnabled(new FakeFalseObservable("valueObject1"));
		value1TextBox.bindValueToProperty("valueObject1");
		
		new Label(form).setText("Object 2 value");
		TextBox value2TextBox = new TextBox(form);
		value2TextBox.setForeground(Color.BLUE);
		value2TextBox.bindEnabled(new FakeFalseObservable("valueObject2"));
		value2TextBox.bindValueToProperty("valueObject2");
	}
	
}

package ar.edu.unq.tpi.comparator.ui.objectDialog;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Color;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import ar.edu.unq.tpi.comparator.ui.utils.FakeFalseObservable;
import ar.unq.tpi.comparatorObject.comparator.FieldToObject;

public class FieldToObjectDialog extends AbstractFieldObjectDialog<FieldToObject> {

	private static final long serialVersionUID = 1L;

	public FieldToObjectDialog(WindowOwner parent, FieldToObject model) {
		super(parent, model);
	}


	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Field Name");
		
		TextBox fieldTextBox = new TextBox(form);
		fieldTextBox.bindEnabled(new FakeFalseObservable("fieldName"));
		fieldTextBox.setForeground(Color.BLUE);
		fieldTextBox.bindValueToProperty("fieldName");

		new Label(form).setText("Value");
		
		TextBox value2TextBox = new TextBox(form);
		value2TextBox.bindEnabled(new FakeFalseObservable("objectToString"));
		value2TextBox.setForeground(Color.BLUE);
		value2TextBox.bindValueToProperty("objectToString");

	}

}

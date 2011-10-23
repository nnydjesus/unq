package ar.edu.unq.tpi.comparator.ui.objectDialog;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.ObservableObject;

import ar.edu.unq.tpi.comparator.ui.utils.FakeFalseObservable;
import ar.unq.tpi.comparatorObject.comparator.FieldToCompare;

public abstract class AbstractFieldObjectDialog<T extends ObservableObject> extends SimpleWindow<T> {
	private static final long serialVersionUID = 1L;

	public AbstractFieldObjectDialog(WindowOwner parent, T model) {
		super(parent, model);
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("OK").onClick(new MessageSend(this, "close"));
	}

}

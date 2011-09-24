package arena.modificado;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.ObservableObject;

public abstract class MyDialog<T extends ObservableObject>  extends Dialog<T> {
	private static final long serialVersionUID = 1L;

	public MyDialog(WindowOwner owner, T model) {
		super(owner, model);
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		super.addActions(actionsPanel);
	}


}

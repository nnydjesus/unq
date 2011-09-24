package videoclub;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.model.SearchByExample;

import tadp.blocbaster.entidades.Socio;

public abstract class VentanaDeBusqueda extends SimpleWindow<Search<Socio>> {
	private static final long serialVersionUID = 1L;

	public VentanaDeBusqueda(WindowOwner owner) {
		super(owner, new SearchByExample<Socio>(MyVideoclub.getInstance().getHome(Socio.class)));
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		super.createMainTemplate(mainPanel);
		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);
	}

	// ***********************************************************
	// ** Grid
	// ***********************************************************

	protected void createResultsGrid(Panel mainPanel) {
		Table<Socio> table = new Table<Socio>(mainPanel, this.getModel().getEntityType());

		table.bindContentsToProperty(Search.RESULTS);
		table.bindSelection(Search.SELECTED);

		this.describeResultsGrid(table);
	}

	protected abstract void describeResultsGrid(Table<Socio> builder);

	// ***********************************************************
	// ** Actions
	// ***********************************************************

	@Override
	protected void addActions(Panel actionsPanel) {
		Button buscar = new Button(actionsPanel);
		buscar.setCaption("Buscar");
		buscar.onClick(new MessageSend(this.getModel(), Search.SEARCH));
		buscar.setAsDefault();

		// TODO Ver si agregamos la acción de limpiar:
		// new Button(actions).setCaption("Limpiar").onClick(new MessageSend(this.getModel(), "clear"));
	}

	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setHorizontalLayout();

		NotNullObservable elementSelected = new NotNullObservable(Search.SELECTED);

		Button edit = new Button(actionsPanel);
		edit.setCaption("Edit");
		edit.bindEnabled(elementSelected);
		edit.onClick(new MessageSend(this, "startEdition"));

		Button remove = new Button(actionsPanel);
		remove.setCaption("Remove");
		remove.bindEnabled(new NotNullObservable(Search.SELECTED));
		remove.onClick(new MessageSend(this.getModel(), "removeSelected"));
	}

	// ********************************************************
	// ** Actions
	// ********************************************************

	public void startEdition() {
		Dialog<?> editor = this.createEditor(this.getModel().getSelected());
		editor.onAccept(new MessageSend(this.getModel(), Search.SEARCH));
		editor.open();
	}

	protected abstract Dialog<?> createEditor(Socio selected);

}

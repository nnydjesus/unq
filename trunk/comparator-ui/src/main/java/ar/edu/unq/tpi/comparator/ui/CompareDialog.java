package ar.edu.unq.tpi.comparator.ui;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;

import ar.edu.unq.tpi.comparator.ui.controler.ComparatorControler;
import ar.edu.unq.tpi.comparator.ui.objectDialog.ComparatorObjectDialog;
import ar.edu.unq.tpi.comparator.ui.objectDialog.FieldToCompareDialog;
import ar.edu.unq.tpi.comparator.ui.objectDialog.FieldToObjectDialog;
import ar.unq.tpi.comparatorObject.comparator.FieldComparator;
import ar.unq.tpi.comparatorObject.comparator.FieldComparatorObject;
import ar.unq.tpi.comparatorObject.comparator.FieldToCompare;
import ar.unq.tpi.comparatorObject.comparator.FieldToObject;

import com.uqbar.commons.ReflectionUtils;
import com.uqbar.commons.collections.Transformer;

public class CompareDialog extends SimpleWindow<ComparatorControler> {

	private static final long serialVersionUID = 1L;
	private String bindProperty;

	public CompareDialog(WindowOwner parent, ComparatorControler model,
			String bindProperty) {
		super(parent, model);
		this.bindProperty = bindProperty;
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		super.createMainTemplate(mainPanel);
		this.setTitle("Vista de un Field To Object");
		this.setTaskDescription("Vista de un Field To Object.");
		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);
	}

	protected void createResultsGrid(Panel mainPanel) {
		Table<FieldComparator> table = new Table<FieldComparator>(mainPanel,
				FieldComparator.class);

		table.bindContentsToProperty(bindProperty);
		table.bindSelection(Search.SELECTED);

		this.describeResultsGrid(table);
	}

	protected void describeResultsGrid(Table<FieldComparator> table) {
		Column<FieldComparator> fieldColumn = new Column<FieldComparator>(table);
		fieldColumn.setTitle("Field");
		fieldColumn.setFixedSize(200);
		fieldColumn
				.bindContentsToTransformer(new Transformer<FieldComparator, String>() {
					@Override
					public String transform(FieldComparator fieldToCompare) {
						return fieldToCompare.getField().getName();
					}
				});
		
		Column<FieldComparator> valueObj1Column = new Column<FieldComparator>(table);
		valueObj1Column.setTitle("Value Object 1");
		valueObj1Column.setFixedSize(500);
		valueObj1Column
		.bindContentsToTransformer(new Transformer<FieldComparator, String>() {
			@Override
			public String transform(FieldComparator fieldToCompare) {
				return fieldToCompare.showValue();
			}
		});

	}

	// ***********************************************************
	// ** Actions
	// ***********************************************************

	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setHorizontalLayout();

		NotNullObservable elementSelected = new NotNullObservable(Search.SELECTED);

		Button buscar = new Button(actionsPanel);
		buscar.setCaption("Details");
		buscar.bindEnabled(elementSelected);
		buscar.onClick(new MessageSend(this, "vewDetails"));
		buscar.setAsDefault();
		
		new Button(actionsPanel).setCaption("Back").onClick(new MessageSend(this, "close"));

	}

	public void vewDetails() {
		ReflectionUtils.invokeMethod(this, "createCompareDialog", new Object[] {getModel().getSelected()});
	}
	
	
	public void createCompareDialog(FieldToObject fieldComparatorObject){
		new FieldToObjectDialog(this, (fieldComparatorObject)).open();
	}
	
	public void createCompareDialog(FieldComparatorObject fieldComparatorObject){
		new ComparatorObjectDialog(this, new ComparatorControler(fieldComparatorObject.getComparatorObject())).open();
	}
	
	public void createCompareDialog(FieldToCompare fieldComparatorObject){
		new FieldToCompareDialog(this, fieldComparatorObject).open();
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
	}

}

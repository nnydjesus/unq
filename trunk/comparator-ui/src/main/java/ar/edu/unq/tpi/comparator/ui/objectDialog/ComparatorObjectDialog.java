package ar.edu.unq.tpi.comparator.ui.objectDialog;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Color;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import ar.edu.unq.tpi.comparator.ui.CompareDialog;
import ar.edu.unq.tpi.comparator.ui.controler.ComparatorControler;
import ar.unq.tpi.comparatorObject.managers.ToStringManager;

public class ComparatorObjectDialog extends AbstractFieldObjectDialog<ComparatorControler> {
	private static final long serialVersionUID = 1L;

	public ComparatorObjectDialog(WindowOwner parent, ComparatorControler model) {
		super(parent, model);
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		super.createMainTemplate(mainPanel);
		this.setTitle("Comparacion de Objetos");
		this.setTaskDescription("Vea los detalles");
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		Button commonsFieldEqualsButton = new Button(actionsPanel);
		commonsFieldEqualsButton.setCaption("fields igual valor");
		commonsFieldEqualsButton.onClick(new MessageSend(this, "viewCommonsFieldEquals"));

		Button commonsFieldNotEqualsButton = new Button(actionsPanel);
		commonsFieldNotEqualsButton.setCaption("fields de distinto valor");
		commonsFieldNotEqualsButton.onClick(new MessageSend(this, "viewCommonsFieldNotEquals"));

		Button fieldObj1Button = new Button(actionsPanel);
		fieldObj1Button.setCaption("fields solo del objeto 1");
		fieldObj1Button.onClick(new MessageSend(this, "viewFieldObj1"));
		
		Button fieldObj2Button = new Button(actionsPanel);
		fieldObj2Button.setCaption("fields solo del objeto 2");
		fieldObj2Button.onClick(new MessageSend(this, "viewFieldObj2"));
	}
	
	public void viewCommonsFieldEquals(){
		new CompareDialog(this, this.getModel(), ComparatorControler.FIELDS_EQUALS_VALUE).open();
	}

	public void viewCommonsFieldNotEquals(){
		new CompareDialog(this, this.getModel(), ComparatorControler.FIELDS_NOT_EQUALS_VALUE).open();
	}
	
	public void viewFieldObj1(){
		new CompareDialog(this, this.getModel(), ComparatorControler.FIELDS_OBJECT1).open();
	}
	
	public void viewFieldObj2(){
		new CompareDialog(this, this.getModel(), ComparatorControler.FIELDS_OBJECT2).open();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel panel = new Panel(mainPanel);
		panel.setLayout(new ColumnLayout(4));
		
		Object obj1 = this.getModel().getComparatorObject().getObject1();
		Object obj2 = this.getModel().getComparatorObject().getObject2();
		String clasObject1 = null;
		String clasObject2 = null;
		
		if(obj1 != null){
			clasObject1 = obj1.getClass().getSimpleName(); 
		}
		
		if(obj2 != null){
			clasObject2 = obj2.getClass().getSimpleName();
		}
		
		new Label(panel).setText("Comparando un Objeto de Clase: ");
		new Label(panel).setText(ToStringManager.toStringObject(clasObject1)).setForeground(Color.BLUE);
		new Label(panel).setText(" con otro de clase: ");
		new Label(panel).setText(ToStringManager.toStringObject(clasObject2)).setForeground(Color.BLUE);
	}

}

package ar.edu.unq.tpi.comparator.ui;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import ar.edu.unq.tpi.comparator.ui.controler.ComparatorControler;
import ar.edu.unq.tpi.comparator.ui.objectDialog.ComparatorObjectDialog;
import ar.unq.tpi.comparatorObject.comparator.ComparatorObject;
import ar.unq.tpi.comparatorObject.comparator.domain.test.Employee;
import ar.unq.tpi.comparatorObject.comparator.domain.test.Person;
import ar.unq.tpi.comparatorObject.comparator.domain.test.State;
import ar.unq.tpi.comparatorObject.comparator.domain.test.Work;
import ar.unq.tpi.comparatorObject.managers.ComparationManager;

/**
 */
public class ComparatorApplication extends Application {
	
	public static void main(String[] args) {
		new ComparatorApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		Person persona1 = new Person("nombre", 122, null, State.GRANDFATHER);
		Employee persona2 = new Employee("nombre", 10, persona1, State.BOY, new Work("Pepito"));
//		Object persona2 = new Object();
		ComparationManager comparationManager = new ComparationManager();
		ComparatorObject compareTo = comparationManager.compareTo(persona1, persona2);
		
		
		return new ComparatorObjectDialog(this, new ComparatorControler(compareTo));
	}
}

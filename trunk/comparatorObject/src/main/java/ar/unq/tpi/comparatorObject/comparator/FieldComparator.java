package ar.unq.tpi.comparatorObject.comparator;

import java.lang.reflect.Field;

import org.uqbar.commons.model.ObservableObject;

/**
 * 
 * @author nny
 */
public abstract class FieldComparator extends ObservableObject {
	private Field field;

	public FieldComparator(Field field) {
		this.field = field;
	}
	
	public abstract String showValue();

	public void setField(Field field) {
		this.field = field;
	}

	public Field getField() {
		return field;
	}
	
	public String getFieldName() {
		return getField().getName();
	}

}

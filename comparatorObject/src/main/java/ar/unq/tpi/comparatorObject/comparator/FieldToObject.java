package ar.unq.tpi.comparatorObject.comparator;

import java.lang.reflect.Field;

import org.uqbar.commons.utils.ReflectionUtils;

import ar.unq.tpi.comparatorObject.managers.ToStringManager;

/**
 * 
 * @author nny
 */
public class FieldToObject extends FieldComparator {
	public static final String FIELD = "field";
	public static final String OBJECT = "object";
	
	private Object object;
	
	public FieldToObject(Field field, Object object) {
		super(field);
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	public String getObjectToString() {
		return showValue();
	}


	public String showValue() {
		return ToStringManager.toStringObject(ReflectionUtils.readField(object, getField()));
	}
	
	@Override
	public String toString() {
		return ToStringManager.toStringObject(object) + "." +getField().getName() +
		" = " + 
		showValue();
	}
	
}
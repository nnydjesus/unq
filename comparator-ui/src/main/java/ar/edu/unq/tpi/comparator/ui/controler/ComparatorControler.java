package ar.edu.unq.tpi.comparator.ui.controler;

import java.util.List;

import org.uqbar.commons.model.ObservableObject;

import ar.unq.tpi.comparatorObject.comparator.ComparatorObject;
import ar.unq.tpi.comparatorObject.comparator.FieldToObject;
import ar.unq.tpi.comparatorObject.comparator.FieldComparator;


public class ComparatorControler extends ObservableObject{
	
	public static final String FIELDS_EQUALS_VALUE = "fieldsEqualsValue";
	public static final String FIELDS_NOT_EQUALS_VALUE = "fieldsNotEqualsValue";
	public static final String FIELDS_OBJECT1 = "fieldsObject1";
	public static final String FIELDS_OBJECT2 = "fieldsObject2";
	
	private FieldComparator selected;
	private final ComparatorObject comparatorObject;
	
	public ComparatorControler(ComparatorObject comparatorObject) {
		this.comparatorObject = comparatorObject;
	}

	public List<FieldComparator> getFieldsEqualsValue() {
		return comparatorObject.getFieldsEquals();
	}
	
	public List<FieldComparator> getFieldsNotEqualsValue() {
		return comparatorObject.getFieldsNotEquals();
	}
	
	public List<FieldToObject> getFieldsObject1() {
		return comparatorObject.getFieldsObj1();
	}
	
	public List<FieldToObject> getFieldsObject2() {
		return comparatorObject.getFieldsObj2();
	}
	
	public void setSelected(FieldComparator selected) {
		this.setFieldValue("selected", selected);
	}

	public FieldComparator getSelected() {
		return selected;
	}

	public ComparatorObject getComparatorObject() {
		return comparatorObject;
	}
	
}

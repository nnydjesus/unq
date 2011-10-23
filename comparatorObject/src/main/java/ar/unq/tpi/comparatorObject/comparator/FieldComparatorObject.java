package ar.unq.tpi.comparatorObject.comparator;

import java.lang.reflect.Field;

public class FieldComparatorObject extends FieldComparator{
	
	private ComparatorObject comparatorObject;
	
	
	public FieldComparatorObject(Field field, ComparatorObject comparatorObject) {
		super(field);
		this.comparatorObject = comparatorObject;
	}




	public ComparatorObject getComparatorObject() {
		return comparatorObject;
	}


	public void setComparatorObject(ComparatorObject comparatorObject) {
		this.comparatorObject = comparatorObject;
	}


	public String showValue() {
		return getField().getName();
	}
	
	@Override
	public String toString() {
		return this.showValue();
	}

}

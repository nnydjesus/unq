package ar.unq.tpi.comparatorObject.comparator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.Entity;

public class ComparatorObject extends Entity {
	private static final long serialVersionUID = 1L;
	
	private List<FieldComparator> fieldsEquals = new ArrayList<FieldComparator>(); // fields de los objetos que tienen el mismo valor
	private List<FieldComparator> fieldsNotEquals = new ArrayList<FieldComparator>(); // fields de los objetos que tienen distinto valor
	private List<FieldToObject> fieldsExclusiveToObject1 = new ArrayList<FieldToObject>(); //fields que estan el el objeto 1 y no el el 2
	private List<FieldToObject> fieldsExclusiveToObject2 = new ArrayList<FieldToObject>(); //fields que estan en el objeto 2 y no en el 1
	
	private Object object1;
	private Object object2;
	
	
	public ComparatorObject(Object obj1, Object obj2) {
		super();
		this.object1 = obj1;
		this.object2 = obj2;
	}
	
	public void addFieldsEquals(FieldComparator comparator){
		fieldsEquals.add(comparator);
	}
	public void addFieldsNotEquals(FieldComparator comparator){
		fieldsNotEquals.add(comparator);
	}
	public void addFieldsObj1(FieldToObject comparator){
		fieldsExclusiveToObject1.add(comparator);
	}
	public void addFieldsObj2(FieldToObject comparator){
		fieldsExclusiveToObject2.add(comparator);
	}
	//All
	public void addAllFieldsEquals(List<FieldComparator> comparators){
		fieldsEquals.addAll(comparators);
	}
	public void addAllFieldsNotEquals(List<FieldComparator> comparators){
		fieldsNotEquals.addAll(comparators);
	}
	public void addAllFieldsObj1(List<FieldToObject> comparators){
		fieldsExclusiveToObject1.addAll(comparators);
	}
	public void addAllFieldsObj2(List<FieldToObject> comparators){
		fieldsExclusiveToObject2.addAll(comparators);
	}

	public List<FieldComparator> getFieldsEquals() {
		return fieldsEquals;
	}

	public void setFieldsEquals(List<FieldComparator> fieldsEquals) {
		this.fieldsEquals = fieldsEquals;
	}

	public List<FieldComparator> getFieldsNotEquals() {
		return fieldsNotEquals;
	}

	public void setFieldsNotEquals(List<FieldComparator> fieldsNotEquals) {
		this.fieldsNotEquals = fieldsNotEquals;
	}

	public List<FieldToObject> getFieldsExclusiveToObject1() {
		return fieldsExclusiveToObject1;
	}

	public void setFieldsExclusiveToObject1(List<FieldToObject> fieldsObj1) {
		this.fieldsExclusiveToObject1 = fieldsObj1;
	}

	public List<FieldToObject> getFieldsExclusiveToObject2() {
		return fieldsExclusiveToObject2;
	}

	public void setFieldObj2(List<FieldToObject> fieldObj2) {
		this.fieldsExclusiveToObject2 = fieldObj2;
	}

	public Object getObject1() {
		return object1;
	}

	public void setObject1(Object obj1) {
		this.object1 = obj1;
	}

	public Object getObject2() {
		return object2;
	}

	public void setObject2(Object obj2) {
		this.object2 = obj2;
	}

	public void addCommonField(Field field, Object obj1, Object obj2, boolean equalValue) {
		addCommonField(new FieldToCompare(field, obj1, obj2), equalValue);
	}

	public void addCommonField(FieldComparator fieldComparator, boolean equalValue) {
		if (equalValue) {
			this.addFieldsEquals(fieldComparator);
		}
		else {
			this.addFieldsNotEquals(fieldComparator);
		}
	}
	
}

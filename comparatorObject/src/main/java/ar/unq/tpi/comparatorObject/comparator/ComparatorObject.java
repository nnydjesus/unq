package ar.unq.tpi.comparatorObject.comparator;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.ObservableObject;

public class ComparatorObject extends Entity {
	private static final long serialVersionUID = 1L;
	
	private List<FieldComparator> fieldsEquals = new ArrayList<FieldComparator>(); // fields de los objetos que tienen el mismo valor
	private List<FieldComparator> fieldsNotEquals = new ArrayList<FieldComparator>(); // fields de los objetos que tienen distinto valor
	private List<FieldToObject> fieldsObj1 = new ArrayList<FieldToObject>(); //fields que estan el el objeto 1 y no el el 2
	private List<FieldToObject> fieldsObj2 = new ArrayList<FieldToObject>(); //fields que estan en el objeto 2 y no en el 1
	
	private Object obj1;
	private Object obj2;
	
	
	public ComparatorObject(Object obj1, Object obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public void addFieldsEquals(FieldComparator comparator){
		fieldsEquals.add(comparator);
	}
	public void addFieldsNotEquals(FieldComparator comparator){
		fieldsNotEquals.add(comparator);
	}
	public void addFieldsObj1(FieldToObject comparator){
		fieldsObj1.add(comparator);
	}
	public void addFieldsObj2(FieldToObject comparator){
		fieldsObj2.add(comparator);
	}
	//All
	public void addAllFieldsEquals(List<FieldComparator> comparators){
		fieldsEquals.addAll(comparators);
	}
	public void addAllFieldsNotEquals(List<FieldComparator> comparators){
		fieldsNotEquals.addAll(comparators);
	}
	public void addAllFieldsObj1(List<FieldToObject> comparators){
		fieldsObj1.addAll(comparators);
	}
	public void addAllFieldsObj2(List<FieldToObject> comparators){
		fieldsObj2.addAll(comparators);
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

	public List<FieldToObject> getFieldsObj1() {
		return fieldsObj1;
	}

	public void setFieldsObj1(List<FieldToObject> fieldsObj1) {
		this.fieldsObj1 = fieldsObj1;
	}

	public List<FieldToObject> getFieldsObj2() {
		return fieldsObj2;
	}

	public void setFieldObj2(List<FieldToObject> fieldObj2) {
		this.fieldsObj2 = fieldObj2;
	}

	public Object getObj1() {
		return obj1;
	}

	public void setObj1(Object obj1) {
		this.obj1 = obj1;
	}

	public Object getObj2() {
		return obj2;
	}

	public void setObj2(Object obj2) {
		this.obj2 = obj2;
	}
	
}

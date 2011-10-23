package ar.unq.tpi.comparatorObject.comparator;

import java.lang.reflect.Field;

import org.uqbar.commons.utils.ReflectionUtils;

import ar.unq.tpi.comparatorObject.managers.ToStringManager;

public class FieldToCompare extends FieldComparator {
	
	private Object obj1;
	private Object obj2;

	public FieldToCompare(Field field, Object obj1, Object obj2) {
		super(field);
		this.obj1 = obj1;
		this.obj2 = obj2;
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

	public String showValue() {
		return ToStringManager.toStringObject(obj1) + "." +getField().getName() +
		" = " + 
		ToStringManager.toStringObject(ReflectionUtils.readField(obj1, getField())) + "\n"+
		
		ToStringManager.toStringObject(obj2) + "." +getField().getName() +
		" = " + 
		ToStringManager.toStringObject(ReflectionUtils.readField(obj2, getField()));
	}
	
	public String getValueObject1(){
		return ToStringManager.toStringObject(ReflectionUtils.readField(obj1, getField()));
	}
	
	public String getValueObject2(){
		return ToStringManager.toStringObject(ReflectionUtils.readField(obj2, getField()));
	}
	
	@Override
	public String toString() {
		return this.showValue();
	}
}

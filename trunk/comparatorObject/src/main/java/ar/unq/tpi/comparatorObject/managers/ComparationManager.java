package ar.unq.tpi.comparatorObject.managers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections15.ListUtils;
import org.uqbar.commons.utils.ReflectionUtils;

import ar.unq.tpi.comparatorObject.comparator.ComparatorObject;
import ar.unq.tpi.comparatorObject.comparator.FieldComparatorObject;
import ar.unq.tpi.comparatorObject.comparator.FieldToCompare;
import ar.unq.tpi.comparatorObject.comparator.FieldToObject;
import ar.unq.tpi.comparatorObject.predicate.ComparataroFieldPredicate;

public class ComparationManager {
	
	public ComparatorObject compareTo(Object obj1, Object obj2) {
//        if(canMach(obj1, obj2)){
        	ComparatorObject comparatorObject = new ComparatorObject(obj1, obj2);
        	ComparataroFieldPredicate comparataroFieldPredicate = new ComparataroFieldPredicate();
        	
        	List<Field> fieldsObj1 = ReflectionUtils.getAllFieldToPredicate(obj1, comparataroFieldPredicate);
        	List<Field> fieldsObj2 = ReflectionUtils.getAllFieldToPredicate(obj2, comparataroFieldPredicate);

        	List<Field> commonsFields = ListUtils.intersection(fieldsObj1, fieldsObj2);
        	List<Field> differentFieldsObj1 = ListUtils.subtract(fieldsObj1, fieldsObj2);
        	List<Field> differentFieldsObj2 = ListUtils.subtract(fieldsObj2, fieldsObj1);
        	
        	processCommonsField(commonsFields, obj1, obj2, comparatorObject);
        	comparatorObject.addAllFieldsObj1(getFieldsToObject(differentFieldsObj1, obj1));
        	comparatorObject.addAllFieldsObj2(getFieldsToObject(differentFieldsObj2, obj2));
        	return comparatorObject;
//        }
//        return null;
	}
	
	private List<FieldToObject> getFieldsToObject(
			List<Field> differentFieldsObj2, Object object) {
		List<FieldToObject> fieldToObjects = new ArrayList<FieldToObject>();
		for (Field field : differentFieldsObj2) {
			fieldToObjects.add(new FieldToObject(field, object));
		}
		return fieldToObjects;
	}

	protected void processCommonsField(List<Field> commonsFields, Object obj1, Object obj2, ComparatorObject comparatorObject){
		for (Field field : commonsFields) {
			if(ReflectionUtils.isBasicType(field.getType())){
				if(EqualsManager.equalsValueField(field, obj1, obj2)){
					comparatorObject.addFieldsEquals(new FieldToCompare(field, obj1, obj2));
				}else{
					comparatorObject.addFieldsNotEquals(new FieldToCompare(field, obj1, obj2));
				}
			}else{
				Object fieldValueObj1 = getFieldValue(field, obj1);
				Object fieldValueObj2 = getFieldValue(field, obj2);
				if(EqualsManager.equalsObjects(fieldValueObj1, fieldValueObj2)){
					comparatorObject.addFieldsEquals(new FieldToCompare(field, obj1, obj2));
				}else{
					comparatorObject.addFieldsNotEquals(new FieldComparatorObject(field, this.compareTo(fieldValueObj1, fieldValueObj2)));
				}
			}
		}
	}
	
	private Boolean canMach(Object object1, Object object2) {
		if (object1 == object2) {
            return true;
        }
        if (object1 == null || object2 == null) {
            return false;
        }
		
        Class lhsClass = object1.getClass();
        Class rhsClass = object2.getClass();
        if (lhsClass.isInstance(object2)) {
        	return true;
        } else if (rhsClass.isInstance(object1)) {
        	return true;
        } else {
            return false;
        }
	}
	
	//Helpers
	
	private Object getFieldValue(Field field, Object obj1) {
		return ReflectionUtils.readField(obj1, field);
	}

}

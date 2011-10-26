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
    	ComparatorObject comparatorObject = new ComparatorObject(obj1, obj2);
    	ComparataroFieldPredicate comparataroFieldPredicate = new ComparataroFieldPredicate();
    	
    	List<Field> fieldsObject1 = ReflectionUtils.getAllFieldToPredicate(obj1, comparataroFieldPredicate);
    	List<Field> fieldsObject2 = ReflectionUtils.getAllFieldToPredicate(obj2, comparataroFieldPredicate);

    	List<Field> commonsFields = ListUtils.intersection(fieldsObject1, fieldsObject2);
    	processCommonsField(commonsFields, obj1, obj2, comparatorObject);
    	
    	List<Field> differentFieldsObj1 = ListUtils.subtract(fieldsObject1, fieldsObject2);
    	List<Field> differentFieldsObj2 = ListUtils.subtract(fieldsObject2, fieldsObject1);
    	
    	comparatorObject.addAllFieldsObj1(getFieldsToObject(differentFieldsObj1, obj1));
    	comparatorObject.addAllFieldsObj2(getFieldsToObject(differentFieldsObj2, obj2));
    	return comparatorObject;
	}
	
	private List<FieldToObject> getFieldsToObject(List<Field> differentFieldsObj2, Object object) {
		List<FieldToObject> fieldToObjects = new ArrayList<FieldToObject>();
		for (Field field : differentFieldsObj2) {
			fieldToObjects.add(new FieldToObject(field, object));
		}
		return fieldToObjects;
	}

	protected void processCommonsField(List<Field> commonFields, Object obj1, Object obj2, ComparatorObject comparatorObject){
		for (Field field : commonFields) {
			Object fieldValueObj1 = ReflectionUtils.readField(obj1, field);
			Object fieldValueObj2 = ReflectionUtils.readField(obj2, field);
			
			if (ReflectionUtils.isBasicType(field.getType())) {
				comparatorObject.addCommonField(field, obj1, obj2, EqualsManager.equalsValueField(fieldValueObj1, fieldValueObj2));
			}
			else {
				if (EqualsManager.equalsObjects(fieldValueObj1, fieldValueObj2)) {
					comparatorObject.addCommonField(new FieldToCompare(field, obj1, obj2), true);
				} 
				else {
					comparatorObject.addCommonField(new FieldComparatorObject(field, this.compareTo(fieldValueObj1, fieldValueObj2)), false);
				}
			}
		}
	}
	
	//Helpers


}

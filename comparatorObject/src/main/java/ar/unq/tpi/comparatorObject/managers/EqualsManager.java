package ar.unq.tpi.comparatorObject.managers;

import java.lang.reflect.Field;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.uqbar.commons.utils.ReflectionUtils;

public class EqualsManager {
	
	public static Boolean equalsObjects(Object obj1, Object obj2){
		return EqualsBuilder.reflectionEquals(obj1, obj2);
	}
	

	public static boolean equalsValueField(Field field, Object obj1, Object obj2) {
		Object fieldValueObj1 = ReflectionUtils.readField(obj1, field);
		Object fieldValueObj2 = ReflectionUtils.readField(obj2, field);
		return new EqualsBuilder().append(fieldValueObj1, fieldValueObj2).isEquals();
	}

}

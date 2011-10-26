package ar.unq.tpi.comparatorObject.managers;

import org.apache.commons.lang.builder.EqualsBuilder;

public class EqualsManager {
	
	public static Boolean equalsObjects(Object obj1, Object obj2){
		return EqualsBuilder.reflectionEquals(obj1, obj2);
	}

	public static boolean equalsValueField(Object fieldValueObj1, Object fieldValueObj2) {
		return new EqualsBuilder().append(fieldValueObj1, fieldValueObj2).isEquals();
	}

}

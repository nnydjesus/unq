package ar.unq.tpi.comparatorObject.managers;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.uqbar.commons.utils.ReflectionUtils;

public class ToStringManager {
	
	public static String toStringObject(Object object) {
		if(object != null && ReflectionUtils.isBasicType(object.getClass())){
			return object.toString();
		}else{
			return ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE).toString();
		}
	}

}

package ar.unq.tpi.comparatorObject.predicate;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.commons.collections15.Predicate;
import org.apache.commons.lang.builder.EqualsBuilder;


public class ComparataroFieldPredicate implements Predicate<Field>{
	
	public boolean evaluate(Field field) {
		int modifiers = field.getModifiers();
		return !(Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)); 
	}


}

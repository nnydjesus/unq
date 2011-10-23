package ar.unq.tpi.comparatorObject.comparator;

import junit.framework.Assert;

import org.junit.Test;

import ar.unq.tpi.comparatorObject.comparator.domain.test.Employee;
import ar.unq.tpi.comparatorObject.comparator.domain.test.Person;
import ar.unq.tpi.comparatorObject.comparator.domain.test.State;
import ar.unq.tpi.comparatorObject.comparator.domain.test.Work;
import ar.unq.tpi.comparatorObject.managers.ComparationManager;


public class ComparatorObjectTest {
	
	
	@Test
	public void compareToEquals(){
		Object object1 = createFakeObject();
		Object object2 = createFakeObject();
		
		ComparatorObject compareTo = new ComparationManager().compareTo(object1, object2);
		
		Assert.assertEquals(object1, compareTo.getObj1());
		Assert.assertEquals(object2, compareTo.getObj2());
		
		Assert.assertTrue(compareTo.getFieldsObj1().isEmpty());
		Assert.assertTrue(compareTo.getFieldsObj2().isEmpty());

		Assert.assertTrue(compareTo.getFieldsNotEquals().isEmpty());
		Assert.assertEquals(4, compareTo.getFieldsEquals().size());
		
	}
	
	@Test
	public void compareToFail(){
		Object object1 = createFakeObject();
		Object object2 = createFakeObject2();
		
		ComparatorObject compareTo = new ComparationManager().compareTo(object1, object2);
		
		Assert.assertEquals(object1, compareTo.getObj1());
		Assert.assertEquals(object2, compareTo.getObj2());
		
		Assert.assertTrue(compareTo.getFieldsObj1().isEmpty());
		
		Assert.assertEquals(1, compareTo.getFieldsObj2().size());
		Assert.assertEquals(3, compareTo.getFieldsNotEquals().size());
		Assert.assertEquals(1, compareTo.getFieldsEquals().size());
		
	}
	
	

	protected Object createFakeObject() {
		return new Person("nombre", 15, null, State.BOY);
	}
	
	protected Object createFakeObject2() {
		return new Employee("nombre2", 55, null, State.GRANDFATHER, new Work("UNQ"));
	}

}

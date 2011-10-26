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
		Object object1 = createPerson();
		Object object2 = createPerson();
		
		ComparatorObject compareTo = new ComparationManager().compareTo(object1, object2);
		
		Assert.assertEquals(object1, compareTo.getObject1());
		Assert.assertEquals(object2, compareTo.getObject2());
		
		Assert.assertTrue(compareTo.getFieldsExclusiveToObject1().isEmpty());
		Assert.assertTrue(compareTo.getFieldsExclusiveToObject2().isEmpty());

		Assert.assertTrue(compareTo.getFieldsNotEquals().isEmpty());
		
		Assert.assertEquals(4, compareTo.getFieldsEquals().size());
		
	}
	
	@Test
	public void compareToFail(){
		Object person = createPerson();
		Object employee = createEmployee();
		
		ComparatorObject compareTo = new ComparationManager().compareTo(person, employee);
		
		Assert.assertEquals(person, compareTo.getObject1());
		Assert.assertEquals(employee, compareTo.getObject2());
		
		Assert.assertTrue(compareTo.getFieldsExclusiveToObject1().isEmpty());
		
		Assert.assertEquals(1, compareTo.getFieldsExclusiveToObject2().size());
		
		Assert.assertEquals(3, compareTo.getFieldsNotEquals().size());
		
		Assert.assertEquals(1, compareTo.getFieldsEquals().size());
		
	}
	
	

	protected Object createPerson() {
		return new Person("nombre", 15, null, State.BOY);
	}
	
	protected Object createEmployee() {
		return new Employee("nombre2", 55, null, State.GRANDFATHER, new Work("UNQ"));
	}

}

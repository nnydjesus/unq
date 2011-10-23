package ar.unq.tpi.comparatorObject.comparator.domain.test;

public class Employee extends Person {

	private Work work;

	public Employee(String name, int age, Person parent, State state, Work work) {
		super(name, age, parent, state);
		this.setWork(work);
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public Work getWork() {
		return work;
	}

}

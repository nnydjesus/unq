package ar.unq.tpi.comparatorObject.comparator.domain.test;

public class Person {
	
	private String name;
	private int age;
	private Person parent;
	private State state;
	
	
	public Person(String name, int age, Person parent, State state) {
		super();
		this.name = name;
		this.age = age;
		this.parent = parent;
		this.state = state;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person getParent() {
		return parent;
	}
	public void setParent(Person parent) {
		this.parent = parent;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	

}

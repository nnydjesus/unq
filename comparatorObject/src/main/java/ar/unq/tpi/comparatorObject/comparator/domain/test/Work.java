package ar.unq.tpi.comparatorObject.comparator.domain.test;


public class Work {
	
	private String name;
	
	public Work(String name) {
		super();
		this.name = name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {
		return  name;
	}

}

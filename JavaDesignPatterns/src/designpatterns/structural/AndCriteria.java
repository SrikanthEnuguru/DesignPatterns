package designpatterns.structural;

import java.util.List;

public class AndCriteria implements Criteria{
	
	private Criteria criteria1;
	private Criteria criteria2;
	

	public AndCriteria(Criteria criteria1, Criteria criteria2) {
		super();
		this.criteria1 = criteria1;
		this.criteria2 = criteria2;
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> persons1 = criteria1.meetCriteria(persons);
		List<Person> persons2 = criteria2.meetCriteria(persons1);		
		return persons2;
	}

}

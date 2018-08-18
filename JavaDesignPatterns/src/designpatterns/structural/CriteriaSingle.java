package designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria{

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> singlePersons = new ArrayList<>();
		for(Person p:persons) {
			if(p.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
				singlePersons.add(p);
			}
		}
		return singlePersons;
	}

}

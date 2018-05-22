package io.openshift.booster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingRepository {
	
	private HashMap<Integer , Greeting> greetings = new HashMap<>();
	
	public GreetingRepository() {
		for (int i=1;i<50;i++) {
			greetings.put(i, new Greeting(i, "Mock-Greeeting #" + i));
		}
	}
	
	public List<Greeting> findAll() {
		return new ArrayList<Greeting>(greetings.values());
	}
	
	public Greeting findById(int id) {
		return greetings.get(id);
	}
	
	public void save(Greeting greeting) {
		greetings.put(greeting.getId(), greeting);
	}
	
	public void delete(int id) {
		greetings.remove(id);
	}
	
}

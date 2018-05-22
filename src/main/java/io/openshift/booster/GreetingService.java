package io.openshift.booster;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingService {

	@Inject
	GreetingRepository repo;
	
	private Logger logger = Logger.getLogger(GreetingService.class.getName());

    public List<Greeting> findAll() {
    	List<Greeting> list = repo.findAll();
    	logger.info("findAll: " + list); 
        return list;
    }

	public Greeting findById(int id) {
		Greeting g = repo.findById(id);
    	logger.info("findById(" + id + "): " + g); 
        return g;
    }

	public void delete(int id) {
		Greeting g = findById(id);
		if (g != null) {
			repo.delete(id);
			g = findById(id);
			if (g != null) {
				logger.warning("delete(" + id + ") failed!");
			} else {
				logger.info("deleted: " + id);
			}
		} else {
			logger.warning("delete(" + id + ") : not existent!");
		}
    }

	public void save(Greeting greeting) {
		logger.info("saving: " + greeting);
    	repo.save(greeting);
    }
}

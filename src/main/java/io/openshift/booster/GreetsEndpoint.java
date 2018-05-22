package io.openshift.booster;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/greets")
public class GreetsEndpoint {

	@Inject
	GreetingService service;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Greeting> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Greeting findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public void delete(@PathParam("id") int id) {
        service.delete(id);
    }

    @POST
    @PUT
    @Path("/")
    @Consumes("application/json")
    public void save(Greeting greeting) {
    	service.save(greeting);
    }
}

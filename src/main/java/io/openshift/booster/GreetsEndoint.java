package io.openshift.booster;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/greets")
public class GreetsEndpoint {

    private static final String template = "Hello, %s!";

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Greeting findById(@PathParam("id") int id) {
        return new Greeting(1,"test ah");
    }
}

package net.martenscs.osgi.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public interface Numb {

	@GET
	@Produces("text/xml")
	public abstract String listNumbers();

	@GET
	@Path("/{id}")
	@Produces("text/plain")
	public abstract String getNumber(@PathParam("id") String id);

}
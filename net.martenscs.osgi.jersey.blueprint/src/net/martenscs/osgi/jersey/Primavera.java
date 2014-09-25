package net.martenscs.osgi.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

interface Product<T> {
	void setId(T value);

	String getId();
}

@Path("/product")
public class Primavera implements Product<String> {

	public String id;

	public void setId(String id) {
		this.id = id;
	}

	@Override
	@GET
	@Produces("text/xml")
	public String getId() {

		return id;

	}
}

package net.martenscs.osgi.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/numbers")
public class NumberResource implements Numb {
    /* (non-Javadoc)
	 * @see net.martenscs.osgi.jersey.Numb#listNumbers()
	 */
    @Override
	@GET
    @Produces("text/xml")
    public String listNumbers() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<!-- Guess the right number! The following numbers are available. -->");
        sb.append("\n");
        sb.append("<numbers>");
        sb.append("\n");
        for (Number number : Number.NUMBERS) {
            sb.append("<number>");
            sb.append(number.getNumber());
            sb.append("</number>");
            sb.append("\n");
        }
        sb.append("</numbers>");
        return sb.toString();
    }
    
    /* (non-Javadoc)
	 * @see net.martenscs.osgi.jersey.Numb#getNumber(java.lang.String)
	 */
    @Override
	@GET
    @Path("/{id}")
    @Produces("text/plain")
    public String getNumber(@PathParam("id") String id) {
        try {
            int i = Integer.parseInt(id);
            Number n = Number.NUMBERS.get(i-1);
            return n.toString();
        } catch (Throwable th) {
            return "Sorry that number is out of range";
        }
    }
}

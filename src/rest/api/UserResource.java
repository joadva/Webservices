package rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("user")
public class UserResource {
	
	@Context
private UriInfo context;
	
	public UserResource() {
		
		
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getJson() {
		
		
		throw new UnsupportedOperationException();
		
		
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void  putJson(String content) {
	
	
		}
	
}

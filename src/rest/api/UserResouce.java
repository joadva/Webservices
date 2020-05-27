package rest.api;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import rest.DTO.User;
import rest.factory.Fabrica;
import rest.interfaces.IUser;

@Path("user")
public class UserResouce {
	
//	
//	@Context
//	private UriInfo context;
//	
//	public UserResouce(){
//						
//	}
	
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		
		try {
			
			IUser user = (IUser) Fabrica.getInstancia("USUARIOS");
			Collection<User> users = user.getAll();
			
			String json = new Gson().toJson(users);
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			return Response.status(Response.Status.SEE_OTHER).entity("Error" + e.toString()).build();
			}
		}
	

	
//	public Response addUser(String username, String description) {
//		try {
//			IUser iUser = (IUser) Fabrica.getInstancia("USUARIOS");
//			if(iUser.create(username, description)) {
//				
//				String json = "{status: successs }";
//				return Response.ok(json,MediaType.APPLICATION_JSON).build();
//			}else {
//				return Response.status(Response.Status.SEE_OTHER).entity("Error: User no create").build();
//			}
//			
//		} catch (Exception e) {
//			return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ e.toString()).build();
//		}
//		
//	}
//	
//	@PUT
//	@Path("{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response update(User user,@PathParam("id")int id) {
//		
//		try {
//			user.setId(id);
//			
//			IUser iUser = (IUser) Fabrica.getInstancia("USUARIOS");
//			iUser.update(user.getId(),user.getUsername(),user.getDescription());
//			
//			String json = "{status:succes}";
//			return Response.ok(json,MediaType.APPLICATION_JSON).build();
//		}catch  (Exception e){
//			return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
//		}
//		
//	}
//	
//	
//	
//	@DELETE
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response delete (@PathParam("id")int id) {
//		try {
//			IUser iUser = (IUser) Fabrica.getInstancia("USUARIOS");
//			
//			if(iUser.delete(id)) {
//				String json = "{status:succes}";
//				return Response.ok(json,MediaType.APPLICATION_JSON).build();
//				}else {
//					return Response.status(Response.Status.SEE_OTHER).entity("ERROR:user no create").build();
//				}
//		}catch (Exception e){
//			return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
//		}
//	}
//	
//	
//	
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getJson() {
//		
//		throw new UnsupportedOperationException();
//	}
//	
//	@PUT
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void putJSON( String content) {
//		
//	}
}

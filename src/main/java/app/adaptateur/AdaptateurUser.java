package app.adaptateur;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import app.bean.User;
import app.gestion.GestionUser;

@Component
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptateurUser {
	
	private static Logger LOG = Logger.getLogger(AdaptateurUser.class);
	
	@Autowired
	GestionUser gestionUser;
		
	@GET
	public List<User> getUsers() {
		LOG.info("get");
		return gestionUser.getList();
	}
	
	@POST
	@Path("/add")
	public Response addUser(@QueryParam("user") User user) {
		LOG.info("add user " + user);
		
		gestionUser.add(user);
		
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/")
	public Response removeUser(@QueryParam("id") String id) {
		
		gestionUser.delete(id);
		return Response.ok().build();
	}

}

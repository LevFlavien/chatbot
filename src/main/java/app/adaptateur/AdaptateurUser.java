package app.adaptateur;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
		return gestionUser.getList();
	}
	
	@GET
	@Path("/{id}")
	public User getUser(@PathParam("id") String idUser) {
		return gestionUser.getById(idUser);
	}
	
	@GET
	@Path("/mail/{mail}")
	public User getUserByMail(@PathParam("mail") String mail) {
		return gestionUser.get(mail);
	}
	
	@POST
	@Path("/add")
	public Response addUser(@QueryParam("user") User user) {
		LOG.info("add user " + user);
		
		gestionUser.add(user);
		
		return Response.ok().build();
	}
	
	@GET
	@Path("/generateDB")
	public Response generateDB() {
		gestionUser.add(new User(null, "Alex", "Medina", "alex.medina@epsi.fr", "amedina"));
		gestionUser.add(new User(null, "Amandine", "Medina", "amandine.medina@epsi.fr", "abucas"));
		gestionUser.add(new User(null, "Adrien", "Medina", "adrien.medina@epsi.fr", "aexcoffier"));
		gestionUser.add(new User(null, "Romain", "Medina", "romain.medina@epsi.fr", "retienne"));
		gestionUser.add(new User(null, "Flavien", "Medina", "flavien.medina@epsi.fr", "flevesque"));
		
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeUser(@PathParam("id") String id) {
		gestionUser.delete(id);
		return Response.ok().build();
	}

}

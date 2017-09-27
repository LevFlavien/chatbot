package app.adaptateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import app.bean.Message;
import app.gestion.GestionMessages;
import app.gestion.GestionUser;

@Component
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptateurMessage {
	
	private static Logger LOG = Logger.getLogger(AdaptateurMessage.class);
	
	@Autowired
	GestionMessages gestionMessages;
	
	@Autowired
	GestionUser gestionUser;
		
	@GET
	public List<Message> getMessages() {
		return gestionMessages.getList();
	}
	
	@GET
	@Path("/{id}")
	public List<Map<String, Object>> getConversation(@PathParam("id") String id) {

		return gestionMessages.getByIdUser(id).getConversation();
		
	}
	
	@GET
	@Path("/user/{id}")
	public Message getUserByMail(@PathParam("id") String id) {
		return gestionMessages.getByIdUser(id);
	}
	
	@POST
	@Path("/add")
	public Response addMessage(@QueryParam("message") Message message) {
		LOG.info("add user " + message);
		
		gestionMessages.add(message);
		
		return Response.ok().build();
	}
	
	@GET
	@Path("/generateDB")
	public Response generateDB() {
		List<Map<String, Object>> messages = new ArrayList<>();
		Map<String, Object> mess = new HashMap<>();
		mess.put(Message.TIMESTAMP, System.currentTimeMillis());
		mess.put(Message.CONTENU, "message1");
		mess.put(Message.EXPEDITEUR, true);
		messages.add(mess);
		
		mess = new HashMap<>();
		mess.put(Message.TIMESTAMP, System.currentTimeMillis());
		mess.put(Message.CONTENU, "message2");
		mess.put(Message.EXPEDITEUR, false);
		messages.add(mess);
		
		gestionMessages.add(new Message(null, gestionUser.get("alex.medina@epsi.fr").getId(), messages));
		
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeUser(@PathParam("id") String id) {
		gestionMessages.delete(id);
		return Response.ok().build();
	}

}

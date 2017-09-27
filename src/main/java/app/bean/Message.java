package app.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Messages")
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TIMESTAMP = "timeStamp";
	
	public static final String CONTENU = "contenu";
	
	public static final String EXPEDITEUR = "expediteur";
	
	@Id
	private String id;
	
	@Indexed
	private String idUser;
	
	List<Map<String, Object>> conversation;

	public Message() {
		super();
	}
	
	public Message(String id) {
		this.id = id;
	}

	public Message(String id, String idUser, List<Map<String, Object>> messages) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.conversation = messages;
	}
	
	public void addMessage(String contenu, Boolean expediteur) {
		Map<String, Object> map = new HashMap<>();
		map.put(TIMESTAMP, System.currentTimeMillis());
		map.put(CONTENU, contenu);
		map.put(EXPEDITEUR, expediteur);
		this.conversation.add(map);
	}

	public String getId() {
		return id;
	}


	public String getIdUser() {
		return idUser;
	}

	public List<Map<String, Object>> getConversation() {
		return conversation;
	}

	public void setConversation(List<Map<String, Object>> conversation) {
		this.conversation = conversation;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", idUser=" + idUser + ", conversation=" + conversation + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

}

package app.gestion;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import app.bean.Message;

/**
 * DAO des messages
 * @author alexm
 *
 */
@Service
public class GestionMessages {
	
	/** Connection à la base Mongo */
	@Autowired
	MongoTemplate mongoTemplate;
		
	/**
     * Récupère un Message de la base mongo à partir de son id.
     * @param id
     * @return le message correspondant
     */
    public Message get(final String id) {
    	return mongoTemplate.findById(id, Message.class);
        
    }

    /**
     * Récupérer un Message donné par l'id du user
     * @param idUser id de l'User
     * @return le message
     */
    public Message getByIdUser(final String idUser) {
    	
    	Message mess = mongoTemplate.findOne(new Query(Criteria.where("idUser").is(idUser.toLowerCase(Locale.FRANCE))),
                Message.class);
    	
    	if(mess == null) {
    		mess = add(new Message(null, idUser));
    	}
    	
    	return mess;
               
    }

    /**
     * Récupérer la liste des Users
     * @return l'User actuellement connecté
     */
    public List<Message> getList() {
        return mongoTemplate.findAll(Message.class);
    }

    /**
     * Crée un nouvel User
     * @param user l'User à ajouter (sans l'id)
     * @return l'User effectivement ajouté (avec id)
     */
    public Message add(final Message message) {

        mongoTemplate.insert(message);
        return message;
    }

    /**
     * met à jour un Message
     * @param message Message à modifier (avec id)
     */
    public void update(final Message message) {

        mongoTemplate.save(message);
    }

    /**
     * Supprime un Message donné par son id <br>
     * @param id du message
     */
    public void delete(final String id) {

        mongoTemplate.remove(new Message(id));

    }
	
}

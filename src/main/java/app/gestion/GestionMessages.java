package app.gestion;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import app.bean.Message;

@Service
public class GestionMessages {

	private static Logger LOG = Logger.getLogger(GestionMessages.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
		
	/**
     * Récupère un Message de la base mongo à partir de son id.
     * @param loginUser le login NT
     * @return le message correspondant ou null s'il n'a pas été trouvé
     */
    public Message get(final String id) {
    	return mongoTemplate.findById(id, Message.class);
        
    }

    /**
     * Récupérer un Message donné par l'id du user<br>
     * .
     * @param idUser id de l'User
     * @return le message
     */
    public Message getByIdUser(final String idUser) {
    	return mongoTemplate.findOne(new Query(Criteria.where("idUser").is(idUser.toLowerCase(Locale.FRANCE))),
                Message.class);

    }

    /**
     * Récupérer la liste des Users (fonction administrateur)<br>
     * .
     * @return l'User actuellement connecté
     */
    public List<Message> getList() {
        return mongoTemplate.findAll(Message.class);
    }

    /**
     * Crée un nouvel User (fonction administrateur)<br>
     * .
     * @param user l'User à ajouter (sans l'id)
     * @return l'User effectivement ajouté (avec id)
     */
    public Message add(final Message message) {

        mongoTemplate.insert(message);
        return message;

    }

    /**
     * met à jour un Message<br>
     * .
     * @param message User à modifier (avec id)
     */
    public void update(final Message message) {

        mongoTemplate.save(message);
    }

    /**
     * Supprime un Message donné par son id <br>
     * @param idUser id de l'User
     */
    public void delete(final String id) {

        mongoTemplate.remove(new Message(id));

    }
	
}

package app.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import app.bean.User;

/**
 * DAO des User
 * @author alexm
 *
 */
@Service
public class GestionUser {
	
	/** Connection à la base mongo */
	@Autowired
	MongoTemplate mongoTemplate;

    /**
     * Récupérer un User donné par son id
     * @param idUser id de l'User
     * @return le User
     */
    public User getById(final String idUser) {
        return mongoTemplate.findById(idUser, User.class);

    }

    /**
     * Récupérer la liste des User
     * @return la liste des Users
     */
    public List<User> getList() {
        return mongoTemplate.findAll(User.class);
    }

    /**
     * Crée un nouvel Use
     * @param user l'User à ajouter (sans l'id)
     * @return l'User effectivement ajouté (avec id)
     */
    public User add(final User user) {
        mongoTemplate.insert(user);
        return user;

    }

    /**
     * met à jour un User
     * @param user User à modifier (avec id)
     */
    public void update(final User user) {

        mongoTemplate.save(user);
    }

    /**
     * Supprime un User donné par son id
     * @param idUser id de l'User
     */
    public void delete(final String idUser) {

        mongoTemplate.remove(new User(idUser));
    }
}

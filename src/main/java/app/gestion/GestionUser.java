package app.gestion;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.bean.User;

@Service
public class GestionUser {
	
	private static Logger LOG = Logger.getLogger(GestionUser.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	/**
     * Récupère un User de la base mongo à partir de son login.
     * @param loginUser le login NT
     * @return l'User correspondant ou null s'il n'a pas été trouvé
     */
    public User get(final String loginUser) {

        return mongoTemplate.findOne(new Query(Criteria.where("mail").is(loginUser.toLowerCase(Locale.FRANCE))),
            User.class);
    }

    /**
     * Récupérer un User donné par son id (fonction administrateur)<br>
     * .
     * @param idUser id de l'User
     * @return l'User actuellement connecté
     */
    public User getById(final String idUser) {
        return mongoTemplate.findById(idUser, User.class);

    }

    /**
     * Récupérer la liste des Users (fonction administrateur)<br>
     * .
     * @return l'User actuellement connecté
     */
    public List<User> getList() {
    	LOG.info("get List");
        List<User> users = mongoTemplate.findAll(User.class);

        LOG.info("users = "+ users);
        return users;
    }

    /**
     * Crée un nouvel User (fonction administrateur)<br>
     * .
     * @param user l'User à ajouter (sans l'id)
     * @return l'User effectivement ajouté (avec id)
     */
    public User add(final User user) {
    	user.setMdp(passwordEncoder.encode(user.getMdp()));
    	LOG.info(user);
        mongoTemplate.insert(user);
        return user;

    }

    /**
     * met à jour un User (fonction administrateur)<br>
     * .
     * @param user User à modifier (avec id)
     */
    public void update(final User user) {

        mongoTemplate.save(user);

    }

    /**
     * Supprime un User donné par son id (fonction administrateur)<br>
     * .
     * @param idUser id de l'User
     */
    public void delete(final String idUser) {

        mongoTemplate.remove(new User(idUser));

    }

}

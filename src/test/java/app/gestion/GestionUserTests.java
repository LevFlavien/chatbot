package app.gestion;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import app.bean.User;
import app.configuration.ConfigBean;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ConfigBean.class, GestionUserTests.class })
public class GestionUserTests {
	
	@Autowired
	GestionUser gestionUser;
	
	private static Logger LOG = Logger.getLogger(GestionUserTests.class);
	
	@Test
	public void test() {
		User user1 = new User(null, "user1", "nom", "user1@chatbot.fr", "mdp");
		user1 = gestionUser.add(user1);
		LOG.info(user1);
	}

}

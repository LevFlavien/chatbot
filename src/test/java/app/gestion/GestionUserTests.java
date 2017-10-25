package app.gestion;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import app.bean.User;
import app.configuration.ConfigBean;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes=ConfigBean.class, loader=AnnotationConfigContextLoader.class)
public class GestionUserTests {
	
	@Autowired
	GestionUser gestionUser;
		
	@Test
	public void test() {
		
		User user = gestionUser.add(new User(null, "Alex", ""));
		
		User user2= gestionUser.getById(user.getId());
		
		Assert.assertEquals(user, user2);
		
		user.setNom("Medina");
		gestionUser.update(user);
		Assert.assertEquals(gestionUser.getById(user.getId()).getNom(), "Medina");
		
		gestionUser.delete(user.getId());
	}

}

package app.gestion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import app.bean.Message;
import app.configuration.ConfigBean;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes=ConfigBean.class, loader=AnnotationConfigContextLoader.class)
public class GestionMessagesTests {
	
	@Autowired
	GestionMessages gestionMessages;
	
	private static Logger LOG = Logger.getLogger(GestionMessagesTests.class);
	
	@Test
	public void test() {
		List<Map<String, Object>> messages = new ArrayList<>();
		Map<String, Object> mess = new HashMap<>();
		mess.put("timeStamp", System.currentTimeMillis());
		mess.put("contenu", "message1");
		mess.put("expediteur", false);
		messages.add(mess);
		
		mess = new HashMap<>();
		mess.put("timeStamp", System.currentTimeMillis());
		mess.put("contenu", "message2");
		mess.put("expediteur", true);
		messages.add(mess);
		
		Message msg = gestionMessages.add(new Message(null, "1234", messages));

		Message message = gestionMessages.getByIdUser("1234");
		
		Message message2 = gestionMessages.get(msg.getId());
		
		assertEquals(message, msg);
		assertEquals(message2, msg);
		
		message.addMessage("message3", true);
		gestionMessages.update(message);
		LOG.info(gestionMessages.get(message.getId()));
		
		gestionMessages.delete(msg.getId());
	}

}

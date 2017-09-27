package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import app.gestion.GestionMessages;
import app.gestion.GestionUser;

@Configuration
public class ConfigBean {
	
	@Bean
	public MongoTemplate mongoTemplate(){
		return new MongoTemplate(new Mongo(), "chatbot");
	}

	@Bean
	public GestionUser gestionUser() {
		return new GestionUser();
	}
	
	@Bean
	public GestionMessages gestionMessages() {
		return new GestionMessages();
	}

}

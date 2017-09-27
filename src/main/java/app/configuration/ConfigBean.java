package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.gestion.GestionUser;

@Configuration
public class ConfigBean {

	@Bean
	public GestionUser gestionUser() {
		return new GestionUser();
	}

}

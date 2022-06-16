package br.com.praticando.pacienteSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PacienteSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteSpringApplication.class, args);
	}

}

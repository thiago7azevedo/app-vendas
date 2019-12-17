package br.com.jcavi.javaweb.sisvendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SisvendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisvendasApplication.class, args);
	}

}

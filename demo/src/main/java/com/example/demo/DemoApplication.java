package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.TipusUsuari;
import com.example.demo.model.Usuari;
import com.example.demo.repository.Borsa;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(Borsa borsa) {
		return args -> {
			 borsa.save(new Usuari(null, "Pere", "Puig", TipusUsuari.ALUMNE));
			 borsa.save(new Usuari(null, "Joan", "Serra", TipusUsuari.ALUMNE));
			 borsa.save(new Usuari(null, "Maria", "Garcia", TipusUsuari.ALUMNE));
			 borsa.save(new Usuari(null, "Anna", "Perez", TipusUsuari.ALUMNE));
			 borsa.save(new Usuari(null, "Jordi", "Martinez", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Marta", "Soler", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Judit", "Gomez", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Marc", "Torres", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Laura", "Vila", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Pol", "Sala", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Sergi", "Castro", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Jordi", "Serra", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Jordi", "Garcia", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Jordi", "Perez", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Jordi", "Martinez", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Jordi", "Soler", TipusUsuari.ALUMNE));
			// borsa.save(new Usuari(null, "Jordi", "Gomez", TipusUsuari.ALUMNE));
	};
}

}

package br.com.alura.LiterAlura;

import br.com.alura.LiterAlura.controller.LiterAluraController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	private final LiterAluraController controller;

	public LiterAluraApplication(LiterAluraController controller) {
		this.controller = controller;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		controller.exibirMenu();
	}
}

package com.challengeliteralura.challengeLiterAlura;


import com.challengeliteralura.challengeLiterAlura.model.Autor;
import com.challengeliteralura.challengeLiterAlura.model.Libro;
import com.challengeliteralura.challengeLiterAlura.service.ConsumoApi;
import com.challengeliteralura.challengeLiterAlura.service.LibroService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Collections;
import java.util.List;


@SpringBootApplication(scanBasePackages = "com.challengeliteralura.challengeLiterAlura")
public class ChallengeLiterAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiterAluraApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(LibroService libroService) {
		return args -> {
			ConsumoApi consumoAPI = new ConsumoApi();
			String json = consumoAPI.obtenerDatos("https://gutendex.com/books/");

			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			JsonNode resultados = root.get("results");

			if (resultados.isArray()) {
				for (JsonNode libroNode : resultados) {
					String titulo = libroNode.get("title").asText();

					// Autor
					JsonNode autoresNode = libroNode.get("authors");
					Autor autor = null;
					if (autoresNode.isArray() && autoresNode.size() > 0) {
						JsonNode autorNode = autoresNode.get(0);
						autor = new Autor(
								autorNode.get("name").asText(),
								autorNode.get("birth_year").isNull() ? null : autorNode.get("birth_year").asInt(),
								autorNode.get("death_year").isNull() ? null : autorNode.get("death_year").asInt()
						);
					}

					// Idiomas
					List<String> idiomas = Collections.emptyList();
					if (libroNode.get("languages").isArray()) {
						idiomas = mapper.convertValue(libroNode.get("languages"), List.class);
					}

					// Descargas
					Integer descargas = libroNode.get("download_count").asInt();

					// Crear y guardar libro
					var libro = new Libro(titulo, List.of(autor), idiomas, descargas);
					Libro guardar = libroService.guardar(libro);

					// Imprimir en consola
					System.out.println("📖 Guardado: " + titulo);
				}
			}
		};
	}
}

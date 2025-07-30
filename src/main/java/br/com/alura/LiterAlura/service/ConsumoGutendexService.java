package br.com.alura.LiterAlura.service;

import br.com.alura.LiterAlura.dto.AutorDto;
import br.com.alura.LiterAlura.dto.DadosLivro;
import br.com.alura.LiterAlura.dto.ResultadoApi;
import br.com.alura.LiterAlura.model.Autor;
import br.com.alura.LiterAlura.model.Livro;
import br.com.alura.LiterAlura.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ConsumoGutendexService {

    private final AutorRepository autorRepository;

    public ConsumoGutendexService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Optional<Livro> buscarLivroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo.replace(" ", "+");
        RestTemplate restTemplate = new RestTemplate();

        ResultadoApi resultado = restTemplate.getForObject(url, ResultadoApi.class);

        if (resultado == null || resultado.results().isEmpty()) {
            return Optional.empty();
        }

        DadosLivro dadosLivro = resultado.results().get(0);

        // Procesar autor
        AutorDto autorDto = dadosLivro.authors().get(0);
        Autor autor = autorRepository.findByNomeIgnoreCase(autorDto.name())
                .orElseGet(() -> {
                    Autor novoAutor = new Autor(
                            autorDto.name(),
                            autorDto.nascimento(),
                            autorDto.falecimento()
                    );
                    return autorRepository.save(novoAutor);
                });

        Livro livro = new Livro();
        livro.setTitulo(dadosLivro.title());
        livro.setIdioma(dadosLivro.languages().isEmpty() ? "N/A" : dadosLivro.languages().get(0).toUpperCase());
        livro.setDownloads(dadosLivro.download_count());
        livro.setAutor(autor);

        return Optional.of(livro);
    }
}

package br.com.alura.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro<AutorDto>(
        String title,
        List<String> languages,
        int download_count,
        List<AutorDto> authors
) {}

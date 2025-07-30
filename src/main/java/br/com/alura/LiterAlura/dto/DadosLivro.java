package br.com.alura.LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

public record DadosLivro(
        String title,
        List<String> languages,
        @JsonAlias("download_count") int download_count,
        List<AutorDto> authors
) {}


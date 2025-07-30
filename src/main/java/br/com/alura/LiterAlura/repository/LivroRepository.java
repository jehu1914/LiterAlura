package br.com.alura.LiterAlura.repository;

import br.com.alura.LiterAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByTituloIgnoreCase(String titulo);
    List<Livro> findByIdioma(String idioma);
    List<Livro> findTop10ByOrderByDownloadsDesc();
}

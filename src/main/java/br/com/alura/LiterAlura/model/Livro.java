package br.com.alura.LiterAlura.model;

import br.com.alura.LiterAlura.dto.DadosLivro;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
    private String idioma;
    private Integer downloads;

    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;

    public Livro() {}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.title();
        this.idioma = dadosLivro.languages().isEmpty() ? "N/A" : dadosLivro.languages().get(0).toUpperCase();
        this.downloads = dadosLivro.download_count();
    }

    // Getters y Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getIdioma() { return idioma; }
    public Integer getDownloads() { return downloads; }
    public Autor getAutor() { return autor; }


    public void setAutor(Autor autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "Libro: " + titulo + " - " + idioma + " (" + downloads + " descargas)";
    }
}

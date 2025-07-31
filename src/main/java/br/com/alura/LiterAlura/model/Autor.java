package br.com.alura.LiterAlura.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {}

    public Autor(String nome, Integer anoNascimento, Integer anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }

    // Getters y setters

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getAnoNascimento() { return anoNascimento; }
    public void setAnoNascimento(Integer anoNascimento) { this.anoNascimento = anoNascimento; }
    public Integer getAnoFalecimento() { return anoFalecimento; }
    public void setAnoFalecimento(Integer anoFalecimento) { this.anoFalecimento = anoFalecimento; }
    public List<Livro> getLivros() { return livros; }
    public void setLivros(List<Livro> livros) { this.livros = livros; }

    @Override
    public String toString() {
        return "\nAutor: " + nome +
                "\nAno de nascimento: " + anoNascimento +
                "\nAno de falecimento: " + (anoFalecimento != null ? anoFalecimento : "Ainda vivo") +
                "\n";
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Autor: ").append(nome).append("\n");
//        sb.append("Ano de nascimento: ").append(anoNascimento).append("\n");
//        sb.append("Ano de falecimento: ").append(
//                anoFalecimento != null ? anoFalecimento : "Ainda vivo"
//        ).append("\n");
//        sb.append("Quantidade de livros cadastrados: ").append(
//                livros != null ? livros.size() : 0
//        );
//        return sb.toString();
//    }

//    @Override
//    public String toString() {
//        return "Autor: " + nome + " (" + anoNascimento + " - " + (anoFalecimento != null ? anoFalecimento : "Presente") + ")";
//    }
}
